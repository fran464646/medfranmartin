package hotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HotelDAO {
	
	public HotelDAO(){
		
	}

	public List<Hotel> getHotels(ArrayList<String> keys,ArrayList<String> values) {
        List<Hotel> hotelList = new ArrayList<Hotel>();

    	Iterator itr = values.iterator();
		try {
            // 1. configuring hibernate
            Configuration configuration = new Configuration().configure();
 
            // 2. create sessionfactory
            SessionFactory sessionFactory = configuration.buildSessionFactory();
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            List<String> conditionsList=new ArrayList<String>();
            Boolean orderbyprice=false;
            String sql="FROM Hotel";
            if (!keys.isEmpty()){
            	sql=sql.concat(" where ");
	            for (String entry : keys){
	            	if (entry.equalsIgnoreCase("nombre") || entry.equalsIgnoreCase("ciudad") || entry.equalsIgnoreCase("categoria") || entry.equalsIgnoreCase("calle") || entry.equalsIgnoreCase("orderby")){
	            		if (!entry.equalsIgnoreCase("orderby")){
			            		String value=String.valueOf(itr.next());
			            		sql=sql.concat(entry+ " LIKE '%"+value+"%' AND    ");
	            		}else{
	            			String value=String.valueOf(itr.next());
	            			conditionsList =new LinkedList<String>(Arrays.asList(value.split(",")));
	            			if (conditionsList.contains("precio")){
	            				orderbyprice=true;
	            				sql=sql.concat("d.idRegimen=c.id AND c.idTipoHabitacion=b.id AND b.idHotel=a.id AND    ");
	            				Integer position=conditionsList.indexOf("precio");
	            				conditionsList.remove(position);
	            				conditionsList.add(position, "minprecio");
	            			}
	            			
	            		}
	            	}
	            }

	            sql=sql.substring(0, sql.length()-7);
	            if (orderbyprice){
	            	sql=sql.concat(" group by a.id");
	            	sql=sql.replace("FROM Hotel ","select distinct a.id,a.nombre,a.ciudad,a.calle,a.descripcion,a.categoria,a.telefono,a.correoElectronico,min(d.precio) as minprecio from Hotel a,TipoHabitacion b, Regimen c,Tarifa d ");
	            	sql=sql.replace(" nombre", " a.nombre");
	            	sql=sql.replace(" ciudad", " a.ciudad");
	            	sql=sql.replace(" categoria", " a.categoria");
	            	sql=sql.replace(" calle", " a.calle");
	            }
	            System.out.println(sql);
	            if (!conditionsList.isEmpty()){
	            	sql=sql.concat(" ORDER BY ");
	            	while(!conditionsList.isEmpty()){
	            		String condition=conditionsList.remove(0);
	            		if (condition.equalsIgnoreCase("nombre") || condition.equalsIgnoreCase("categoria") || condition.equalsIgnoreCase("minprecio")){
	            			if (condition.equalsIgnoreCase("minprecio")){
	            				sql=sql.concat(condition+",");
	            			}else{
	            				if (orderbyprice){
			            			String str="a.";
			            			sql=sql.concat(str.concat(condition)+",");
	            				}else{
	            					sql=sql.concat(condition+",");
	            				}
	            			}
	            		}
	            	}
	            	sql=sql.substring(0, sql.length()-1);
	            }
            }
            Query query = session.createQuery(sql);
            hotelList = query.list();
            session.getTransaction().commit();
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return hotelList;
	}
}

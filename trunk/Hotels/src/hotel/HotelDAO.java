package hotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
            String sql="FROM Hotel";
            if (!keys.isEmpty()){
            	sql=sql.concat(" where ");
	            for (String entry : keys){
	            	if (entry.equalsIgnoreCase("nombre") || entry.equalsIgnoreCase("ciudad") || entry.equalsIgnoreCase("categoria") || entry.equalsIgnoreCase("calle") || entry.equalsIgnoreCase("orderby") || entry.equalsIgnoreCase("orderbyprice")){
	            		if (!entry.equalsIgnoreCase("orderby")){
	            			if (entry.equalsIgnoreCase("orderbyprice")){
	            				sql="select distinct a.id,a.nombre,a.ciudad,a.calle,a.descripcion,a.categoria,a.telefono,a.correoElectronico from Hotel a,TipoHabitacion b, Regimen c,Tarifa d where d.idRegimen=c.id AND c.idTipoHabitacion=b.id AND b.idHotel=a.id order by d.precio    ";
	            			}else{
			            		String value=values.remove(0);
			            		sql=sql.concat(entry+ " LIKE '%"+value+"%' AND ");
	            			}
	            		}else{
	            			String value=values.remove(0);
	            			conditionsList =new LinkedList<String>(Arrays.asList(value.split(",")));
	            		}
	            	}
	            }
	            sql=sql.substring(0, sql.length()-4);
	            System.out.println(sql);
	            if (!conditionsList.isEmpty()){
	            	sql=sql.concat(" ORDER BY ");
	            	while(!conditionsList.isEmpty()){
	            		String condition=conditionsList.remove(0);
	            		if (condition.equalsIgnoreCase("nombre") || condition.equalsIgnoreCase("categoria")){
	            			sql=sql.concat(condition+",");
	            		}
	            	}
	            	sql=sql.substring(0, sql.length()-1);
	            }
            }
            Query query = session.createQuery(sql);
            hotelList = query.list();
            System.out.println(hotelList.size());
            session.getTransaction().commit();
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return hotelList;
	}
}

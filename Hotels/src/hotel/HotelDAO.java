package hotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            String sql="FROM Hotel";
            if (!keys.isEmpty()){
            	sql=sql.concat(" where ");
	            for (String entry : keys){
	            	if (entry.equalsIgnoreCase("nombre") || entry.equalsIgnoreCase("ciudad") || entry.equalsIgnoreCase("categoria") || entry.equalsIgnoreCase("calle")){
	            		String value=values.remove(0);
	            		sql=sql.concat(entry+ " LIKE '%"+value+"%' AND ");
	            	}
	            }
	            sql=sql.substring(0, sql.length()-4);
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

package hotel;

import habitacion.Habitacion;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import regimen.Regimen;
import servicio.Servicio;
import tipoHabitacion.TipoHabitacion;

public class HotelDAO {
	
	public HotelDAO(){
		
	}
	
	public List<Regimen> getRegimenesHabitacion(String id_habitacion){
		List<Regimen> regimenesHabitacion=new ArrayList<Regimen>();
		try{
		// 1. configuring hibernate
	        Configuration configuration = new Configuration().configure();
	
	        // 2. create sessionfactory
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	        // 3. Get Session object
	        Session session = sessionFactory.openSession();
	
	        // 4. Starting Transaction
	        Transaction transaction = session.beginTransaction();
			String sql="FROM Regimen where idTipoHabitacion =:id ";
			Query query=session.createQuery(sql);
			query.setParameter("id", Long.valueOf(id_habitacion));
			regimenesHabitacion=query.list();
		} catch (HibernateException e){
			 System.out.println(e.getMessage());
	         System.out.println("error");
		}
		return regimenesHabitacion;
	}
	
	public List<Servicio> getServiciosHabitacion(String id_habitacion){
		List<Servicio> serviciosHabitacion=new ArrayList<Servicio>();
		try{
		// 1. configuring hibernate
	        Configuration configuration = new Configuration().configure();
	
	        // 2. create sessionfactory
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	        // 3. Get Session object
	        Session session = sessionFactory.openSession();
	
	        // 4. Starting Transaction
	        Transaction transaction = session.beginTransaction();
			String sql="FROM Servicio where idTipoHabitacion =:id ";
			Query query=session.createQuery(sql);
			query.setParameter("id", Long.valueOf(id_habitacion));
			serviciosHabitacion=query.list();
		} catch (HibernateException e){
			 System.out.println(e.getMessage());
	         System.out.println("error");
		}
		return serviciosHabitacion;
	}
	
	public TipoHabitacion getHabitacion(String id_habitacion){
		List<TipoHabitacion> tipoHabitacion=new ArrayList<TipoHabitacion>();
		try{
		// 1. configuring hibernate
	        Configuration configuration = new Configuration().configure();
	
	        // 2. create sessionfactory
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	        // 3. Get Session object
	        Session session = sessionFactory.openSession();
	
	        // 4. Starting Transaction
	        Transaction transaction = session.beginTransaction();
			String sql="FROM TipoHabitacion where id =:id ";
			Query query=session.createQuery(sql);
			query.setParameter("id", Long.valueOf(id_habitacion));
			tipoHabitacion=query.list();
		} catch (HibernateException e){
			 System.out.println(e.getMessage());
	         System.out.println("error");
		}
		return tipoHabitacion.get(0);
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
            String condition;
            String sql="FROM Hotel";
            if (!keys.isEmpty()){
            	sql=sql.concat(" where ");
	            for (String entry : keys){
	            	if (entry.equalsIgnoreCase("nombre") || entry.equalsIgnoreCase("ciudad") || entry.equalsIgnoreCase("categoria") || entry.equalsIgnoreCase("calle") || entry.equalsIgnoreCase("orderby")){
	            		if (!entry.equalsIgnoreCase("orderby")){
			            		String value=String.valueOf(itr.next());
			            		if (entry.equalsIgnoreCase("categoria")) sql = sql.concat(entry+ " = "+value);
			            		else sql=sql.concat(entry+ " LIKE '%"+value+"%'");
			            		if (itr.hasNext()) sql=sql.concat(" AND ");
	            		}else{
	            			String value=String.valueOf(itr.next());
	            			conditionsList =new LinkedList<String>(Arrays.asList(value.split(",")));
	            			if (conditionsList.contains("precio")){
	            				orderbyprice=true;
	            				sql=sql.concat("d.idRegimen=c.id AND c.idTipoHabitacion=b.id AND b.idHotel=a.id");
	            				if(keys.indexOf(entry) != keys.size() - 1) sql = sql.concat(" AND ");
	            				Integer position=conditionsList.indexOf("precio");
	            				conditionsList.remove("precio");
	            				conditionsList.add(position, "minprecio");
	            			}
	            			
	            		}
	            	}
	            }

	            if (orderbyprice){
	            	sql=sql.concat(" group by a.id");
	            	sql=sql.replace("FROM Hotel ","select distinct a.id,a.nombre,a.ciudad,a.calle,a.descripcion,a.categoria,a.telefono,a.correoElectronico,min(d.precio) as minprecio from Hotel a,TipoHabitacion b, Regimen c,Tarifa d ");
	            	sql=sql.replace(" nombre", " a.nombre");
	            	sql=sql.replace(" ciudad", " a.ciudad");
	            	sql=sql.replace(" categoria", " a.categoria");
	            	sql=sql.replace(" calle", " a.calle");
	            }
	            if (!conditionsList.isEmpty()){
	            	sql=sql.concat(" ORDER BY ");
	            	itr = conditionsList.iterator();
	            	while(itr.hasNext()){
            			condition = String.valueOf(itr.next());
            			if (condition.equalsIgnoreCase("nombre") || condition.equalsIgnoreCase("categoria") || condition.equalsIgnoreCase("minprecio")){
	            			if (condition.equalsIgnoreCase("minprecio")){
	            				sql=sql.concat(condition);
	            				if (itr.hasNext()) sql = sql.concat(",");
	            			}else{
	            				if (orderbyprice){
			            			sql=sql.concat("a."+condition);
			            			if (itr.hasNext()) sql = sql.concat(",");
	            				}else{
	            					sql=sql.concat(condition);
	            					if (itr.hasNext()) sql=sql.concat(",");
	            				}
	            			}
	            		}
	            	}
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
	
	public Hotel getHotel(String id){
		List<Hotel> hotel=new ArrayList<Hotel>();
		try{
		// 1. configuring hibernate
	        Configuration configuration = new Configuration().configure();
	
	        // 2. create sessionfactory
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	        // 3. Get Session object
	        Session session = sessionFactory.openSession();
	
	        // 4. Starting Transaction
	        Transaction transaction = session.beginTransaction();
			String sql="FROM Hotel where id =:id ";
			Query query=session.createQuery(sql);
			query.setParameter("id", Long.valueOf(id));
			hotel=query.list();
		} catch (HibernateException e){
			 System.out.println(e.getMessage());
	         System.out.println("error");
		}
		return hotel.get(0);
	}
	
	public List<TipoHabitacion> getHotelRooms(String id,String fechaEntrada,String fechaSalida) throws ParseException{
		List<TipoHabitacion> habitaciones=new ArrayList<TipoHabitacion>();
		System.out.println(fechaEntrada);
		System.out.println(fechaSalida);
		try{
		// 1. configuring hibernate
	        Configuration configuration = new Configuration().configure();
	
	        // 2. create sessionfactory
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	        // 3. Get Session object
	        Session session = sessionFactory.openSession();
	
	        // 4. Starting Transaction
	        Transaction transaction = session.beginTransaction();
			System.out.println(habitaciones);
			String sql="SELECT a.id,a.idHotel,a.nombre,a.capacidad,a.tamano,a.tipoCama,a.oferta from TipoHabitacion a, Habitacion b where b.idTipoHabitacion=a.id AND a.idHotel=:id AND b.numero not in (SELECT idHabitacion from Reserva where (fechaEntrada<=:fechaEntrada AND fechaSalida>=:fechaEntrada) OR (fechaEntrada>=:fechaEntrada AND fechaSalida<=:fechaSalida) OR ((fechaEntrada>=:fechaEntrada AND fechaEntrada<=:fechaSalida) AND fechaSalida>=:fechaSalida)) group by a.id";
			Query query=session.createQuery(sql);	
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        Date date=formatter.parse(fechaEntrada);
			query.setParameter("fechaEntrada",date);
			date=formatter.parse(fechaSalida);
			query.setParameter("fechaSalida",date);
			query.setParameter("id", Long.valueOf(id));
			habitaciones=query.list();
		} catch (HibernateException e){
			 System.out.println(e.getMessage());
	         System.out.println("error");
		}
		return habitaciones;
	}
}

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
import reserva.Reserva;
import servicio.Servicio;
import tarifa.Tarifa;
import tipoHabitacion.TipoHabitacion;

public class HotelDAO {
	
	public HotelDAO(){
		
	}
	
	public List<Servicio> getServiciosHotel(String id_hotel){
		List<Servicio> serviciosHotel=new ArrayList<Servicio>();
		try{
		// 1. configuring hibernate
	        Configuration configuration = new Configuration().configure();
	
	        // 2. create sessionfactory
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	        // 3. Get Session object
	        Session session = sessionFactory.openSession();
	
	        // 4. Starting Transaction
	        Transaction transaction = session.beginTransaction();
			String sql="FROM Servicio where idHotel =:id ";
			Query query=session.createQuery(sql);
			query.setParameter("id", Long.valueOf(id_hotel));
			serviciosHotel=query.list();
		} catch (HibernateException e){
			 System.out.println(e.getMessage());
	         System.out.println("error");
		}
		return serviciosHotel;
	}
	
	public List<Tarifa> getTarifasHabitacion(String id_habitacion){
		List<Tarifa> tarifasHabitacion=new ArrayList<Tarifa>();
		try{
		// 1. configuring hibernate
	        Configuration configuration = new Configuration().configure();
	
	        // 2. create sessionfactory
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	        // 3. Get Session object
	        Session session = sessionFactory.openSession();
	
	        // 4. Starting Transaction
	        Transaction transaction = session.beginTransaction();
			String sql="FROM Tarifa where idTipoHabitacion =:id ";
			Query query=session.createQuery(sql);
			query.setParameter("id", Long.valueOf(id_habitacion));
			tarifasHabitacion=query.list();
		} catch (HibernateException e){
			 System.out.println(e.getMessage());
	         System.out.println("error");
		}
		return tarifasHabitacion;
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

	public List<Hotel> getHotels(ArrayList<String> keys,ArrayList<String> values) throws ParseException {
        List<Hotel> hotelList = new ArrayList<Hotel>();
        Integer numHabitaciones=0;
        Boolean preciominimoAnadido=false;
        Boolean preciomaximoAnadido=false;
        Boolean numHabitacionesAnadido=false;
        Boolean servicios=false;
        Double preciominimo=null;
        Double preciomaximo=null;

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
            List<String> serviciosList=new ArrayList<String>();
            Boolean orderbyprice=false;
            String condition;
            String sql="FROM Hotel";
            if (!keys.isEmpty()){
            	sql=sql.concat(" where ");
	            for (String entry : keys){
	            	if (entry.equalsIgnoreCase("nombre") || entry.equalsIgnoreCase("ciudad") || entry.equalsIgnoreCase("categoria") || entry.equalsIgnoreCase("calle") || entry.equalsIgnoreCase("orderby") || entry.equalsIgnoreCase("preciominimo") || entry.equalsIgnoreCase("preciomaximo") || entry.equalsIgnoreCase("servicios") || entry.equalsIgnoreCase("numeroHabitaciones")){
	            		if (!entry.equalsIgnoreCase("orderby") && !entry.equalsIgnoreCase("preciominimo") && !entry.equalsIgnoreCase("preciomaximo")){
			            		if (entry.equalsIgnoreCase("servicios")){
			            			sql=sql.concat("e.idHotel=a.id AND ");
			            			String value=String.valueOf(itr.next());
			            			serviciosList =new LinkedList<String>(Arrays.asList(value.split(",")));
			            			Iterator iter=serviciosList.iterator();
			            			while (iter.hasNext()){
			            				String condition1=String.valueOf(iter.next());
			            				sql=sql.concat("e.nombre LIKE '%"+condition1+"%'");
			            				if (iter.hasNext()){
			            					sql=sql.concat(" AND ");
			            				}
			            			}
			            			if (itr.hasNext()){
			            				sql=sql.concat(" AND ");
			            			}
			            			servicios=true;
			            			
			            		}else{
			            			if (entry.equalsIgnoreCase("numeroHabitaciones")){
			            				sql=sql.concat("f.idTipoHabitacion=b.id AND d.idRegimen=c.id AND c.idTipoHabitacion=b.id AND b.idHotel=a.id AND f.numero NOT IN (SELECT idHabitacion from Reserva where (fechaEntrada<=:fecha AND fechaSalida>=:fecha))");
			            				numHabitaciones=Integer.valueOf(String.valueOf(itr.next()));
			            				numHabitacionesAnadido=true;
			            				if (itr.hasNext()){
			            					sql.concat(" AND ");
			            				}
			            			}else{
			            				String value=String.valueOf(itr.next());
					            		if (entry.equalsIgnoreCase("categoria")) sql = sql.concat(entry+ " = "+value);
					            		else sql=sql.concat(entry+ " LIKE '%"+value+"%'");
					            		if (itr.hasNext()) sql=sql.concat(" AND ");
			            			}
		            				
			            		}
	            		}else{
	            			if (entry.equalsIgnoreCase("preciominimo") || entry.equalsIgnoreCase("preciomaximo")){
	            				if (!preciominimoAnadido && !preciomaximoAnadido){
	            					sql=sql.concat("d.idRegimen=c.id AND c.idTipoHabitacion=b.id AND b.idHotel=a.id");
	            				}
	            				if (entry.equalsIgnoreCase("preciominimo")){
	            					sql=sql.concat(" AND d.precio>=:preciominimo");
	            					preciominimoAnadido=true;
	            					preciominimo=Double.valueOf(String.valueOf(itr.next()));
	            					orderbyprice=true;
	            				}else{
	            					sql=sql.concat(" AND d.precio<=:preciomaximo");
	            					preciomaximoAnadido=true;
	            					preciomaximo=Double.valueOf(String.valueOf(itr.next()));
	            					orderbyprice=true;
	            				}
	            			}else{
	            				orderbyprice=true;
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
	            }
	            if (numHabitacionesAnadido){
	            	sql=sql.concat(" group by a.id");
	            	sql=sql.replace("FROM Hotel ","select distinct a.id,a.nombre,a.ciudad,a.calle,a.descripcion,a.categoria,a.telefono,a.correoElectronico,a.enTemporada,min(d.precio) as minprecio from Hotel a,TipoHabitacion b, Regimen c,Tarifa d,Habitacion f ");
	            	sql=sql.replace(" nombre", " a.nombre");
	            	sql=sql.replace(" ciudad", " a.ciudad");
	            	sql=sql.replace(" categoria", " a.categoria");
	            	sql=sql.replace(" calle", " a.calle");
	            }
	            if (servicios){
	            	if (numHabitacionesAnadido){
	            		
	            		sql=sql.replace("FROM Hotel ","select distinct a.id,a.nombre,a.ciudad,a.calle,a.descripcion,a.categoria,a.telefono,a.correoElectronico,a.enTemporada,min(d.precio) as minprecio from Hotel a,TipoHabitacion b, Regimen c,Tarifa d,Servicio e,Habitacion f");
	            	}else{
	            		sql=sql.concat(" group by a.id");
	            		sql=sql.replace("FROM Hotel ","select distinct a.id,a.nombre,a.ciudad,a.calle,a.descripcion,a.categoria,a.telefono,a.correoElectronico,a.enTemporada,min(d.precio) as minprecio from Hotel a,TipoHabitacion b, Regimen c,Tarifa d,Servicio e ");
	            	}
	            	sql=sql.replace(" nombre", " a.nombre");
	            	sql=sql.replace(" ciudad", " a.ciudad");
	            	sql=sql.replace(" categoria", " a.categoria");
	            	sql=sql.replace(" calle", " a.calle");
	            }
	            if (orderbyprice){
	            	if (servicios){
	            		if (numHabitacionesAnadido){
	            			sql=sql.replace("FROM Hotel ","select distinct a.id,a.nombre,a.ciudad,a.calle,a.descripcion,a.categoria,a.telefono,a.correoElectronico,a.enTemporada,min(d.precio) as minprecio from Hotel a,TipoHabitacion b, Regimen c,Tarifa d,Servicio e, Habitacion f ");
	            		}else{
	            			
	            			sql=sql.replace("FROM Hotel ","select distinct a.id,a.nombre,a.ciudad,a.calle,a.descripcion,a.categoria,a.telefono,a.correoElectronico,a.enTemporada,min(d.precio) as minprecio from Hotel a,TipoHabitacion b, Regimen c,Tarifa d,Servicio e ");
	            		}
	            		
	            	}else{
	            		if(numHabitacionesAnadido){
	            			sql=sql.replace("FROM Hotel ","select distinct a.id,a.nombre,a.ciudad,a.calle,a.descripcion,a.categoria,a.telefono,a.correoElectronico,a.enTemporada,min(d.precio) as minprecio from Hotel a,TipoHabitacion b, Regimen c,Tarifa d, Habitacion f ");
	            		}else{
	            			sql=sql.concat(" group by a.id");
	            			sql=sql.replace("FROM Hotel ","select distinct a.id,a.nombre,a.ciudad,a.calle,a.descripcion,a.categoria,a.telefono,a.correoElectronico,a.enTemporada,min(d.precio) as minprecio from Hotel a,TipoHabitacion b, Regimen c,Tarifa d ");
	            		}
	            		
	            	}
	            	sql=sql.replace(" nombre", " a.nombre");
	            	sql=sql.replace(" ciudad", " a.ciudad");
	            	sql=sql.replace(" categoria", " a.categoria");
	            	sql=sql.replace(" calle", " a.calle");
	            }

	            if (numHabitacionesAnadido){
	            	sql=sql.concat(" HAVING count(f.numero)>="+numHabitaciones.toString());
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

	            					System.out.println("Paso por aqui");
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
            if (preciominimoAnadido){
            	query.setParameter("preciominimo", preciominimo);
            }
            if(preciomaximoAnadido){
            	query.setParameter("preciomaximo",preciomaximo);
            }
            if (numHabitacionesAnadido){
            	Date date = new Date();
            	query.setParameter("fecha", date);
            }
            System.out.println(query.toString());
            hotelList = query.list();
            session.getTransaction().commit();
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return hotelList;
	}
	
	public String doReserva(String id_hotel,String id_habitacion,String id_tarifa,String fechaEntrada,String fechaSalida,String nombre,String apellido1,String apellido2,String email,String telefono,String numCuenta,String observacion) throws ParseException{
		List<String> numberofrooms=new ArrayList<String>();
		try{
		// 1. configuring hibernate
	        Configuration configuration = new Configuration().configure();
	
	        // 2. create sessionfactory
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	        // 3. Get Session object
	        Session session = sessionFactory.openSession();
	
	        // 4. Starting Transaction
	        Transaction transaction = session.beginTransaction();
	        String sql="from Reserva";
	        Query query=session.createQuery(sql);
	        List<Reserva> reservas=query.list();
	        Long idultimareserva=reservas.get(reservas.size()-1).getId()+1;
			sql="select f.numero from TipoHabitacion b,Habitacion f where f.idTipoHabitacion=b.id AND f.idTipoHabitacion=:id_habitacion AND b.idHotel=:hotelid AND f.numero NOT IN (SELECT idHabitacion from Reserva where (fechaEntrada<=:fechaEntrada AND fechaSalida>=:fechaEntrada) OR (fechaEntrada>=:fechaEntrada AND fechaSalida<=:fechaSalida) OR ((fechaEntrada>=:fechaEntrada AND fechaEntrada<=:fechaSalida) AND fechaSalida>=:fechaSalida)) group by b.id";
			query=session.createQuery(sql);
			query.setParameter("hotelid", Long.valueOf(id_hotel));
			query.setParameter("id_habitacion", Long.valueOf(id_habitacion));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        Date date=formatter.parse(fechaEntrada);
	        query.setParameter("fechaEntrada", date);
	        formatter = new SimpleDateFormat("dd/MM/yyyy");
	        date=formatter.parse(fechaSalida);
	        query.setParameter("fechaSalida", date);
			numberofrooms=query.list();
			if (numberofrooms.isEmpty()){
				return "La combinacion de (habitacion,tarifa) seleccionada no se encuentra disponible para las fechas seleccionadas.";
			}else{
				Long idHabitacion=Long.valueOf(String.valueOf(numberofrooms.get(0)));
				Reserva reserva=new Reserva();
				reserva.setId(idultimareserva);
				reserva.setIdHabitacion(idHabitacion);
				reserva.setIdTarifa(Long.valueOf(id_tarifa));
				reserva.setNombre(nombre);
				reserva.setApellido1(apellido1);
				reserva.setApellido2(apellido2);
				reserva.setEmail(email);
				reserva.setTelefono(telefono);
				reserva.setNumCuenta(numCuenta);
				reserva.setObservacion(observacion);
				/*query.setLong("idHabitacion", idHabitacion);
				query.setLong("idTarifa", Long.valueOf(id_tarifa));
				query.setString("nombre", nombre);
				query.setString("apellido1", apellido1);
				query.setString("apellido2", apellido2);
				query.setString("email", email);
				query.setString("telefono", telefono);
				query.setString("numCuenta", numCuenta);
				query.setString("observacion", observacion);*/
				formatter = new SimpleDateFormat("dd/MM/yyyy");
		        date=new Date();
		        reserva.setFechaRealizacion(date);
		        //query.setDate("fechaRealizacion", date);
		        date=formatter.parse(fechaEntrada);
		        //query.setDate("fechaEntrada", date);
		        reserva.setFechaEntrada(date);
		        date=formatter.parse(fechaSalida);
		        //query.setDate("fechaSaldia", date);
		        reserva.setFechaSalida(date);
		        Long valor=null;
		        valor=(Long)session.save(reserva);
		        if (valor!=null){
		        	session.getTransaction().commit();
		        	return "Su reserva se ha realizado correctamente!";
		        	
		        }else{
		        	session.close();
		        	return "Su reservo no se ha podido realizar. Por favor, vuelva a intentarlo!";
		        }
			}
		} catch (HibernateException e){
			 System.out.println(e.getMessage());
	         System.out.println("error");
	         return "Error interno";
		}
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
			String sql="SELECT a.id,count(*) from TipoHabitacion a, Habitacion b where b.idTipoHabitacion=a.id AND b.numero not in (SELECT idHabitacion from Reserva where (fechaEntrada<=:fechaEntrada AND fechaSalida>=:fechaEntrada) OR (fechaEntrada>=:fechaEntrada AND fechaSalida<=:fechaSalida) OR ((fechaEntrada>=:fechaEntrada AND fechaEntrada<=:fechaSalida) AND fechaSalida>=:fechaSalida)) group by a.id";
			Query query=session.createQuery(sql);	
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        Date date=formatter.parse(fechaEntrada);
			query.setParameter("fechaEntrada",date);
			date=formatter.parse(fechaSalida);
			query.setParameter("fechaSalida",date);
			habitaciones=query.list();
		} catch (HibernateException e){
			 System.out.println(e.getMessage());
	         System.out.println("error");
		}
		return habitaciones;
	}
}

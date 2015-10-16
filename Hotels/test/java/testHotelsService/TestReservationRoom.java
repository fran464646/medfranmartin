package testHotelsService;

import static org.junit.Assert.assertTrue;
import hotel.Hotel;
import hotel.HotelDAO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestReservationRoom {
	
	HotelDAO hoteldao = new HotelDAO();
	
	@Test
	public void testCheckCorrectReservationRoom() throws ParseException{
		String respuesta;
		respuesta = hoteldao.doReserva("1","1","1","14/10/2015","15/10/2015","Fran","Pais","Fondo","francisco@udc.es","608360469","78960574","Vale");
		assertTrue(respuesta.equalsIgnoreCase("Su reserva se ha realizado correctamente!"));
		respuesta = hoteldao.doReserva("1","1","1","14/10/2015","15/10/2015","Fran","Pais","Fondo","francisco@udc.es","608360469","78960574","Vale");
		assertTrue(respuesta.equalsIgnoreCase("La combinacion de (habitacion,tarifa) seleccionada no se encuentra disponible para las fechas seleccionadas."));
		
		// 1. configuring hibernate
        Configuration configuration = new Configuration().configure();

        // 2. create sessionfactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // 3. Get Session object
        Session session = sessionFactory.openSession();

        // 4. Starting Transaction
        Transaction transaction = session.beginTransaction();
        
		String sql="select max(id) from Reserva";
		List<Object> lista = new ArrayList<Object>();
		Query query=session.createQuery(sql);
		lista = query.list();
		
		sql = "delete from Reserva where id = :id";
		query=session.createQuery(sql);
		String id = String.valueOf(lista.get(0));
		query.setParameter("id", Long.valueOf(id));
		query.executeUpdate();
		transaction.commit();
		session.close();

	}
	
}

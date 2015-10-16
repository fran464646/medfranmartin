package testHotelsService;

import static org.junit.Assert.assertTrue;
import hotel.Hotel;
import hotel.HotelDAO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class TestReservationRoom {
	
	HotelDAO hoteldao = new HotelDAO();
	
	@Test
	public void testCheckCorrectReservationRoom() throws ParseException{
		String respuesta;
		respuesta = hoteldao.doReserva("1","1","1","14/10/2015","15/10/2015","Fran","Pais","Fondo","francisco@udc.es","608360469","78960574","Vale");
		assertTrue(respuesta.equalsIgnoreCase("Su reserva se ha realizado correctamente!"));
	}
	
}

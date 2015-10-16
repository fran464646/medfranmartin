package testHotelsService;

import static org.junit.Assert.assertTrue;
import hotel.Hotel;
import hotel.HotelDAO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import servicio.Servicio;

public class TestFilterHotel {
	HotelDAO hoteldao = new HotelDAO();

	@Test
	public void testCheckFilterHotelsByPrice() throws ParseException{
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		keys.add("preciominimo");
		keys.add("preciomaximo");
		values.add("90");
		values.add("120");
		List<Hotel> hoteles = new ArrayList<Hotel>();
		hoteles = hoteldao.getHotels(keys,values);
		
		Iterator itr = hoteles.iterator();
	       Object[] obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),3l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),7l)==0);
	}
	
	@Test
	public void testCheckFilterHotelsByServices() throws ParseException{
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		keys.add("servicios");
		values.add("Comida");
		List<Hotel> hoteles = new ArrayList<Hotel>();
		hoteles = hoteldao.getHotels(keys,values);
		
		Iterator itr = hoteles.iterator();
	       Object[] obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),1l)==0);
	}
	
	@Test
	public void testCheckFilterHotelsByNumberOfAvailableRooms() throws ParseException{
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		keys.add("numeroHabitaciones");
		values.add("3");
		List<Hotel> hoteles = new ArrayList<Hotel>();
		hoteles = hoteldao.getHotels(keys,values);
		
		Iterator itr = hoteles.iterator();
	       Object[] obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),3l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),4l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),5l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),6l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),7l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),8l)==0);
	}
	
	@Test
	public void testCheckFilterHotelsByAvailability() throws ParseException{
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		keys.add("fechaEntrada");
		keys.add("fechaSalida");
		values.add("13/10/2015");
		values.add("14/10/2015");
		List<Hotel> hoteles = new ArrayList<Hotel>();
		hoteles = hoteldao.getHotels(keys,values);
		
		Iterator itr = hoteles.iterator();
	       Object[] obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),1l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),3l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),4l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),5l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),6l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),7l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),8l)==0);
	}
	
}

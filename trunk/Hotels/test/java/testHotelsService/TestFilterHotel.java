package testHotelsService;

import static org.junit.Assert.assertTrue;
import hotel.Hotel;
import hotel.HotelDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import servicio.Servicio;

public class TestFilterHotel {
	HotelDAO hoteldao = new HotelDAO();

	@Test
	public void testCheckFilterHotelsByPrice() {
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		keys.add("preciominimo");
		keys.add("preciomaximo");
		values.add("90");
		values.add("120");
		List<Hotel> hoteles = new ArrayList<Hotel>();
		hoteles = hoteldao.getHotels(keys,values);
	    assertTrue(Long.compare(hoteles.get(0).getId(),3l)==0);
	    assertTrue(Long.compare(hoteles.get(1).getId(),7l)==0);
	}
	
	@Test
	public void testCheckFilterHotelsByServices() {
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		keys.add("servicio");
		values.add("comida");
		List<Hotel> hoteles = new ArrayList<Hotel>();
		hoteles = hoteldao.getHotels(keys,values);
	    assertTrue(Long.compare(hoteles.get(0).getId(),1l)==0);
	}
	
	@Test
	public void testCheckFilterHotelsByNumberOfAvailableRooms() {
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		keys.add("numeroHabitaciones");
		values.add("3");
		List<Hotel> hoteles = new ArrayList<Hotel>();
		hoteles = hoteldao.getHotels(keys,values);
	    assertTrue(Long.compare(hoteles.get(0).getId(),3l)==0);
	    assertTrue(Long.compare(hoteles.get(1).getId(),4l)==0);
	    assertTrue(Long.compare(hoteles.get(2).getId(),5l)==0);
	    assertTrue(Long.compare(hoteles.get(3).getId(),6l)==0);
	    assertTrue(Long.compare(hoteles.get(4).getId(),7l)==0);
	    assertTrue(Long.compare(hoteles.get(5).getId(),8l)==0);
	}
	
}

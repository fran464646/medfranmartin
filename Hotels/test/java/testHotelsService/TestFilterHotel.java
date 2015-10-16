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
	public void testCheckFilterHotelByPrice() {
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
}

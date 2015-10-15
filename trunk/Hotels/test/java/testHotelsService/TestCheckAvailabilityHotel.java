package testHotelsService;

import static org.junit.Assert.assertTrue;
import hotel.HotelDAO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tipoHabitacion.TipoHabitacion;

public class TestCheckAvailabilityHotel {
	List<TipoHabitacion> tipos = new ArrayList<TipoHabitacion>();
	HotelDAO hoteldao;
	@Test
	public void testCheckAvailability() throws ParseException {
		tipos = hoteldao.getHotelRooms("1", "14/10/2015", "15/10/2015");
		System.out.println(tipos.get(0).getId());
		System.out.println(tipos.get(1).getId());
		assertTrue(Long.compare(tipos.get(0).getId(),1)==0);
		assertTrue(Long.compare(tipos.get(1).getId(),2)==0);

	}
	
	
}

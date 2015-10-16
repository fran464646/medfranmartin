package testHotelsService;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hotel.HotelDAO;

import org.junit.Test;

import servicio.Servicio;
import tipoHabitacion.TipoHabitacion;

public class TestViewRoom {
	HotelDAO hoteldao = new HotelDAO();
	
	@Test
	public void testCheckViewRoom() {
		TipoHabitacion result;
		result = hoteldao.getHabitacion("1");
		assertTrue(Long.compare(result.getId(),1l)==0);
	}
	
	@Test
	public void testCheckViewServicesRoom() {
		List<Servicio> servicios = new ArrayList<Servicio>();
		servicios = hoteldao.getServiciosHabitacion("1");
		Iterator itr = servicios.iterator();
	       Object[] obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),1l)==0);
	       obj = (Object[]) itr.next();
	       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),2l)==0);
		}
}
	

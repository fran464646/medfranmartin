package testHotelsService;

import static org.junit.Assert.assertTrue;
import hotel.HotelDAO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import regimen.Regimen;
import servicio.Servicio;
import tipoHabitacion.TipoHabitacion;

public class TestViewHotel {
	HotelDAO hoteldao = new HotelDAO();
	@Test
	public void testCheckAvailabilityHotel() throws ParseException {
		List<TipoHabitacion> tipos = new ArrayList<TipoHabitacion>();
		tipos=hoteldao.getHotelRooms("1", "14/10/2015", "15/10/2015");
		Iterator itr = tipos.iterator();
       Object[] obj = (Object[]) itr.next();
       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),1)==0);
       obj = (Object[]) itr.next();
       assertTrue(Long.compare(Long.valueOf(String.valueOf(obj[0])),2)==0);
	}
	
	@Test
	public void testCheckServicesHotel() {
		List<Servicio> servicios = new ArrayList<Servicio>();
		servicios = hoteldao.getServiciosHotel("1");
	       assertTrue(Long.compare(servicios.get(0).getId(),1l)==0);
	}
}

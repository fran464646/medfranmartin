package testHotelsService;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hotel.HotelDAO;

import org.junit.Test;

import regimen.Regimen;
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
	       assertTrue(Long.compare(servicios.get(0).getId(),1l)==0);
	       assertTrue(Long.compare(servicios.get(1).getId(),2l)==0);
		}
	
	@Test
	public void testCheckViewRegimesRoom() {
		List<Regimen> regimenes = new ArrayList<Regimen>();
		regimenes = hoteldao.getRegimenesHabitacion("1");
	       assertTrue(Long.compare(regimenes.get(0).getId(),1l)==0);
	       assertTrue(Long.compare(regimenes.get(1).getId(),2l)==0);
		}
	
	@Test
	public void testCheckViewRatesRoom() {
		List<Tarifa> tarifas = new ArrayList<Tarifa>();
		tarifas = hoteldao.getTarifasHabitacion("1");
	       assertTrue(Long.compare(tarifas.get(0).getId(),1l)==0);
	       assertTrue(Long.compare(tarifas.get(1).getId(),2l)==0);
	       assertTrue(Long.compare(tarifas.get(2).getId(),3l)==0);
	       assertTrue(Long.compare(tarifas.get(3).getId(),4l)==0);
		}
}
	

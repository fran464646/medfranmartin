package testHotelsService;

import static org.junit.Assert.*;
import hotel.Hotel;
import hotel.HotelDAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestOrderHotels {

	HotelDAO hoteldao = new HotelDAO();
	ArrayList<String> keys = new ArrayList<String>();
	ArrayList<String> values = new ArrayList<String>();
	List<Hotel> hoteles_BD = new ArrayList<Hotel>();
	
	@Test
	public void testOrderHotelsByName() {
		int i = 0;
		keys.add("orderby");
		values.add("nombre");
		hoteles_BD = hoteldao.getHotels(keys, values);
		int tamano = hoteles_BD.size();
		if (tamano>1){
			for (int j = 1;j<tamano;j++){
				assertTrue(hoteles_BD.get(i).getNombre().compareToIgnoreCase(hoteles_BD.get(j).getNombre())<=0);
			}
		} else assertTrue(true);
	}
	
	@Test
	public void testOrderHotelsByCategory() {
		int i = 0;
		keys.add("orderby");
		values.add("categoria");
		hoteles_BD = hoteldao.getHotels(keys, values);
		int tamano = hoteles_BD.size();
		if (tamano>1){
			for (int j = 1;j<tamano;j++){
				assertTrue(Integer.compare(hoteles_BD.get(i).getCategoria(),hoteles_BD.get(j).getCategoria())<=0);
			}
		} else assertTrue(true);
	}

}

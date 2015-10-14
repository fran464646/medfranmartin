package testHotelsService;

import static org.junit.Assert.*;
import hotel.Hotel;
import hotel.HotelDAO;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	@Test
	public void testOrderHotelsByPrice() {
		keys.add("orderby");
		values.add("precio");
		hoteles_BD =  hoteldao.getHotels(keys, values);
		List <Hotel> hoteles = new ArrayList<Hotel>();
		
		Hotel h1 = new Hotel();
		h1.setId(5l);
		Hotel h2 = new Hotel();
		h2.setId(3l);
		Hotel h3 = new Hotel();
		h3.setId(8l);
		Hotel h4 = new Hotel();
		h4.setId(1l);
		Hotel h5 = new Hotel();
		h5.setId(4l);
		Hotel h6 = new Hotel();
		h6.setId(2l);
		Hotel h7 = new Hotel();
		h7.setId(7l);
		Hotel h8 = new Hotel();
		h8.setId(6l);
		
		hoteles.add(h1);
		hoteles.add(h2);
		hoteles.add(h3);
		hoteles.add(h4);
		hoteles.add(h5);
		hoteles.add(h6);
		hoteles.add(h7);
		hoteles.add(h8);
		
		Iterator itr = hoteles_BD.iterator();
		int i = 0;
        while(itr.hasNext()){
           Object[] obj = (Object[]) itr.next();
           //now you have one array of Object for each row
           String id = String.valueOf(obj[0]); // don't know the type of column CLIENT assuming String
           assertTrue(Long.compare(Long.valueOf(id),hoteles.get(i).getId())==0);
           i++;
        }
	}

}

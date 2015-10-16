package testHotelsService;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import hotel.Hotel;
import hotel.HotelDAO;

import org.junit.Test;

public class TestSearchHotels {
	HotelDAO hoteldao = new HotelDAO();
	ArrayList<String> keys = new ArrayList<String>();
	ArrayList<String> values = new ArrayList<String>();
	List<Hotel> hoteles_BD = new ArrayList<Hotel>();
	
	@Test
	public void testSearchHotelByCity() throws ParseException{
		keys.add("ciudad");
		values.add("Coristanco");
		hoteles_BD= hoteldao.getHotels(keys, values);
		for (Hotel h : hoteles_BD) assertTrue(h.getCiudad().equalsIgnoreCase("Coristanco"));
	}
	
	@Test
	public void testSearchHotelByName() throws ParseException{
		keys.add("nombre");
		values.add("Buena vista");
		hoteles_BD= hoteldao.getHotels(keys, values);
		for (Hotel h : hoteles_BD) assertTrue(h.getNombre().equalsIgnoreCase("Buena vista"));
	}
	
	@Test
	public void testSearchHotelByStreet() throws ParseException{
		keys.add("calle");
		values.add("Avenida Federico");
		hoteles_BD= hoteldao.getHotels(keys, values);
		for (Hotel h : hoteles_BD) assertTrue(h.getCalle().equalsIgnoreCase("Avenida Federico"));
	}
	
	@Test
	public void testSearchHotelByCategory() throws ParseException{
		keys.add("categoria");
		values.add("4");
		hoteles_BD= hoteldao.getHotels(keys, values);
		for (Hotel h : hoteles_BD) assertTrue(Integer.compare(h.getCategoria(),4)==0);
	}

}

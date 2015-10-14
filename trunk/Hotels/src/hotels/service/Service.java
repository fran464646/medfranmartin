package hotels.service;

import static org.junit.Assert.assertTrue;
import hotel.Hotel;
import hotel.HotelDAO;
import hotel.HotelResults;

import java.io.IOException;
import java.io.PrintWriter;
 
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
 
public class Service extends HttpServlet {
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
 
        String hotels = null;
        Enumeration parameters = request.getParameterNames();
        ArrayList<String> keys=new ArrayList<String>();
        ArrayList<String> values=new ArrayList<String>();
        List<Hotel> hotelList = new ArrayList<Hotel>();
        List<HotelResults> hotelListResult = new ArrayList<HotelResults>();
        while (parameters.hasMoreElements()){
        	String key=(String) parameters.nextElement();
        	keys.add(key);
        	String value=request.getParameter(key);
        	values.add(value);
        }
        try
        {
        hotelList = new HotelDAO().getHotels(keys,values);
        if (values.contains("precio")){
	        Iterator itr = hotelList.iterator();
	        while(itr.hasNext()){
	           Object[] obj = (Object[]) itr.next();
	           //now you have one array of Object for each row
	           Long id = Long.valueOf(String.valueOf(obj[0]));
	           String nombre = String.valueOf(obj[1]);
	           String calle = String.valueOf(obj[2]);
	           String ciudad = String.valueOf(obj[3]);
	           String descripcion = String.valueOf(obj[4]);
	           Integer categoria = Integer.valueOf(String.valueOf(obj[5]));
	           String telefono = String.valueOf(obj[6]);
	           String correoElectronico = String.valueOf(obj[7]);
	           Double precio = Double.valueOf(String.valueOf(obj[8]));
	           System.out.println(precio);
	           HotelResults hotel=new HotelResults(id,nombre,calle,ciudad,descripcion,categoria,telefono,correoElectronico,precio);
	           hotelListResult.add(hotel);
	        }
	        Gson gson = new Gson();
	        hotels = gson.toJson(hotelListResult);
	        writer.println(hotels);
	    }else{
	        Gson gson = new Gson();
	        hotels = gson.toJson(hotelList);
	        writer.println(hotels);
        }
        } catch (Exception e)
        {
        e.printStackTrace();
        }
        
    }
 
}

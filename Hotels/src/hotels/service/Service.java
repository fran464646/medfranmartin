package hotels.service;

import hotel.Hotel;
import hotel.HotelDAO;

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
        while (parameters.hasMoreElements()){
        	String key=(String) parameters.nextElement();
        	keys.add(key);
        	String value=request.getParameter(key);
        	values.add(value);
        }
        try
        {
        hotelList = new HotelDAO().getHotels(keys,values);
        Gson gson = new Gson();
        hotels = gson.toJson(hotelList);
        } catch (Exception e)
        {
        e.printStackTrace();
        }
        if (keys.contains("orderbyprice")){
	        Iterator itr = hotelList.iterator();
	        while(itr.hasNext()){
	           Object[] obj = (Object[]) itr.next();
	           String id = String.valueOf(obj[0]); 
	           String nombre = String.valueOf(obj[1]);
	           String ciudad = String.valueOf(obj[2]);
	           String calle = String.valueOf(obj[3]);
	           String descripcion = String.valueOf(obj[4]);
	           String categoria = String.valueOf(obj[5]);
	           String telefono = String.valueOf(obj[6]);
	           String email = String.valueOf(obj[7]);
	           writer.println("Id="+id+" Nombre="+nombre+" Ciudad="+ciudad+" Calle="+calle+" Descripcion="+descripcion+" Categoria="+categoria+" Telefono="+telefono+" Email="+email+"\n");
	        }
        }else{
	        for (Hotel hotel : hotelList){
	        	writer.println("Id="+hotel.getId()+" Nombre="+hotel.getNombre()+" Ciudad="+hotel.getCiudad()+" Calle="+hotel.getCalle()+" Descripcion="+hotel.getDescripcion()+" Categoria="+hotel.getCategoria()+" Telefono="+hotel.getTelefono()+" Email="+hotel.getCorreoElectronico()+"\n");

	        }
        }
    }
 
}

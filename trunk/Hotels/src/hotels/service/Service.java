package hotels.service;

import hotel.Hotel;
import hotel.HotelDAO;

import java.io.IOException;
import java.io.PrintWriter;
 
import java.util.ArrayList;
import java.util.Enumeration;
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
        for (Hotel hotel : hotelList){
        	writer.println("Id="+hotel.getId()+" Nombre="+hotel.getNombre()+" Ciudad="+hotel.getCiudad()+" Calle="+hotel.getCalle()+" Descripcion="+hotel.getDescripcion()+" Categoria="+hotel.getCategoria()+" Telefono="+hotel.getTelefono()+" Email="+hotel.getCorreoElectronico()+"\n");
        }
    }
 
}

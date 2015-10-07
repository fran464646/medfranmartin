package webService;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
 

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

import com.google.gson.Gson;
 


import com.sun.jersey.api.core.HttpContext;

import model.AccessManager;
 
import Hotel.Hotel;
 
@Path("/hotelService")
public class HotelService
{
@GET
@Path("/hotels")
@Produces("application/json")
public String hotels(@Context HttpServletRequest context)
{
String hotels = null;
Enumeration parameters = context.getParameterNames();
ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
while (parameters.hasMoreElements()){
	String key = (String) parameters.nextElement();
	String value = context.getParameter(key);
	if (key.equalsIgnoreCase("ciudad")){
		try
		{
		hotelList = new AccessManager().getHotelsByCity(value);
		hotelList = new AccessManager().getHotels();
		Gson gson = new Gson();
		hotels = gson.toJson(hotelList);
		} catch (Exception e)
		{
		e.printStackTrace();
		}
	}
}

return hotels;
}
}

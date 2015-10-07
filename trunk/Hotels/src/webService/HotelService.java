package webService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
 
import com.google.gson.Gson;
 
import model.AccessManager;
 
import Hotel.Hotel;
 
@Path("/hotelService")
public class HotelService
{
@GET
@Path("/hotels")
@Produces("application/json")
public String hotels()
{
String hotels = null;
ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
try
{
hotelList = new AccessManager().getHotels();
Gson gson = new Gson();
hotels = gson.toJson(hotelList);
} catch (Exception e)
{
e.printStackTrace();
}
return hotels;
}
}

package hotels.service;

import habitacion.Habitacion;
import hotel.Hotel;
import hotel.HotelDAO;
import hotel.HotelResults;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
 
@Path("/")
public class Service {
 
	
	@GET
	@Path("/{id_hotel}/Habitaciones")
	public String Hotel(@PathParam("id_hotel")String id, @QueryParam("fechaEntrada")String fechaEntrada,@QueryParam("fechaSalida")String fechaSalida) throws ParseException{
		String habitacionesJSON;
		List<String> habitaciones=new HotelDAO().getHotelRooms(id,fechaEntrada,fechaSalida);
		Gson gson = new Gson();
        habitacionesJSON = gson.toJson(habitaciones);
        return habitacionesJSON;
	}
	@GET
	@Path("/")
    public String Hoteles(@QueryParam("nombre") String nombre,@QueryParam("ciudad") String ciudad,@QueryParam("calle") String calle,@QueryParam("categoria") String categoria,@QueryParam("orderby") String orderby){

		ArrayList<String> keys=new ArrayList<String>();
        ArrayList<String> values=new ArrayList<String>();
        String hotels = null;
        if(nombre!=null){
        	keys.add("nombre");
        	values.add(nombre);
        }
        if(ciudad!=null){
        	keys.add("ciudad");
        	values.add(ciudad);
        }
        if(calle!=null){
        	keys.add("calle");
        	values.add(calle);
        }
        if(categoria!=null){
        	keys.add("categoria");
        	values.add(categoria);
        }
        if(orderby!=null){
        	keys.add("orderby");
        	values.add(orderby);
        }
        List<Hotel> hotelList = new ArrayList<Hotel>();
        List<HotelResults> hotelListResult = new ArrayList<HotelResults>();
        try
        {
        hotelList = new HotelDAO().getHotels(keys,values);
        if (orderby!=null && orderby.contains("precio")){
	        Iterator itr = hotelList.iterator();
	        while(itr.hasNext()){
	           Object[] obj = (Object[]) itr.next();
	           //now you have one array of Object for each row
	           Long id = Long.valueOf(String.valueOf(obj[0]));
	           String nombre1 = String.valueOf(obj[1]);
	           String ciudad1 = String.valueOf(obj[2]);
	           String calle1 = String.valueOf(obj[3]);
	           String descripcion = String.valueOf(obj[4]);
	           Integer categoria1 = Integer.valueOf(String.valueOf(obj[5]));
	           String telefono = String.valueOf(obj[6]);
	           String correoElectronico = String.valueOf(obj[7]);
	           Double precio = Double.valueOf(String.valueOf(obj[8]));
	           HotelResults hotel=new HotelResults(id,nombre1,calle1,ciudad1,descripcion,categoria1,telefono,correoElectronico,precio);
	           hotelListResult.add(hotel);
	        }
	        Gson gson = new Gson();
	        hotels = gson.toJson(hotelListResult);
	        return hotels;
	    }else{
	        Gson gson = new Gson();
	        hotels = gson.toJson(hotelList);
	        return hotels;
        }
        } catch (Exception e)
        {
        e.printStackTrace();
        return "";
        }
        
    }
}
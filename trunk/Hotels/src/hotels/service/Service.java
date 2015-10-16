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

import regimen.Regimen;
import servicio.Servicio;
import tarifa.Tarifa;
import tipoHabitacion.TipoHabitacion;

import com.google.gson.Gson;
 
@Path("/")
public class Service {
 
	@GET
	@Path("/{id_hotel}/Habitaciones/{id_habitacion}/Tarifas/{id_tarifa}/Reservar")
	public String HacerReserva(@PathParam("id_hotel")String id_hotel,@PathParam("id_habitacion")String id_habitacion,@PathParam("id_tarifa")String id_tarifa,@QueryParam("fechaEntrada")String fechaEntrada,@QueryParam("fechaSalida")String fechaSalida,@QueryParam("nombre")String nombre,@QueryParam("apellido1")String apellido1,@QueryParam("apellido2")String apellido2,@QueryParam("email")String email,@QueryParam("telefono")String telefono,@QueryParam("numCuenta")String numCuenta,@QueryParam("observacion")String observacion) throws ParseException{
		String hotelJSON;
		String respuesta;
		System.out.println(id_hotel);
		System.out.println(id_habitacion);
		System.out.println(id_tarifa);
		System.out.println(fechaEntrada);
		System.out.println(fechaSalida);
		System.out.println(nombre);
		System.out.println(apellido1);
		System.out.println(apellido2);
		System.out.println(email);
		System.out.println(telefono);
		System.out.println(numCuenta);
		System.out.println(observacion);
		if (id_hotel!=null && id_habitacion!=null && id_tarifa!=null && fechaEntrada!=null && fechaSalida!=null && nombre!=null && apellido1!=null && apellido2!=null && email!=null && telefono!=null && numCuenta!=null && observacion!=null){
			 respuesta=new HotelDAO().doReserva(id_hotel,id_habitacion,id_tarifa,fechaEntrada,fechaSalida,nombre,apellido1,apellido2,email,telefono,numCuenta,observacion);
			 Gson gson = new Gson();
		        hotelJSON = gson.toJson(respuesta);
		        return hotelJSON;
		}else{
			String fallo="Los datos introducidos son incorrectos. Por favor, revíselos y vuelva a intentarlo.";
			Gson gson = new Gson();
	        hotelJSON = gson.toJson(fallo);
	        return hotelJSON;
		}
	}
	
	
	@GET
	@Path("/{id_hotel}/Servicios")
	public String ServiciosHotel(@PathParam("id_hotel")String id_hotel) throws ParseException{
		String hotelJSON;
		List<Servicio> serviciosHotel=new HotelDAO().getServiciosHotel(id_hotel);
		Gson gson = new Gson();
        hotelJSON = gson.toJson(serviciosHotel);
        return hotelJSON;
	}
	
	@GET
	@Path("/{id_hotel}/Habitaciones/{id_habitacion}/Tarifas")
	public String TarifasHabitacion(@PathParam("id_habitacion")String id_habitacion) throws ParseException{
		String habitacionJSON;
		List<Tarifa> tarifasHabitacion=new HotelDAO().getTarifasHabitacion(id_habitacion);
		Gson gson = new Gson();
        habitacionJSON = gson.toJson(tarifasHabitacion);
        return habitacionJSON;
	}
	
	@GET
	@Path("/{id_hotel}/Habitaciones/{id_habitacion}/Regimenes")
	public String RegimenesHabitacion(@PathParam("id_habitacion")String id_habitacion) throws ParseException{
		String habitacionJSON;
		List<Regimen> regimenesHabitacion=new HotelDAO().getRegimenesHabitacion(id_habitacion);
		Gson gson = new Gson();
        habitacionJSON = gson.toJson(regimenesHabitacion);
        return habitacionJSON;
	}
	
	@GET
	@Path("/{id_hotel}/Habitaciones/{id_habitacion}/Servicios")
	public String ServiciosHabitacion(@PathParam("id_habitacion")String id_habitacion) throws ParseException{
		String habitacionJSON;
		List<Servicio> serviciosHabitacion=new HotelDAO().getServiciosHabitacion(id_habitacion);
		Gson gson = new Gson();
        habitacionJSON = gson.toJson(serviciosHabitacion);
        return habitacionJSON;
	}
	
	@GET
	@Path("/{id_hotel}/Habitaciones/{id_habitacion}")
	public String Habitacion(@PathParam("id_habitacion")String id_habitacion) throws ParseException{
		String habitacionJSON;
		TipoHabitacion habitacion=new HotelDAO().getHabitacion(id_habitacion);
		Gson gson = new Gson();
        habitacionJSON = gson.toJson(habitacion);
        return habitacionJSON;
	}
	
	@GET
	@Path("/{id_hotel}/Habitaciones")
	public String Hotel(@PathParam("id_hotel")String id, @QueryParam("fechaEntrada")String fechaEntrada,@QueryParam("fechaSalida")String fechaSalida) throws ParseException{
		String habitacionesJSON;
		List<TipoHabitacion> habitaciones=new HotelDAO().getHotelRooms(id,fechaEntrada,fechaSalida);
		List<TipoHabitacion> habitacionesfinal=new ArrayList<TipoHabitacion>();
		 Iterator itr = habitaciones.iterator();
	        while(itr.hasNext()){
	           Object[] obj = (Object[]) itr.next();
	           //now you have one array of Object for each row
	           Long idHabitacion = Long.valueOf(String.valueOf(obj[0]));
	           Long idHotel = Long.valueOf(String.valueOf(obj[1]));
	           String nombre = String.valueOf(obj[2]);
	           Integer capacidad = Integer.valueOf(String.valueOf(obj[3]));
	           Integer tamano = Integer.valueOf(String.valueOf(obj[4]));
	           String tipoCama = String.valueOf(obj[5]);
	           Boolean oferta = Boolean.valueOf(String.valueOf(obj[6]));	
	           TipoHabitacion tipoHabitacion=new TipoHabitacion(idHabitacion,idHotel,nombre,capacidad,tamano,tipoCama,oferta);
	           habitacionesfinal.add(tipoHabitacion);
	        }
		Gson gson = new Gson();
        habitacionesJSON = gson.toJson(habitacionesfinal);
        return habitacionesJSON;
	}
	
	@GET
	@Path("/")
    public String Hoteles(@QueryParam("nombre") String nombre,@QueryParam("ciudad") String ciudad,@QueryParam("calle") String calle,@QueryParam("categoria") String categoria,@QueryParam("orderby") String orderby,@QueryParam("preciominimo") String preciominimo,@QueryParam("preciomaximo") String preciomaximo, @QueryParam("servicios") String servicios, @QueryParam("numeroHabitaciones") String numeroHabitaciones){

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
        if(preciominimo!=null){
        	keys.add("preciominimo");
        	values.add(preciominimo);
        }
        if(preciomaximo!=null){
        	keys.add("preciomaximo");
        	values.add(preciomaximo);
        }
        if(servicios!=null){
        	keys.add("servicios");
        	values.add(servicios);
        }

        if(numeroHabitaciones!=null){
        	keys.add("numeroHabitaciones");
        	values.add(numeroHabitaciones);
        }
        List<Hotel> hotelList = new ArrayList<Hotel>();
        List<HotelResults> hotelListResult = new ArrayList<HotelResults>();
        try
        {
        hotelList = new HotelDAO().getHotels(keys,values);
        if ((orderby!=null && orderby.contains("precio"))||servicios!=null||numeroHabitaciones!=null||preciominimo!=null||preciomaximo!=null){
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
	           Boolean enTemporada = Boolean.valueOf(String.valueOf(obj[8]));
	           Double precio = Double.valueOf(String.valueOf(obj[9]));
	           HotelResults hotel=new HotelResults(id,nombre1,calle1,ciudad1,descripcion,categoria1,telefono,correoElectronico,precio,enTemporada);
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

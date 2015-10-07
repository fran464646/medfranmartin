package model;

import java.sql.Connection;
import java.util.ArrayList;

import Hotel.Access;
import Hotel.Database;
import Hotel.Hotel;
 
 
public class AccessManager
{
public ArrayList<Hotel> getHotels() throws Exception
{
ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
Database db = new Database();
Connection conexion = db.getConnection();
Access access = new Access();
hotelList = access.getHotels(conexion);
return hotelList;
}

public ArrayList<Hotel> getHotelsByCity(String city) throws Exception
{
ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
Database db = new Database();
Connection conexion = db.getConnection();
Access access = new Access();
hotelList = access.getHotelsByCity(conexion,city);
return hotelList;
}
}

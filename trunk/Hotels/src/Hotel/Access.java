package Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
public class Access
{
public ArrayList<Hotel> getHotels(Connection conexion) throws SQLException
{
ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM hotel");
ResultSet rs = stmt.executeQuery();
try
{
while(rs.next())
{
Hotel hotelObj = new Hotel();
hotelObj.setId(rs.getLong("id"));
hotelObj.setNombre(rs.getString("nombre"));
hotelObj.setCiudad(rs.getString("ciudad"));
hotelObj.setCalle(rs.getString("calle"));
hotelObj.setDescripcion(rs.getString("descripcion"));
hotelObj.setCategoria(rs.getInt("categoria"));
hotelObj.setTelefono(rs.getString("telefono"));
hotelObj.setCorreoElectronico(rs.getString("correoElectronico"));
hotelList.add(hotelObj);
}
} catch (SQLException e)
{
e.printStackTrace();
}
return hotelList;
 
}
}

package Hotel;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database
{
public Connection getConnection() throws Exception
{
try
{
String connectionURL = "jdbc:mysql://localhost:3306/ws";
Connection connection = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "root", "608360469");
return connection;
} catch (Exception e)
{
throw e;
}

}

}

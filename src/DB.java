import java.net.*;
import java.sql.*;

public class DB  {
  public static Connection getConnection(){
   Connection con =null;
   
   try
   {
        Class.forName("org.h2.Driver");
       con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/library","","");
       System.out.println("connection established");
   
   }
   catch(Exception e)
   {
    e.printStackTrace();
    
   }
  
  
    
            
    return con;
}
}

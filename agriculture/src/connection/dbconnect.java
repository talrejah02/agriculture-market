package connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnect {
	public  static Connection createconnection() {
		     Connection con = null;
		     String url = "jdbc:mysql://localhost:3306/agro"; //MySQL URL followed by the database name
		     String username = "root"; //MySQL username
		     System.out.println("In DBConnection.java class ");
		     
		      
		     try
		     {
		         try
		         {
		            Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
		         } 
		         catch (ClassNotFoundException e)
		         {
		            e.printStackTrace();
		         }       
		     
				con = DriverManager.getConnection(url, username,""); //attempting to connect to MySQL database
		         System.out.println("Printing connection object "+con);
		     } 
		     catch (Exception e) 
		     {
		        e.printStackTrace();
		     }   
		     return con; 
		 }
		
	}
	



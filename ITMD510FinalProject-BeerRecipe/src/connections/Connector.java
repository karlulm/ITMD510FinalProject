package connections;

import java.sql.*;

public class Connector {

	public Connection OpenConnection(){
		

		   String DB_URL = "jdbc:mysql://www.papademas.net:3306/510labs?autoReconnect=true&useSSL=false";


		   String user = "db510";
		   String password = "510";

		   Connection conn = null;
//		   Statement stmt = null;
		   try{
		      
		      Class.forName("com.mysql.jdbc.Driver");

		      
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, user, password);
		      
		      System.out.println("Connected to:" + DB_URL);		      
		      
		   }catch(SQLException se){
		      
		      se.printStackTrace();
		   }catch(Exception e){
		     
		      e.printStackTrace();
		   }
		   
		return conn;
		
	}
	
	public void Close(Connection conn){
		
		if (conn != null) {
	        try {
	        	conn.close();
	        	System.out.print("Connection Closed");
	        } catch (SQLException e) { /* ignored */}
	    }
	}

}

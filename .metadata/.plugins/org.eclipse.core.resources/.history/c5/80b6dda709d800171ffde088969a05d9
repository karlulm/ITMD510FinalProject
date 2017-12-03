package SQL;

import java.sql.Connection;
import java.sql.*;

public class CreateTables {
	

	
	
	String createUserTable = "CREATE TABLE k_ulm_FP_Users (" +
			"UserID INT, " +
			"UserName VARCHAR(255), " +
			"UserEmail VARCHAR(255), " + 
			"UserFristName VARCHAR(255), " +
			"UserLastName VARCHAR(255), " + 
			"UserPassword VARCHAR(255), " +
			"AccountCreatedOn Date," +
			"IsAdmin VARCHAR(255))";
	
	public String getCreateUserTable() {
		return createUserTable;
	}
	
	

	public void runCreateStatment(Connection conn, String sqlStatment){
		
		 Statement stmt = null;
		
		 try{
			 stmt = conn.createStatement();
			 	 
			 stmt.executeUpdate(sqlStatment);
			 
			 System.out.println("Created User table...");
			 
		 }catch(SQLException se){
			 //Handle errors for JDBC
			 se.printStackTrace();
			 
		 }catch(Exception e){
			 //Handle errors for Class.forName
			 e.printStackTrace();
		 }
				
	}
	
	public Boolean SeeIfTableExisits(Connection conn,String tableName){
		
		Boolean doesTableExists = false;
		
		 try{
				DatabaseMetaData md = conn.getMetaData();
				ResultSet rs = md.getTables(null, null, "%", null);

				while (rs.next()) {
					
					if (rs.getString(3).equals(tableName)){
						
						doesTableExists = true;
						System.out.println("Table Already Exists");
					}
				}
		 }catch(SQLException se){
			 //Handle errors for JDBC
			 se.printStackTrace();
			 
		 }catch(Exception e){
			 //Handle errors for Class.forName
			 e.printStackTrace();
		 }
		
		return doesTableExists;
	}

}

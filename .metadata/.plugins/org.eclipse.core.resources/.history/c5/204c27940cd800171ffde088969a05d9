package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RunSqlStatement {
	
	public void RunStatement(Connection conn, String sqlStatment){
		
		 Statement stmt = null;
			
		 try{
			 stmt = conn.createStatement();
			 	 
			 stmt.executeUpdate(sqlStatment);
			 
			 
		 }catch(SQLException se){
			 //Handle errors for JDBC
			 se.printStackTrace();
			 
		 }catch(Exception e){
			 //Handle errors for Class.forName
			 e.printStackTrace();
		 }
				
	}

}

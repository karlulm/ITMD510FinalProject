package user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class User {
	
	//TODO create Unique UserNames and USerIDs
	//TODO User Login


	int userID;
	String userName;
	String userEmail;
	String userFristName;
	String userLastName;
	String userPassword;
	Date accountCreatedOn;
	Boolean isAdmin;
	
	
	public int getNewUserID(Connection conn){
		
	     int lastUserID = 0;
		
		
		try{		
			 Statement stmt = null;
			 
			 String query = "SELECT * FROM 510labs.k_ulm_fp_users";
			 
			 stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
		     
			 rs.last();
	    	 lastUserID = rs.getInt("UserID") + 1;
	    	 
		     if (lastUserID == 0){
		    	 lastUserID = 1000;
		    
		     }else{
		    	    	 
		    	 rs.last();
		    	 lastUserID = rs.getInt("UserID") + 1;
			 }

		 }catch(SQLException se){
			 //Handle errors for JDBC
			 se.printStackTrace();
			 
		 }catch(Exception e){
			 //Handle errors for Class.forName
			 e.printStackTrace();
		 }
		return lastUserID;
		
	}
	
	public User newUser(Connection conn,String userName, String userEmail, String userFristName, String userLastName, String userPassword){
		
		User newUser = new User();
		
		int newUserID = newUser.getNewUserID(conn);
		
		newUser.setUserID(newUserID);
		newUser.setUserName(userName);
		newUser.setUserEmail(userEmail);
		newUser.setUserFristName(userFristName);
		newUser.setUserLastName(userLastName);
		
		Login newLogin = new Login();
		
		newLogin.userSignUp(userPassword, newUser);
		
		 Date date = new Date();
		
		newUser.setAccountCreatedOn(date);	
		newUser.setIsAdmin(false);	
		
		return newUser;
	}
	
	public String UserToSqlInsert(User newUser){
		
		String sqlInsertIntoUsersTable = "INSERT INTO k_ulm_FP_Users VALUES(" +
				"'" + newUser.getUserID() + "' ," +
				"'" + newUser.getUserName() + "' ," +
				"'" + newUser.getUserEmail() + "' ," +
				"'" + newUser.getUserFristName() + "' ," +
				"'" + newUser.getUserLastName() + "' ," +
				"'" + newUser.getUserPassword() + "' ," +
				"NOW() ," +
				"'" + newUser.getIsAdmin() + "')";
				
		System.out.println(sqlInsertIntoUsersTable);
		
		
		
		
		return sqlInsertIntoUsersTable;
	}
	
	
	
	/*
	 * Getters and Setter below
	 */
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserFristName() {
		return userFristName;
	}
	public void setUserFristName(String userFristName) {
		this.userFristName = userFristName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public Date getAccountCreatedOn() {
		return accountCreatedOn;
	}
	public void setAccountCreatedOn(Date accountCreatedOn) {
		this.accountCreatedOn = accountCreatedOn;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
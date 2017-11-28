package user;

import java.security.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	String SALT = "Go Hawks";
	
	/*
	 * The userSignUp method will take in the user password and user name. It
	 * will then add a SALT and hash the password. This is done so the user 
	 * password is never sorted in plain text. This new hash value is then added
	 * back to the user object.
	 */
	
	public User userSignUp( String password, User newUser) {
		
		System.out.println("Passwprd Pre Hash round 1: " + password);
		
		String saltedPassword = SALT + password;
		
		System.out.println("Salted Passwprd Pre Hash round 1: " + saltedPassword);
		
		String hashedPassword = generateHash(saltedPassword);
		
		newUser.setUserPassword(hashedPassword);
		
		return newUser;
	}
	
	
	/*
	 * The generateHash takes a password with the added SALT and hashes the values
	 * making it almost impossible to hack the password.
	 */
	
	public static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest shaAlgorithm = MessageDigest.getInstance("SHA-1");
			
			byte[] hashedBytes = shaAlgorithm.digest(input.getBytes());
			
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
			
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}

	
	
	
	public Boolean isValidPassowrd(String username, String password,Connection conn) {
	
		Boolean isAuthenticated = false;
		
		try{
			
			Statement stmt = null;
			 
			String saltedPassword = SALT + password;
			
			String hashedPassword = generateHash(saltedPassword);
			
				
			String query = "SELECT * FROM 510labs.k_ulm_fp_users WHERE UserName = '" + username + "'";
			 
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			
			String storedPasswordHash = rs.getString("UserPassword");
			
	    	 
			if(hashedPassword.equals(storedPasswordHash)){
				isAuthenticated = true;
			}else{
				isAuthenticated = false;
			}

		 }catch(SQLException se){
			 //Handle errors for JDBC
			 se.printStackTrace();
			 
		 }catch(Exception e){
			 //Handle errors for Class.forName
			 e.printStackTrace();
		 }	
		
		return isAuthenticated;
	}
	
	
	
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
	
	/*
	 * verifyUser will check to make sure no null values got added to the User object
	 */
	
	public boolean verifyUser(User newUser){
		
		boolean isUserInfoValid = true;
		
		if (newUser.getUserID() == 0){
			
			isUserInfoValid = false;
		}
		
		if (newUser.getUserName().equals(null) || newUser.getUserName().equals("")){
			
			isUserInfoValid = false;
		}
		
		if (newUser.getUserEmail().equals(null)){
			
			isUserInfoValid = false;
		}
		
		if (newUser.getUserFristName().equals(null)){
			
			isUserInfoValid = false;
		}
		
		if (newUser.getUserLastName().equals(null)){
			
			isUserInfoValid = false;
		}
		if (newUser.getUserPassword().equals(null)){
			
			isUserInfoValid = false;
		}		
		
		return isUserInfoValid;
	}
	
	
	
	
}

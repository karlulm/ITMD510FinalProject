package user;

import java.security.*;

public class Login {

	String SALT = "Go Hawks";
	
	/*
	 * The userSignUp method will take in the user password and user name. It
	 * will then add a SALT and hash the password. This is done so the user 
	 * password is never sorted in plain text. This new hash value is then added
	 * back to the user object.
	 */
	
	public User userSignUp( String password, User newUser) {
		
		String saltedPassword = SALT + password;
		
		String hashedPassword = generateHash(saltedPassword);
		
		newUser.setUserPassword(hashedPassword);
		
		return newUser;
	}
	
	
	/*
	
	public Boolean login(String username, String password) {
		Boolean isAuthenticated = false;

		// remember to use the same SALT value use used while storing password
		// for the first time.
		String saltedPassword = SALT + password;
		String hashedPassword = generateHash(saltedPassword);

		String storedPasswordHash = DB.get(username);
		
		if(hashedPassword.equals(storedPasswordHash)){
			isAuthenticated = true;
		}else{
			isAuthenticated = false;
		}
		return isAuthenticated;
	}
	
	*/
	
	
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

	
	
}

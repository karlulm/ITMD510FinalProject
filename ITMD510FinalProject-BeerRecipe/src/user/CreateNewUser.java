package user;

import java.sql.Connection;

import SQL.RunSqlStatement;

public class CreateNewUser {
	
	public User newUser(Connection conn,String userName, String userEmail, String userFristName, String userLastName, String userPassword){
		
		User myNewUser = new User();
		
		Login newLogin = new Login();
		
		myNewUser = myNewUser.newUser(conn, userName, userEmail, userFristName, userLastName, userPassword);
		
		
		if (newLogin.verifyUser(myNewUser) == true){
			
			String Sql = myNewUser.UserToSqlInsert(myNewUser);
			
			RunSqlStatement toSQL = new RunSqlStatement();
			
			toSQL.RunStatement(conn, Sql);
			
		}	
		
		return myNewUser;
		
		
	}

}

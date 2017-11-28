package main;

import java.sql.Connection;

import SQL.CreateTables;
import SQL.RunSqlStatement;
import connections.Connector;
import connections.StartUpCheck;
import user.CreateNewUser;
import user.Login;
import user.User;

public class main {

	public static void main(String[] args) {
		
		Connector myConnector = new Connector();		
		Connection conn = myConnector.OpenConnection();

		StartUpCheck newStart = new StartUpCheck();
		
		newStart.StartUp(conn); //runs before first run of the software to make sure all tables are set up and working.
		
		
		CreateNewUser newUser = new CreateNewUser();
		
		newUser.newUser(conn, "", "TestUser@user.com", "Test", "User", "TestUser");
		
		
		Login newLogin = new Login();
		
		Boolean valid = newLogin.isValidPassowrd("TestUser", "TestUser", conn);
		
		System.out.println(valid);
		
		if (valid == true){
			System.out.println("we in Bitches");
		}
		
		
		
		myConnector.Close(conn);
		
		
		

	}

}
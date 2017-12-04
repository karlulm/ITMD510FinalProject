package main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import BeerRecipe.Fermentables;
import BeerRecipe.Hops;
import BeerRecipe.Yeasts;
import BreweryDB_APIs.FermentablesAPI;
import BreweryDB_APIs.HopsAPI;
import BreweryDB_APIs.YeastAPI;
import SQL.CreateTables;
import SQL.RunSqlStatement;
import UserInterface.UserLoginUI;
import connections.Connector;
import connections.StartUpCheck;
import user.CreateNewUser;
import user.Login;
import user.User;

public class main {

	public static void main(String[] args) {
		

		/*
		Connector myConnector = new Connector();		
		Connection conn = myConnector.OpenConnection();

		StartUpCheck newStart = new StartUpCheck();
		
		newStart.StartUp(conn); //runs before first run of the software to make sure all tables are set up and working.
		
		
		CreateNewUser newUser = new CreateNewUser();
		
		User myLoggedInrUser = new User();
		
//		myLoggedInrUser = newUser.newUser(conn, "testingTest", "TestUser@user.com", "Test", "User", "TestUser");
		
		
		Login newLogin = new Login();
		
		Boolean valid = newLogin.isValidPassowrd("BeerAdmin", "BeerRocks1234!", conn);

		
		System.out.println(valid);
		
		if (valid == true){
			System.out.println("we in Bitches");
			
			myLoggedInrUser = myLoggedInrUser.getMyUSerInfo("BeerAdmin", conn);
			
			FermentablesAPI FermAPI = new FermentablesAPI();
			
			List<Fermentables> FermAPIList = FermAPI.getFermentablesAPI(myLoggedInrUser);
			
			System.out.println(FermAPIList.size());
			
			for (int i = 0; FermAPIList.size() > i; ++i){
				
				Fermentables toSQL = new Fermentables();
				
				int testing = FermAPIList.get(i).getFermID();
				
				String tits = toSQL.FermToSqlInsert(FermAPIList.get(i));
				
				System.out.println(tits);
			}
			
		}
		
		
		
/*		
		
		FermentablesAPI FermAPI = new FermentablesAPI();
		
		User newUser = new User();
		
		List<User> userList = newUser.getUserList(conn);
		
		//System.out.println(userList.get(0).getUserName());
		
		int myUserID = 0;
		
		 myUserID = userList.get(0).getUserID();
		
		System.out.println("myUSer ID " + myUserID);
		
		
		
		*/
		
		
		
		/*
		
		
		List<Fermentables> FermAPIList = FermAPI.getFermentablesAPI(myUserID);
		
		System.out.println(FermAPIList.size());
		
		for (int i = 0; FermAPIList.size() > i; ++i){
			
			Fermentables toSQL = new Fermentables();
			
			int testing = FermAPIList.get(i).getFermID();
			
			String tits = toSQL.FermToSqlInsert(FermAPIList.get(i));
			
			System.out.println(tits);
		}
		
		
		*/
//		myConnector.Close(conn);
		
//		newUI.start();
		
		
		

		

	}

}
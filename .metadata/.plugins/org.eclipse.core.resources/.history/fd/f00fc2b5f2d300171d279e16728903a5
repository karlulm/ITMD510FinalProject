package main;

import java.sql.Connection;

import SQL.CreateTables;
import SQL.RunSqlStatement;
import connections.Connector;
import connections.StartUpCheck;
import user.Login;
import user.User;

public class main {

	public static void main(String[] args) {

		
		Connector conn = new Connector();
		
		Connection sqlConnection = conn.OpenConnection();
		
		CreateTables tables = new CreateTables();

		StartUpCheck firstRun = new StartUpCheck();
		
		firstRun.CheckTableSQLTables(sqlConnection);
		
		
		
		User myNewUser = new User();
		
		myNewUser = myNewUser.newUser(sqlConnection, "kulm", "kulm@hawk.iit.edu", "Karl", "Ulm", "gohawks");
		
		String Sql = myNewUser.UserToSqlInsert(myNewUser);
		
		RunSqlStatement toSQL = new RunSqlStatement();
		
		toSQL.RunStatement(sqlConnection, Sql);
		
		conn.Close(sqlConnection);
		
		
		

	}

}
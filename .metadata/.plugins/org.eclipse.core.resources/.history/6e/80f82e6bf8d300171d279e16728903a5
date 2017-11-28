package connections;

import java.sql.Connection;

import SQL.CreateTables;

public class StartUpCheck {
	
	public void CheckTableSQLTables(Connection conn){
		
		CreateTables createtable = new CreateTables();
		
		/*
		 * Checks to see if the User table exists in SQL already. If not it creates the
		 * Table
		 */

		if (createtable.SeeIfTableExisits(conn,"k_ulm_FP_Users").equals(true)){
			
			String createUserTable = createtable.getCreateUserTable();
			
			createtable.runCreateStatment(conn, createUserTable);			
		}
		
	}

}

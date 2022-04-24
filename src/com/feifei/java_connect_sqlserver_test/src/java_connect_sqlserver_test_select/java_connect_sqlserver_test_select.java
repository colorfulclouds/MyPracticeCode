package java_connect_sqlserver_test_select;

import java.sql.*;
//Á¬½Ó sqlserver
public class java_connect_sqlserver_test_select {

	public static void main(String[] args) {

		Connection con = null;
		String insert = "insert into student values('04138055','weihang',20,100)";
		
		Statement stm = null;
		try{
			
		Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		
		con = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;databaseName = java_connect_test","sa","19951102yufei");
	
		con.setCatalog("java_connect_test");
		stm = con.createStatement();
		stm.executeUpdate(insert);
		con.close();
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}
}

package mysql_modify;

import java.sql.*;
import java.util.Scanner;

public class mysql_modify {

	public static void main(String[] args) {

		Connection con;
		Statement stm = null;
		String id;
		Scanner reader = new Scanner(System.in);
		String new_id;
	
		String modify;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_connect_test?","root","19951102");
			
			System.out.print("Ñ§ºÅ:");
			id = reader.next();
			System.out.print("ÐÂÑ§ºÅ:");
			new_id = reader.next();
			modify = "update student set id = '"+new_id+"' where id = '"+id+"'";

			stm =con.createStatement();
			stm.executeUpdate(modify);
			con.close();
			
			
			
		} 
		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		
	}

}

package mysql_delete;

import java.sql.*;
import java.util.*;

public class mysql_delete {

	public static void main(String[] args) {

		Connection con = null;
		Scanner reader = new Scanner(System.in);
		String id;
		String delete;
		Statement stm = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_connect_test?","root","19951102");
			System.out.print("学号:");
			id = reader.next();
			delete = "delete from student where id = '"+ id +"'";
			stm =con.createStatement();
			int num = stm.executeUpdate(delete);
			System.out.print("删除数量:"+num);
			con.close();
			
		} 
		catch (ClassNotFoundException | SQLException e) {

			System.out.println("数据库链接异常!");
			//e.printStackTrace();
		}
		
	}

}

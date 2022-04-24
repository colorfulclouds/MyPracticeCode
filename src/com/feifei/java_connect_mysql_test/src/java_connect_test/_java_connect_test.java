package java_connect_test;

import java.beans.Statement;
import java.sql.*;
import java.util.*;



public class _java_connect_test {

	public static void main(String[] args) {

		//String insert = "insert into student values('04133022','weihang',22,'男')";//sql语句    最简单的方法 很累
		String insert;
		Scanner reader = new Scanner(System.in);
		String id ;
		String name;
		int age;
		String sex;
		java.sql.Statement stmt;
		PreparedStatement ps;
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver").newInstance()//这种方式也可以
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_connect_test?","root","19951102");
			//////
			System.out.print("学号: ");
			id = reader.next();
			System.out.print("姓名: ");
			name = reader.next();
			System.out.print("年龄: ");
			age = reader.nextInt();
			System.out.print("性别: ");
			sex = reader.next();
			insert = "insert into student values(?,?,?,?)";
			ps = con.prepareStatement(insert);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setLong(3, age);
			ps.setString(4, sex);
			//////
		   
			ps.executeUpdate();
			//stmt = con.createStatement();//创建一个statement对象并返回    它将用于执行具体的SQL语句
			//stmt.executeUpdate(insert);
			System.out.println("success!");
			con.close();
			
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}

}

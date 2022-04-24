package mysql_select;

import java.sql.*;

import com.mysql.jdbc.ResultSet;

public class mysql_select {

	public static void main(String[] args) {

		Connection con = null;
		Statement stm = null;
		
		java.sql.ResultSet rs = null;
		
		String id = null;
		String name = null;
		int age = 0;
		String sex = null;
		
		String sql = "select * from student";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_connect_test?","root","19951102");
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			//¿ªÊ¼±éÀú
			while(rs.next()){
				
				id = rs.getString("id");
				name = rs.getString("name");
				age = rs.getInt("age");
				sex = rs.getString("sex");
				System.out.println(id+"  "+name+"  "+age+"  "+sex);
				
				
			}
			con.close();
			
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}

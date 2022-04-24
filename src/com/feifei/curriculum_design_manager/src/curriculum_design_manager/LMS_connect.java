
package curriculum_design_manager;

import java.sql.*;

public class LMS_connect {
	
	Connection con = null;
	Statement stm = null;

	public LMS_connect() {
		
		try{
			
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;databaseName = LMS","sa","19951102yufei");
			con.setCatalog("LMS");
			stm = con.createStatement();
			}
			catch(ClassNotFoundException | SQLException e){
				System.out.println("数据库链接异常!");
			}
		
	}
	
	public Statement getStatement(){
		return stm;
	}
	
}

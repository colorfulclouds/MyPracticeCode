import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
class Reader_message_select{{
	A a=new A();

try {

	
				Class.forName(a.driverName);
				a.dbConn = DriverManager.getConnection(a.dbURL, a.userName, a.userPwd);
				Statement sta=a.dbConn.createStatement();
				String name1=A.f8.getText();
				ResultSet rs=sta.executeQuery("select * from Reader  where ReaderName = '"+name1+"' ");
				System.out.println("Connection Successful!");
				while(rs.next()){
					String pause="                                                                    ";
		             int id=rs.getInt("ReaderId");
		             String name=rs.getString("ReaderName");
		            
		             String type=rs.getString("ReaderType");
		             String sex=rs.getString("ReaderSex");
		             int no=rs.getInt("ReaderNo");
		             int grade=rs.getInt("ReaderGrade");
		             String Dep=rs.getString("ReaderDep");
		             String Pref=rs.getString("ReaderPref");
		             if(name.equals(A.f8.getText())){
		            	 JOptionPane.showMessageDialog(null, "该读者不存在！请重新输入！");
		            	 A.a1.setText(null);

		         }
		             else{
			             A.a1.setText(pause+"编号                 :"+pause+String.valueOf(id));
			             A.a2.setText(pause+"姓名               :"+pause+name);
			             A.a3.setText(pause+"学生类型      :"+pause+type);
			             A.a4.setText(pause+"性别                :"+pause+sex);
			             A.a5.setText(pause+"学号         :"+pause+String.valueOf(no));
			             A.a6.setText(pause+"入学年纪        :"+pause+String.valueOf(grade));
			             A.a7.setText(pause+"所属学院:"+pause+Dep);
			             A.a8.setText(pause+"学生专业   "+pause+Pref);
			             System.out.println(id+"\t"+name+"\t"+sex+"\t"+no+"\t"+type+"\t"+Dep+"\t"+grade+"\t"+Dep+"\t"+Pref);
		            	 
		            }
				}

	            
				//ps.executeUpdate();
			    a.dbConn.close();
//			    JOptionPane.showMessageDialog(null, "插入成功");
				}
				catch (Exception e1) {
				e1.printStackTrace();
				}
}	}
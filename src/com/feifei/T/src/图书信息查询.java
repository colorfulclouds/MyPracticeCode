import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
class Book_Selete{{
	A a=new A();

try {
	
				Class.forName(a.driverName);
				a.dbConn = DriverManager.getConnection(a.dbURL, a.userName, a.userPwd);
				Statement sta=a.dbConn.createStatement();
				int BookNo1=Integer.parseInt(A.f8.getText());
				ResultSet rs=sta.executeQuery("select * from Book  where BookNo = '"+BookNo1+"' ");
				System.out.println("Connection Successful!");
				while(rs.next()){
					 String pause="                                                                    ";
		             String ID=rs.getString("BookID");
		             String Name=rs.getString("BookName");
		             String Writer=rs.getString("BookWriter");
		             String Publish=rs.getString("BookPublish");
		             int Price=rs.getInt("BookPrice");
		             String date=rs.getString("BookDate");
		             String Main=rs.getString("BookMain");
		             String state=rs.getString("BookState");
		             String BookPrim=rs.getString("BookPrim");
		             int Copy=rs.getInt("BookCopy");
		             A.a1.setText(pause+"图书编号                 :"+pause+ID);
		             A.a2.setText(pause+"图书名称                   :"+pause+Name);
		             A.a3.setText(pause+"作者                             :"+pause+Writer);
		             A.a4.setText(pause+"出版社                :"+pause+Publish);
		             A.a5.setText(pause+"图书价格                          :"+pause+String.valueOf(Price));
		             A.a6.setText(pause+"出版时间        :"+pause+date);
		             A.a7.setText(pause+"图书主要内容:"+pause+Main);
		             A.a8.setText(pause+"图书类型                            "+pause+BookPrim);
		             A.a9.setText(pause+"当前状态   "+pause+state);
		             A.a10.setText(pause+"剩余图书   "+pause+String.valueOf(Copy));
		            
		         }
				//JOptionPane.showMessageDialog(null, "该书不存在！请重新输入！");
	            
				//ps.executeUpdate();
			    a.dbConn.close();
//			    JOptionPane.showMessageDialog(null, "插入成功");
				}
				catch (Exception e1) {
				e1.printStackTrace();
				}
}	}
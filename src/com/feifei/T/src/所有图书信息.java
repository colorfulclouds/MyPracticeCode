import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTextField;
class All_Book_Message{{
	A a=new A();

try {
	
    MyFrame f3= new MyFrame("图书信息如下",150,100,950,500,Color.white);
    A.f2.dispose();
    f3.setLayout(new GridLayout(2,1));
	Panel pp4=new Panel(new 	GridLayout(9,1));
	f3.add(A.m1);
    A.m1.add(A.e4);
	A.m1.add(A.e5);
	A.m1.add(A.e1);
	A.m1.add(A.e2);
	A.m1.add(A.e3);
	A.e1.add(A.n3);
	A.e2.add(A.n7);
	A.e2.add(A.n9);
	A.e3.add(A.n4);
	A.e3.add(A.n5);
	A.e3.add(A.n1);
	A.e5.add(A.n10);
	//A.e3.add(A.n2);
	A.e3.add(A.n6);
	String pause1="                                   ";
	Panel pp5=new Panel(new 	GridLayout(1,1));
	pp4.add(pp5);
	pp5.add(new JLabel("图书号--------:"+"图书编号-------:"+"图书名称—————————作者—————出版社————————价格——剩余图书————当前状态"));
				
				System.out.println("Connection Successful!");
				
				for(int i=1;i<100;i++){
					Class.forName(a.driverName);
					a.dbConn = DriverManager.getConnection(a.dbURL, a.userName, a.userPwd);
					Statement sta=a.dbConn.createStatement();
					ResultSet rs=sta.executeQuery("select * from Book Where  id = '"+i+"' ");

					while(rs.next()){
					String pause="                                                                    ";
					String pause2="                         ";
					String pause3="             ";
		             String id=rs.getString("BookID");
		             String name=rs.getString("BookNo");
		             String type=rs.getString("BookName");
		             String sex=rs.getString("BookWriter");
		             String no=rs.getString("BookPublish");
		             int grade=rs.getInt("BookPrice");
		             int copy=rs.getInt("BookCopy");
		             String Dep=rs.getString("BookMain");
		             String Pref=rs.getString("BookState");
		        

		     		
		             f3.add(pp4);
		             JLabel jjj=new JLabel();
		             jjj.setText(id+name+type+pause3+sex+pause3+no+pause3+grade+pause3+pause3+copy+pause3+pause3+Pref);
		             pp4.add(jjj);
		             
		             
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
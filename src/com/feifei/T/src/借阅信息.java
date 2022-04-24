import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTextField;
class Borrow_Book_Message{{
	A a=new A();

try {
	
    MyFrame f3= new MyFrame("借阅信息如下",150,100,950,500,Color.white);
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
	A.e3.add(A.n4);
	A.e3.add(A.n5);
	A.e3.add(A.n1);
//	A.e3.add(A.n2);
	A.e3.add(A.n6);
	A.e5.add(A.n10);
	String pause1="                                   ";
	Panel pp5=new Panel(new 	GridLayout(1,1));
	pp4.add(pp5);
	pp5.add(new JLabel("—-借阅信息如下:"+pause1+"图书编号:"+"————"+"借书人ID———借书时间—————截止时间————————归还时间——是否归还——"));
				
				System.out.println("Connection Successful!");
				
				for(int i=1;i<100;i++){
					Class.forName(a.driverName);
					a.dbConn = DriverManager.getConnection(a.dbURL, a.userName, a.userPwd);
					Statement sta=a.dbConn.createStatement();
					ResultSet rs=sta.executeQuery("select * from Borrow Where  ID = '"+i+"' ");

					while(rs.next()){
					String pause="                                                                    ";
					String pause2="                         ";
					String pause3="             ";
		             String id=rs.getString("BookID");
		             String name=rs.getString("ReaderID");
		             String type=rs.getString("Outdate");
		             String sex=rs.getString("YHdate");
		             String no=rs.getString("Indate");
		             int grade=rs.getInt("Fine");
		             String Dep=rs.getString("CLState");
		             String Pref=rs.getString("MID");
		        

		     		
		             f3.add(pp4);
		             JLabel jjj=new JLabel();
		             jjj.setText(pause+id+name+pause3+type+pause2+"   "+sex+pause2+"   "+no+pause2+"   "+"   "+Dep+"   ");
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
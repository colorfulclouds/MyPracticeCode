
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

class Delete_Book{{
	A a=new A();
	
try {
    MyFrame f3= new MyFrame("借阅信息如下",150,100,950,500,Color.white);
    A.f2.dispose();
    f3.setLayout(new GridLayout(2,1));
	Panel pp4=new Panel(new 	GridLayout(3,1));
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
	A.e3.add(A.n11);
	A.e3.add(A.n6);
	f3.add(pp4);
    Panel pp6=new Panel(new 	GridLayout(1,3));
    Panel pp7=new Panel(new 	GridLayout(1,9));
    JMenuBar m1=new JMenuBar();
    JMenu e8=new JMenu("图书编号              ");
    JMenu e5=new JMenu("书名选择        ");
   // JMenu e6=new JMenu("借书人选择                    ");
   // JMenu e4=new JMenu("ID选择                                   ");
   // JMenu e3=new JMenu("起始时间                        ");
   // JMenu e2=new JMenu("结束时间                ");
   // JMenu e7=new JMenu("借书编号                     ");
    m1.add(e8);
    m1.add(e5);
    pp6.add(m1);
    pp4.add(pp6);
    pp4.add(pp7);
    pp7.add(A.aa0);
    pp7.add(A.aa1);
    pp7.add(A.b14);
            for(int i=1;i<100;i++){
            Class.forName(a.driverName);
			a.dbConn = DriverManager.getConnection(a.dbURL, a.userName, a.userPwd);
			Statement sta=a.dbConn.createStatement();
			ResultSet rs=sta.executeQuery("select * from Book Where  ID = '"+i+"' ");
			while(rs.next()){
			String pause="                                                                    ";
           //  String id=rs.getString("BookID");
             final String name=rs.getString("BookName");
           //  String type=rs.getString("Outdate");
           //  String sex=rs.getString("YHdate");
           //  String no=rs.getString("Indate");
           //  int grade=rs.getInt("Fine");
           //  String Dep=rs.getString("CLState");
           //  String Pref=rs.getString("MID");
        
             e5.setName("name");
             JMenuItem n1=new JMenuItem(name);
             
             e5.add(n1);
             n1.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                 	//e5.setName(name);
                	 A a=new A();
                	 System.out.println("nihao");
                	 A.aa1.setText(name);
                	 try{
                	Class.forName(a.driverName);
         			a.dbConn = DriverManager.getConnection(a.dbURL, a.userName, a.userPwd);
         			Statement sta=a.dbConn.createStatement();
         			ResultSet rs=sta.executeQuery("select * from Book Where  BookName = '"+name+"' ");
         			while(rs.next()){
    		             String bbc=rs.getString("BookID");
    		             A.aa0.setText(bbc);
    		             
    		             
    		             

    		         }
                    A.b14.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        
                       	 A a=new A();
                       	 System.out.println("nihao");
                       	 A.aa1.setText(name);
                       	 try{
                       	Class.forName(a.driverName);
                       	String name11=A.aa0.getText();
                       	System.out.println(name11);
                       	
                			a.dbConn = DriverManager.getConnection(a.dbURL, a.userName, a.userPwd);
                			Statement sta=a.dbConn.createStatement();
                			ResultSet rs=sta.executeQuery("delete from Borrow Where  BookID = '"+name11+"' ");
                			
                			JOptionPane.showMessageDialog(null, "删除成功");
                			
                       	 
                    		
                        


                        }
                       	 catch (Exception e1) {
                       		 e1.printStackTrace();
                       		 }
                       	 try{
                       	Class.forName(a.driverName);
                       	String name11=A.aa0.getText();
                       	System.out.println(name11);
                       	
                			a.dbConn = DriverManager.getConnection(a.dbURL, a.userName, a.userPwd);
                			Statement sta=a.dbConn.createStatement();
                			ResultSet rs=sta.executeQuery("delete from Book Where  BookID = '"+name11+"' ");
                			
                			JOptionPane.showMessageDialog(null, "删除成功");
                			
                       	 
                    		
                        


                        }
                       	 catch (Exception e1) {
                       		 e1.printStackTrace();
                       		 }
                       	 
                        } 
                    });
         			
                	 
             		
                 


                 }
                	 catch (Exception e1) {
                		 e1.printStackTrace();
                		 }
                	 
                 } 
             });
             
             
			}
            }

	   }
catch (Exception e1) {
e1.printStackTrace();
}
	   }

    
	
	}
				




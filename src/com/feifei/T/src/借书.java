
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

class Borrow_Book{{
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
	//A.e3.add(A.n2);
	A.e3.add(A.n6);
	A.e5.add(A.n10);
	f3.add(pp4);
    Panel pp6=new Panel(new 	GridLayout(1,3));
    Panel pp7=new Panel(new 	GridLayout(1,9));
    JMenuBar m1=new JMenuBar();
    JMenu e8=new JMenu("图书编号              ");
    JMenu e5=new JMenu("书名选择        ");
    JMenu e6=new JMenu("借书人选择                    ");
    JMenu e4=new JMenu("ID选择                                   ");
    JMenu e3=new JMenu("起始时间                        ");
    JMenu e2=new JMenu("结束时间                ");
    JMenu e7=new JMenu("借书编号                     ");
    m1.add(e8);
    m1.add(e5);
    m1.add(e6);
    m1.add(e4);
    m1.add(e3);
    m1.add(e2);
    m1.add(e7);
    pp6.add(m1);
    pp4.add(pp6);
    pp4.add(pp7);
    pp7.add(A.aa0);
    pp7.add(A.aa1);
    pp7.add(A.aa2);
    pp7.add(A.aa3);
    pp7.add(A.ff8);
    pp7.add(A.ff9);
    //pp7.add(A.ff9);
    pp7.add(A.ff10);
    pp7.add(A.b13);
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
         			
                	 
             		
                 


                 }
                	 catch (Exception e1) {
                		 e1.printStackTrace();
                		 }
                	 
                 } 
             });
             
             
			}
            }
            for(int i=1;i<15;i++){
            Class.forName(a.driverName);
			a.dbConn = DriverManager.getConnection(a.dbURL, a.userName, a.userPwd);
			Statement sta=a.dbConn.createStatement();
			ResultSet rs=sta.executeQuery("select * from Reader Where  ID = '"+i+"' ");
			while(rs.next()){
			String pause="                                                                    ";
             final String id=rs.getString("ReaderID");
             final String name=rs.getString("ReaderName");
        

             JMenuItem n2=new JMenuItem(name);
             JMenuItem n3=new JMenuItem(id);
             n2.setName(name);
             e6.add(n2);
             //e4.add(n3);
             n2.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                 	//e5.setName(name);
                	 A a=new A();
                	 System.out.println("nihao");
                	 A.aa2.setText(name);
                	 try{
                	Class.forName(a.driverName);
         			a.dbConn = DriverManager.getConnection(a.dbURL, a.userName, a.userPwd);
         			Statement sta=a.dbConn.createStatement();
         			ResultSet rs=sta.executeQuery("select * from Reader Where  ReaderName = '"+name+"' ");
         			while(rs.next()){
    		             String bbc=rs.getString("ReaderID");
    		             A.aa3.setText(bbc);

    		         }
         			
                	 
             		
                 


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
				




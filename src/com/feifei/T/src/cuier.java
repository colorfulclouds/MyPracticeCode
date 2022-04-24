
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

import javax.swing.*;

public class cuier {


protected static Icon icon;

public static void main(String[] args) {
	//D d=new D();

	final MyFrame f= new MyFrame("图书管理系统",150,100,950,500,Color.white);
	f.setLayout(new GridLayout(1,1));
	Panel p1=new Panel(new 	GridLayout(3,1));
	Panel p2=new Panel(new GridLayout(2,1));
	Panel p3=new Panel(new GridLayout(4,1));
	Panel p4=new Panel(new GridLayout(1,2));
	Panel p5=new Panel(new GridLayout(1,2));
	p4.add(new JLabel("                                                              帐号:"));
	p4.add(A.j2);
	p5.add(new JLabel("                                                              密码:"));
	p5.add(A.j3);
	Button b4=new Button("doas");
	b4.setBounds(50, 50, 300, 300);
	p1.add(A.b1);
	p1.add(A.b2);
	p1.add(A.b3);
	Panel p =new Panel(new  BorderLayout());
    p.add(p2,BorderLayout.CENTER);
    JLabel l1=new JLabel("        --欢迎使用小马图书管理系统--");
    l1.setFont(new java.awt.Font("黑体",1,40));
    p2.add(l1);
    p2.add(p3);
    p3.add(new JLabel("  管理员登录  :"));
    p3.add(p4);
    p3.add(p5);
    p3.add(A.b7);
  //  p3.add(A.b12);
    A.t1.setBounds(300, 300, 40, 20);
    f.add(p);
    f.setVisible(true);
    A.b7.addActionListener(new ActionListener() {              //登录
        public void actionPerformed(ActionEvent e) {
        	String zh=A.j2.getText();
        	//String a="cui";
        	String mm=A.j3.getText();
        	try {
        		A b=new A();
				Class.forName(b.driverName);
				b.dbConn = DriverManager.getConnection(b.dbURL, b.userName, b.userPwd);
				Statement sta=b.dbConn.createStatement();
				String BookNo1=A.j2.getText();
				ResultSet rs=sta.executeQuery("select * from Denglu where Lzhanghao = '"+BookNo1+"' ");
				System.out.println("Connection Successful!");
				
				while(rs.next()){
		             String mima=rs.getString("Lmima").trim();
		             System.out.println(mima);
		             System.out.println(A.j3.getText());
		         	if(mima.equals(A.j3.getText().trim())){
		        		f.dispose();
		 	           A bb=new A();
		 	       		
		               Panel pp1=new Panel(new 	GridLayout(3,1));
		               Panel pp3=new Panel(new 	GridLayout(1,3));
		       		A.f2.setLayout(new GridLayout(2,1));
		            //   Icon icon=new ImageIcon("D:\\烤肉串.jpg");   //图片添加
		               JLabel j1=new JLabel();
		       	    j1.setIcon(icon);
		       		A.f2.add(A.m1);
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
		       		A.e4.add(A.n8);
		       		A.f2.setVisible(true);

		}
		        	else{
		        		JOptionPane.showMessageDialog(null, "帐号密码错误");
		        	}
		        	
  
		         }
	            
				//ps.executeUpdate();
			    b.dbConn.close();
//			    JOptionPane.showMessageDialog(null, "插入成功");
				}
			catch (Exception e1) {
			e1.printStackTrace();
			}

        }
    });
    A.b12.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String zh=A.j2.getText();
        	String a="cui";
        	String mm=A.j3.getText();
        		f.dispose();
 	           A b=new A();
 	       		
               Panel pp1=new Panel(new 	GridLayout(3,1));
               Panel pp3=new Panel(new 	GridLayout(1,3));
       		A.f2.setLayout(new GridLayout(2,1));
              // Icon icon=new ImageIcon("D:\\nihao2.jpg");   //图片添加
               JLabel j1=new JLabel();
       	    j1.setIcon(icon);
       		A.f2.add(A.m1);
       		A.m1.add(j1);
            A.m1.add(A.e4);
       		A.m1.add(A.e5);
       		A.m1.add(A.e1);
       		A.m1.add(A.e2);
         	
       		A.e1.add(A.n3);
       		A.e2.add(A.n7);
       		A.e2.add(A.n9);
       		A.e4.add(A.n8);
       		A.e5.add(A.n10);
       		A.f2.setVisible(true);


        	
        }
    });   
    A.n1.addActionListener(new ActionListener() {                   //读者信息插入
        public void actionPerformed(ActionEvent e) {
			   A a=new A();
			   MyFrame f4= new MyFrame("读者信息查询",150,100,950,500,Color.white);
	        	f4.setLayout(new GridLayout(2,1));
	        	Panel pp4=new Panel(new 	GridLayout(10,2));
	        	f4.add(A.m1);
	            A.m1.add(A.e4);
	    		A.m1.add(A.e5);
	    		A.m1.add(A.e1);
	    		A.m1.add(A.e2);
	    		A.m1.add(A.e3);
	            A.e4.add(A.n8);
	    		A.e1.add(A.n3);
	    		A.e2.add(A.n7);
	    		A.e2.add(A.n9);
	    		A.e3.add(A.n4);
	    		A.e3.add(A.n5);
	    		A.e3.add(A.n1);
	    		A.e3.add(A.n11);
	    		A.e3.add(A.n6);
	    		A.e5.add(A.n10);
	    		f4.add(pp4);
	    	//	Panel pp5=new Panel(new 	GridLayout(1,3));
	    	//	pp4.add(pp5);
       		pp4.add(new JLabel("---读者编号"));
       		pp4.add(A.t2);
       		pp4.add(new JLabel("---读者姓名"));
       		pp4.add(A.j1);
       		pp4.add(new JLabel("---性别"));
       		pp4.add(A.t3);
       		pp4.add(new JLabel("---学号"));
       		pp4.add(A.t4);
       		pp4.add(new JLabel("---用户类型"));
       		pp4.add(A.t5);
       		pp4.add(new JLabel("---学院"));
       		pp4.add(A.t6);
       		pp4.add(new JLabel("---年纪"));
       		pp4.add(A.t7);
       		pp4.add(new JLabel("---专业"));
       		pp4.add(A.t8);
       		pp4.add(new JLabel("---编号"));
       		pp4.add(A.t9);
       		pp4.add(A.b1);
       	//	A.f2.setVisible(true);

}
    }); 
    A.n4.addActionListener(new ActionListener() {               //增加新书
        public void actionPerformed(ActionEvent e) {
			   A a=new A();
			   MyFrame f4= new MyFrame("读者信息查询",150,100,950,500,Color.white);
	        	f4.setLayout(new GridLayout(2,1));
	        	Panel pp4=new Panel(new 	GridLayout(15,2));
	        	f4.add(A.m1);
	            A.m1.add(A.e4);
	    		A.m1.add(A.e5);
	    		A.m1.add(A.e1);
	    		A.m1.add(A.e2);
	    		A.m1.add(A.e3);
	            A.e4.add(A.n8);
	    		A.e1.add(A.n3);
	    		A.e2.add(A.n7);
	    		A.e2.add(A.n9);
	    		A.e3.add(A.n4);
	    		A.e3.add(A.n5);
	    		A.e3.add(A.n1);
	    	    A.e3.add(A.n11);
	    		A.e3.add(A.n6);
	    		A.e5.add(A.n10);
	    		f4.add(pp4);
	    	//	Panel pp5=new Panel(new 	GridLayout(1,3));
	    	//	pp4.add(pp5);
       		pp4.add(new JLabel("---图书编号"));
       		pp4.add(A.tt1);
       		pp4.add(new JLabel("---图书ID"));
       		pp4.add(A.tt2);
       		pp4.add(new JLabel("---图书名称"));
       		pp4.add(A.tt3);
       		pp4.add(new JLabel("---作者"));
       		pp4.add(A.tt4);
       		pp4.add(new JLabel("---出版社"));
       		pp4.add(A.tt5);
       		pp4.add(new JLabel("---价格"));
       		pp4.add(A.tt6);
       		pp4.add(new JLabel("---出版日期"));
       		pp4.add(A.tt7);
       		pp4.add(new JLabel("---分类"));
       		pp4.add(A.tt8);
       		pp4.add(new JLabel("---内容简介"));
       		pp4.add(A.tt9);
       		pp4.add(new JLabel("---剩余库存"));
       		pp4.add(A.tt10);
       		pp4.add(new JLabel("---当前状态"));
       		pp4.add(A.tt11);
       		pp4.add(new JLabel("---专业"));
       		pp4.add(A.tt12);
       		pp4.add(new JLabel("---所在官室"));
       		pp4.add(A.tt13);
       		pp4.add(new JLabel("---图书凭证编号"));
       		pp4.add(A.tt14);
       		pp4.add(new JLabel());
       		pp4.add(A.bb3);
       	//	A.f2.setVisible(true);

}
    }); 
    
    A.b1.addActionListener(new ActionListener() {                 //读者信息插入按钮监听器
        public void actionPerformed(ActionEvent e) {
        	
         C c=new C();
				}
        
    });
    
    A.bb3.addActionListener(new ActionListener() {                 //读者信息插入按钮监听器
        public void actionPerformed(ActionEvent e) {
        	Book_Message_Select bmss=new Book_Message_Select();
				}
        
    });
    A.b5.addActionListener(new ActionListener() {                 //读者信息查询按钮监听器
        public void actionPerformed(ActionEvent e) {
        	Reader_message_select f=new Reader_message_select();
				}
        
    });
    A.b6.addActionListener(new ActionListener() {                 //读者信息查询按钮监听器
        public void actionPerformed(ActionEvent e) {
        	Book_Selete f=new Book_Selete();
				}
        
    });
    A.n3.addActionListener(new ActionListener() {              //读者信息查询
        public void actionPerformed(ActionEvent e) {
            A.f2.dispose();
        	MyFrame f3= new MyFrame("读者信息查询",150,100,950,500,Color.white);
        	f3.setLayout(new GridLayout(2,1));
        	Panel pp4=new Panel(new 	GridLayout(9,1));
        	f3.add(A.m1);
            A.m1.add(A.e4);
    		A.m1.add(A.e5);
    		A.m1.add(A.e1);
    		A.m1.add(A.e2);
    		A.m1.add(A.e3);
            A.e4.add(A.n8);
    		A.e1.add(A.n3);
    		A.e2.add(A.n7);
    		A.e2.add(A.n9);
    		A.e3.add(A.n4);
    		A.e3.add(A.n5);
    		A.e3.add(A.n1);
    	    A.e3.add(A.n11);
    		A.e3.add(A.n6);
    		A.e5.add(A.n10);
    		f3.add(pp4);
    		Panel pp5=new Panel(new 	GridLayout(1,3));
    		pp4.add(pp5);
    		pp5.add(new JLabel("请输入要查询读者的姓名： "));
    		pp5.add(A.f8);
    		pp5.add(A.b5);
    		pp4.add(A.a1);
    		pp4.add(A.a2);
    		pp4.add(A.a3);
    		pp4.add(A.a4);
    		pp4.add(A.a5);
    		pp4.add(A.a6);
    		pp4.add(A.a7);
    		pp4.add(A.a8);
        
    		

        	

        	
        }
    });
    A.n7.addActionListener(new ActionListener() {               //书籍信息查询
        public void actionPerformed(ActionEvent e) {
            A.f2.dispose();
        	MyFrame f3= new MyFrame("图书信息查询",150,100,950,500,Color.white);
        	f3.setLayout(new GridLayout(2,1));
        	Panel pp4=new Panel(new 	GridLayout(11,1));
        	f3.add(A.m1);
            A.m1.add(A.e4);
    		A.m1.add(A.e5);
    		A.m1.add(A.e1);
    		A.m1.add(A.e2);
    		A.m1.add(A.e3);
            A.e4.add(A.n8);
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
    		Panel pp5=new Panel(new 	GridLayout(1,3));
    		pp4.add(pp5);
    		pp5.add(new JLabel("请输入要查询图书的的编号：(101001-102000) "));
    		pp5.add(A.f8);
    		pp5.add(A.b6);
    		pp4.add(A.a1);
    		pp4.add(A.a2);
    		pp4.add(A.a3);
    		pp4.add(A.a4);
    		pp4.add(A.a5);
    		pp4.add(A.a6);
    		pp4.add(A.a7);
    		pp4.add(A.a8);
    		
        
    		

        	

        	
        }
    });


	
    A.n6.addActionListener(new ActionListener() {  //借书信息查询
        public void actionPerformed(ActionEvent e) {
Borrow_Book_Message bbb=new Borrow_Book_Message();

        }
    });
    A.n8.addActionListener(new ActionListener() {//借书
        public void actionPerformed(ActionEvent e) {
        	Borrow_Book bbo=new Borrow_Book();
    		
        


        }
    });
    A.n10.addActionListener(new ActionListener() {            //还书
        public void actionPerformed(ActionEvent e) {
        	Return_Book rb=new Return_Book();
    		
        


        }
    });
    A.n5.addActionListener(new ActionListener() {                   //删除书籍
        public void actionPerformed(ActionEvent e) {
        	Delete_Book dbb= new Delete_Book();	
    		
        


        }
    });
    A.n9.addActionListener(new ActionListener() {              //查询所有图书
        public void actionPerformed(ActionEvent e) {
        	All_Book_Message abm=new All_Book_Message();
    		
        


        }
    });
    A.bb2.addActionListener(new ActionListener() {             //确定插入
        public void actionPerformed(ActionEvent e) {

        	Borrow_Book bbo=new Borrow_Book();
        }
    });
    A.b13.addActionListener(new ActionListener() {                //记录录入
        public void actionPerformed(ActionEvent e) {
        	Borrow_Message_insert bmi=new Borrow_Message_insert();
        }
    });
    A.n11.addActionListener(new ActionListener() {                   //删除读者
        public void actionPerformed(ActionEvent e) {
        	Delete_Reader dd= new Delete_Reader();	
    		
        


        }
    });

}

}


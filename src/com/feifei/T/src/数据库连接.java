import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;


class A{
	    static String driverName ="com.microsoft.jdbc.sqlserver.SQLServerDriver";
		String dbURL = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=DBTest";
		String userName = "sa";
		String userPwd = "";
		Connection dbConn;
        static MyFrame f2= new MyFrame("图书管理系统",150,100,950,500,Color.white);
        
		static JTextField j1=new JTextField();
		static JTextField j2=new JTextField();
		static JTextField j3=new JTextField();
		static JButton b1=new JButton("确定插入");
		static JButton bb1=new JButton("bb1");
		static JButton bb2=new JButton("确定插入");
		static JButton bb3=new JButton("确定插入");
		static JButton b10=new JButton("2.图书信息插入");
		static JButton b11=new JButton("3.管理员信息插入");
		static JButton b2=new JButton("读者信息修改");
		static JButton b3=new JButton("1.读者信息查询");
		static JButton b8=new JButton("2.书籍信息查询");
		static JButton b9=new JButton("3.管理员信息查询");
		static JButton b4=new JButton("管理员登录");
		static JButton b5=new JButton("查询");
		static JButton b6=new JButton("查询");
		static JButton b7=new JButton("登录");
		static JButton b12=new JButton("学生快速入口");
		static JButton b13=new JButton("记录录入");
		static JButton b14=new JButton("确定删除");
		static JButton b15=new JButton("点击还书");
		static JTextField t1=new JTextField();
		static JTextField t2=new JTextField();
		static JTextField t3=new JTextField();
		static JTextField t4=new JTextField();
		static JTextField t5=new JTextField();
		static JTextField t6=new JTextField();
		static JTextField t7=new JTextField();
		static JTextField t9=new JTextField();
		static JTextField t8=new JTextField();
		static JTextField f8=new JTextField();		
		static JMenuBar m1=new JMenuBar();
		static JMenu e1=new JMenu("-------------读者信息------------");
		static JMenu e2=new JMenu("-------------书籍信息------------");
		static JMenu e3=new JMenu("------------管理员操作------------");
		static JMenu e4=new JMenu("------------读者借阅-------------");
		static JMenu e5=new JMenu("-------------读者还书------------");
		static JMenuItem n1=new JMenuItem("读者信息插入");
		static JMenuItem n7=new JMenuItem("书籍信息查询");
		//static JMenuItem n2=new JMenuItem("读者信息修改");
		static JMenuItem n3=new JMenuItem("读者信息查询");
		static JMenuItem n4=new JMenuItem("增加新书");
		static JMenuItem n5=new JMenuItem("删除书籍");
		static JMenuItem n6=new JMenuItem("借书信息查询");
		static JMenuItem n8=new JMenuItem("借书");
		static JMenuItem n10=new JMenuItem("还书");
		static JMenuItem n9=new JMenuItem("查询所有图书");
		static JMenuItem n11=new JMenuItem("删除读者");
		static JLabel a1=new JLabel();
		static JLabel a2=new JLabel();
		static JLabel a3=new JLabel();
		static JLabel a4=new JLabel();
		static JLabel a5=new JLabel();
		static JLabel a6=new JLabel();
		static JLabel a7=new JLabel();
		static JLabel a8=new JLabel();
		static JLabel a9=new JLabel();
		static JLabel a10=new JLabel();
		static Panel ppp1=new Panel(new 	GridLayout(9,1));
		static JLabel lbBook1=new JLabel();
		static JLabel lbBook2=new JLabel("111");
		static JPopupMenu menu=new JPopupMenu(); 
		static JLabel aa0=new JLabel("");
		static JLabel aa1=new JLabel("");
		static JLabel aa2=new JLabel();
		static JLabel aa3=new JLabel();
		static JLabel aa4=new JLabel();
		static JLabel aa5=new JLabel();
		static JLabel aa6=new JLabel();
		static JLabel aa7=new JLabel();
		static JTextField ff8=new JTextField();
		static JTextField ff9=new JTextField();
		static JTextField ff10=new JTextField();
		static JTextField tt1=new JTextField();
		static JTextField tt2=new JTextField();
		static JTextField tt3=new JTextField();
		static JTextField tt4=new JTextField();
		static JTextField tt5=new JTextField();
		static JTextField tt6=new JTextField();
		static JTextField tt7=new JTextField();
		static JTextField tt8=new JTextField();
		static JTextField tt9=new JTextField();
		static JTextField tt10=new JTextField();
		static JTextField tt11=new JTextField();
		static JTextField tt12=new JTextField();
		static JTextField tt13=new JTextField();
		static JTextField tt14=new JTextField();
		static JTextField tt15=new JTextField();
		static JLabel ttt1=new JLabel();
		static JLabel ttt2=new JLabel();
		static JLabel ttt3=new JLabel();
		static JLabel ttt4=new JLabel();
		static String ccc;
		
}
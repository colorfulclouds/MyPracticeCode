import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


class Book_Message_Select{		
	{
	           A a=new A();
			   String []o=new String[20];
			   String insert;
			   String a1=A.tt1.getText();
			   String a2=A.tt2.getText();
			   String a3=A.tt3.getText();
			   String a4=A.tt4.getText();
			   int a6=Integer.parseInt(A.tt6.getText());
			   int a7=Integer.parseInt(A.tt7.getText());
			   String a5=A.tt5.getText();
			   String a8=A.tt8.getText();
			   String a9=A.tt9.getText();
			   String a10=A.tt10.getText();
			   int a11=Integer.parseInt(A.tt11.getText());
			   String a12=A.tt12.getText();
			   String a13=A.tt13.getText();
			   int a14=Integer.parseInt(A.tt14.getText());
			   try {
				Class.forName(a.driverName);
				a.dbConn = DriverManager.getConnection(a.dbURL, a.userName, a.userPwd);
				insert ="Insert into Book values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=a.dbConn.prepareStatement(insert);
				System.out.println("Connection Successful!");
	            ps.setInt(6, a6);
	            ps.setString(1, a1);
	            ps.setString(2, a2);
	            ps.setString(3, a3);
	            ps.setString(4, a4);
	            ps.setString(5, a5);
	            ps.setInt(6, a6);
	            ps.setInt(7, a7);
	            ps.setString(8, a8);
	            ps.setString(9, a9);
	            ps.setString(10, a10);
	            ps.setInt(11, a11);
	            ps.setString(12, a12);
	            ps.setString(13, a13);
	            ps.setInt(14, a14);
				ps.executeUpdate();
			    a.dbConn.close();
			    JOptionPane.showMessageDialog(null, "≤Â»Î≥…π¶");
			    A.t2.setText(null);
			    A.t3.setText(null);
			    A.t4.setText(null);
			    A.t5.setText(null);
			    A.t6.setText(null);
			    A.t7.setText(null);
			    A.t8.setText(null);
			    A.j1.setText(null);
				}
				catch (Exception e1) {
				e1.printStackTrace();
				}
}	}
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
class Borrow_Message_insert{	
	{
	           A a=new A();
			   String insert;
			   String b=A.aa0.getText();
			   int d=Integer.parseInt(A.ff8.getText());
			   int e=Integer.parseInt(A.ff9.getText());
			   String c=A.aa3.getText();
			   int f=Integer.parseInt(A.ff10.getText());
			   try {
				Class.forName(a.driverName);
				a.dbConn = DriverManager.getConnection(a.dbURL, a.userName, a.userPwd);
				insert ="Insert into Borrow values(?,?,?,?,0,0,'∑Ò',02,?)";
				PreparedStatement ps=a.dbConn.prepareStatement(insert);
				System.out.println("Connection Successful!");
				ps.setString(1, b);
	            ps.setString(2, c);
	            ps.setInt(3, d);
	            ps.setInt(4, e);
	            ps.setInt(5, f);
	         //   ps.setString(5, leixing);
	          //  ps.setString(6, xueyuan);
	          //  ps.setInt(7, grade);
	          //  ps.setString(8, zhuanye);
				ps.executeUpdate();
			    a.dbConn.close();
			    JOptionPane.showMessageDialog(null, "≤Â»Î≥…π¶");
			    A.aa0.setText(null);
			    A.aa2.setText(null);
			    A.aa1.setText(null);
			    A.aa3.setText(null);
			    A.ff8.setText(null);
			    A.ff9.setText(null);
			    A.ff10.setText(null);
			    A.j1.setText(null);
				}
				catch (Exception e1) {
				e1.printStackTrace();
				}
}	}
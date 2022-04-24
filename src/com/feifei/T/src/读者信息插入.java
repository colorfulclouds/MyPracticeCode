import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class C {
	{
		A a = new A();
		String[] o = new String[20];
		String insert;
		String sex = A.t3.getText();
		int id = Integer.parseInt(A.t2.getText());
		int num = Integer.parseInt(A.t4.getText());
		String name = A.j1.getText();
		String leixing = A.t5.getText();
		String xueyuan = A.t6.getText();
		int grade = Integer.parseInt(A.t7.getText());
		String zhuanye = A.t8.getText();
		int wid = Integer.parseInt(A.t9.getText());
		try {
			Class.forName(a.driverName);
			a.dbConn = DriverManager.getConnection(a.dbURL, a.userName,
					a.userPwd);
			insert = "exec procedure_name p,p,p......";
			insert = "Insert into Reader values(?,?,?,?,?,?,?,?,0,?)";
			PreparedStatement ps = a.dbConn.prepareStatement(insert);
			System.out.println("Connection Successful!");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, sex);
			ps.setInt(4, num);
			ps.setString(5, leixing);
			ps.setString(6, xueyuan);
			ps.setInt(7, grade);
			ps.setString(8, zhuanye);
			ps.setInt(9, wid);
			ps.executeUpdate();
			a.dbConn.close();
			JOptionPane.showMessageDialog(null, "插入成功");
			A.t2.setText(null);
			A.t3.setText(null);
			A.t4.setText(null);
			A.t5.setText(null);
			A.t6.setText(null);
			A.t7.setText(null);
			A.t8.setText(null);
			A.j1.setText(null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}

class D {
	MyFrame f2 = new MyFrame("图书管理系统", 150, 100, 950, 600, Color.white);;
}

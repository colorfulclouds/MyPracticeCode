package library_management_system;

import java.sql.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		

		JFrame jf = new JFrame();
		log_panel reader_panel = new log_panel(jf);
		ImageIcon s_f_icon = new ImageIcon("s_f_icon.png");
		jf.setSize(1000, 700);
		jf.setIconImage(s_f_icon.getImage());//窗口图标
		jf.setLocationRelativeTo(null);//屏幕居中显示
		jf.setResizable(false);//不让用户改变界面尺寸
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("乐阅(读者版)");
		
		jf.add(reader_panel);//添加jpanel
		
		jf.setVisible(true);
		
	}
}

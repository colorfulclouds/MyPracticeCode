package library_management_system;

import java.sql.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		

		JFrame jf = new JFrame();
		log_panel reader_panel = new log_panel(jf);
		ImageIcon s_f_icon = new ImageIcon("s_f_icon.png");
		jf.setSize(1000, 700);
		jf.setIconImage(s_f_icon.getImage());//����ͼ��
		jf.setLocationRelativeTo(null);//��Ļ������ʾ
		jf.setResizable(false);//�����û��ı����ߴ�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("����(���߰�)");
		
		jf.add(reader_panel);//���jpanel
		
		jf.setVisible(true);
		
	}
}

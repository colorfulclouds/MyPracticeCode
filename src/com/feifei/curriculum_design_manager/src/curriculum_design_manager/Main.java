package curriculum_design_manager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		
		JFrame jf = new JFrame();
		log_manager_panel l_m_p = new log_manager_panel(jf);
		
		ImageIcon s_f_icon = new ImageIcon("manager_icon.png");
		jf.setSize(1000, 700);
		jf.setIconImage(s_f_icon.getImage());//����ͼ��
		jf.setLocationRelativeTo(null);//��Ļ������ʾ
		jf.setResizable(false);//�����û��ı����ߴ�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("����(����Ա)");
		jf.add(l_m_p);
		
		jf.setVisible(true);
	}
}

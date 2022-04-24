package library_management_system;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class log_panel extends JPanel{

	
	JTabbedPane tabbedpane = new JTabbedPane();//�������� �л�ʹ�õ�
	//Ϊ��¼�ɹ���׼��
	JFrame jf = null;//������
	select_panel s_p = null;
	
	BufferedImage background_image = null;//���ߵ�¼����ͼƬ
	//��¼��Ϣ�ı���
	JTextField LMS_readerid = null;//���ߵ�Ψһ��
	JLabel lbl_readerid = new JLabel("�˺�:");
	JPasswordField LMS_readerpsd = null;//���ߵ�����
	JLabel lbl_readerpsd = new JLabel("����:");
	
	JButton btn_load = new JButton("��¼");
	JButton btn_reload = new JButton("����");
	JLabel sign = new JLabel("����(���߰�)");
	
	private String id;	//����id
	private String psd;	//��������
	
	private String sql = null;//����Ƿ���ڸö��ߵ�sql���
	LMS_connect l = new LMS_connect();
	Statement stm = l.getStatement();
	
	ResultSet rs = null;//selectִ�к�Ľ����
	
	
	
	public log_panel(JFrame jf) {
		
		try {
			
			//Ϊ��¼�ɹ���ʹ��
			this.jf = jf;
			s_p = new select_panel();
			//jf.add(s_p);
			//s_p.setVisible(false);
			
			background_image = ImageIO.read(new FileInputStream("background_image.png"));
			LMS_readerid = new JTextField();
			LMS_readerpsd = new JPasswordField();
			this.setLayout(null);
			//������(���߰�)��λ������
			sign.setFont(new Font("�����п�", 10, 50));//������ʾ����
			sign.setBounds(600, -100, 400, 500);
			add(sign);
			//���˺š�λ������
			lbl_readerid.setFont(new Font("��������", 10, 30));
			lbl_readerid.setBounds(600, 250, 100, 100);
			add(lbl_readerid);
			//�˺��ı���
			LMS_readerid.setBounds(700, 283, 200, 30);
			add(LMS_readerid);
			//�����롱λ������
			lbl_readerpsd.setFont(new Font("��������", 10, 30));
			lbl_readerpsd.setBounds(600, 270, 100, 200);
			add(lbl_readerpsd);
			//�����ı���
			LMS_readerpsd.setBounds(700, 355, 200, 30);
			add(LMS_readerpsd);
			//����¼����ťλ������
			btn_load.setBounds(610, 480, 100, 50);
			btn_load.setBackground(new Color(220, 220, 220));
			add(btn_load);
			btn_load.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					id = LMS_readerid.getText();
					psd = new String(LMS_readerpsd.getPassword());
					
//					System.out.println(id+".test."+psd);//test
					sql = "select * from LMS_reader where LMS_readernum = '"+id+"' and LMS_readerpsd = '"+psd+"' ";
					try {
						rs = stm.executeQuery(sql);
						if(rs.next() == false){
							new player_audio("alert.wav").playBackgroundSound();//��������
							JOptionPane.showMessageDialog(null, "�����˺Ż�����", "����", JOptionPane.ERROR_MESSAGE); //��ʾ��¼����
							LMS_readerid.setText("");
							LMS_readerpsd.setText("");
						}
						
						else{
							//rs.next();
							
							setcansee(false);//�����Լ��ķ���
//							setVisible(false)//����ϵͳ�� ʹ���Լ��ķ���
							jf.repaint();//�������һ��panel�Ļ������
							
							//jf.add(s_p);//��¼�ɹ�����½���
							tabbedpane.addTab("�ҵ���Ϣ", new reader_info(id,psd));
							tabbedpane.addTab("�ҽ����", new my_borrow_book(id,psd));
							tabbedpane.addTab("����", new select_panel());
							
							jf.add(tabbedpane);
							l.con.close();//�������ݿ�ʹ�����  �ر����ݿ�����
							
						}
							
					} 
					catch (SQLException e1) {
//						e1.printStackTrace();
						System.out.println("select reader error");
					}
					
				}
			});
			//�����á���ť����
			btn_reload.setBounds(800, 480, 100, 50);
			btn_reload.setBackground(new Color(220, 220, 220));
			add(btn_reload);
			btn_reload.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					LMS_readerid.setText("");
					LMS_readerpsd.setText("");
				}
			});
		} 
		catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("can not find this picture");
		} 
		catch (IOException e) {
//			e.printStackTrace();
			System.out.println("i/o error");
		}
	}
	
	//panel�Ŀɼ��Ա仯����
	public void setcansee(boolean visible){
		setVisible(visible);
	}
	
	//��дpaintComponent()����
	public void paintComponent(Graphics g){
		
		g.drawImage(background_image, 20, 50, null);
		
	}
	
}

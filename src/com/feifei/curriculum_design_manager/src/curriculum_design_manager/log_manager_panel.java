package curriculum_design_manager;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class log_manager_panel extends JPanel{

	JTabbedPane tabbedpane = new JTabbedPane();//�������� �л�ʹ�õ�
	JFrame jf;
	BufferedImage background_image = null;
	Statement stm = new LMS_connect().getStatement();//��ȡ���ݿ�����
	String sql = "";//�洢��Ҫִ�е�sql���
	String id = "";//����Ա�˺�
	String psd = "";//����Ա����
	ResultSet rs ;
	
	JTextField jtf_m_id = new JTextField();//����Ա�˺�
	JPasswordField jtf_m_psd = new JPasswordField();//����Ա����
	JLabel jll_m_id = new JLabel("�˺�");
	JLabel jll_m_psd = new JLabel("����");
	
	JLabel head = new JLabel(new ImageIcon("log_in.png")); 
	JLabel title = new JLabel("����(����Ա��)");
	
	JButton log = new JButton("��¼");
	JButton relog = new JButton("����");
	
	public log_manager_panel(JFrame jf) {

		try {
			setLayout(null);//��ղ��ֹ���
			background_image = ImageIO.read(new FileInputStream("background.jpg"));
			
			//������ʾλ��
			title.setFont(new Font("��Բ", Font.BOLD, 30));
			title.setBounds(400, 50, 250, 30);
			add(title);
			
			//ͷ����ʾλ��
			head.setBounds(150, 200, 256, 256);
			add(head);
			
			//��¼��Ϣ�ı�ǩ
			//�˺�
			jll_m_id.setFont(new Font("����", 10, 30));
			jll_m_id.setBounds(500, 250, 80, 30);
			add(jll_m_id);
			
			//����
			jll_m_psd.setFont(new Font("����", 10, 30));
			jll_m_psd.setBounds(500, 350, 80, 30);
			add(jll_m_psd);
			
			//�ı���
			//�˺ŶԻ���
			jtf_m_id.setBounds(650, 250, 150, 30);
			add(jtf_m_id);
			
			//����Ի���
			jtf_m_psd.setBounds(650, 350, 150, 30);
			add(jtf_m_psd);
			
			//��ť
			//��¼��ť
			log.setFont(new Font("����ϸ��", 10, 30));
			log.setOpaque(false);//����������仰���ð�ťΪ͸����
			log.setBackground(new Color(151, 255, 255));
			log.setBounds(420, 510, 160, 50);
			add(log);
			
			log.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					id = jtf_m_id.getText();
					psd = new String(jtf_m_psd.getPassword());
					
					sql = "select * from LMS_manager where LMS_managerid = '"+id+"' and LMS_managerpsd = '"+psd+"' ";
					
					if(id.length() == 0 || psd.length() == 0){
						
						JOptionPane.showMessageDialog(null, "���Ƶ�¼��Ϣ", "����", JOptionPane.ERROR_MESSAGE); 
						jtf_m_id.setText("");
						jtf_m_psd.setText("");
					}
					else{
						
						try {
							rs = stm.executeQuery(sql);
							
							if(rs.next() == false){
								JOptionPane.showMessageDialog(null, "��¼��Ϣ������", "����", JOptionPane.ERROR_MESSAGE); //��ʾ��¼����
								jtf_m_id.setText("");
								jtf_m_psd.setText("");
							}
							else{
								
								setVisible(false);
								repaint();
								jf.setTitle(jf.getTitle()+" : "+id);
								tabbedpane.addTab("����Ա��Ϣ", new manager_info(id,psd));
								tabbedpane.addTab("���߲�ѯ", new reader_borrow_return(id,psd));
								tabbedpane.addTab("������Ϣ", new return_operate(id,psd));
								tabbedpane.addTab("������Ϣ", new borrow_operate(id,psd));
								tabbedpane.addTab("������Ϣ", new reader_operate(id,psd));
								tabbedpane.addTab("ͼ������", new booktype_operate(id,psd));
								tabbedpane.addTab("ͼ��", new bookinfo_operate(id,psd));
								jf.add(tabbedpane);
								
								/*
								 * ��¼�ɹ�
								 */
							}
							
						}
						catch (SQLException e1) {
							e1.printStackTrace();
							System.out.println("sql error");
						}
						
					}
					
				}
			});
			
			//���ð�ť
			relog.setBounds(470, 600, 60, 20);
			relog.setOpaque(false);//����������仰���ð�ťΪ͸����
			relog.setBackground(new Color(151, 255, 255));
			add(relog);
			relog.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					jtf_m_id.setText("");
					jtf_m_psd.setText("");
				}
			});
			
		} 
		catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("no find file");
		} 
		catch (IOException e) {
//			e.printStackTrace();
			System.out.println("i/o error");
		}
	}
	
	//���Ʊ���ͼƬ
	public void paintComponent(Graphics g){
		
		g.drawImage(background_image, 0, 0, null);
		
	}
}

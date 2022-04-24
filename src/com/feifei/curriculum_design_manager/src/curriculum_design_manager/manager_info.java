package curriculum_design_manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class manager_info extends JPanel{

	BufferedImage background_image = null;//����ͼƬ
	
	Statement stm ;
	ResultSet rs ;
	String sql;
	
	private String id;//����Ա�˺�
	private String psd;//����Ա����
	private String name;//����Ա����
	
	JTextArea jta_privilege = new JTextArea();//��ʾ���������Ȩ��
	JScrollPane jsp_privilege = new JScrollPane(jta_privilege);//��ʾ����Ա��ȫ��Ȩ��
	JLabel jll_privilege = new JLabel("�ҵ�Ȩ��");
	FileReader fr;
	
	JLabel title = new JLabel("�ҵ���Ϣ");
	JLabel jll_name = new JLabel("����");
	JLabel jll_id = new JLabel("�˺�");
	
	JTextField jtf_name = new JTextField();
	JTextField jtf_id = new JTextField();	
	
	//���ְ�ť
	JButton mod_sub_btn = new JButton("�޸�");//�޸�/�ύ��ť
	static boolean mod_change = true;//�޸� �ύ���ܽ��������õ�
	
	
	public manager_info(String id,String psd) {

		this.id = id;
		this.psd = psd;
		
		stm = new LMS_connect().getStatement();//��ȡ���ݿ�����
		sql = "select * from LMS_manager where LMS_managerid = '"+id+"' and LMS_managerpsd = '"+psd+"' ";
		
		try {
			rs = stm.executeQuery(sql);
			rs.next();//��Ҫ���  ����next ���������ݵ�ǰһ��  
		} 
		catch (SQLException e1) {
//			e1.printStackTrace();
			System.out.println("sql error");
		}
		
		try {
			background_image = ImageIO.read(new FileInputStream("manager_info.png"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		setLayout(null);//��ղ��ֹ���
		//���������
		title.setFont(new Font("΢���ź�",10,30));
		title.setBounds(440, 10, 120, 30);
		add(title);
		
		//����Ա��Ϣ��ʾ��ǩ
		//������ʾ��ǩ
		jll_name.setFont(new Font("����",10,25));
		jll_name.setBounds(120, 120, 50, 20);
		add(jll_name);
		//�˺���ʾ��ǩ
		jll_id.setFont(new Font("����",10,25));
		jll_id.setBounds(120, 200, 50, 20);
		add(jll_id);
		
		//����Ա��Ϣ��ʾ�ı���
		//�����ı���
		jtf_name.setEditable(false);
		jtf_name.setBounds(250, 115, 120, 30);
		try {
			jtf_name.setText(rs.getString("LMS_managername"));
		} 
		catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("sql error");
		}
		add(jtf_name);
		
		//�˺��ı���
		jtf_id.setEditable(false);
		jtf_id.setBounds(250, 195, 120, 30);
		jtf_id.setText(id);
		add(jtf_id);
		
		//����Աȫ��Ȩ����ʾ��ǩ
		jll_privilege.setFont(new Font("����Ҧ��",10,30));
		jll_privilege.setBounds(665, 80, 120, 35);
		add(jll_privilege);
		
		//����Աȫ��Ȩ����ʾ�ı���
		int i;
		try {
			fr = new FileReader("privilege.txt");
		} 
		catch (FileNotFoundException e3) {
//			e3.printStackTrace();
			System.out.println("no find file");
		}
		try {
			while((i = fr.read()) != -1)
				jta_privilege.append(Character.toString((char)i));
			
		} 
		catch (IOException e2) {
//			e2.printStackTrace();
			System.out.println("i/o error");
		}
		jta_privilege.setEditable(false);//����ԱȨ�޲��ɱ༭
		jta_privilege.setFont(new Font("��������",10,20));
		jta_privilege.setOpaque(false);
		jsp_privilege.setBounds(500, 150, 450, 450);
		add(jsp_privilege);
		
		//�޸ġ��ύ��ť����
		mod_sub_btn.setOpaque(false);//����������仰���ð�ťΪ͸����
		mod_sub_btn.setBackground(new Color(151, 255, 255));
		mod_sub_btn.setBounds(400, 115, 70, 30);
		add(mod_sub_btn);
		mod_sub_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
//				mod_change
				//�޸Ĺ���
				if(mod_change == true){
					
					mod_change = false;//��һ���϶������ύ
					jtf_name.setEditable(true);//�������ı���Ŀɱ༭��
					mod_sub_btn.setText("�ύ");
				}
				
				//�ύ����
				else{
					
					sql = "update LMS_manager set LMS_managername = '"+jtf_name.getText()+"' where LMS_managerid = '"+id+"'";
					try {
						stm.executeUpdate(sql);
					}
					catch (SQLException e1) {
//						e1.printStackTrace();
						System.out.println("sql error");
					}
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�!", "��ϲ!", JOptionPane.DEFAULT_OPTION);
					mod_change = true;//��һ�ο϶������޸�
					jtf_name.setEditable(false);//�ύ�ɹ��ر������ı���ɱ༭��
					mod_sub_btn.setText("�޸�");
				}
				
			}
		});
		
	}
	
	public void paintComponent(Graphics g){
		
		g.drawImage(background_image, 0, 370, null);
	}

}

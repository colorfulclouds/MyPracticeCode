package library_management_system;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;

public class reader_info extends JPanel{

	
	BufferedImage background_image = null;//����ͼƬ
	private String id;
	private String psd;
	private String sql;
	
	private String old_psd;//��ֹδ���κ������޸�
	
	Statement stm;
	ResultSet rs;//���Ԫ��
	
	JLabel jtitle = new JLabel("�ҵ���Ϣ");
	

	String []values = new String[]{"LMS_readername","LMS_readertel","LMS_readerregis","LMS_readerbooknumber"};//sql�����ʹ��  ��������Ϣ�����ı�������ʾ
	
	Vector <JLabel>jll_info = new Vector();
	JLabel jll_info_name = new JLabel("����");
	JLabel jll_info_tel = new JLabel("�ֻ�����");
	JLabel jll_info_regis = new JLabel("ע��ʱ��");
	JLabel jll_info_days = new JLabel("��������");
	JLabel jll_info_psd = new JLabel("������");
	private int jtf_y = 200;
	
	Vector <JTextField>jtf_info = new Vector();
	JTextField jtf_info_name = new JTextField();
	JTextField jtf_info_tel = new JTextField();
	JTextField jtf_info_regis = new JTextField();
	JTextField jtf_info_days = new JTextField();
	JPasswordField jtf_info_psd = new JPasswordField();//����
	private int jll_y = 200;
	
	JButton mod_btn = new JButton("�޸�");
	JButton sub_btn = new JButton("�ύ");
	JButton re_btn = new JButton("ȡ��");
	
	
	/**
	 * ���Բ���Ҫ����  ��Ϊ�û��Ѿ�ȷ����  �˺Ų��ܹ��ظ� ��QQ ��һ��   ���Թ���Ա�汾��ʱ��  ע����ߵ�ʱ�� ��Ҫע��
	 */
	public reader_info(String id, String psd) {

		
		try {
			background_image = ImageIO.read(new FileInputStream("mod_info.png"));
		} 
		catch (FileNotFoundException e2) {
//			e2.printStackTrace();
			System.out.println("no find file");
		} 
		catch (IOException e2) {
			e2.printStackTrace();
			System.out.println("i/o error");
		}//���ͼƬ
		this.id = id;
		this.psd = psd;
		
		//��ӱ�ǩ��Ϣ��ʾ��������	���������ڴ����е���ʾλ��
		jll_info.add(jll_info_name);
		jll_info.add(jll_info_tel);
		jll_info.add(jll_info_regis);
		jll_info.add(jll_info_days);
		for(int i = 0;i<4;i++){
			jll_info.get(i).setBounds(300, jll_y, 150, 30);
			jll_info.get(i).setFont(new Font("������κ", 10, 30));
			add(jll_info.get(i));
			jll_y += 50;
		}
		jll_info_psd.setBounds(300, 400, 150, 30);
		jll_info_psd.setFont(new Font("������κ", 10, 30));
		add(jll_info_psd);
		jll_info_psd.setVisible(false);
		
		//�����Ϣ��ʾ�ı�������		���������ڴ����е���ʾλ��
		jtf_info.add(jtf_info_name);
		jtf_info.add(jtf_info_tel);
		jtf_info.add(jtf_info_regis);
		jtf_info.add(jtf_info_days);
		for(int i = 0;i<4;i++){
			jtf_info.get(i).setEditable(false);//����Ϊ��Ϣ�ı���Ϊ���ɱ༭
			jtf_info.get(i).setBounds(530, jtf_y, 150, 30);
			add(jtf_info.get(i));
			jtf_y += 50;
		}
		
		jtf_info_psd.setBounds(530, 400, 150, 30);
		add(jtf_info_psd);
		jtf_info_psd.setVisible(false);//��������޸ĵ�ʱ�����ֳ���
		
		//�޸İ�ť
		mod_btn.setBounds(700, 500, 100, 40);
		mod_btn.setFont(new Font("���Ŀ���", 10, 20));
		mod_btn.setBackground(new Color(220, 220, 220));
		add(mod_btn);
		mod_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				repaint();
				jtf_info.get(0).setEditable(true);
				jtf_info.get(1).setEditable(true);
				
				jll_info_psd.setVisible(true);//�޸ĵ�ʱ����ʾ ��ʾ��ǩ
				jtf_info_psd.setVisible(true);//�޸ĵ�ʱ����ʾ ��������޸ĵ��ı���
				
				
				mod_btn.setVisible(false);//����ԭ�����޸İ�ť
				//��ʾ�����޸ĵİ�ť
				sub_btn.setVisible(true);//��ʾ�ύ��ť
				re_btn.setVisible(true);//��ʾȡ����ť
				
				
				jll_info_name.setText("������");
				jll_info_tel.setText("���ֻ�����");
				
			}
		});
		
		//�ύ��ť
		sub_btn.setBounds(700, 500, 100, 40);
		sub_btn.setFont(new Font("���Ŀ���", 10, 20));
		sub_btn.setBackground(new Color(220, 220, 220));
		add(sub_btn);
		sub_btn.setVisible(false);
		
		sub_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				old_psd = jtf_info_psd.getText();//��ֹΪ���κ������޸Ĳ���
				if(old_psd.length() == 0)
					old_psd = psd;
				
				sql = "update LMS_reader set LMS_readername = '"+jtf_info.get(0).getText()+"',LMS_readertel = '"+jtf_info.get(1).getText()+"',"+
						"LMS_readerpsd = '"+old_psd+"' where LMS_readernum = '"+id+"' ";
				
				try {
					stm.executeUpdate(sql);
					new JOptionPane().showMessageDialog(null, "�޸ĳɹ�!", "��ϲ!", JOptionPane.DEFAULT_OPTION);
					
					jtf_info.get(0).setEditable(false);//�˺� ȡ���ɱ༭��
					jtf_info.get(1).setEditable(false);//����ȡ���ɱ༭��
					
					mod_btn.setVisible(true);//�޸İ�ť����
					re_btn.setVisible(false);//�ύ�� ����ȡ����ť
					sub_btn.setVisible(false);//�ύ�� �����޸İ�ť
					jll_info_psd.setVisible(false);//��ʾ�����ǩ����
					jtf_info_psd.setVisible(false);//�����ı�������
					
					//��ʾ��ǩ��λ
					jll_info_name.setText("����");
					jll_info_tel.setText("�ֻ�����");
				} 
				catch (SQLException e1) {
//					e1.printStackTrace();
					System.out.println("sql error");
				}
				//��ʼ�ػ�ÿ���ı����е���Ϣ ���и��� ���ݿ� ����д��
			}
		});
		
		//ȡ����ť
		re_btn.setBounds(810, 500, 100, 40);
		re_btn.setFont(new Font("���Ŀ���", 10, 20));
		re_btn.setBackground(new Color(220, 220, 220));
		add(re_btn);
		re_btn.setVisible(false);
		
		re_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				jtf_info.get(0).setEditable(false);
				jtf_info.get(1).setEditable(false);
				
				jll_info_psd.setVisible(false);
				jtf_info_psd.setVisible(false);				
				jll_info_psd.setVisible(false);
				jtf_info_psd.setVisible(false);
				
				re_btn.setVisible(false);
				sub_btn.setVisible(false);
				mod_btn.setVisible(true);
				
				jll_info_name.setText("����");
				jll_info_tel.setText("�ֻ�����");
			}
		});
		
		jtitle.setFont(new Font("����Ҧ��",10,30));
		this.setLayout(null);//���ֹ����ÿ�
		jtitle.setBounds(425, 30, 150, 40);
		add(jtitle);
		
		sql = "select * from LMS_reader where LMS_readernum = '"+id+"' and LMS_readerpsd = '"+psd+"'";
		stm = new LMS_connect().getStatement();
		try {
			rs = stm.executeQuery(sql);
			rs.next();
			
			for(int i = 0;i<3;i++){
				jtf_info.get(i).setText(rs.getString(values[i]));
			}
			
			jtf_info.get(3).setText(rs.getString(values[3]));
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql error");
		}
		
	}

	//ȥ����ֹ���ֲ�Ӱ
	//��д����
//	public void paintComponent(Graphics g){
//		
//		g.drawImage(background_image, 20, 0, null);
//	}
}

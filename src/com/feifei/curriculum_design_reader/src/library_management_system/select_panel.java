package library_management_system;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class select_panel extends JPanel{

	BufferedImage background_image = null;
	
	//���ݿ��������
	LMS_connect l = new LMS_connect();
	Statement stm = l.getStatement();
	ResultSet rs = null;//��ѯ�������
	
	JLabel select;//������ʾ��ǩ
	JPanel mode_panel = new JPanel();//���ظ��ֹ��ܵ�panel
	
	JPanel condition_panel = new JPanel();//������Ҫ����ĸ�����Ϣ
	JButton start_select = new JButton("��ʼ����");
	JTextField jtf_info_one = new JTextField();//��һ��������Ϣ�ı���	һ�������  ������ʹ��
	JLabel section = new JLabel("~");//�ڶ���������Ϣ��ʱ��ʹ��
	JTextField jtf_info_two = new JTextField();//�ڶ���������Ϣ�ı���  ���ֻ�������������ʱ����õ�
	JLabel jbl_select_info = new JLabel();//������ʱ����ʾ���뵽�ı����е���Ϣ
	
	
	ButtonGroup bg = new ButtonGroup();
	JRadioButton []jrb = new JRadioButton[12];//���һ����ť ���±�Ϊ11�İ�ť Ϊ�鿴ȫ����ͼ�����Ϣ�İ�ť
	
	String[]mode = new String[]{"���ʱ�׼���","����","����","����","������","����","�����","�ɽ�����","�۸�","ҳ��"};//���ĸ����⴦��  ��Ϊ���������
	String[]select_info = new String[]{"���ʱ�׼���","����","��������","��������","��������","��������","�����","�ɽ�����","�۸�����","ҳ������"};
	String[]select_key = new String[]{"LMS_isbn","LMS_bookname","LMS_anthor","LMS_translator","LMS_publish","LMS_typename","LMS_total","LMS_typedays","LMS_price","LMS_page"};//�ı���ǰ���
	
	String key = "";//��¼��ǰ��Ҫ��ѯ������
	String field_one = "";//��¼��������
	String field_two = "";//��¼��������
	float value_one;
	float value_two;
	int value_one_int;
	int value_two_int;
	
	String sql = "";//sql���

	DefaultTableModel table=new DefaultTableModel(); 
	String[] title = {"ISBN","����","����","����","������","����ʱ��","��ҳ��","�����","������","�ɽ�����","�򵥽���"};
	
	JTable jtl_info = new JTable(table);
	JScrollPane jsp_info = new JScrollPane(jtl_info);//���й�������ȥ��ʾ��ѯ���Ԫ��
	
	public select_panel() {

		try {
			
			jrb[11] = new JRadioButton("ȫ��ͼ��");
			jrb[11].setFont(new Font("����", 10, 20));
			jrb[11].setBounds(30, 20, 150, 30);
			add(jrb[11]);
			bg.add(jrb[11]);
			//�����¼� ȫ������Ϣ
			jrb[11].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					//���ͼ����Ϣ���
					for(int i = table.getRowCount()-1;i>=0;i--)
						table.removeRow(i);
					
					sql = "select * from LMS_view_bookinfo_booktype";
					try {
						
						rs = stm.executeQuery(sql);
						while(rs.next()){
							
							Vector c = new Vector();
							c.add(rs.getString("LMS_isbn"));
							c.add(rs.getString("LMS_bookname"));
							c.add(rs.getString("LMS_anthor"));
							c.add(rs.getString("LMS_translator"));
							c.add(rs.getString("LMS_publish"));
							c.add(rs.getString("LMS_publishtime"));
							c.add(rs.getString("LMS_page"));
							c.add(rs.getString("LMS_total"));
							c.add(rs.getString("LMS_typename"));
							c.add(rs.getString("LMS_typedays"));
							c.add(rs.getString("LMS_introduce"));
							table.addRow(c);
						}
					
					} 
					catch (SQLException e1) {
						e1.printStackTrace();
						System.out.println("sql error");
					}
					
					
					
				}
			});
		
			jtl_info.setEnabled(false);//�ñ���е����ݲ��ɱ��༭
			jtl_info.setRowHeight(20);//���ñ����и�
			//������ֵ��ӵ��б���  ������ʾ
			for(int i = 0;i<11;i++)
				table.addColumn(title[i]);
			
			background_image = ImageIO.read(new FileInputStream("select_background.png"));
			this.setLayout(null);
			//������ʾ��ǩ����
			select = new JLabel("��ѡ�������ʽ");
			select.setFont(new Font("����",10,30));
			select.setBounds(390, 15, 250, 30);
			add(select);
			//���ع��ܰ�ť��panel
			mode_panel.setOpaque(false);//����Ϊ͸����
			mode_panel.setLayout(new GridLayout(2,6,0,10));
			mode_panel.setBounds(30, 100, 990, 50);
			//���ּ�����Ϣ��¼��
			condition_panel.setOpaque(false);//����͸����
			condition_panel.setBounds(30, 180, 990, 50);
			condition_panel.setLayout(null);//��ղ��ֹ���
			
			jbl_select_info.setText(select_info[0]);
			jbl_select_info.setFont(new Font("��������", 10, 20));
			
			jbl_select_info.setBounds(150, 10, 140, 20);
			condition_panel.add(jbl_select_info);//������Ϣ��ʾ���������
			
			jtf_info_one.setBounds(300, 10, 150, 20);
			condition_panel.add(jtf_info_one);//��ӵ���Ϣ������Ϣ�ı���
			
			section.setBounds(460, 10, 10, 20);
			condition_panel.add(section);//~��ʹ�� ���������ʱ��ʹ��
			
			jtf_info_two.setBounds(480, 10, 140, 20);
			condition_panel.add(jtf_info_two);//���������ʱ����������ʹ��
			
			jsp_info.setOpaque(false);
			jsp_info.setBounds(30, 240, 935, 400);
			add(jsp_info);
			
			start_select.setBackground(new Color(220, 220, 220));
			start_select.setBounds(630, 10, 100, 20);
			condition_panel.add(start_select);
			
			add(condition_panel);
			//Ĭ������Ĵ���
			key = select_key[0];//Ĭ�ϵļ�����ʽ
			jtf_info_two.setEditable(false);//Ĭ��Ϊ����ͼ���ŵļ�����ʽ  ���Եڶ����ı��򲻿ɱ༭
			
			for(int i = 0;i<10;i++){
				jrb[i] = new JRadioButton(mode[i]);
//				jrb[i].setOpaque(false);//���ϱ�͸��  ���ǻ��в�Ӱ
					int k = i;
					
					jrb[i].addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {

						jbl_select_info.setText(select_info[k]);
						condition_panel.add(jbl_select_info);
						
						if(k <= 5)
							jtf_info_two.setEditable(false);
							
						if(k >= 6)
							jtf_info_two.setEditable(true);
							
						key = select_key[k];
					}
				});
				
				jrb[i].setFont(new Font("��������", 10, 20));
				bg.add(jrb[i]);
				
				mode_panel.add(jrb[i]);
			}
			
			//��ʼ�����ļ���
			start_select.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					//ÿ�ε����ʼ������ ���Ԫ�������
					for(int i = table.getRowCount()-1;i>=0;i--)
						table.removeRow(i);
					
					field_one = jtf_info_one.getText();
					field_two = jtf_info_two.getText();
					
					if(field_one.length() == 0){
						new player_audio("alert.wav").playBackgroundSound();//��������
						JOptionPane.showMessageDialog(null, "û�и�������", "����", JOptionPane.ERROR_MESSAGE); //��ʾ��¼����
						if(key == "LMS_price" || key == "LMS_page"){
							if(field_two.length() == 0){
								new player_audio("alert.wav").playBackgroundSound();//��������
								JOptionPane.showMessageDialog(null, "û�и�������", "����", JOptionPane.ERROR_MESSAGE); //��ʾ����δ��д��
							}
						}
						
					}
					
					if(field_one.length() != 0){
						
						if(key == "LMS_price" || key == "LMS_page" || key == "LMS_typedays" || key == "LMS_total"){
							System.out.println("test");
							if(field_two.length() == 0){
								new player_audio("alert.wav").playBackgroundSound();//��������
								JOptionPane.showMessageDialog(null, "û�и�������", "����", JOptionPane.ERROR_MESSAGE); //��ʾ����δ��д��
							}
							else{
								//�����ѯ
								if(key == "LMS_price"){
									
									value_one = Float.valueOf(field_one);
									value_two = Float.valueOf(field_two);
									
									sql = "select LMS_isbn,LMS_bookname,LMS_anthor,LMS_translator,LMS_publish,LMS_publishtime,LMS_price,LMS_page,LMS_introduce,LMS_total,LMS_typename,LMS_typedays"+
												" from LMS_view_bookinfo_booktype"+" where "+key+" <= '"+value_two+"' and "+key+" >= '"+value_one+"'";         		
								}
								//if(key == "LMS_page")
								else{
									value_one_int = Integer.valueOf(field_one);
									value_two_int = Integer.valueOf(field_two);
									sql = "select LMS_isbn,LMS_bookname,LMS_anthor,LMS_translator,LMS_publish,LMS_publishtime,LMS_price,LMS_page,LMS_introduce,LMS_total,LMS_typename,LMS_typedays"+
											" from LMS_view_bookinfo_booktype"+" where "+key+" <= '"+value_two_int+"' and "+key+" >= '"+value_one_int+"'";   
								}
								
								try {
									rs = stm.executeQuery(sql);
								
									while(rs.next()){
										
										Vector c = new Vector();
										c.add(rs.getString("LMS_isbn"));
										c.add(rs.getString("LMS_bookname"));
										c.add(rs.getString("LMS_anthor"));
										c.add(rs.getString("LMS_translator"));
										c.add(rs.getString("LMS_publish"));
										c.add(rs.getString("LMS_publishtime"));
										c.add(rs.getString("LMS_page"));
										c.add(rs.getString("LMS_total"));
										c.add(rs.getString("LMS_typename"));
										c.add(rs.getString("LMS_typedays"));
										c.add(rs.getString("LMS_introduce"));
										table.addRow(c);
									}
									
								} 
								catch (SQLException e1) {
									e1.printStackTrace();
									System.out.println("sql error");
								}
								
							}
									
						}
						else{
							//��ֵģ����ѯ
							field_one = field_one.toLowerCase();//ת��ΪСд ���м���
							
							sql = "select LMS_isbn,LMS_bookname,LMS_anthor,LMS_translator,LMS_publish,LMS_publishtime,LMS_price,LMS_page,LMS_introduce,LMS_total,LMS_typename,LMS_typedays"+
									" from LMS_view_bookinfo_booktype"+" where "+key+" like '%"+field_one+"%'";
							try {
								rs = stm.executeQuery(sql);

								while(rs.next()){
									
									Vector c = new Vector();
									c.add(rs.getString("LMS_isbn"));
									c.add(rs.getString("LMS_bookname"));
									c.add(rs.getString("LMS_anthor"));
									c.add(rs.getString("LMS_translator"));
									c.add(rs.getString("LMS_publish"));
									c.add(rs.getString("LMS_publishtime"));
									c.add(rs.getString("LMS_page"));
									c.add(rs.getString("LMS_total"));
									c.add(rs.getString("LMS_typename"));
									c.add(rs.getString("LMS_typedays"));
									c.add(rs.getString("LMS_introduce"));
									table.addRow(c);
									
								}

							}
							catch (SQLException e1) {
								e1.printStackTrace();
								System.out.println("sql error->��");
							}
							
						}//if
					
					}
				}
			});
			
			add(mode_panel);
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
	
//	public void paintComponent(Graphics g){
//		
//		g.drawImage(background_image, 0, 0, null);
//		
//	}
}

package curriculum_design_manager;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class booktype_operate extends JPanel{

	private String id;//��������Ա���˺� ���������Լ�����һ��������
	private String psd;//��������Ա������  ���������Լ�����һ��������
	
	String [] mode = new String[]{"�鿴","�޸�","����","ɾ��"};
	
	String sql;//sql���
	Statement stm;
	ResultSet rs ;//���ս��Ԫ��
	
	DefaultTableModel dtl = new DefaultTableModel();
	JTable table;//�����Ϣ�ı��
	JScrollPane jsp_booktype ;//����Ϣ�ܹ���ʾ��
	
	JPanel btn_jpl = new JPanel();
	ButtonGroup bg = new ButtonGroup();//��ťȺ��   ��ťֻ��һ����Ч��
	JRadioButton []jrb = new JRadioButton[4] ;//����ɾ���ġ��鰴ť
	
	//ȷ���� ȡ����ť
	JPanel yes_no = new JPanel();//����ȷ����ȡ����ť��panel���
	JButton yes = new JButton("ȷ��");
	JButton no = new JButton("ȡ��");
	private int flag = 0;//���ѡ����ĸ����� �ṩ��ȷ����ȡ����ťʹ��
						 //�޸� flag = 1
						 //����flag = 2
						 //ɾ��flag = 3
	
	JLabel prompt = new JLabel(new ImageIcon("booktype.png"));//��ʾ�µ�ͼ������
	JPanel add_panel = new JPanel();//�����ͼ������ʱ�� ʹ�õ��������
	Vector <JTextField>vec_add_jta_booktype = new Vector();//���ͼ��������Ϣ���ı���
	Vector vec_add_jll_booktype = new Vector();//����ͼ��������Ϣ�ı�ǩ
	
	Vector <Integer>vec_delete = new Vector();//ɾ������ʹ��//=====
	int port ;//��¼ָ������ Ϊ�˸�ɾ��ʹ��//=========
	
	String[] title = {"���ͱ��","��������","�ɽ�����"};

	public booktype_operate(String id, String psd) {
		
		//������ӵ�ͼ��������Ϣ������
		add_panel.setLayout(new GridLayout(2,3,5,15));//��Ų������
		
		//��ʾ�µ�ͼ�����͵�λ������
		prompt.setBounds(25, 80, 60, 60);
		add(prompt);
		
		//�����ʾ3����ǩ
		for(int i = 0;i<3;i++){
			
			vec_add_jll_booktype.add(new JLabel(title[i]));//���ӱ�ǩ��������
			vec_add_jta_booktype.add(new JTextField());//������Ҫ���ӵ��ı���������
			
		}
		
		//��ӱ�ǩ  ��������ȡ���������
		for(int i = 0;i<3;i++)			
			add_panel.add((Component) vec_add_jll_booktype.get(i));
		
		//����ı���  ��������ȡ������
		for(int i = 0;i<3;i++)
			add_panel.add((Component) vec_add_jta_booktype.get(i));
			
		add_panel.setBounds(95, 70, 865, 80);//���ͼ��������Ϣ������λ��
		add(add_panel);
		prompt.setVisible(false);//��ʾ��ǩ�Ŀɼ��ԣ�ֻ�������ͼ��������Ϣ��ʱ��  �ɼ���
		add_panel.setVisible(false);//��Ӹ���ͼ��������Ϣ�Ŀɼ��ԣ�ֻ�������ͼ��������Ϣ��ʱ��  �ɼ���
		
		
		table = new JTable(dtl){
			@Override
			//��һ�е�ͼ�����ͱ�Ų��ܹ��޸�
			public boolean isCellEditable(int rowindex,int colindex){
			    if (colindex == 0 || colindex == 3) return false; 
			    return true;
			 } 
		};//�����Ϣ�ı��
		table.getTableHeader().setReorderingAllowed(false);   //���������ƶ�   
//		table.getTableHeader().setResizingAllowed(false);   //������������Ȳ����Ա仯
		table.setRowHeight(20);//���ñ����и�
		
		//������  ��ɾ����ʱ��ʹ��//=======
				table.addMouseListener(new MouseAdapter() {
					
					public void mousePressed(MouseEvent e) {

						if(flag == 3){//��ɾ�����ܵ�ʱ��  ����Ч��
							port = table.rowAtPoint(e.getPoint());
							System.out.println(port);
							
							if(dtl.getValueAt(port, 3) != "��"){
								dtl.setValueAt("��",port , 3);
								vec_delete.add(port);//��׼��ɾ���ļ�¼����
							}
								
							//˵���Ѿ�������� �ٵ����Ҫȥ��ɾ����
							else{
								vec_delete.remove(new Integer(port));//ɾ������Ѿ�ѡ���  ˵����ɾ����
								dtl.setValueAt("",port , 3);
							}
								
						}
						
					}
				});
				//=========
		
		
		jsp_booktype = new JScrollPane(table);//����Ϣ�ܹ���ʾ��
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);//���ʧȥ�����ʱ�� ���Լ�ʹ��������

		
		//ȷ����ȡ�� ��ť��λ������
		yes_no.setLayout(new GridLayout(1, 2));//�պ÷���������ť
		//��ť͸��Ч��
		yes.setOpaque(false);
		yes.setBackground(Color.pink);
		//��ť͸��Ч��
		no.setOpaque(false);
		no.setBackground(Color.pink);
		yes_no.add(yes);
		yes_no.add(no);
		yes_no.setBounds(25, 580, 935, 50);
		add(yes_no);
		yes_no.setVisible(false);//���˲鿴֮������������  ���������鰴ť
		
		//���ӵ������
		for(int i = 0;i<3;i++)
			dtl.addColumn(title[i]);
		table.setEnabled(false);//�ñ�񲻿ɱ༭
		table.setRowHeight(20);//���ñ����и�
		jsp_booktype.setBounds(25, 165, 935, 400);
		add(jsp_booktype);
		
		this.id = id;
		this.psd = psd;
		stm = new LMS_connect().getStatement();//��ȡ���ݿ�
		setLayout(null);//��ղ��ֹ���
		
		
		
		//���÷��õ�ѡ��ť��panel�Ĳ��ֹ���
		btn_jpl.setLayout(new GridLayout(1, 4));
		btn_jpl.setBounds(150, 20, 700, 50);
		
		//��ʼ����ť
		for(int i = 0;i<4;i++){
			
			jrb[i] = new JRadioButton(mode[i]);
			jrb[i].setFont(new Font("����", 10, 30));
			bg.add(jrb[i]);//�ӵ���ťȺ���� ��ֻ֤��һ����ť��Ч��
			btn_jpl.add(jrb[i]);//�����ڰ�ťpanel��
			
		}
		
		//һ��ʼ ��ʾ����
		{
			//ÿ�εĲ�ѯ�����ԭ���ı��
			for(int i = dtl.getRowCount()-1;i>=0;i--)
				dtl.removeRow(i);
			
			sql = "select * from LMS_booktype ";//��ѯ���
			try {
				rs = stm.executeQuery(sql);
				while(rs.next()){
					Vector v = new Vector();
					v.add(rs.getString("LMS_typeid"));
					v.add(rs.getString("LMS_typename"));
					v.add(rs.getString("LMS_typedays"));
					dtl.addRow(v);
				}
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("sql error");
			}
		}
		
		//�鿴��ť�ļ���
		jrb[0].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//���ֿɼ���,�Լ����ɼ���
				yes_no.setVisible(false);//���˲鿴֮������������  ���������鰴ť
				table.setEnabled(false);//�����رտɱ༭��
				prompt.setVisible(false);//��ʾ��ǩ�Ŀɼ��ԣ�ֻ�������ͼ����Ϣ��ʱ��  �ɼ���
				add_panel.setVisible(false);//��Ӹ�����Ϣ�Ŀɼ��ԣ�ֻ�������ͼ����Ϣ��ʱ��  �ɼ���
				
				
				//ÿ�εĲ�ѯ�����ԭ���ı��
				for(int i = dtl.getRowCount()-1;i>=0;i--)
					dtl.removeRow(i);
				
				sql = "select * from LMS_booktype";//��ѯ���
				try {
					rs = stm.executeQuery(sql);
					while(rs.next()){
						Vector v = new Vector();
						v.add(rs.getString("LMS_typeid"));
						v.add(rs.getString("LMS_typename"));
						v.add(rs.getString("LMS_typedays"));
						dtl.addRow(v);
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("sql error");
				}
				
			}
		});
		
		//�޸İ�ť�ļ���
		jrb[1].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				//ÿ���޸�ǰ ����Ҫ��ӡ���ݿ����е�����
				for(int i = dtl.getRowCount()-1;i>=0;i--)
					dtl.removeRow(i);
				
				sql = "select * from LMS_booktype";//��ѯ���
				try {
					rs = stm.executeQuery(sql);
					while(rs.next()){
						Vector v = new Vector();
						v.add(rs.getString("LMS_typeid"));
						v.add(rs.getString("LMS_typename"));
						v.add(rs.getString("LMS_typedays"));
						dtl.addRow(v);
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("sql error");
				}
				
				
				flag = 1;
				yes_no.setVisible(true);//���˲鿴֮������������  ���������鰴ť
				table.setEnabled(true);//�ñ����Ա༭
				prompt.setVisible(false);//��ʾ��ǩ�Ŀɼ��ԣ�ֻ�������ͼ����Ϣ��ʱ��  �ɼ���
				add_panel.setVisible(false);//��Ӹ�����Ϣ�Ŀɼ��ԣ�ֻ�������ͼ����Ϣ��ʱ��  �ɼ���

			}
		});
		
		//���Ӱ�ť�ļ���
		jrb[2].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		
				//ÿ������Ǯ ���鿴���������е�ͼ��������Ϣ
				for(int i = dtl.getRowCount()-1;i>=0;i--)
					dtl.removeRow(i);
				
				sql = "select * from LMS_booktype";//��ѯ���
				try {
					rs = stm.executeQuery(sql);
					while(rs.next()){
						Vector v = new Vector();
						v.add(rs.getString("LMS_typeid"));
						v.add(rs.getString("LMS_typename"));
						v.add(rs.getString("LMS_typedays"));
						dtl.addRow(v);
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("sql error");
				}
				
				flag = 2;
				yes_no.setVisible(true);
				table.setEnabled(false);//�ñ�񲻿ɱ༭
				prompt.setVisible(true);//��ʾ��ǩ�Ŀɼ��ԣ�ֻ�������ͼ����Ϣ��ʱ��  �ɼ���
				add_panel.setVisible(true);//��Ӹ�����Ϣ�Ŀɼ��ԣ�ֻ�������ͼ����Ϣ��ʱ��  �ɼ���
			}
		});
		
		//ɾ����ť�ļ���
		jrb[3].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				//ÿ��ɾ��ǰ ���鿴���������е�ͼ��������Ϣ
				for(int i = dtl.getRowCount()-1;i>=0;i--)
					dtl.removeRow(i);
				
				sql = "select * from LMS_booktype";//��ѯ���
				try {
					rs = stm.executeQuery(sql);
					while(rs.next()){
						Vector v = new Vector();
						v.add(rs.getString("LMS_typeid"));
						v.add(rs.getString("LMS_typename"));
						v.add(rs.getString("LMS_typedays"));
						dtl.addRow(v);
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("sql error");
				}
				
				//====================
				
				if(dtl.getColumnCount() <= 3)//�ڳ�����Χ��Ͳ��ڳ�����//====
					dtl.addColumn("��ѡ��");//======
				//�ָ����ߵ�ʱ���״̬
				if(dtl.getColumnCount() > 3){
					for(int i = 0;i<vec_delete.size();i++)
						table.setValueAt("��", vec_delete.get(i), 3);
				}
				//====================
				
				flag = 3;
				yes_no.setVisible(true);
				table.setEnabled(false);//�ñ�񲻿ɱ༭
				prompt.setVisible(false);//��ʾ��ǩ�Ŀɼ��ԣ�ֻ�������ͼ����Ϣ��ʱ��  �ɼ���
				add_panel.setVisible(false);//��Ӹ�����Ϣ�Ŀɼ��ԣ�ֻ�������ͼ����Ϣ��ʱ��  �ɼ���
				
			}
		});
		
		//ȷ����ť
		yes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//ִ�е��Ǽ����޸ĵĹ��� ���޸ĺ�������ύ�����ݿ�
				if(flag == 1){
					for(int i = 0 ;i<dtl.getRowCount();i++){
						
						Vector v = new Vector();//�洢ÿһ�е�����
						for(int j = 1;j<3;j++)
							v.add(table.getValueAt(i, j));
						/*
						 * "���ͱ��","��������","�ɽ�����"
						 */
						sql = "update LMS_booktype set "+
							" LMS_typename = '"+v.get(0)+"', LMS_typedays = '"+v.get(1)+"' where LMS_typeid = '"+table.getValueAt(i, 0)+"'";
						try {
							stm.executeUpdate(sql);
							
						}
						catch (SQLException e1) {
							e1.printStackTrace();
							System.out.println("sql error");
						}
					}
					JOptionPane.showConfirmDialog(null, "�޸ĳɹ�!", "��ϲ", JOptionPane.DEFAULT_OPTION);
				}
				
				//ִ�е��Ǽ������ӵĹ���  �����ӵ���ͼ�����͵������ύ�����ݿ�
				if(flag == 2){
				
					sql = "insert into LMS_booktype values('"+vec_add_jta_booktype.get(0).getText()+"','"+vec_add_jta_booktype.get(1).getText()+"' , "+
						" '"+vec_add_jta_booktype.get(2).getText()+"')";
					
					try {
						stm.executeUpdate(sql);
						
						for(int i = 0;i<3;i++)//������һ���� ���ͼ��������Ϣ�ı���
							vec_add_jta_booktype.get(i).setText("");
						
					} 
					catch (SQLException e1) {
					
						e1.printStackTrace();
//						JOptionPane.showMessageDialog(null, "�Ѿ�����!", "����!", JOptionPane.ERROR_MESSAGE);
						System.out.println("sql error");
					}
				}
				
				//ִ�м���ɾ���Ĺ���
				if(flag == 3){
					int ii = 0;
					//��ʼɾ��
					for(int i = 0;i<vec_delete.size();i++){
						
						sql = "delete from LMS_booktype where LMS_typeid  = '"+table.getValueAt(vec_delete.get(i), 0)+"' ";
						
						try {
							ii = stm.executeUpdate(sql);
						} 
						catch (SQLException e1) {
//							e1.printStackTrace();
							System.out.println("sql error");
						}
					}
					
					
					if(vec_delete.size() != 0)//��Ϊ0  ˵���й�ɾ��������
						if(ii != 0)//Ҫɾ����ͼ������ ���ڽ��ȥ �ǾͲ���ɾ�� 
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�!", "��ϲ!", JOptionPane.DEFAULT_OPTION);
					
					vec_delete.removeAllElements();//����֮�� ��Ҫ����ɾ��
					//ȷ��֮�� ������ʾɾ��������ʾ
					for(int i = dtl.getRowCount()-1;i>=0;i--)
						dtl.removeRow(i);
					
					sql = "select * from LMS_booktype ";//��ѯ���
					try {
						rs = stm.executeQuery(sql);
						while(rs.next()){
							Vector v = new Vector();
							v.add(rs.getString("LMS_typeid"));
							v.add(rs.getString("LMS_typename"));
							v.add(rs.getString("LMS_typedays"));
							dtl.addRow(v);
						}
					} 
					catch (SQLException e1) {
						e1.printStackTrace();
						System.out.println("sql error");
					}
				}
			}
		});
		
		//ȡ����ť
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//�޸ĵ�ȡ������
				if(flag == 1){
					for(int i = dtl.getRowCount()-1;i>=0;i--)
						dtl.removeRow(i);
					
					sql = "select * from LMS_booktype";//��ѯ���
					try {
						rs = stm.executeQuery(sql);
						while(rs.next()){
							Vector v = new Vector();
							v.add(rs.getString("LMS_typeid"));
							v.add(rs.getString("LMS_typename"));
							v.add(rs.getString("LMS_typedays"));
							dtl.addRow(v);
						}
					} 
					catch (SQLException e1) {
//						e1.printStackTrace();
						System.out.println("sql error");
					}
				}
				
				//���ӵ�ȡ������
				if(flag == 2){
					
					for(int i = 0;i<12;i++)
						vec_add_jta_booktype.get(i).setText("");
				}
				
				//ɾ����ȡ������
				if(flag == 3){
					
					vec_delete.removeAllElements();//ȡ���Ǿ�������е���Ϣ
					for(int i = dtl.getRowCount()-1;i>=0;i--)//�ѱ��ȫ��ȫ��ȥ��
						dtl.setValueAt("", i, 3);
				}
				
			}
		});
		
		add(btn_jpl);
		
	}
	
}

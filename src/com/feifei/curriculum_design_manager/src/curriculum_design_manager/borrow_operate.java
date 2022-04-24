package curriculum_design_manager;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class borrow_operate extends JPanel{
	
	private String id;//��������Ա���˺� ���������Լ�����һ��������
	private String psd;//��������Ա������  ���������Լ�����һ��������
	
	String [] mode = new String[]{"�鿴","�޸�","����","ɾ��"};
	
	String sql;//sql���
	Statement stm;
	ResultSet rs ;//���ս��Ԫ��
	
	DefaultTableModel dtl = new DefaultTableModel();
	JTable table;//�����Ϣ�ı���
	JScrollPane jsp_bookinfo ;//����Ϣ�ܹ���ʾ��
	
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
	
	JLabel prompt = new JLabel(new ImageIcon("borrow.png"));//��ʾ�µ�ͼ��
	JPanel add_panel = new JPanel();//������ͼ��ʱ�� ʹ�õ��������
	Vector <JTextField>vec_add_jta_bookinfo = new Vector();//������Ϣ���ı���
	Vector vec_add_jll_bookinfo = new Vector();//������Ϣ�ı�ǩ
	
	Vector <Integer>vec_delete = new Vector();//ɾ������ʹ��//=====
	int port ;//��¼ָ������ Ϊ�˸�ɾ��ʹ��//=========
	
	String[] title = {"���","����Ψһ���","ISBN","����ʱ��","Ӧ��ʱ��","�Ƿ�黹"};
	
	//���췽����ʼ

	public borrow_operate(String id, String psd) {
		
		//�������ӵ���Ϣ������
		add_panel.setLayout(new GridLayout(2,5,5,15));//��Ų�������
		
		//��ʾ�µ�ͼ���λ������
		prompt.setBounds(25, 80, 50, 60);
		add(prompt);
		
		//������ʾ12����ǩ
		for(int i = 0;i<5;i++){
			
			vec_add_jll_bookinfo.add(new JLabel(title[i+1]));//��ǩ
			vec_add_jta_bookinfo.add(new JTextField());//�ı���
			
		}
		
		//���ӱ�ǩ
		for(int i = 0;i<5;i++)			
			add_panel.add((Component) vec_add_jll_bookinfo.get(i));
		
		//�����ı���
		for(int i = 0;i<5;i++)
			add_panel.add((Component) vec_add_jta_bookinfo.get(i));
			
		add_panel.setBounds(95, 70, 865, 80);//����ͼ����Ϣ������λ��
		add(add_panel);
		prompt.setVisible(false);//��ʾ��ǩ�Ŀɼ��ԣ�ֻ��������ͼ����Ϣ��ʱ��  �ɼ���
		add_panel.setVisible(false);//���Ӹ�����Ϣ�Ŀɼ��ԣ�ֻ��������ͼ����Ϣ��ʱ��  �ɼ���
		
		table = new JTable(dtl){
			@Override
			//��һ�еı�Ų��ܹ��޸�
			public boolean isCellEditable(int rowindex,int colindex){
			    if (colindex == 0 || colindex == 3 || colindex == 4 || colindex == 6) return false; //������Ҫ�¼���===========
			    return true;
			 } 
		};//�����Ϣ�ı���
		
		table.getTableHeader().setReorderingAllowed(false);   //���������ƶ�   
//		table.getTableHeader().setResizingAllowed(false);   //��������������Ȳ����Ա仯
		table.setRowHeight(20);//���ñ�����и�
		
		//�������  ��ɾ����ʱ��ʹ��//=======
		table.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {

				if(flag == 3){//��ɾ�����ܵ�ʱ��  ����Ч��
					port = table.rowAtPoint(e.getPoint());
					System.out.println(port);
					
					if(dtl.getValueAt(port, 6) != "��"){
						dtl.setValueAt("��",port , 6);
						vec_delete.add(port);//��׼��ɾ���ļ�¼����
					}
						
					//˵���Ѿ�������� �ٵ����Ҫȥ��ɾ����
					else{
						vec_delete.remove(new Integer(port));//ɾ������Ѿ�ѡ���  ˵����ɾ����
						dtl.setValueAt("",port , 6);
					}
						
				}
				
			}
		});
		//=========
		
		jsp_bookinfo = new JScrollPane(table);//����Ϣ�ܹ���ʾ��
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);//����ʧȥ�����ʱ�� ���Լ�ʹ��������
		
		//ȷ����ȡ�� ��ť��λ������
		yes_no.setLayout(new GridLayout(1, 2));//�պ÷���������ť
		//��ť͸��Ч��
		yes.setOpaque(false);
		//��ť͸��Ч��
		yes.setBackground(Color.pink);
		no.setOpaque(false);
		//��ť͸��Ч��
		no.setBackground(Color.pink);
		yes_no.add(yes);
		yes_no.add(no);
		yes_no.setBounds(25, 580, 935, 50);
		add(yes_no);
		yes_no.setVisible(false);//���˲鿴֮������������  ���������鰴ť
		
		//���ӵ�������
		for(int i = 0;i<6;i++)
			dtl.addColumn(title[i]);
		table.setEnabled(false);//�ñ��񲻿ɱ༭
		table.setRowHeight(20);//���ñ�����и�
		jsp_bookinfo.setBounds(25, 165, 935, 400);
		add(jsp_bookinfo);
		
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
			//ÿ�εĲ�ѯ�����ԭ���ı���
			for(int i = dtl.getRowCount()-1;i>=0;i--)
				dtl.removeRow(i);
			
			sql = "select * from LMS_view_borrow_booktype ";//��ѯ���
			try {
				rs = stm.executeQuery(sql);
				while(rs.next()){
					Vector v = new Vector();
					v.add(rs.getString("LMS_borrowid"));
					v.add(rs.getString("LMS_borrowreadernum"));
					v.add(rs.getString("LMS_borrowisbn"));
					v.add(rs.getString("LMS_borrowtime"));
					v.add(rs.getString("LMS_borrowbacktime"));
					v.add(rs.getString("LMS_borrowisback"));
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
				prompt.setVisible(false);//��ʾ��ǩ�Ŀɼ��ԣ�ֻ��������ͼ����Ϣ��ʱ��  �ɼ���
				add_panel.setVisible(false);//���Ӹ�����Ϣ�Ŀɼ��ԣ�ֻ��������ͼ����Ϣ��ʱ��  �ɼ���
				
				
				//ÿ�εĲ�ѯ�����ԭ���ı���
				for(int i = dtl.getRowCount()-1;i>=0;i--)
					dtl.removeRow(i);
				
				sql = "select * from LMS_view_borrow_booktype";//��ѯ���
				try {
					rs = stm.executeQuery(sql);
					while(rs.next()){
						Vector v = new Vector();
						v.add(rs.getString("LMS_borrowid"));
						v.add(rs.getString("LMS_borrowreadernum"));
						v.add(rs.getString("LMS_borrowisbn"));
						v.add(rs.getString("LMS_borrowtime"));
						v.add(rs.getString("LMS_borrowbacktime"));
						v.add(rs.getString("LMS_borrowisback"));
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
				
				sql = "select * from LMS_view_borrow_booktype";//��ѯ���
				try {
					rs = stm.executeQuery(sql);
					while(rs.next()){
						Vector v = new Vector();
						v.add(rs.getString("LMS_borrowid"));
						v.add(rs.getString("LMS_borrowreadernum"));
						v.add(rs.getString("LMS_borrowisbn"));
						v.add(rs.getString("LMS_borrowtime"));
						v.add(rs.getString("LMS_borrowbacktime"));
						v.add(rs.getString("LMS_borrowisback"));
						dtl.addRow(v);
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("sql error");
				}
				
//				type.addItem("sda");
//				type.addItem("123");
//				table.setCellEditor(new DefaultCellEditor(type));
				
				flag = 1;
				yes_no.setVisible(true);//���˲鿴֮������������  ���������鰴ť
				table.setEnabled(true);//�ñ�����Ա༭
				prompt.setVisible(false);//��ʾ��ǩ�Ŀɼ��ԣ�ֻ��������ͼ����Ϣ��ʱ��  �ɼ���
				add_panel.setVisible(false);//���Ӹ�����Ϣ�Ŀɼ��ԣ�ֻ��������ͼ����Ϣ��ʱ��  �ɼ���

			}
		});
		
		//���Ӱ�ť�ļ���
		jrb[2].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		
				//ÿ������Ǯ ���鿴���������е�ͼ����Ϣ
				for(int i = dtl.getRowCount()-1;i>=0;i--)
					dtl.removeRow(i);
				
				sql = "select * from LMS_view_borrow_booktype";//��ѯ���
				try {
					rs = stm.executeQuery(sql);
					while(rs.next()){
						Vector v = new Vector();
						v.add(rs.getString("LMS_borrowid"));
						v.add(rs.getString("LMS_borrowreadernum"));
						v.add(rs.getString("LMS_borrowisbn"));
						v.add(rs.getString("LMS_borrowtime"));
						v.add(rs.getString("LMS_borrowbacktime"));
						v.add(rs.getString("LMS_borrowisback"));
						dtl.addRow(v);
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("sql error");
				}
				
				flag = 2;
				yes_no.setVisible(true);
				table.setEnabled(false);//�ñ��񲻿ɱ༭
				prompt.setVisible(true);//��ʾ��ǩ�Ŀɼ��ԣ�ֻ��������ͼ����Ϣ��ʱ��  �ɼ���
				add_panel.setVisible(true);//���Ӹ�����Ϣ�Ŀɼ��ԣ�ֻ��������ͼ����Ϣ��ʱ��  �ɼ���
			}
		});
		
		//ɾ����ť�ļ���
		jrb[3].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				//ÿ��ɾ��ǰ ���鿴���������е�ͼ����Ϣ
				for(int i = dtl.getRowCount()-1;i>=0;i--)
					dtl.removeRow(i);
				
				sql = "select * from LMS_view_borrow_booktype";//��ѯ���
				try {
					rs = stm.executeQuery(sql);
					while(rs.next()){
						Vector v = new Vector();
						v.add(rs.getString("LMS_borrowid"));
						v.add(rs.getString("LMS_borrowreadernum"));
						v.add(rs.getString("LMS_borrowisbn"));
						v.add(rs.getString("LMS_borrowtime"));
						v.add(rs.getString("LMS_borrowbacktime"));
						v.add(rs.getString("LMS_borrowisback"));
						dtl.addRow(v);
					}
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("sql error");
				}
				
				//====================
				
				if(dtl.getColumnCount() <= 6)//�ڳ�����Χ��Ͳ��ڳ�����//====
					dtl.addColumn("��ѡ��");//======
				//�ָ����ߵ�ʱ���״̬
				if(dtl.getColumnCount() > 6){
					for(int i = 0;i<vec_delete.size();i++)
						table.setValueAt("��", vec_delete.get(i), 6);
				}
				//====================
				
				flag = 3;
				yes_no.setVisible(true);
				table.setEnabled(false);//�ñ��񲻿ɱ༭
				prompt.setVisible(false);//��ʾ��ǩ�Ŀɼ��ԣ�ֻ��������ͼ����Ϣ��ʱ��  �ɼ���
				add_panel.setVisible(false);//���Ӹ�����Ϣ�Ŀɼ��ԣ�ֻ��������ͼ����Ϣ��ʱ��  �ɼ���
				
			}
		});
		
		//ȷ����ť�ļ���
		yes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//ִ�е��Ǽ����޸ĵĹ��� ���޸ĺ�������ύ�����ݿ�
				if(flag == 1){
					for(int i = 0 ;i<dtl.getRowCount();i++){
						
						Vector v = new Vector();//�洢ÿһ�е�����
						for(int j = 1;j<6;j++)
							v.add(table.getValueAt(i, j));
						
						sql = "update LMS_borrow set LMS_borrowreadernum = '"+v.get(0)+"', "+
							" LMS_borrowisbn = '"+v.get(1)+"', LMS_borrowtime = '"+v.get(2)+"' ,LMS_borrowbacktime = '"+v.get(3)+"' ,"+
								" LMS_borrowisback = '"+v.get(4)+"' "+
							" where LMS_borrowid = '"+table.getValueAt(i, 0)+"' ";
						try {
							stm.executeUpdate(sql);
							
						}
						catch (SQLException e1) {
//							e1.printStackTrace();
							System.out.println("sql error");
						}
					}
					JOptionPane.showConfirmDialog(null, "�޸ĳɹ�!", "��ϲ", JOptionPane.DEFAULT_OPTION);
				}
				
				//ִ�е��Ǽ������ӵĹ���  �����ӵ���ͼ��������ύ�����ݿ�
				if(flag == 2){
				
					//û������ʱ���ʱ��  ʹ��ϵͳĥ�˵Ķ�ʱ��
					if(vec_add_jta_bookinfo.get(2).getText().length() == 0)
						vec_add_jta_bookinfo.get(2).setText(new String(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date())));
					
					sql = "insert into LMS_borrow values('"+vec_add_jta_bookinfo.get(0).getText()+"','"+vec_add_jta_bookinfo.get(1).getText()+"' , "+
							" '"+vec_add_jta_bookinfo.get(2).getText()+"' , '"+vec_add_jta_bookinfo.get(3).getText()+"'  , '"+vec_add_jta_bookinfo.get(4).getText()+"')";
					
					try {
						stm.executeUpdate(sql);
						
						for(int i = 0;i<5;i++)//������һ���� ���ͼ����Ϣ�ı���
							vec_add_jta_bookinfo.get(i).setText("");
						
					} 
					catch (SQLException e1) {
					
						e1.printStackTrace();
//						JOptionPane.showMessageDialog(null, "�Ѿ�����!", "����!", JOptionPane.ERROR_MESSAGE);
						System.out.println("sql error");
					}
				}
				
				//ɾ���Ĵ���//================================
				if(flag == 3){
					
					//��ʼɾ��
					
					for(int i = 0;i<vec_delete.size();i++){
						
						sql = "delete from LMS_borrow where LMS_borrowid  = '"+table.getValueAt(vec_delete.get(i), 0)+"' ";
						
						try {
							stm.executeUpdate(sql);
						} 
						catch (SQLException e1) {
//							e1.printStackTrace();
							System.out.println("sql error");
						}
					}
					
					
					if(vec_delete.size() != 0)//��Ϊ0  ˵���й�ɾ��������
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�!", "��ϲ!", JOptionPane.DEFAULT_OPTION);
					
					vec_delete.removeAllElements();//����֮�� ��Ҫ����ɾ��
					//ȷ��֮�� ������ʾɾ���������ʾ
					for(int i = dtl.getRowCount()-1;i>=0;i--)
						dtl.removeRow(i);
					
					sql = "select * from LMS_borrow";//��ѯ���
					try {
						rs = stm.executeQuery(sql);
						while(rs.next()){
							Vector v = new Vector();
							v.add(rs.getString("LMS_borrowid"));
							v.add(rs.getString("LMS_borrowreadernum"));
							v.add(rs.getString("LMS_borrowisbn"));
							v.add(rs.getString("LMS_borrowtime"));
							v.add(rs.getString("LMS_borrowbacktime"));
							v.add(rs.getString("LMS_borrowisback"));
							dtl.addRow(v);
						}
					} 
					catch (SQLException e1) {
						e1.printStackTrace();
						System.out.println("sql error");
					}
					
				}
				//================================
			}
		});
		
		//ȡ����ť
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//�޸ĵ�ȡ������
				if(flag == 1){
					for(int i = dtl.getRowCount()-1;i>=0;i--)
						dtl.removeRow(i);
					
					sql = "select * from LMS_borrow";//��ѯ���
					try {
						rs = stm.executeQuery(sql);
						while(rs.next()){
							Vector v = new Vector();
							v.add(rs.getString("LMS_borrowid"));
							v.add(rs.getString("LMS_borrowreadernum"));
							v.add(rs.getString("LMS_borrowisbn"));
							v.add(rs.getString("LMS_borrowtime"));
							v.add(rs.getString("LMS_borrowbacktime"));
							v.add(rs.getString("LMS_borrowisback"));
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
					
					for(int i = 0;i<5;i++)
						vec_add_jta_bookinfo.get(i).setText("");
				}
				
				//=========
				//ɾ����ȡ������
				if(flag == 3){
					
					vec_delete.removeAllElements();//ȡ���Ǿ�������е���Ϣ
					for(int i = dtl.getRowCount()-1;i>=0;i--)//�ѱ��ȫ��ȫ��ȥ��
						dtl.setValueAt("", i, 6);
				}
				//==============
				
			}
		});
		
		add(btn_jpl);
		
	}

}
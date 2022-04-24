package curriculum_design_manager;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class reader_borrow_return extends JPanel{

	private String id;//����Ա�˺�
	private String psd;//����Ա����
	
	Statement stm = new LMS_connect().getStatement();//��ȡ���ݿ�
	
	String [] title = new String[]{"ISBN","����","����ʱ��","Ӧ��ʱ��"};
	
	private String reader_id;//���ߵ��˺�
	private JTextField jtf_reader_id = new JTextField();//���ߵ��˺������ı���
	private JLabel jll_reader_id = new JLabel("�����˺�");
	
	//��¼���ߵĶ�������Щ��(δ����)
	DefaultTableModel dtl_borrow = new DefaultTableModel();
	JTable table_borrow = new JTable(dtl_borrow);
	JScrollPane jsp_borrow = new JScrollPane(table_borrow);//���ڳ��ر��
	JLabel jll_borrow = new JLabel("δ��");
	String sql_borrow;
	ResultSet rs_borrow;
	
	//��¼���ߵĶ�������Щ��(�ѻ���)
	DefaultTableModel dtl_return = new DefaultTableModel();
	JTable table_return = new JTable(dtl_return);
	JScrollPane jsp_return = new JScrollPane(table_return);//���ڳ��ر��
	JLabel jll_return = new JLabel("�ѻ�");
	String sql_return;
	ResultSet rs_return;
	
	JButton btn_reader_id = new JButton("ȷ��");
	
	//���췽��
	public reader_borrow_return(String id,String psd) {

		this.id = id;
		this.psd = psd;
		
		setLayout(null);//��ղ��ֹ���
		//�����˺ű�ǩ��λ������
		jll_reader_id.setFont(new Font("����", 10, 20));
		jll_reader_id.setBounds(150, 20, 100, 30);
		add(jll_reader_id);
		
		//���ߵ��˺������ı���λ������
		jtf_reader_id.setBounds(260, 20, 140, 30);
		add(jtf_reader_id);
		
		
		//�ѻ���Ϣ�ı��
		jsp_borrow.setBounds(150, 110, 700, 200);
		add(jsp_borrow);
		table_borrow.setEnabled(false);
		
		//δ���������ʾ��ǩ
		jll_borrow.setFont(new Font("����", 10, 30));
		jll_borrow.setBounds(450, 60, 60, 30);
		add(jll_borrow);

		for(int i = 0;i<4;i++)
			dtl_borrow.addColumn(title[i]);
		
		//δ����Ϣ�ı��
		jsp_return.setBounds(150, 345, 700, 250);
		add(jsp_return);
		table_return.setEnabled(false);
		
		//δ���������ʾ��ǩ
		jll_return.setFont(new Font("����", 10, 30));
		jll_return.setBounds(450, 310, 60, 30);
		add(jll_return);
				
		for(int i = 0;i<3;i++)
			dtl_return.addColumn(title[i]);
		
		//ȷ����ť��λ������
		btn_reader_id.setBounds(470, 20, 60, 30);
		btn_reader_id.setOpaque(false);//��ť��͸��
		btn_reader_id.setBackground(Color.pink);
		add(btn_reader_id);
		
		
		//ȷ����ť�ļ���
		btn_reader_id.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				reader_id = jtf_reader_id.getText();//��ȡ���ߵ��˺�
				//=======================
				//δ����Ϣ�ı��
				//���ԭ��δ��ͼ��ı��(borrow)
				for(int i = dtl_borrow.getRowCount()-1;i>=0;i--)
					dtl_borrow.removeRow(i);
				
				sql_borrow = "select LMS_isbn,LMS_bookname,LMS_borrowtime,LMS_borrowbacktime from LMS_view_borrow_booktype,LMS_bookinfo "+
						" where LMS_bookinfo.LMS_isbn =  LMS_view_borrow_booktype.LMS_borrowisbn and LMS_borrowreadernum = '"+reader_id+"' and LMS_borrowisback = 0";
				try {
					rs_borrow = stm.executeQuery(sql_borrow);
					
					while(rs_borrow.next()){
						Vector v = new Vector();
						v.add(rs_borrow.getString("LMS_isbn"));
						v.add(rs_borrow.getString("LMS_bookname"));
						v.add(rs_borrow.getString("LMS_borrowtime"));
						v.add(rs_borrow.getString("LMS_borrowbacktime"));
						dtl_borrow.addRow(v);
					}
				}
				catch (SQLException ee) {
//					ee.printStackTrace();
					System.out.println("sql error");
				}

				//=======================
				
				for(int i = dtl_return.getRowCount()-1;i>=0;i--)
					dtl_return.removeRow(i);
				
				sql_return = "select LMS_isbn,LMS_bookname,LMS_borrowtime from LMS_view_borrow_booktype,LMS_bookinfo where  LMS_view_borrow_booktype.LMS_borrowreadernum = '"+reader_id+"' and LMS_view_borrow_booktype.LMS_borrowisback = 1 and LMS_bookinfo.LMS_isbn = LMS_view_borrow_booktype.LMS_borrowisbn ";
				
				try {
					rs_return = stm.executeQuery(sql_return);
					
					while(rs_return.next()){
						Vector v = new Vector();
						v.add(rs_return.getString("LMS_isbn"));
						v.add(rs_return.getString("LMS_bookname"));
						v.add(rs_return.getString("LMS_borrowtime"));
						
						dtl_return.addRow(v);
					}
				}
				catch (SQLException ee) {
				
//					ee.printStackTrace();
					System.out.println("sql error");
				}
			}
		});
		
		
		
	}
}

package library_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//我借的书
public class my_borrow_book extends JPanel{
	
	private String id;//读者的账号
	private String psd;//读者的密码
	
	
	Statement stm = new LMS_connect().getStatement();//获取数据库
	
	String [] title = new String[]{"ISBN","书名","借书时间","应还时间"};
	
	//记录读者的都借了那些书(未还的)
	DefaultTableModel dtl_borrow = new DefaultTableModel();
	JTable table_borrow = new JTable(dtl_borrow);
	JScrollPane jsp_borrow = new JScrollPane(table_borrow);//用于承载表格
	JLabel jll_borrow = new JLabel("未还");
	String sql_borrow;
	ResultSet rs_borrow;
	
	//记录读者的都借了那些书(已还的)
	DefaultTableModel dtl_return = new DefaultTableModel();
	JTable table_return = new JTable(dtl_return);
	JScrollPane jsp_return = new JScrollPane(table_return);//用于承载表格
	JLabel jll_return = new JLabel("已还");
	String sql_return;
	ResultSet rs_return;
	
//	String sql_return_temp;//在查询内部使用的  用它找到还书的日期
//	ResultSet rs_return_temp;//查询内部使用  用它找到还书的日期 
	
	JButton flush_info = new JButton("刷新");//实时刷新自己都借了那些书
	
	public my_borrow_book(String id, String psd) {
		
		setLayout(null);
		
		//=======================
		//未还信息的表格
		jsp_borrow.setBounds(150, 50, 700, 250);
		add(jsp_borrow);
		table_borrow.setEnabled(false);
		
		//未还的书的提示标签
		jll_borrow.setFont(new Font("楷体", 10, 30));
		jll_borrow.setBounds(450, 10, 60, 30);
		add(jll_borrow);

		for(int i = 0;i<4;i++)
			dtl_borrow.addColumn(title[i]);
		
		sql_borrow = "select LMS_isbn,LMS_bookname,LMS_borrowtime,LMS_borrowbacktime from LMS_view_borrow_booktype,LMS_bookinfo "+
				" where LMS_bookinfo.LMS_isbn =  LMS_view_borrow_booktype.LMS_borrowisbn and LMS_borrowreadernum = '"+id+"' and LMS_borrowisback = 0";
		
		
		
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
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql error");
		}
		//=======================
		
		//未还的书的提示标签
		jll_return.setFont(new Font("楷体", 10, 30));
		jll_return.setBounds(450, 310, 60, 30);
		add(jll_return);
				
		//未还信息的表格
		jsp_return.setBounds(150, 345, 700, 250);
		add(jsp_return);
		table_return.setEnabled(false);
		
		for(int i = 0;i<3;i++)
			dtl_return.addColumn(title[i]);
//		dtl_return.addColumn("还书时间");
//		
//		sql_return = "select LMS_isbn,LMS_bookname,LMS_borrowtime,LMS_returntime from LMS_view_borrow_booktype,LMS_bookinfo,LMS_return "+
//				" where LMS_bookinfo.LMS_isbn =  LMS_view_borrow_booktype.LMS_borrowisbn and LMS_bookinfo.LMS_isbn = LMS_return.LMS_returnisbn and LMS_return.LMS_returnreaderid = '"+id+"' and LMS_borrowreadernum = '"+id+"' and LMS_borrowisback = 1";
		
		sql_return = "select LMS_isbn,LMS_bookname,LMS_borrowtime from LMS_view_borrow_booktype,LMS_bookinfo where  LMS_view_borrow_booktype.LMS_borrowreadernum = '"+id+"' and LMS_view_borrow_booktype.LMS_borrowisback = 1 and LMS_bookinfo.LMS_isbn = LMS_view_borrow_booktype.LMS_borrowisbn ";
		
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
		catch (SQLException e) {
		
//			e.printStackTrace();
			System.out.println("sql error");
		}
		
		//刷新按钮的位置设置
		flush_info.setBounds(50, 50, 60, 30);
		flush_info.setOpaque(false);
		flush_info.setBackground(Color.pink);
		
		add(flush_info);
		//刷新借书信息的监听
		flush_info.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				/*
				 * 看是不是这里
				 */
				//清空原来未还图书的表格(borrow)
				for(int i = dtl_borrow.getRowCount()-1;i>=0;i--)
					dtl_borrow.removeRow(i);
				sql_borrow = "select LMS_isbn,LMS_bookname,LMS_borrowtime,LMS_borrowbacktime from LMS_view_borrow_booktype,LMS_bookinfo "+
						" where LMS_bookinfo.LMS_isbn =  LMS_view_borrow_booktype.LMS_borrowisbn and LMS_borrowreadernum = '"+id+"' and LMS_borrowisback = 0";
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
				
				//清空原来已还图书的表格(return)
				for(int i = dtl_return.getRowCount()-1;i>=0;i--)
					dtl_return.removeRow(i);
				sql_return = "select LMS_isbn,LMS_bookname,LMS_borrowtime from LMS_view_borrow_booktype,LMS_bookinfo where  LMS_view_borrow_booktype.LMS_borrowreadernum = '"+id+"' and LMS_view_borrow_booktype.LMS_borrowisback = 1 and LMS_bookinfo.LMS_isbn = LMS_view_borrow_booktype.LMS_borrowisbn ";
				
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

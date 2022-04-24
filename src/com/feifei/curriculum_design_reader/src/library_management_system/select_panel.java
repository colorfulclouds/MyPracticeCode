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
	
	//数据库操作变量
	LMS_connect l = new LMS_connect();
	Statement stm = l.getStatement();
	ResultSet rs = null;//查询结果集合
	
	JLabel select;//检索提示标签
	JPanel mode_panel = new JPanel();//承载各种功能的panel
	
	JPanel condition_panel = new JPanel();//检索需要输入的各种信息
	JButton start_select = new JButton("开始检索");
	JTextField jtf_info_one = new JTextField();//第一个检索信息文本框	一般用这个  单检索使用
	JLabel section = new JLabel("~");//第二个检索信息的时候使用
	JTextField jtf_info_two = new JTextField();//第二个检索信息文本框  这个只有在区间检索的时候会用到
	JLabel jbl_select_info = new JLabel();//检索的时候提示输入到文本框中的信息
	
	
	ButtonGroup bg = new ButtonGroup();
	JRadioButton []jrb = new JRadioButton[12];//最后一个按钮 即下标为11的按钮 为查看全部的图书的信息的按钮
	
	String[]mode = new String[]{"国际标准书号","书名","作者","译者","出版社","分类","库存量","可借天数","价格","页数"};//后四个特殊处理  因为是区间检索
	String[]select_info = new String[]{"国际标准书号","书名","作者姓名","译者姓名","出版社名","分类类名","库存量","可借天数","价格区间","页数区间"};
	String[]select_key = new String[]{"LMS_isbn","LMS_bookname","LMS_anthor","LMS_translator","LMS_publish","LMS_typename","LMS_total","LMS_typedays","LMS_price","LMS_page"};//文本框前面的
	
	String key = "";//记录当前需要查询的属性
	String field_one = "";//记录属性下限
	String field_two = "";//记录属性上限
	float value_one;
	float value_two;
	int value_one_int;
	int value_two_int;
	
	String sql = "";//sql语句

	DefaultTableModel table=new DefaultTableModel(); 
	String[] title = {"ISBN","书名","作者","译者","出版社","出版时间","总页数","库存量","类型名","可借天数","简单介绍"};
	
	JTable jtl_info = new JTable(table);
	JScrollPane jsp_info = new JScrollPane(jtl_info);//带有滚动条地去显示查询结果元组
	
	public select_panel() {

		try {
			
			jrb[11] = new JRadioButton("全部图书");
			jrb[11].setFont(new Font("楷体", 10, 20));
			jrb[11].setBounds(30, 20, 150, 30);
			add(jrb[11]);
			bg.add(jrb[11]);
			//监听事件 全部的信息
			jrb[11].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					//清空图书信息表格
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
		
			jtl_info.setEnabled(false);//让表格中的内容不可被编辑
			jtl_info.setRowHeight(20);//设置表格的行高
			//将属性值添加到列表顶部  用于提示
			for(int i = 0;i<11;i++)
				table.addColumn(title[i]);
			
			background_image = ImageIO.read(new FileInputStream("select_background.png"));
			this.setLayout(null);
			//检索提示标签设置
			select = new JLabel("请选择检索方式");
			select.setFont(new Font("仿宋",10,30));
			select.setBounds(390, 15, 250, 30);
			add(select);
			//承载功能按钮的panel
			mode_panel.setOpaque(false);//设置为透明的
			mode_panel.setLayout(new GridLayout(2,6,0,10));
			mode_panel.setBounds(30, 100, 990, 50);
			//各种检索信息的录入
			condition_panel.setOpaque(false);//设置透明的
			condition_panel.setBounds(30, 180, 990, 50);
			condition_panel.setLayout(null);//清空布局管理
			
			jbl_select_info.setText(select_info[0]);
			jbl_select_info.setFont(new Font("华文隶书", 10, 20));
			
			jbl_select_info.setBounds(150, 10, 140, 20);
			condition_panel.add(jbl_select_info);//检索信息提示的相关设置
			
			jtf_info_one.setBounds(300, 10, 150, 20);
			condition_panel.add(jtf_info_one);//添加单信息检索信息文本域
			
			section.setBounds(460, 10, 10, 20);
			condition_panel.add(section);//~的使用 区间检索的时候使用
			
			jtf_info_two.setBounds(480, 10, 140, 20);
			condition_panel.add(jtf_info_two);//区间检索的时候上限区间使用
			
			jsp_info.setOpaque(false);
			jsp_info.setBounds(30, 240, 935, 400);
			add(jsp_info);
			
			start_select.setBackground(new Color(220, 220, 220));
			start_select.setBounds(630, 10, 100, 20);
			condition_panel.add(start_select);
			
			add(condition_panel);
			//默认情况的处理
			key = select_key[0];//默认的检索方式
			jtf_info_two.setEditable(false);//默认为国际图书编号的检索方式  所以第二个文本框不可编辑
			
			for(int i = 0;i<10;i++){
				jrb[i] = new JRadioButton(mode[i]);
//				jrb[i].setOpaque(false);//加上变透明  但是会有残影
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
				
				jrb[i].setFont(new Font("华文隶书", 10, 20));
				bg.add(jrb[i]);
				
				mode_panel.add(jrb[i]);
			}
			
			//开始检索的监听
			start_select.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					//每次点击开始检索后 清空元组结果表格
					for(int i = table.getRowCount()-1;i>=0;i--)
						table.removeRow(i);
					
					field_one = jtf_info_one.getText();
					field_two = jtf_info_two.getText();
					
					if(field_one.length() == 0){
						new player_audio("alert.wav").playBackgroundSound();//警告声音
						JOptionPane.showMessageDialog(null, "没有给出下限", "警告", JOptionPane.ERROR_MESSAGE); //提示登录出错！
						if(key == "LMS_price" || key == "LMS_page"){
							if(field_two.length() == 0){
								new player_audio("alert.wav").playBackgroundSound();//警告声音
								JOptionPane.showMessageDialog(null, "没有给出上限", "警告", JOptionPane.ERROR_MESSAGE); //提示下限未填写！
							}
						}
						
					}
					
					if(field_one.length() != 0){
						
						if(key == "LMS_price" || key == "LMS_page" || key == "LMS_typedays" || key == "LMS_total"){
							System.out.println("test");
							if(field_two.length() == 0){
								new player_audio("alert.wav").playBackgroundSound();//警告声音
								JOptionPane.showMessageDialog(null, "没有给出上限", "警告", JOptionPane.ERROR_MESSAGE); //提示上限未填写！
							}
							else{
								//区间查询
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
							//单值模糊查询
							field_one = field_one.toLowerCase();//转换为小写 进行检索
							
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
								System.out.println("sql error->单");
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

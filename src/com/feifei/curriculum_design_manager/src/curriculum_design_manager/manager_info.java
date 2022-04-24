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

	BufferedImage background_image = null;//背景图片
	
	Statement stm ;
	ResultSet rs ;
	String sql;
	
	private String id;//管理员账号
	private String psd;//管理员密码
	private String name;//管理员姓名
	
	JTextArea jta_privilege = new JTextArea();//显示管理的所有权限
	JScrollPane jsp_privilege = new JScrollPane(jta_privilege);//显示管理员的全部权限
	JLabel jll_privilege = new JLabel("我的权限");
	FileReader fr;
	
	JLabel title = new JLabel("我的信息");
	JLabel jll_name = new JLabel("姓名");
	JLabel jll_id = new JLabel("账号");
	
	JTextField jtf_name = new JTextField();
	JTextField jtf_id = new JTextField();	
	
	//各种按钮
	JButton mod_sub_btn = new JButton("修改");//修改/提交按钮
	static boolean mod_change = true;//修改 提交功能交换所设置的
	
	
	public manager_info(String id,String psd) {

		this.id = id;
		this.psd = psd;
		
		stm = new LMS_connect().getStatement();//获取数据库链接
		sql = "select * from LMS_manager where LMS_managerid = '"+id+"' and LMS_managerpsd = '"+psd+"' ";
		
		try {
			rs = stm.executeQuery(sql);
			rs.next();//必要语句  现在next 在正常数据的前一个  
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
		
		setLayout(null);//清空布局管理
		//标题的设置
		title.setFont(new Font("微软雅黑",10,30));
		title.setBounds(440, 10, 120, 30);
		add(title);
		
		//管理员信息提示标签
		//姓名提示标签
		jll_name.setFont(new Font("宋体",10,25));
		jll_name.setBounds(120, 120, 50, 20);
		add(jll_name);
		//账号提示标签
		jll_id.setFont(new Font("宋体",10,25));
		jll_id.setBounds(120, 200, 50, 20);
		add(jll_id);
		
		//管理员信息显示文本框
		//姓名文本框
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
		
		//账号文本框
		jtf_id.setEditable(false);
		jtf_id.setBounds(250, 195, 120, 30);
		jtf_id.setText(id);
		add(jtf_id);
		
		//管理员全部权限提示标签
		jll_privilege.setFont(new Font("方正姚体",10,30));
		jll_privilege.setBounds(665, 80, 120, 35);
		add(jll_privilege);
		
		//管理员全部权限提示文本域
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
		jta_privilege.setEditable(false);//管理员权限不可编辑
		jta_privilege.setFont(new Font("方正舒体",10,20));
		jta_privilege.setOpaque(false);
		jsp_privilege.setBounds(500, 150, 450, 450);
		add(jsp_privilege);
		
		//修改、提交按钮设置
		mod_sub_btn.setOpaque(false);//和下面的两句话设置按钮为透明的
		mod_sub_btn.setBackground(new Color(151, 255, 255));
		mod_sub_btn.setBounds(400, 115, 70, 30);
		add(mod_sub_btn);
		mod_sub_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
//				mod_change
				//修改功能
				if(mod_change == true){
					
					mod_change = false;//下一步肯定就是提交
					jtf_name.setEditable(true);//打开姓名文本框的可编辑性
					mod_sub_btn.setText("提交");
				}
				
				//提交功能
				else{
					
					sql = "update LMS_manager set LMS_managername = '"+jtf_name.getText()+"' where LMS_managerid = '"+id+"'";
					try {
						stm.executeUpdate(sql);
					}
					catch (SQLException e1) {
//						e1.printStackTrace();
						System.out.println("sql error");
					}
					JOptionPane.showMessageDialog(null, "修改成功!", "恭喜!", JOptionPane.DEFAULT_OPTION);
					mod_change = true;//下一次肯定就是修改
					jtf_name.setEditable(false);//提交成功关闭姓名文本框可编辑性
					mod_sub_btn.setText("修改");
				}
				
			}
		});
		
	}
	
	public void paintComponent(Graphics g){
		
		g.drawImage(background_image, 0, 370, null);
	}

}

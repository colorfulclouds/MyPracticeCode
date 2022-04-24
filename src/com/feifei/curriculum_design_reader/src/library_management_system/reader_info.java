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

	
	BufferedImage background_image = null;//背景图片
	private String id;
	private String psd;
	private String sql;
	
	private String old_psd;//防止未做任何密码修改
	
	Statement stm;
	ResultSet rs;//结果元组
	
	JLabel jtitle = new JLabel("我的信息");
	

	String []values = new String[]{"LMS_readername","LMS_readertel","LMS_readerregis","LMS_readerbooknumber"};//sql语句中使用  将读者信息放在文本框中显示
	
	Vector <JLabel>jll_info = new Vector();
	JLabel jll_info_name = new JLabel("姓名");
	JLabel jll_info_tel = new JLabel("手机号码");
	JLabel jll_info_regis = new JLabel("注册时间");
	JLabel jll_info_days = new JLabel("借书上限");
	JLabel jll_info_psd = new JLabel("新密码");
	private int jtf_y = 200;
	
	Vector <JTextField>jtf_info = new Vector();
	JTextField jtf_info_name = new JTextField();
	JTextField jtf_info_tel = new JTextField();
	JTextField jtf_info_regis = new JTextField();
	JTextField jtf_info_days = new JTextField();
	JPasswordField jtf_info_psd = new JPasswordField();//密码
	private int jll_y = 200;
	
	JButton mod_btn = new JButton("修改");
	JButton sub_btn = new JButton("提交");
	JButton re_btn = new JButton("取消");
	
	
	/**
	 * 可以不需要密码  因为用户已经确认了  账号不能够重复 和QQ 号一样   所以管理员版本的时候  注册读者的时候 需要注意
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
		}//添加图片
		this.id = id;
		this.psd = psd;
		
		//添加标签信息提示到向量中	并且设置在窗体中的显示位置
		jll_info.add(jll_info_name);
		jll_info.add(jll_info_tel);
		jll_info.add(jll_info_regis);
		jll_info.add(jll_info_days);
		for(int i = 0;i<4;i++){
			jll_info.get(i).setBounds(300, jll_y, 150, 30);
			jll_info.get(i).setFont(new Font("华文新魏", 10, 30));
			add(jll_info.get(i));
			jll_y += 50;
		}
		jll_info_psd.setBounds(300, 400, 150, 30);
		jll_info_psd.setFont(new Font("华文新魏", 10, 30));
		add(jll_info_psd);
		jll_info_psd.setVisible(false);
		
		//添加信息显示文本框到向量		并且设置在窗体中的显示位置
		jtf_info.add(jtf_info_name);
		jtf_info.add(jtf_info_tel);
		jtf_info.add(jtf_info_regis);
		jtf_info.add(jtf_info_days);
		for(int i = 0;i<4;i++){
			jtf_info.get(i).setEditable(false);//设置为信息文本框为不可编辑
			jtf_info.get(i).setBounds(530, jtf_y, 150, 30);
			add(jtf_info.get(i));
			jtf_y += 50;
		}
		
		jtf_info_psd.setBounds(530, 400, 150, 30);
		add(jtf_info_psd);
		jtf_info_psd.setVisible(false);//密码框在修改的时候显现出来
		
		//修改按钮
		mod_btn.setBounds(700, 500, 100, 40);
		mod_btn.setFont(new Font("华文楷体", 10, 20));
		mod_btn.setBackground(new Color(220, 220, 220));
		add(mod_btn);
		mod_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				repaint();
				jtf_info.get(0).setEditable(true);
				jtf_info.get(1).setEditable(true);
				
				jll_info_psd.setVisible(true);//修改的时候显示 提示标签
				jtf_info_psd.setVisible(true);//修改的时候显示 新密码的修改的文本框
				
				
				mod_btn.setVisible(false);//隐藏原来的修改按钮
				//显示用于修改的按钮
				sub_btn.setVisible(true);//显示提交按钮
				re_btn.setVisible(true);//显示取消按钮
				
				
				jll_info_name.setText("新姓名");
				jll_info_tel.setText("新手机号码");
				
			}
		});
		
		//提交按钮
		sub_btn.setBounds(700, 500, 100, 40);
		sub_btn.setFont(new Font("华文楷体", 10, 20));
		sub_btn.setBackground(new Color(220, 220, 220));
		add(sub_btn);
		sub_btn.setVisible(false);
		
		sub_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				old_psd = jtf_info_psd.getText();//防止为做任何密码修改操作
				if(old_psd.length() == 0)
					old_psd = psd;
				
				sql = "update LMS_reader set LMS_readername = '"+jtf_info.get(0).getText()+"',LMS_readertel = '"+jtf_info.get(1).getText()+"',"+
						"LMS_readerpsd = '"+old_psd+"' where LMS_readernum = '"+id+"' ";
				
				try {
					stm.executeUpdate(sql);
					new JOptionPane().showMessageDialog(null, "修改成功!", "恭喜!", JOptionPane.DEFAULT_OPTION);
					
					jtf_info.get(0).setEditable(false);//账号 取消可编辑性
					jtf_info.get(1).setEditable(false);//姓名取消可编辑性
					
					mod_btn.setVisible(true);//修改按钮重现
					re_btn.setVisible(false);//提交后 隐藏取消按钮
					sub_btn.setVisible(false);//提交后 隐藏修改按钮
					jll_info_psd.setVisible(false);//提示密码标签隐藏
					jtf_info_psd.setVisible(false);//密码文本框隐藏
					
					//提示标签归位
					jll_info_name.setText("姓名");
					jll_info_tel.setText("手机号码");
				} 
				catch (SQLException e1) {
//					e1.printStackTrace();
					System.out.println("sql error");
				}
				//开始截获每个文本框中的信息 进行更新 数据库 更新写回
			}
		});
		
		//取消按钮
		re_btn.setBounds(810, 500, 100, 40);
		re_btn.setFont(new Font("华文楷体", 10, 20));
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
				
				jll_info_name.setText("姓名");
				jll_info_tel.setText("手机号码");
			}
		});
		
		jtitle.setFont(new Font("方正姚体",10,30));
		this.setLayout(null);//布局管理置空
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

	//去掉防止出现残影
	//重写方法
//	public void paintComponent(Graphics g){
//		
//		g.drawImage(background_image, 20, 0, null);
//	}
}

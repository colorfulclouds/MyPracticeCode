package library_management_system;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class log_panel extends JPanel{

	
	JTabbedPane tabbedpane = new JTabbedPane();//窗体的最顶端 切换使用的
	//为登录成功做准备
	JFrame jf = null;//主窗体
	select_panel s_p = null;
	
	BufferedImage background_image = null;//读者登录背景图片
	//登录信息文本框
	JTextField LMS_readerid = null;//读者的唯一号
	JLabel lbl_readerid = new JLabel("账号:");
	JPasswordField LMS_readerpsd = null;//读者的密码
	JLabel lbl_readerpsd = new JLabel("密码:");
	
	JButton btn_load = new JButton("登录");
	JButton btn_reload = new JButton("重置");
	JLabel sign = new JLabel("乐阅(读者版)");
	
	private String id;	//读者id
	private String psd;	//读者密码
	
	private String sql = null;//检测是否存在该读者的sql语句
	LMS_connect l = new LMS_connect();
	Statement stm = l.getStatement();
	
	ResultSet rs = null;//select执行后的结果集
	
	
	
	public log_panel(JFrame jf) {
		
		try {
			
			//为登录成功后使用
			this.jf = jf;
			s_p = new select_panel();
			//jf.add(s_p);
			//s_p.setVisible(false);
			
			background_image = ImageIO.read(new FileInputStream("background_image.png"));
			LMS_readerid = new JTextField();
			LMS_readerpsd = new JPasswordField();
			this.setLayout(null);
			//“乐阅(读者版)”位置设置
			sign.setFont(new Font("华文行楷", 10, 50));//设置显示字体
			sign.setBounds(600, -100, 400, 500);
			add(sign);
			//“账号”位置设置
			lbl_readerid.setFont(new Font("华文隶书", 10, 30));
			lbl_readerid.setBounds(600, 250, 100, 100);
			add(lbl_readerid);
			//账号文本框
			LMS_readerid.setBounds(700, 283, 200, 30);
			add(LMS_readerid);
			//“密码”位置设置
			lbl_readerpsd.setFont(new Font("华文隶书", 10, 30));
			lbl_readerpsd.setBounds(600, 270, 100, 200);
			add(lbl_readerpsd);
			//密码文本框
			LMS_readerpsd.setBounds(700, 355, 200, 30);
			add(LMS_readerpsd);
			//“登录”按钮位置设置
			btn_load.setBounds(610, 480, 100, 50);
			btn_load.setBackground(new Color(220, 220, 220));
			add(btn_load);
			btn_load.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					id = LMS_readerid.getText();
					psd = new String(LMS_readerpsd.getPassword());
					
//					System.out.println(id+".test."+psd);//test
					sql = "select * from LMS_reader where LMS_readernum = '"+id+"' and LMS_readerpsd = '"+psd+"' ";
					try {
						rs = stm.executeQuery(sql);
						if(rs.next() == false){
							new player_audio("alert.wav").playBackgroundSound();//警告声音
							JOptionPane.showMessageDialog(null, "请检查账号或密码", "警告", JOptionPane.ERROR_MESSAGE); //提示登录出错！
							LMS_readerid.setText("");
							LMS_readerpsd.setText("");
						}
						
						else{
							//rs.next();
							
							setcansee(false);//调用自己的方法
//							setVisible(false)//不用系统的 使用自己的方法
							jf.repaint();//解决了上一个panel的画面残留
							
							//jf.add(s_p);//登录成功后的新界面
							tabbedpane.addTab("我的信息", new reader_info(id,psd));
							tabbedpane.addTab("我借的书", new my_borrow_book(id,psd));
							tabbedpane.addTab("检索", new select_panel());
							
							jf.add(tabbedpane);
							l.con.close();//到此数据库使用完毕  关闭数据库连接
							
						}
							
					} 
					catch (SQLException e1) {
//						e1.printStackTrace();
						System.out.println("select reader error");
					}
					
				}
			});
			//“重置”按钮设置
			btn_reload.setBounds(800, 480, 100, 50);
			btn_reload.setBackground(new Color(220, 220, 220));
			add(btn_reload);
			btn_reload.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {

					LMS_readerid.setText("");
					LMS_readerpsd.setText("");
				}
			});
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
	
	//panel的可见性变化函数
	public void setcansee(boolean visible){
		setVisible(visible);
	}
	
	//重写paintComponent()方法
	public void paintComponent(Graphics g){
		
		g.drawImage(background_image, 20, 50, null);
		
	}
	
}

package curriculum_design_manager;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class log_manager_panel extends JPanel{

	JTabbedPane tabbedpane = new JTabbedPane();//窗体的最顶端 切换使用的
	JFrame jf;
	BufferedImage background_image = null;
	Statement stm = new LMS_connect().getStatement();//获取数据库连接
	String sql = "";//存储需要执行的sql语句
	String id = "";//管理员账号
	String psd = "";//管理员密码
	ResultSet rs ;
	
	JTextField jtf_m_id = new JTextField();//管理员账号
	JPasswordField jtf_m_psd = new JPasswordField();//管理员密码
	JLabel jll_m_id = new JLabel("账号");
	JLabel jll_m_psd = new JLabel("密码");
	
	JLabel head = new JLabel(new ImageIcon("log_in.png")); 
	JLabel title = new JLabel("乐阅(管理员版)");
	
	JButton log = new JButton("登录");
	JButton relog = new JButton("重置");
	
	public log_manager_panel(JFrame jf) {

		try {
			setLayout(null);//清空布局管理
			background_image = ImageIO.read(new FileInputStream("background.jpg"));
			
			//标题显示位置
			title.setFont(new Font("幼圆", Font.BOLD, 30));
			title.setBounds(400, 50, 250, 30);
			add(title);
			
			//头像显示位置
			head.setBounds(150, 200, 256, 256);
			add(head);
			
			//登录信息的标签
			//账号
			jll_m_id.setFont(new Font("楷体", 10, 30));
			jll_m_id.setBounds(500, 250, 80, 30);
			add(jll_m_id);
			
			//密码
			jll_m_psd.setFont(new Font("楷体", 10, 30));
			jll_m_psd.setBounds(500, 350, 80, 30);
			add(jll_m_psd);
			
			//文本框
			//账号对话框
			jtf_m_id.setBounds(650, 250, 150, 30);
			add(jtf_m_id);
			
			//密码对话框
			jtf_m_psd.setBounds(650, 350, 150, 30);
			add(jtf_m_psd);
			
			//按钮
			//登录按钮
			log.setFont(new Font("华文细黑", 10, 30));
			log.setOpaque(false);//和下面的两句话设置按钮为透明的
			log.setBackground(new Color(151, 255, 255));
			log.setBounds(420, 510, 160, 50);
			add(log);
			
			log.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					id = jtf_m_id.getText();
					psd = new String(jtf_m_psd.getPassword());
					
					sql = "select * from LMS_manager where LMS_managerid = '"+id+"' and LMS_managerpsd = '"+psd+"' ";
					
					if(id.length() == 0 || psd.length() == 0){
						
						JOptionPane.showMessageDialog(null, "完善登录信息", "警告", JOptionPane.ERROR_MESSAGE); 
						jtf_m_id.setText("");
						jtf_m_psd.setText("");
					}
					else{
						
						try {
							rs = stm.executeQuery(sql);
							
							if(rs.next() == false){
								JOptionPane.showMessageDialog(null, "登录信息不存在", "警告", JOptionPane.ERROR_MESSAGE); //提示登录出错！
								jtf_m_id.setText("");
								jtf_m_psd.setText("");
							}
							else{
								
								setVisible(false);
								repaint();
								jf.setTitle(jf.getTitle()+" : "+id);
								tabbedpane.addTab("管理员信息", new manager_info(id,psd));
								tabbedpane.addTab("读者查询", new reader_borrow_return(id,psd));
								tabbedpane.addTab("还书信息", new return_operate(id,psd));
								tabbedpane.addTab("借书信息", new borrow_operate(id,psd));
								tabbedpane.addTab("读者信息", new reader_operate(id,psd));
								tabbedpane.addTab("图书类型", new booktype_operate(id,psd));
								tabbedpane.addTab("图书", new bookinfo_operate(id,psd));
								jf.add(tabbedpane);
								
								/*
								 * 登录成功
								 */
							}
							
						}
						catch (SQLException e1) {
							e1.printStackTrace();
							System.out.println("sql error");
						}
						
					}
					
				}
			});
			
			//重置按钮
			relog.setBounds(470, 600, 60, 20);
			relog.setOpaque(false);//和下面的两句话设置按钮为透明的
			relog.setBackground(new Color(151, 255, 255));
			add(relog);
			relog.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					jtf_m_id.setText("");
					jtf_m_psd.setText("");
				}
			});
			
		} 
		catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("no find file");
		} 
		catch (IOException e) {
//			e.printStackTrace();
			System.out.println("i/o error");
		}
	}
	
	//绘制背景图片
	public void paintComponent(Graphics g){
		
		g.drawImage(background_image, 0, 0, null);
		
	}
}

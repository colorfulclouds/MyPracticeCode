/*
 * 用户给定一个英语文章（ACII文件）的磁盘文件名。
 * 	1）程序自动统计出其中的字母、数字、空格的个数；
 *	2）统计某一字符串在文章中出现的次数；
 *	3）删除某一子串，并将后面的字符前移。
 *	4）【软件功能】中文菜单，人机会话。
 */
package help;

import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class help {

	static String src = null;//英语文章路径
	static FileInputStream fis = null;//读出文件流
	static int i;
	static String english_str = "";
	static char j = 0;
	static int letter_no = 0;
	static int num_letter = 0;
	static int num_number = 0;
	static int num_space = 0;
	static int dheight = 50;
	static String substr = "";
	static String temp = "";
	static String _temp = "";
	static String skill_str = "";
	public static void main(String[] args) {
		
		JFrame jf = new JFrame();
		JTextField jtf = new JTextField(100);//路径
		JTextArea jta = new JTextArea();//文章内容
		JScrollPane jsp = new JScrollPane(jta);
		JButton jb = new JButton("确定");
		JPanel jp = new JPanel();
		JLabel subjl = new JLabel("输入子串:");
		JButton del_btn = new JButton("删除该子串");
		JButton jbsub = new JButton("确定");
		JTextField subjtf = new JTextField();//输入子串
		JTextField subjtf_num = new JTextField();//显示子串个数
		
		subjtf_num.setBounds(480, 260, 100, 20);
		subjtf_num.setEditable(false);
		subjl.setBounds(420, 230, 100, 20);
		subjtf.setBounds(480, 230, 100, 20);
		del_btn.setBounds(480, 300, 100, 20);
		jbsub.setBounds(583, 230, 60, 20);
		
		jf.add(jbsub);
		jf.add(subjtf);jf.add(del_btn);
		jf.add(subjl);
		jf.add(subjtf_num);
		
		del_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				skill_str = english_str.replace(substr, "");
				english_str = skill_str;
				jta.setText("");//先清空文本域之前的内容
				jta.setText(english_str);
			}
		});
		jbsub.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int length1;
				int length2;
				temp = english_str;//可以多次查看子串个数
				substr = subjtf.getText();
				length1 = temp.length();
				_temp = temp.replace(substr, "");//全部把指定的字符串替换为空的  可以计算出出现次数
				length2 = _temp.length();
				subjtf_num.setText("子串出现次数:"+(length1-length2)/substr.length());
			}
		});
		
		JTextField [] _jtf = new JTextField[3];
		for(int i= 0;i<3;i++){
			_jtf[i] = new JTextField();
			_jtf[i].setEditable(false);
			_jtf[i].setBounds(430, dheight, 100, 20);
			dheight += 50;
			jf.add(_jtf[i]);
		}
			
		jsp.setBounds(10, 40, 400, 320);
		jta.setEditable(false);//设置文本域内容不可编辑
		jp.setLayout(null);
		jtf.setBounds(10, 10, 400, 20);
		jb.setBounds(430, 10, 70, 20);
		
		jb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				src = new String(jtf.getText());
				
				try {
					fis = new FileInputStream(new File(src));
				} 
				catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}	
				//	H:\\JAVA语言练习\\help\\help.txt	\\测试路径
				try {
					
					while((i = fis.read()) != -1){
						
						j = (char) i;
						
						if(Character.isLetter(j))
							num_letter ++;
						else
							if(Character.isDigit(j))
								num_number ++;
							else
								if(Character.isSpace(j))
									num_space ++;
						
						letter_no ++;
						if(letter_no % 70 == 0)
							english_str += "\r\n";
						english_str += j;

					}
					jta.setText(english_str);//显示在文本域中
					temp = english_str;//保留一份在找子串个数时使用
					_jtf[0].setText("字母 :" + num_letter);
					_jtf[1].setText("数字 :" + num_number);
					_jtf[2].setText("空格 :" + num_space);
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		jp.add(jsp);
		jp.add(jb);
		jp.add(jtf);
		jf.add(jp);
		
		jf.setSize(650, 400);
		jf.setResizable(false);//不让用户改变界面尺寸
		jf.setLocationRelativeTo(null);//屏幕居中显示
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

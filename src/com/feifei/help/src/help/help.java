/*
 * �û�����һ��Ӣ�����£�ACII�ļ����Ĵ����ļ�����
 * 	1�������Զ�ͳ�Ƴ����е���ĸ�����֡��ո�ĸ�����
 *	2��ͳ��ĳһ�ַ����������г��ֵĴ�����
 *	3��ɾ��ĳһ�Ӵ�������������ַ�ǰ�ơ�
 *	4����������ܡ����Ĳ˵����˻��Ự��
 */
package help;

import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class help {

	static String src = null;//Ӣ������·��
	static FileInputStream fis = null;//�����ļ���
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
		JTextField jtf = new JTextField(100);//·��
		JTextArea jta = new JTextArea();//��������
		JScrollPane jsp = new JScrollPane(jta);
		JButton jb = new JButton("ȷ��");
		JPanel jp = new JPanel();
		JLabel subjl = new JLabel("�����Ӵ�:");
		JButton del_btn = new JButton("ɾ�����Ӵ�");
		JButton jbsub = new JButton("ȷ��");
		JTextField subjtf = new JTextField();//�����Ӵ�
		JTextField subjtf_num = new JTextField();//��ʾ�Ӵ�����
		
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
				jta.setText("");//������ı���֮ǰ������
				jta.setText(english_str);
			}
		});
		jbsub.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int length1;
				int length2;
				temp = english_str;//���Զ�β鿴�Ӵ�����
				substr = subjtf.getText();
				length1 = temp.length();
				_temp = temp.replace(substr, "");//ȫ����ָ�����ַ����滻Ϊ�յ�  ���Լ�������ִ���
				length2 = _temp.length();
				subjtf_num.setText("�Ӵ����ִ���:"+(length1-length2)/substr.length());
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
		jta.setEditable(false);//�����ı������ݲ��ɱ༭
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
				//	H:\\JAVA������ϰ\\help\\help.txt	\\����·��
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
					jta.setText(english_str);//��ʾ���ı�����
					temp = english_str;//����һ�������Ӵ�����ʱʹ��
					_jtf[0].setText("��ĸ :" + num_letter);
					_jtf[1].setText("���� :" + num_number);
					_jtf[2].setText("�ո� :" + num_space);
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
		jf.setResizable(false);//�����û��ı����ߴ�
		jf.setLocationRelativeTo(null);//��Ļ������ʾ
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

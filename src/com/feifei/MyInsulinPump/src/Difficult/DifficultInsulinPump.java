package Difficult;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.*;
import java.util.Random;

import javax.swing.*;

/**
 * ������ 5%
 * �ȵ������� ��  30
 * @author ��ɫ������
 *
 */
class timethread implements Runnable{
	
	private JFrame UIframe;
	private JPanel UIpanel;
	private JPanel _UIpanel;//ʱ��
	private JLabel UIlable;
	private JLabel _UIlable;//�ṩѪ��Ũ�� ��ǩ
	DateFormat format;
	
	public timethread(JFrame UIframe,JPanel UIpanel){
		
		_UIpanel = new JPanel();
		UIlable = new JLabel();
		_UIlable = new JLabel();
		
		this.UIframe = UIframe;
		this.UIpanel = UIpanel;
		
		format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//������ɫ
		_UIpanel.setBackground(Color.pink);
		_UIpanel.setBounds(330, 10, 150, 25);
		_UIpanel.add(UIlable);
		UIpanel.add(_UIpanel);
		UIframe.add(UIpanel);
		
	}
	
	public void run(){
		
		while(true){
			
			UIlable.setText(new String(format.format(new java.util.Date())));
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
				
		}//while
		
	}//run
	
}
class elethread implements Runnable {

	private int eledevice = 100;//��������λ��%��
	private JFrame UIframe;
	private JPanel UIpanel;
	private JPanel _UIpanel;
	private JLabel UIlable;
	
	public elethread(JFrame UIframe,JPanel UIpanel) {
		
		UIlable = new JLabel();//ֻ������ʾ����,���Ծֲ�����
		_UIpanel = new JPanel();//��������
		
		this.UIframe = UIframe;
		this.UIpanel = UIpanel;
		
		UIframe.setTitle("MyInsulinPump");//��������

		//���ñ���ɫΪ��ɫ
		UIpanel.setBackground(Color.pink);
		_UIpanel.setBackground(Color.pink);
		
		_UIpanel.setBounds(40, 10, 150, 30);//�Զ���λ��
		_UIpanel.add(UIlable);
		UIpanel.add(_UIpanel);
		UIframe.add(UIpanel);
		
	}
	//������ʾ�߳�
	public void run() {

		while(true){
			
		UIlable.setText(new String("����:"+eledevice+"%            "));
				//eledevice--;
				eledevice-=1;
				if(eledevice<5){
					_UIpanel.setBackground(Color.red);
					UIlable.setText("��������!���ڹػ�!");
					
					try {
						Thread.sleep(4000);
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.exit(0);
					
				}
				try {
					Thread.sleep(5000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
		
		}//while

	}//run
	
}

class workthread implements Runnable{
	
	private double InsulinContent;//�ȵ��ر�����
	private double xtc;//Ѫ��Ũ��
	private JFrame UIframe;  
	private JPanel UIpanel;
	
	private JButton eat_button;//�Է���ť
	private JButton sport_button;//�˶���ť

	private JPanel content_jpanel;//���ø�������������5 
	
	private JLabel insulin_content_jlabel;//���ȵ��������ı��ı�ǩ
	private JLabel fbg_content_jlabel;//����Ѫ�ǵ��ı���ǩ
	
	private String mode;//Ѫ�ǵ������ı�
	DecimalFormat df ;//���ָ�ʽ
	
	FileOutputStream fos ;//������־(д��)
	FileReader fr;//������־(����)
	DateFormat format;
	
	
	public workthread(JFrame UIframe,JPanel UIpanel) {//���췽��
				
		try {
			fos = new FileOutputStream("log.txt");		//������־
			format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} 
		catch (FileNotFoundException e1) {
			//e1.printStackTrace();
			System.out.println("��־�ļ����쳣!");
		}
		
		xtc = new Random().nextInt(150)+50;
		df = new DecimalFormat("0.0");
		InsulinContent = 300;
		
		eat_button = new JButton("�Է�");
		sport_button = new JButton("�˶�");
		
		mode =  new String();
		
		this.UIframe = UIframe;
		this.UIpanel = UIpanel;
		
		content_jpanel = new JPanel();
		insulin_content_jlabel = new JLabel();
		fbg_content_jlabel = new JLabel();
		
		content_jpanel.setLayout(null);//���Ĭ�ϲ���
		content_jpanel.setLayout(new FlowLayout(FlowLayout.LEFT,90,20));	
		
		eat_button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {			
				
				xtc = 180;
	
			}
		}
		);
		
		sport_button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				xtc = 50;
			}
		});
		
		//�Է���ť
		eat_button.setFocusPainted(false);//�ÿ��İ�ť(û�б߿�)
		eat_button.setBackground(Color.pink);
		eat_button.setBounds(50, 280,80,30);
		//�˶���ť
		sport_button.setFocusPainted(false);//�ÿ��İ�ť(û�б߿�)
		sport_button.setBackground(Color.pink);
		sport_button.setBounds(300, 280, 80, 30);
		
		UIpanel.add(sport_button);
		UIpanel.add(eat_button);
		UIframe.add(UIpanel);
		
		content_jpanel.setBounds(80, 120, 400, 100);
		content_jpanel.setBackground(Color.pink);
			
	}
	
	public void run(){				//��ʼ��������Ҫ����
		
		insulin_content_jlabel.setText(new String("��������"));
		content_jpanel.add(insulin_content_jlabel);
		UIpanel.add(content_jpanel);
		UIframe.add(UIpanel);
		
		while(true){
			xtc = new Random().nextInt(150)+50;
			//insulin_content_jlabel.setText(new String("Ѫ��Ũ��:"+xtc+"mg/dl")); 
				
			float inject = 0.0f;//ע����ȵ��غ���
			
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		
			if(xtc<60){

				mode = "(Ѫ��ƫ��.����ע��)"+"Ѫ��Ũ��:"+xtc+"mg/dl";
				
			}
			else
				if(xtc>150){
					
					mode = "(Ѫ��ƫ��!����ע��)"+"Ѫ��Ũ��:"+xtc+"mg/dl";
					inject = 0.6f;
					//InsulinContent-=0.6;		//��inject�滻
				}
					else{
						mode = "(����.΢��ע��)"+"Ѫ��Ũ��:"+xtc+"mg/dl";
						inject = 0.3f;
						//InsulinContent-=0.3;	//��inject�滻
					}
					
			InsulinContent-=inject;
			
			if(InsulinContent <30){
				
				insulin_content_jlabel.setBackground(Color.red);
				insulin_content_jlabel.setText("�ȵ���ʣ��������!�뼰ʱ���   			!");
				
				
				fbg_content_jlabel.setText("���ڹػ�!����������־�ļ�!");
				
				
				
				try {
					fr = new FileReader("log.txt");
					int i = 0;
					System.out.println("ʱ��          Ѫ��Ũ��            ע����ȵ��غ���");
					while((i = fr.read())!=-1)
						System.out.print((char) i);
					Thread.sleep(3000);
					System.exit(0);
				} 
				catch (InterruptedException | IOException e) {
					e.printStackTrace();
				}
			}
			
			else{
				
			insulin_content_jlabel.setText(mode);
			fbg_content_jlabel.setText("�ȵ���ʣ����:"+df.format(InsulinContent)+"��λ");
			
			}
			
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = new String(format.format(new java.util.Date())+" 	"+xtc+" 	"+inject);//ʱ��  Ѫ��Ũ��  ע����ȵ��غ��� 
			int length = str.length();
			try {
				fos.write(str.getBytes(), 0, length);
				fos.write("\r\n".getBytes());
				fos.flush();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
			content_jpanel.add(insulin_content_jlabel,FlowLayout.LEFT);
			content_jpanel.add(fbg_content_jlabel);
			
			UIpanel.add(content_jpanel);
			UIframe.add(UIpanel);
			
		}//while
		
	}//run
	
}

public class DifficultInsulinPump {

	public static void main(String[] args) throws Exception {
		
		JFrame UIframe = new JFrame(); //��������
		JPanel UIpanel = new JPanel(); //��������
		
		UIpanel.setLayout(null);//���Ĭ�ϵĲ��ָ�ʽ
		
		ImageIcon icon=new ImageIcon("H:\\JAVA������ϰ\\MyInsulinPump\\1.jpg");//ͼ����Ϣ
		
		UIframe.setSize(500, 400);//���ڴ�С
		UIframe.setLocationRelativeTo(null);//��Ļ������ʾ
		UIframe.setResizable(false);//�����û��ı����ߴ�
		UIframe.setIconImage(icon.getImage());//����ͼ��
		
		//�رմ���
		UIframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				
				try {
					FileReader fr = new FileReader("log.txt");
					int i;
					System.out.println("ʱ��          Ѫ��Ũ��            ע����ȵ��غ���");
					while((i = fr.read())!=-1)
						System.out.print((char) i);
				} 
				catch ( IOException e1) {
					
					e1.printStackTrace();
				}
				
				System.exit(0);	
			}
		});
		
		//�����߳�
		elethread _elethread = new elethread(UIframe,UIpanel);
		Thread __elethread = new Thread(_elethread);
		__elethread.start();
		
		//ʱ���߳�
		timethread _timethread = new timethread(UIframe,UIpanel);
		Thread __timethread = new Thread(_timethread);
		__timethread.start();
	
		//�����߳�
		workthread _workthread = new workthread(UIframe, UIpanel);
		Thread __workthread = new Thread(_workthread);
		__workthread.start();
		
		UIframe.show();
	}

}

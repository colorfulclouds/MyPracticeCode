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
 * 电量《 5%
 * 胰岛素余量 《  30
 * @author 蓝色的心情
 *
 */
class timethread implements Runnable{
	
	private JFrame UIframe;
	private JPanel UIpanel;
	private JPanel _UIpanel;//时间
	private JLabel UIlable;
	private JLabel _UIlable;//提供血糖浓度 标签
	DateFormat format;
	
	public timethread(JFrame UIframe,JPanel UIpanel){
		
		_UIpanel = new JPanel();
		UIlable = new JLabel();
		_UIlable = new JLabel();
		
		this.UIframe = UIframe;
		this.UIpanel = UIpanel;
		
		format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//设置颜色
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

	private int eledevice = 100;//电量（单位：%）
	private JFrame UIframe;
	private JPanel UIpanel;
	private JPanel _UIpanel;
	private JLabel UIlable;
	
	public elethread(JFrame UIframe,JPanel UIpanel) {
		
		UIlable = new JLabel();//只用来显示电量,所以局部变量
		_UIpanel = new JPanel();//放置上面
		
		this.UIframe = UIframe;
		this.UIpanel = UIpanel;
		
		UIframe.setTitle("MyInsulinPump");//窗口名称

		//设置背景色为粉色
		UIpanel.setBackground(Color.pink);
		_UIpanel.setBackground(Color.pink);
		
		_UIpanel.setBounds(40, 10, 150, 30);//自定义位置
		_UIpanel.add(UIlable);
		UIpanel.add(_UIpanel);
		UIframe.add(UIpanel);
		
	}
	//电量显示线程
	public void run() {

		while(true){
			
		UIlable.setText(new String("电量:"+eledevice+"%            "));
				//eledevice--;
				eledevice-=1;
				if(eledevice<5){
					_UIpanel.setBackground(Color.red);
					UIlable.setText("电量过低!正在关机!");
					
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
	
	private double InsulinContent;//胰岛素泵容量
	private double xtc;//血糖浓度
	private JFrame UIframe;  
	private JPanel UIpanel;
	
	private JButton eat_button;//吃饭按钮
	private JButton sport_button;//运动按钮

	private JPanel content_jpanel;//放置各种容量的容器5 
	
	private JLabel insulin_content_jlabel;//放胰岛素容量文本的标签
	private JLabel fbg_content_jlabel;//放置血糖的文本标签
	
	private String mode;//血糖的属性文本
	DecimalFormat df ;//数字格式
	
	FileOutputStream fos ;//工作日志(写入)
	FileReader fr;//工作日志(读出)
	DateFormat format;
	
	
	public workthread(JFrame UIframe,JPanel UIpanel) {//构造方法
				
		try {
			fos = new FileOutputStream("log.txt");		//工作日志
			format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} 
		catch (FileNotFoundException e1) {
			//e1.printStackTrace();
			System.out.println("日志文件打开异常!");
		}
		
		xtc = new Random().nextInt(150)+50;
		df = new DecimalFormat("0.0");
		InsulinContent = 300;
		
		eat_button = new JButton("吃饭");
		sport_button = new JButton("运动");
		
		mode =  new String();
		
		this.UIframe = UIframe;
		this.UIpanel = UIpanel;
		
		content_jpanel = new JPanel();
		insulin_content_jlabel = new JLabel();
		fbg_content_jlabel = new JLabel();
		
		content_jpanel.setLayout(null);//清空默认布局
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
		
		//吃饭按钮
		eat_button.setFocusPainted(false);//好看的按钮(没有边框)
		eat_button.setBackground(Color.pink);
		eat_button.setBounds(50, 280,80,30);
		//运动按钮
		sport_button.setFocusPainted(false);//好看的按钮(没有边框)
		sport_button.setBackground(Color.pink);
		sport_button.setBounds(300, 280, 80, 30);
		
		UIpanel.add(sport_button);
		UIpanel.add(eat_button);
		UIframe.add(UIpanel);
		
		content_jpanel.setBounds(80, 120, 400, 100);
		content_jpanel.setBackground(Color.pink);
			
	}
	
	public void run(){				//开始工作的主要方法
		
		insulin_content_jlabel.setText(new String("开机……"));
		content_jpanel.add(insulin_content_jlabel);
		UIpanel.add(content_jpanel);
		UIframe.add(UIpanel);
		
		while(true){
			xtc = new Random().nextInt(150)+50;
			//insulin_content_jlabel.setText(new String("血糖浓度:"+xtc+"mg/dl")); 
				
			float inject = 0.0f;//注射的胰岛素含量
			
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		
			if(xtc<60){

				mode = "(血糖偏低.无需注射)"+"血糖浓度:"+xtc+"mg/dl";
				
			}
			else
				if(xtc>150){
					
					mode = "(血糖偏高!极速注射)"+"血糖浓度:"+xtc+"mg/dl";
					inject = 0.6f;
					//InsulinContent-=0.6;		//用inject替换
				}
					else{
						mode = "(正常.微量注射)"+"血糖浓度:"+xtc+"mg/dl";
						inject = 0.3f;
						//InsulinContent-=0.3;	//用inject替换
					}
					
			InsulinContent-=inject;
			
			if(InsulinContent <30){
				
				insulin_content_jlabel.setBackground(Color.red);
				insulin_content_jlabel.setText("胰岛素剩余量不足!请及时添加   			!");
				
				
				fbg_content_jlabel.setText("正在关机!并且生成日志文件!");
				
				
				
				try {
					fr = new FileReader("log.txt");
					int i = 0;
					System.out.println("时间          血糖浓度            注射的胰岛素含量");
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
			fbg_content_jlabel.setText("胰岛素剩余量:"+df.format(InsulinContent)+"单位");
			
			}
			
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = new String(format.format(new java.util.Date())+" 	"+xtc+" 	"+inject);//时间  血糖浓度  注射的胰岛素含量 
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
		
		JFrame UIframe = new JFrame(); //基本容器
		JPanel UIpanel = new JPanel(); //基本轻型
		
		UIpanel.setLayout(null);//清空默认的布局格式
		
		ImageIcon icon=new ImageIcon("H:\\JAVA语言练习\\MyInsulinPump\\1.jpg");//图标信息
		
		UIframe.setSize(500, 400);//窗口大小
		UIframe.setLocationRelativeTo(null);//屏幕居中显示
		UIframe.setResizable(false);//不让用户改变界面尺寸
		UIframe.setIconImage(icon.getImage());//窗口图标
		
		//关闭窗口
		UIframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				
				try {
					FileReader fr = new FileReader("log.txt");
					int i;
					System.out.println("时间          血糖浓度            注射的胰岛素含量");
					while((i = fr.read())!=-1)
						System.out.print((char) i);
				} 
				catch ( IOException e1) {
					
					e1.printStackTrace();
				}
				
				System.exit(0);	
			}
		});
		
		//电量线程
		elethread _elethread = new elethread(UIframe,UIpanel);
		Thread __elethread = new Thread(_elethread);
		__elethread.start();
		
		//时间线程
		timethread _timethread = new timethread(UIframe,UIpanel);
		Thread __timethread = new Thread(_timethread);
		__timethread.start();
	
		//工作线程
		workthread _workthread = new workthread(UIframe, UIpanel);
		Thread __workthread = new Thread(_workthread);
		__workthread.start();
		
		UIframe.show();
	}

}

package MyMicrowave;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class time_progressbar extends Thread{
	
	JProgressBar mw_progressbar;//进度条
	int time;
	int second = 0;
	JTextArea mw_info;
	
	//只为模拟加工完成 自动关机
	JButton start_button;
	boolean thread_start;
	boolean easy_start;
	int []mode_num;
	JTextField time_field;
	int temperature;
	JTextField fire_field;
	//只为模拟自动关机
	
	void modify(boolean thread_start){
		this.thread_start = thread_start;
	}
	
	public time_progressbar(JProgressBar mw_progressbar,int time,JTextArea mw_info, JButton start_button, boolean easy_start, int []mode_num, JTextField time_field, int temperature, JTextField fire_field) {

		this.mw_progressbar = mw_progressbar;
		this.time = time;
		this.mw_info = mw_info;
		
		this.start_button = start_button;
		this.easy_start = easy_start;
		this.mode_num = mode_num;
		this.time_field = time_field;
		this.temperature = temperature;
		this.fire_field = fire_field;
		
	}
	//加工完成   自动关机
	public void turn_off(){
		
		start_button.setText("取出来!");
		easy_start = true;////交替开机/关机按钮
		for(int i = 0;i<3;i++)
			mode_num[i] = 0;
		time = 10;
		time_field.setText(new String().valueOf(time));
		temperature = 100;
		fire_field.setText(new String().valueOf(temperature));
		
	}
	
	public void run(){
			//	System.out.println("测试 _关键指示: "+stop_start);
		while(thread_start){
			//System.out.println("测试 _关键指示: "+stop_start);
		mw_progressbar.setStringPainted(true);
		mw_progressbar.setString("剩余时间: "+time+" min "+second+" s");
		mw_progressbar.setIndeterminate(true);//进度条左右移动
		
		if(time == 0 && second == 0){
			
			mw_progressbar.setIndeterminate(false);
			mw_progressbar.setString("加工完成!");
			mw_info.setText("");
			mw_info.append("\n\n加工完成!快拿出去吃!");
			turn_off();
			break;

		}
		if(second == 0){
			
			time--;
			second = 60;
			
		}
			
		second--;
		
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}//while
		
		System.out.println("线程已经结束");
	}//run
	
}

class work{
	
	JButton [] mw_button = new JButton[8];//功能按钮集
	JButton [] num_button = new JButton[10];//数字按钮集
	String [] mode_string = {"热牛奶","烤肉串","蒸米饭","烤面包","烤红薯","烤鱼","爆米花","烤排骨"};
	String [] num_string = {"1","2","3","4","5","6","7","8","9","0"};
	JFrame mw_windows;
	JPanel mw_panel;
	JPanel button_panel;//放置按钮的容器
	JPanel pic_panel;//设置图片的容器
	JLabel pic_label;//图片标签
	JButton start_button;
	//处理时间 和火力大小
	JPanel field;
	JTextField time_field;
	JLabel time_label;
	JTextField fire_field;
	JLabel fire_label;

	JPanel zero_delete;//盛放0和删除的容器
	JButton delete;//删除按钮
	
	JTextArea mw_info;//状态信息
	
	int temperature = 100;//温度100°C
	int time = 10;//时间10min
	
	int[]  mode_num = {0,0,0};//选择的功能 不到达指定的数量 无法开始工作    1为工作先决条件   选择物品 模拟放入的食物
	
	boolean easy_start = true;//开始/停止
	boolean easy_field =false;//时间 温度文本框
	
	JPanel num_panel;//放置数字按钮的容器
	
	JProgressBar mw_progressbar;//进度条
	
	int j = 0;
	int _j = 0;
	
	String temp_mode = new String("现实中的微波炉不放东西也可以工作");//用来记录选取的食物 在状态信息面板中显示出啦
	
	time_progressbar [] work_thread = new time_progressbar[2];
	int flag = 1;//给线程数量使用的(flag+1)%2在0 1间跳动 记录线程
	
	public work(JFrame mw_windows,JPanel mw_panel) {
		
		//状态信息面板 模拟显示屏
		mw_info = new JTextArea();
		mw_info.setBackground(Color.pink);
		mw_info.setBounds(740, 70, 200, 100);
		mw_info.setEditable(false);
		mw_info.append("欢迎使用!");
		mw_panel.add(mw_info);
		
		this.mw_windows = mw_windows;
		this.mw_panel = mw_panel;
				
		time_label = new JLabel("时间(min):");
		fire_label = new JLabel("温度(℃):");
		time_field = new JTextField();//时间文本框
		time_field.setFocusable(true);  
		time_field.requestFocus(); 
		time_field.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {			
			}		
			public void mouseExited(MouseEvent e) {				
			}
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {

				time_field.setFocusable(true);  
				time_field.requestFocus();  
				easy_field = true;
			}
		});
		
		fire_field = new JTextField();//温度文本框
		fire_field.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {			
			}		
			public void mouseExited(MouseEvent e) {				
			}
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {

				fire_field.setFocusable(true);  
				fire_field.requestFocus();  
				easy_field = false;
			}
		});
				
		//添加时间、温度
		field = new JPanel(new GridLayout(2,2,15,5));
		
		field.setBackground(new Color(100, 180, 180));
		field.add(time_label);
		field.add(time_field);
		field.add(fire_label);
		field.add(fire_field);
		field.setBounds(560, 100, 145, 50);
		mw_panel.add(field);
		
		mw_progressbar = new JProgressBar(1,100);
		mw_progressbar.setBackground(Color.YELLOW);
		mw_progressbar.setBounds(560, 10, 400, 30);
		
		mw_panel.add(mw_progressbar);
		
		start_button = new JButton("开机");
		start_button.setFocusPainted(false);//好看的按钮(没有边框)
		start_button.setBackground(Color.GRAY);//按钮颜色
		start_button.setBounds(880, 210, 80, 75);
		//开始按钮的相关时间监听
		start_button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
	
				work_thread[(flag+1)%2] = new time_progressbar(mw_progressbar, time,mw_info,start_button,easy_start,mode_num,time_field,temperature,fire_field);
				
				if(easy_start){
					//好多事件  启动后 好多的功能
					
					easy_start = false;//交替开机/关机按钮
					
					for(int i = 0;i<3;i++)
						mode_num[i] = 1;
					System.out.println(mode_num[0]+""+mode_num[1]+""+mode_num[2]);
					if(mode_num[0] == 1 && mode_num[1] == 1 && mode_num[2] == 1 ){
						
						mw_info.setText("");//清空文本域
						mw_info.append(new String("\n"+"总时长: "+time+" min"+"\n"));
						mw_info.append(new String("温度: "+temperature+" ℃"+"\n"));
						mw_info.append("食物: "+temp_mode);
					
						start_button.setText("关机");
						start(work_thread[(flag+1)%2]);
						
					}
					
				}
				
				else{
					//好多时间 停止所有已经启动的事件
					pic_label.setIcon(new ImageIcon("..\\MyMicrowave\\2.png"));					
					easy_start = true;//交替开机/关机按钮
					temp_mode = new String("现实中的微波炉不放东西也可以工作");
					start_button.setText("开机");
					stop(work_thread[(flag)%2]);
				}
				
				flag ++;	
			}
			
		});
			
		mw_panel.add(start_button);
		pic_panel = new JPanel();
		pic_label = new JLabel(new ImageIcon("..\\MyMicrowave\\2.png"));//初始化图片
		
		num_panel = new JPanel();
		num_panel.setLayout(new GridLayout(3, 3, 10, 10));
		num_panel.setBackground(new Color(100, 180, 180));
		
		//缺省温度和时间,显示在文本框中
		time_field.setText(new String().valueOf(time));
		fire_field.setText(new String().valueOf(temperature));
		
		//数字键盘的构建
		for(int i = 0;i<9;i++){
			_j = i;
			num_button[i] = new JButton(num_string[i]);
			num_button[i].setFocusPainted(false);//好看的按钮(没有边框)
			num_button[i].setBackground(Color.GRAY);//按钮颜色
			num_panel.add(num_button[i]);
			
			num_button[i].addActionListener(new ActionListener() {
				
				int k = _j;//防止不同步
				
				public void actionPerformed(ActionEvent e) {
					if(mode_num[0]==0)//不满足三个条件 不能开始      为0说明没有在工作     可以赋予工作
						if(easy_field){

							time = Integer.parseInt(num_string[k])+time*10;
							System.out.println("时间文本框:"+time);//测试
							time_field.setText(new String().valueOf(time));
						//	mode_num[0] = 1;
							//mw_progressbar.setString(new String().valueOf(time));
						}
					if(mode_num[1]==0)//不满足三个条件 不能开始     	为0说明没有在工作     可以赋予工作
						if(!easy_field){
						
							temperature =Integer.parseInt(num_string[k])+temperature*10;
							System.out.println("温度文本框:"+temperature);//测试
							fire_field.setText(new String().valueOf(temperature));
						//	mode_num[1] = 1;
							
						}
	
				}
			});
			
		}
		//放置数字按钮的容器
				zero_delete = new JPanel(new GridLayout(2,1,0,10));
				zero_delete.setBounds(820, 210, 50, 150);
				zero_delete.setBackground(new Color(100, 180, 180));
				
		//数字0和删除统一处理	
		num_button[9] = new JButton(num_string[9]);
		//添加烦人0的事件处理
		num_button[9].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				if(mode_num[0]==0)
				if(easy_field){
					
					time = Integer.parseInt(num_string[9])+time*10;
					System.out.println("时间文本框:"+time);//测试
					time_field.setText(new String().valueOf(time));
				}
				if(mode_num[1]==0)
				if(!easy_field){
					
					temperature =Integer.parseInt(num_string[9])+temperature*10;
					System.out.println("温度文本框:"+temperature);//测试
					fire_field.setText(new String().valueOf(temperature));
					
				}
			}
		});
		//数字删除按钮
		delete = new JButton("←");
		delete.setBackground(Color.gray);
		delete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				if(mode_num[0]==0)//工作过程中   不能修改时间
				if(easy_field){
					
					time = time/10;
					System.out.println("时间文本框:"+time);//测试
					time_field.setText(new String().valueOf(time));
				}
				if(mode_num[1]==0)//工作过程中    不能修改温度
				if(!easy_field){
				
					temperature =temperature/10;
					System.out.println("温度文本框:"+temperature);//测试
					fire_field.setText(new String().valueOf(temperature));
					
				}
				
			}
		});
		
		num_button[9].setFocusPainted(false);//好看的按钮(没有边框)
		num_button[9].setBackground(Color.GRAY);//按钮颜色
		zero_delete.add(num_button[9]);
		zero_delete.add(delete);
		
		mw_panel.add(zero_delete);
		
		//功能图片按钮
		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(2, 4, 10, 10));
		button_panel.setBackground(new Color(100, 180, 180));

		for( int i = 0;i<8;i++){
			j = i;//传递  无法在监听器中使用i变量   
			mw_button[i] = new JButton(mode_string[i]);
			mw_button[i].setFocusPainted(false);//好看的按钮(没有边框)
			mw_button[i].setBackground(Color.GRAY);//按钮颜色
			
			mw_button[i].addActionListener(new ActionListener() {
			
			int k = j;//直接使用j 会发生不同步现象
			public void actionPerformed(ActionEvent arg0) {
				if(mode_num[2]==0){
					
					pic_label.setIcon(new ImageIcon(new String("..\\MyMicrowave\\图片\\"+k+".jpg")));
					//mode_num[2] = 1;
					temp_mode = mode_string[k];
				}
				
			}
			});
			
			button_panel.add(mw_button[i]);
			
		}
		
		//图片区
		pic_panel.setBackground(new Color(100, 180, 180));//保险小缝隙的颜色残留,全部和主界面颜色统一
		pic_panel.add(pic_label);
		pic_panel.setBounds(25, 20, 510, 530);
		mw_panel.add(pic_panel);
		
		//键盘区
		num_panel.setBounds(560, 210, 250, 150);
		mw_panel.add(num_panel);
		//功能区
		
		button_panel.setBounds(560, 380, 400, 150);
		mw_panel.add(button_panel);
		mw_windows.add(mw_panel);
		
	}//构造方法到此结束
	
	//正式开始工作了
	public void start(time_progressbar work_thread){

		work_thread.modify(true);
		work_thread.start();//多线程实现倒计时
		
	}
	
	//停止工作
	public void stop(time_progressbar work_thread){
	
		for(int i = 0;i<3;i++)
			mode_num[i] = 0;
		time = 10;
		time_field.setText(new String().valueOf(time));
		temperature = 100;
		fire_field.setText(new String().valueOf(temperature));
		//temp_mode = new String("现实中的微波炉不放东西也可以工作");
		mw_progressbar.setStringPainted(false);
		mw_progressbar.setIndeterminate(false);
		work_thread.modify(false);

	}
	
}

public class My {
	
	public static void main(String [] args){
		
		//long number = 0345;
		//long number = 0345L;
		long number = 345L;
		
		JFrame mw_windows = new JFrame("MyMicrowave");
		JPanel mw_panel = new JPanel();
		mw_panel.setLayout(null);
		mw_panel.setBackground(new Color(100, 180, 180));//淡蓝色
				
		ImageIcon mw_icon = new ImageIcon("..\\MyMicrowave\\1.png");
		mw_windows.setIconImage(mw_icon.getImage());//窗口图标
		mw_windows.setSize(1000,600);//尺寸
		mw_windows.setLocationRelativeTo(null);//屏幕居中显示
		mw_windows.setResizable(false);//不让用户改变界面尺寸
		
		mw_windows.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e){
				System.exit(0);	
			}
			
		}) ;
		
		work sc = new work(mw_windows, mw_panel);
		mw_windows.show();
		
	}

}

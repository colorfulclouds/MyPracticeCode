package MyMicrowave;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class time_progressbar extends Thread{
	
	JProgressBar mw_progressbar;//������
	int time;
	int second = 0;
	JTextArea mw_info;
	
	//ֻΪģ��ӹ���� �Զ��ػ�
	JButton start_button;
	boolean thread_start;
	boolean easy_start;
	int []mode_num;
	JTextField time_field;
	int temperature;
	JTextField fire_field;
	//ֻΪģ���Զ��ػ�
	
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
	//�ӹ����   �Զ��ػ�
	public void turn_off(){
		
		start_button.setText("ȡ����!");
		easy_start = true;////���濪��/�ػ���ť
		for(int i = 0;i<3;i++)
			mode_num[i] = 0;
		time = 10;
		time_field.setText(new String().valueOf(time));
		temperature = 100;
		fire_field.setText(new String().valueOf(temperature));
		
	}
	
	public void run(){
			//	System.out.println("���� _�ؼ�ָʾ: "+stop_start);
		while(thread_start){
			//System.out.println("���� _�ؼ�ָʾ: "+stop_start);
		mw_progressbar.setStringPainted(true);
		mw_progressbar.setString("ʣ��ʱ��: "+time+" min "+second+" s");
		mw_progressbar.setIndeterminate(true);//�����������ƶ�
		
		if(time == 0 && second == 0){
			
			mw_progressbar.setIndeterminate(false);
			mw_progressbar.setString("�ӹ����!");
			mw_info.setText("");
			mw_info.append("\n\n�ӹ����!���ó�ȥ��!");
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
		
		System.out.println("�߳��Ѿ�����");
	}//run
	
}

class work{
	
	JButton [] mw_button = new JButton[8];//���ܰ�ť��
	JButton [] num_button = new JButton[10];//���ְ�ť��
	String [] mode_string = {"��ţ��","���⴮","���׷�","�����","������","����","���׻�","���Ź�"};
	String [] num_string = {"1","2","3","4","5","6","7","8","9","0"};
	JFrame mw_windows;
	JPanel mw_panel;
	JPanel button_panel;//���ð�ť������
	JPanel pic_panel;//����ͼƬ������
	JLabel pic_label;//ͼƬ��ǩ
	JButton start_button;
	//����ʱ�� �ͻ�����С
	JPanel field;
	JTextField time_field;
	JLabel time_label;
	JTextField fire_field;
	JLabel fire_label;

	JPanel zero_delete;//ʢ��0��ɾ��������
	JButton delete;//ɾ����ť
	
	JTextArea mw_info;//״̬��Ϣ
	
	int temperature = 100;//�¶�100��C
	int time = 10;//ʱ��10min
	
	int[]  mode_num = {0,0,0};//ѡ��Ĺ��� ������ָ�������� �޷���ʼ����    1Ϊ�����Ⱦ�����   ѡ����Ʒ ģ������ʳ��
	
	boolean easy_start = true;//��ʼ/ֹͣ
	boolean easy_field =false;//ʱ�� �¶��ı���
	
	JPanel num_panel;//�������ְ�ť������
	
	JProgressBar mw_progressbar;//������
	
	int j = 0;
	int _j = 0;
	
	String temp_mode = new String("��ʵ�е�΢��¯���Ŷ���Ҳ���Թ���");//������¼ѡȡ��ʳ�� ��״̬��Ϣ�������ʾ����
	
	time_progressbar [] work_thread = new time_progressbar[2];
	int flag = 1;//���߳�����ʹ�õ�(flag+1)%2��0 1������ ��¼�߳�
	
	public work(JFrame mw_windows,JPanel mw_panel) {
		
		//״̬��Ϣ��� ģ����ʾ��
		mw_info = new JTextArea();
		mw_info.setBackground(Color.pink);
		mw_info.setBounds(740, 70, 200, 100);
		mw_info.setEditable(false);
		mw_info.append("��ӭʹ��!");
		mw_panel.add(mw_info);
		
		this.mw_windows = mw_windows;
		this.mw_panel = mw_panel;
				
		time_label = new JLabel("ʱ��(min):");
		fire_label = new JLabel("�¶�(��):");
		time_field = new JTextField();//ʱ���ı���
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
		
		fire_field = new JTextField();//�¶��ı���
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
				
		//���ʱ�䡢�¶�
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
		
		start_button = new JButton("����");
		start_button.setFocusPainted(false);//�ÿ��İ�ť(û�б߿�)
		start_button.setBackground(Color.GRAY);//��ť��ɫ
		start_button.setBounds(880, 210, 80, 75);
		//��ʼ��ť�����ʱ�����
		start_button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
	
				work_thread[(flag+1)%2] = new time_progressbar(mw_progressbar, time,mw_info,start_button,easy_start,mode_num,time_field,temperature,fire_field);
				
				if(easy_start){
					//�ö��¼�  ������ �ö�Ĺ���
					
					easy_start = false;//���濪��/�ػ���ť
					
					for(int i = 0;i<3;i++)
						mode_num[i] = 1;
					System.out.println(mode_num[0]+""+mode_num[1]+""+mode_num[2]);
					if(mode_num[0] == 1 && mode_num[1] == 1 && mode_num[2] == 1 ){
						
						mw_info.setText("");//����ı���
						mw_info.append(new String("\n"+"��ʱ��: "+time+" min"+"\n"));
						mw_info.append(new String("�¶�: "+temperature+" ��"+"\n"));
						mw_info.append("ʳ��: "+temp_mode);
					
						start_button.setText("�ػ�");
						start(work_thread[(flag+1)%2]);
						
					}
					
				}
				
				else{
					//�ö�ʱ�� ֹͣ�����Ѿ��������¼�
					pic_label.setIcon(new ImageIcon("..\\MyMicrowave\\2.png"));					
					easy_start = true;//���濪��/�ػ���ť
					temp_mode = new String("��ʵ�е�΢��¯���Ŷ���Ҳ���Թ���");
					start_button.setText("����");
					stop(work_thread[(flag)%2]);
				}
				
				flag ++;	
			}
			
		});
			
		mw_panel.add(start_button);
		pic_panel = new JPanel();
		pic_label = new JLabel(new ImageIcon("..\\MyMicrowave\\2.png"));//��ʼ��ͼƬ
		
		num_panel = new JPanel();
		num_panel.setLayout(new GridLayout(3, 3, 10, 10));
		num_panel.setBackground(new Color(100, 180, 180));
		
		//ȱʡ�¶Ⱥ�ʱ��,��ʾ���ı�����
		time_field.setText(new String().valueOf(time));
		fire_field.setText(new String().valueOf(temperature));
		
		//���ּ��̵Ĺ���
		for(int i = 0;i<9;i++){
			_j = i;
			num_button[i] = new JButton(num_string[i]);
			num_button[i].setFocusPainted(false);//�ÿ��İ�ť(û�б߿�)
			num_button[i].setBackground(Color.GRAY);//��ť��ɫ
			num_panel.add(num_button[i]);
			
			num_button[i].addActionListener(new ActionListener() {
				
				int k = _j;//��ֹ��ͬ��
				
				public void actionPerformed(ActionEvent e) {
					if(mode_num[0]==0)//�������������� ���ܿ�ʼ      Ϊ0˵��û���ڹ���     ���Ը��蹤��
						if(easy_field){

							time = Integer.parseInt(num_string[k])+time*10;
							System.out.println("ʱ���ı���:"+time);//����
							time_field.setText(new String().valueOf(time));
						//	mode_num[0] = 1;
							//mw_progressbar.setString(new String().valueOf(time));
						}
					if(mode_num[1]==0)//�������������� ���ܿ�ʼ     	Ϊ0˵��û���ڹ���     ���Ը��蹤��
						if(!easy_field){
						
							temperature =Integer.parseInt(num_string[k])+temperature*10;
							System.out.println("�¶��ı���:"+temperature);//����
							fire_field.setText(new String().valueOf(temperature));
						//	mode_num[1] = 1;
							
						}
	
				}
			});
			
		}
		//�������ְ�ť������
				zero_delete = new JPanel(new GridLayout(2,1,0,10));
				zero_delete.setBounds(820, 210, 50, 150);
				zero_delete.setBackground(new Color(100, 180, 180));
				
		//����0��ɾ��ͳһ����	
		num_button[9] = new JButton(num_string[9]);
		//��ӷ���0���¼�����
		num_button[9].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				if(mode_num[0]==0)
				if(easy_field){
					
					time = Integer.parseInt(num_string[9])+time*10;
					System.out.println("ʱ���ı���:"+time);//����
					time_field.setText(new String().valueOf(time));
				}
				if(mode_num[1]==0)
				if(!easy_field){
					
					temperature =Integer.parseInt(num_string[9])+temperature*10;
					System.out.println("�¶��ı���:"+temperature);//����
					fire_field.setText(new String().valueOf(temperature));
					
				}
			}
		});
		//����ɾ����ť
		delete = new JButton("��");
		delete.setBackground(Color.gray);
		delete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				if(mode_num[0]==0)//����������   �����޸�ʱ��
				if(easy_field){
					
					time = time/10;
					System.out.println("ʱ���ı���:"+time);//����
					time_field.setText(new String().valueOf(time));
				}
				if(mode_num[1]==0)//����������    �����޸��¶�
				if(!easy_field){
				
					temperature =temperature/10;
					System.out.println("�¶��ı���:"+temperature);//����
					fire_field.setText(new String().valueOf(temperature));
					
				}
				
			}
		});
		
		num_button[9].setFocusPainted(false);//�ÿ��İ�ť(û�б߿�)
		num_button[9].setBackground(Color.GRAY);//��ť��ɫ
		zero_delete.add(num_button[9]);
		zero_delete.add(delete);
		
		mw_panel.add(zero_delete);
		
		//����ͼƬ��ť
		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(2, 4, 10, 10));
		button_panel.setBackground(new Color(100, 180, 180));

		for( int i = 0;i<8;i++){
			j = i;//����  �޷��ڼ�������ʹ��i����   
			mw_button[i] = new JButton(mode_string[i]);
			mw_button[i].setFocusPainted(false);//�ÿ��İ�ť(û�б߿�)
			mw_button[i].setBackground(Color.GRAY);//��ť��ɫ
			
			mw_button[i].addActionListener(new ActionListener() {
			
			int k = j;//ֱ��ʹ��j �ᷢ����ͬ������
			public void actionPerformed(ActionEvent arg0) {
				if(mode_num[2]==0){
					
					pic_label.setIcon(new ImageIcon(new String("..\\MyMicrowave\\ͼƬ\\"+k+".jpg")));
					//mode_num[2] = 1;
					temp_mode = mode_string[k];
				}
				
			}
			});
			
			button_panel.add(mw_button[i]);
			
		}
		
		//ͼƬ��
		pic_panel.setBackground(new Color(100, 180, 180));//����С��϶����ɫ����,ȫ������������ɫͳһ
		pic_panel.add(pic_label);
		pic_panel.setBounds(25, 20, 510, 530);
		mw_panel.add(pic_panel);
		
		//������
		num_panel.setBounds(560, 210, 250, 150);
		mw_panel.add(num_panel);
		//������
		
		button_panel.setBounds(560, 380, 400, 150);
		mw_panel.add(button_panel);
		mw_windows.add(mw_panel);
		
	}//���췽�����˽���
	
	//��ʽ��ʼ������
	public void start(time_progressbar work_thread){

		work_thread.modify(true);
		work_thread.start();//���߳�ʵ�ֵ���ʱ
		
	}
	
	//ֹͣ����
	public void stop(time_progressbar work_thread){
	
		for(int i = 0;i<3;i++)
			mode_num[i] = 0;
		time = 10;
		time_field.setText(new String().valueOf(time));
		temperature = 100;
		fire_field.setText(new String().valueOf(temperature));
		//temp_mode = new String("��ʵ�е�΢��¯���Ŷ���Ҳ���Թ���");
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
		mw_panel.setBackground(new Color(100, 180, 180));//����ɫ
				
		ImageIcon mw_icon = new ImageIcon("..\\MyMicrowave\\1.png");
		mw_windows.setIconImage(mw_icon.getImage());//����ͼ��
		mw_windows.setSize(1000,600);//�ߴ�
		mw_windows.setLocationRelativeTo(null);//��Ļ������ʾ
		mw_windows.setResizable(false);//�����û��ı����ߴ�
		
		mw_windows.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e){
				System.exit(0);	
			}
			
		}) ;
		
		work sc = new work(mw_windows, mw_panel);
		mw_windows.show();
		
	}

}

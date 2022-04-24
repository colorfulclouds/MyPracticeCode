import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

import javax.swing.*;

public class ChatClient extends JFrame {

	JTextField jtf = new JTextField();
	JTextArea jta = new JTextArea();
	DataOutputStream dos = null;
	DataInputStream dis = null;
	Socket s = null;
	boolean stop_thread = false;

	public static void main(String[] args) {

		
		new ChatClient().launchframe();

	}

	public void launchframe() {

		setLayout(new GridLayout(2,1));
		jta.setLineWrap(true);//出现滚动条
		add(jta);//文本域
		add(jtf);//文本框
		setLocation(400, 300);
		this.setSize(300, 300);
		
		jtf.addActionListener(new enterlistener());
		
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
			
				disconnect();
				System.exit(0);
				//dispose();//关闭窗口的另一个写法
			}
		
		});
		
		setVisible(true);//show()方法一样的效果    但是show() 方法不建议使用
		connect();
		new Thread(new recvthread()).start();
	}
	
	public void connect(){
		
		try {
			
			s = new Socket("127.0.0.1",8888);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			System.out.println("connect server!");
			stop_thread = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void disconnect(){
	
		try{
			
			dis.close();
			dos.close();
			s.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
			
	}
	
	private class recvthread implements Runnable{
		
		
		public void run(){
			try{
				
				while(stop_thread){
				String str = dis.readUTF();//阻塞时 一直在傻傻等待 读取  线程会 无法终止   比较难解决
				jta.setText(jta.getText()+str+'\n');
			}
			}
			catch(SocketException e){
				System.out.println("谢谢使用!");
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
			
			
		}
		
	}
	
	private class enterlistener implements ActionListener{//回车发出文字

		public void actionPerformed(ActionEvent e) {

			String line = jtf.getText().trim();
			//jta.setText(line);
			jtf.setText("");//发出文字后  就清空文本域
			try{
				//发送输入的文本
				//DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				dos.writeUTF(line);
				dos.flush();
				//dos.close();
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
			
			
		}
		
	}

}

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
		jta.setLineWrap(true);//���ֹ�����
		add(jta);//�ı���
		add(jtf);//�ı���
		setLocation(400, 300);
		this.setSize(300, 300);
		
		jtf.addActionListener(new enterlistener());
		
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
			
				disconnect();
				System.exit(0);
				//dispose();//�رմ��ڵ���һ��д��
			}
		
		});
		
		setVisible(true);//show()����һ����Ч��    ����show() ����������ʹ��
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
				String str = dis.readUTF();//����ʱ һֱ��ɵɵ�ȴ� ��ȡ  �̻߳� �޷���ֹ   �Ƚ��ѽ��
				jta.setText(jta.getText()+str+'\n');
			}
			}
			catch(SocketException e){
				System.out.println("ллʹ��!");
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
			
			
		}
		
	}
	
	private class enterlistener implements ActionListener{//�س���������

		public void actionPerformed(ActionEvent e) {

			String line = jtf.getText().trim();
			//jta.setText(line);
			jtf.setText("");//�������ֺ�  ������ı���
			try{
				//����������ı�
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

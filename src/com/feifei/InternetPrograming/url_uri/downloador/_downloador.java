package downloador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class _downloador {

	public static void main(String[] args) {

		JFrame jf = new JFrame("My Download");
		jf.setSize(600, 400);
		jf.setLocation(100, 100);
		
		JPanel p = new JPanel();
		JLabel l = new JLabel("input URL:");
		final JTextField tf = new JTextField(30);
		
		p.add(l);
		p.add(tf);
		jf.getContentPane().add(p,"North");//将第一个容器jpanel放在 顶级容器的最北边
		
		final JTextArea ta = new JTextArea();
		jf.getContentPane().add(ta,"Center");
		
		
		JButton btn = new JButton("start download!");
		jf.getContentPane().add(btn,"South");

		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				String str = tf.getText();
				try {
					URL url = new URL(str);
					URLConnection urlconn = url.openConnection();
					String line = System.getProperty("line.separator");
					ta.append("host:  "+url.getHost());
					ta.append(line);
					ta.append("port:  "+url.getDefaultPort());
					ta.append(line);
					ta.append("type:  "+urlconn.getContentType());
					ta.append(line);
					ta.append("length:  "+urlconn.getContentLength());
					InputStream is = urlconn.getInputStream();
					//InputStreamReader isr = new InputStreamReader(is);
					//BufferedReader br = new BufferedReader(isr);
					FileOutputStream fos = new FileOutputStream("H:\\我的视频\\孙鑫Java全套\\孙鑫Java无难事12\\1.jpg");
					//String strline;
					int data;
					
					
					
					//while((strline = br.readLine())!=null)
					while((data = is.read())!=-1)
					{
						
						//fos.write(strline.getBytes());
						//fos.write(line.getBytes());//行分隔符
						fos.write(data);
						
					}
					
					//br.close();
					is.close();
					fos.close();
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		jf.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e){
				System.exit(0);	
			}
			
		}) ;
		
		jf.show();
	}

}

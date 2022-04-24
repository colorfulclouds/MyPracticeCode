package myclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class _myclient {

	public static void main(String [] args){
		
		try {
			
			Socket s = new Socket("127.0.0.1", 6000);
			//Socket s = new Socket(InetAddress.getByName(null), 6000);

			OutputStream os = s.getOutputStream();
			InputStream is = s.getInputStream();
			byte [] buf = new byte[100];
			int len = is.read(buf);
			System.out.println(new String(buf,0,len));
			
			os.write("hello i am you bride".getBytes());
			os.close();
			is.close();
			s.close();
			
			
		} 
	
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

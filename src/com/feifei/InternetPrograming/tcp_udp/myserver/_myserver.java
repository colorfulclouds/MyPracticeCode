package myserver;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class _myserver extends Thread{

	private Socket s;
	
	public _myserver(Socket s){
		
		this.s = s;
		
	}
	
	public void run(){
		
		try{
			
			OutputStream os = s.getOutputStream();
			InputStream is = s.getInputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);
			//os.write("hello i am yufeifei".getBytes());
			bos.write("hello i am yufeifei".getBytes());
			byte [] buf = new byte[100];
			int len = is.read(buf);
			System.out.println(new String(buf,0,len));
			
			s.close();
			
			
			//os.close();
			//is.close();
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {

		try{
			
			ServerSocket ss = new ServerSocket(6000);
			while(true){
				
				Socket s = ss.accept();
				new _myserver(s).start();
			}
			
			//ss.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	

}

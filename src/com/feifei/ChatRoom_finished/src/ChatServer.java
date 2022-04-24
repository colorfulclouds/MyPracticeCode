import java.awt.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class ChatServer {

	ArrayList<connect> connects = new ArrayList<connect>();
	
	public static void main(String[] args) {

		new ChatServer().start();
		
	}

	void start(){
		
		try{
			
			ServerSocket ss = new ServerSocket(8888);
			boolean started = true;
			while(started){
				
				Socket s = ss.accept();
				
				System.out.println("a client enter!");
				connect c = new connect(s);
				connects.add(c);
				new Thread(c).start();
				
			}
			
			ss.close();
		}
		catch(Exception e){
			
			System.out.println("a client close!");
		}
	}
	
	class connect implements Runnable{
		
		Socket s = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		boolean bconnected = false;
		
		 connect(Socket s){
			
			this.s = s;
			bconnected = true;
			try {
				
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
			}
			catch (IOException e) {

				e.printStackTrace();
			}
			
		}
		 
		public void send(String str){
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				connects.remove(this);
				System.out.println("¹Ø¼üÓï¾ä!");
				//e.printStackTrace();
			}
		}
		
		public void run(){
			
			while(bconnected){
				
				String str = null;
				
				try {
					str = dis.readUTF();
					//System.out.println("·É¦ä(£þ¦á£þ)¦ä"+str);
					
					for(int i = 0;i<connects.size();i++){
						connect c = connects.get(i);
						//System.out.println("¾Í"+str);
						c.send(str);
					}
					System.out.println(str);
				}
				catch (IOException e) {

					//e.printStackTrace();
					System.out.println("a client exit!");
					bconnected =false;
					try{
						
						dis.close();
						dos.close();
						s.close();
					
					}
					catch(Exception ee){
						ee.printStackTrace();
					}
				}
				
			}
			
		}
		
	}
}

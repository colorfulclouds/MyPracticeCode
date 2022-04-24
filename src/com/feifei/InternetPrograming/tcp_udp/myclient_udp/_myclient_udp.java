package myclient_udp;

import java.net.*;

public class _myclient_udp extends Thread{

	public static void main(String[] args) {

		
		try{
			
			DatagramSocket ds = new DatagramSocket();
			String str = "hello i am yufeifei";
			DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(),InetAddress.getByName("localhost"),6400);
			ds.send(dp);
			
			byte [] buf = new byte[100];
			DatagramPacket dprecv = new DatagramPacket(buf, 100);
			ds.receive(dprecv);
			System.out.println(new String(buf,0,dprecv.getLength()));
			
			
			ds.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}

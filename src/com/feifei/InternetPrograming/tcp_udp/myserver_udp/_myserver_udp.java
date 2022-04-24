package myserver_udp;

import java.net.*;

public class _myserver_udp extends Thread{

	public static void main(String[] args) {

		
	}
	
	public static void rec(){
		
		try{
			
			DatagramSocket ds = new DatagramSocket(6400);
			byte[] buf = new byte[100];
			DatagramPacket dp = new DatagramPacket(buf, 100);
			ds.receive(dp);
			System.out.println(new String(buf,0,dp.getLength()));
			
			String str = "welcome you";
			DatagramPacket dpsend = new DatagramPacket(str.getBytes(),str.length(),dp.getAddress(),dp.getPort());
				
			ds.send(dpsend);
			
			ds.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}

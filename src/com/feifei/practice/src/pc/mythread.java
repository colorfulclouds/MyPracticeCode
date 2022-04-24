package pc;
import java.io.*;

public class mythread {

	public static void main(String [] args){
		
		PipedOutputStream pp = new PipedOutputStream();
		PipedInputStream cc = new PipedInputStream();
		try {
			pp.connect(cc);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		produce p = new produce(pp);
		consumer c = new consumer(cc);
		
		p.start();
		c.start();
	}
	
}

class produce extends Thread{
	
	private PipedOutputStream pos;
	
	public produce(PipedOutputStream pos) {

		this.pos = pos;
		
	}
	
	public void run(){
		
		try {
			pos.write("good love".getBytes());
			pos.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
}

class consumer extends Thread{
	
	private PipedInputStream pis;
	public consumer(PipedInputStream pis){
		
		this.pis = pis;
		
	}
	
	public void run(){
		byte [] buf = new byte[100];
		
		try {
			pis.read(buf);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(new String(buf,0,buf.length));
		try {
			pis.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
}
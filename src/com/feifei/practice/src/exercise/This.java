package exercise;
import java.io.*;

public class This {
	
	public static void main(String [] args) throws IOException{
		
		/*int data;
		
		while((data = System.in.read())!=-1)
			System.out.write(data);*/
		
		//FileOutputStream fos = new FileOutputStream("H:\\JAVA”Ô—‘¡∑œ∞\\1.txt");
		
		//BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		//fos.write("wo shi yufeifei !".getBytes());
		//fos.close();
		
		//bos.write("haha  i will be ok!".getBytes());
		//bos.close();
		//boolean i = true;
		
		//int j = 9;
		//char c = 'a';
		//float f = 1.2f;
		
		/*DataOutputStream dos = new DataOutputStream(bos);
		
		dos.writeBoolean(i);
		dos.writeInt(j);
		dos.writeChar(c);
		dos.writeFloat(f);
		dos.close();
		
		/*FileInputStream fis = new FileInputStream("H:\\JAVA”Ô—‘¡∑œ∞\\1.txt");
		byte [] buf = new byte[100];
		
		BufferedInputStream  bis = new BufferedInputStream(fis);
		
		bis.read(buf);
		
		System.out.println(new String(buf,0,buf.length));
		bis.close();
		
		//fis.read(buf);
		
		//System.out.println(new String(buf,0,buf.length));*/
		
		
		/*FileInputStream fis = new FileInputStream("H:\\JAVA”Ô—‘¡∑œ∞\\1.txt");
		BufferedInputStream  bis = new BufferedInputStream(fis);
	
		DataInputStream dis = new DataInputStream(bis);
		System.out.println(dis.readBoolean());
		System.out.println(dis.readInt());
		System.out.println(dis.readChar());
		System.out.println(dis.readFloat());
		dis.close();*/
		
		/*FileOutputStream fos = new FileOutputStream("F:\\1.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write("hello world!");
		bw.close();
		
		FileInputStream fis = new FileInputStream("F:\\1.txt");
		InputStreamReader  isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println(br.readLine());
		br.close();
		*/
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader  br = new BufferedReader(isr);
		String test;
		
		while((test = br.readLine())!=null)
			System.out.println(test);
		br.close();
		
		
	}
	

}

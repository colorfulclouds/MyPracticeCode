package _stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ex {

	public static void main(String[] args) throws IOException {
		
		String str = "nshisnihishia������ô";
		byte [] buf = str.getBytes();
		ByteArrayOutputStream baout =new ByteArrayOutputStream();
		
		baout.write(buf);
		System.out.println("�����ַ���:"+baout.toString());
		
		byte [] b = baout.toByteArray();
		
		OutputStream file = new FileOutputStream("f:\\my.txt");
		baout.writeTo(file);
		baout.close();
		
		ByteArrayInputStream bain = new ByteArrayInputStream(b);
		
		byte [] bArray = new byte [b.length];
		
		System.out.print("������:");
		while(bain.read(bArray)!=-1){}
		
		System.out.println(new String (bArray));
		bain.close();
		
	}

}

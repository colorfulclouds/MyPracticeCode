package produece;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.Writer;

public class ss {

	public static void main(String[] args)  throws IOException{

		String str = "asdasdas����";
		CharArrayWriter caw = new CharArrayWriter();
		
		caw.write(str);
		
		System.out.println("�����ַ���:"+caw.toString());
		
		char [] buf = caw.toCharArray();
		Writer file = new FileWriter("f:\\my.txt");
		caw.writeTo(file);
		caw.close();
		
		CharArrayReader car = new CharArrayReader(buf);
		int i ;
		System.out.println("��������:");
		while((i= car.read())!=-1)
			System.out.println((char)i);
		car.close();
	}

}

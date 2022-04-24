package filechar;

import java.awt.image.ImagingOpException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;

public class file {

	public static void main(String[] args) {

		String str = "白日依山尽\n";
		char [] ch = str.toCharArray();
		FileWriter fw = null;
		FileReader fr = null;
		
		try{
			
			fw = new FileWriter("f://mydata.txt");
			fw.write(ch);
			fw.write("黄河入海流\n");

			fw.write("欲穷千里目\n");
			fw.write("更上一层楼\n");
			fw.close();
		}catch(IOException e){
			
			System.err.println("error");
			System.exit(-1);
			
		}
		
		try{
			
			int i;
			while((i = fr.read())!=-1)
				System.out.println((char)i);
			System.out.println();
			fr.close();
		}
		
		catch(FileNotFoundException e){
			
			System.err.println("no find!");
			System.exit(-2);
			
			
		}
		
		catch(IOException e){
			
			System.err.println("possible error!");
			System.exit(-3);
			
		}
		
		
		
		
		
	}

}

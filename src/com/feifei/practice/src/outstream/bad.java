package outstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class bad {

	public static void main(String [] args){
		
		int i ;
		File mydir = new File("f://mydir");
		
		if(!mydir.exists())
			try {
				mydir.createNewFile();
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		
		File myfile = new File(mydir,"my.txt");
		
		try{
			
			FileOutputStream fout = new FileOutputStream(myfile);
			System.out.println("input stop by '#'");
			while((i = System.in.read())!='#')
				fout.write(i);
			fout.close();
		}
		
		catch(FileNotFoundException e)
		{
			System.err.println("no file");
			System.exit(-1);
			
		}
		catch(IOException e){
			
			System.err.println("error!");
			System.exit(-2);
			
		}
		
	}
	
}

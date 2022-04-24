package stream;
import java.io.*;
public class mystream {

	public static void main(String[] args) throws IOException{

		int i = 0 ;
	
		byte [] b = new byte[1000];
		//String str = null;
		FileInputStream fin = null;
		try{
			
			fin = new FileInputStream("H:\\JAVA”Ô—‘¡∑œ∞\\practice\\src\\stream\\mystream.java");
			System.out.println(fin.available());
			//fin.read(b,fin.available()/2,fin.available());
			while((i = fin.read(b,10,20))!=-1)
			{
				String str = new String(b);
			System.out.println(str);
				
				//fin.read(b);
			}

			
			//while(!=-1)
				//System.out.print((char)i);
			
		}catch(FileNotFoundException e)
		{
			System.err.println(args[0]);
			System.exit(-1);
		}
		
		catch(ArrayIndexOutOfBoundsException e){
			System.err.println("**");
			System.exit(-2);
			
		}
		
		catch(IOException e){
			
			System.err.println();
			System.exit(-3);
		}
		
		finally{
			
			fin.close();
		}
		
		
	}

}

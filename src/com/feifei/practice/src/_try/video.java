package _try;
import java.io.*;

public class video {

	public static void main(String [] args)  throws IOException{
		
		//File f = new File("1.txt");
		//f.createNewFile();
		//f.mkdir();
		
		//File f = new File("H:\\JAVA语言练习\\1.txt");
		//f.createNewFile();

		/*
		f.createNewFile();
		//f.delete();
		f.deleteOnExit();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
		/*for(int i = 0;i++;i<5){
			
			File.createTempFile("yufei", ".txt");
			
		}*/
		
	
		
		File f = new File("G:\\Program Files\\Dreamweaver");
		
		
		String [] names  = f.list(new FilenameFilter() {
			//匿名类
			public boolean accept(File dir, String name) {
				
				
				return name.indexOf(".dll")!=-1;
			}
		}
		
				);
		for(int i = 0;i<names.length;i++)
			System.out.println(names[i]);
	}
	
}

package file;
import java.io.*;

public class myfile {

	public static void main(String[] args) throws IOException{
		
		File mydir = new File ("f://mydir");
		if(!mydir.exists())
			mydir.mkdir();
		
		File mydir1 = new File(mydir,"mydir1");
		if(!mydir1.exists())
			mydir1.mkdir();
		
		File mydir2 = new File(mydir1,"mydir2");
		if(!mydir2.exists())
			mydir2.mkdir();
		
		File file = new File(mydir2,"my.txt");
		if(!file.exists())
			{
			file.createNewFile();
		
			}
		//listDir(mydir);
		
		delect(mydir);
	}

	 private static void delect(File mydir) {

		 
		System.out.println(mydir.delete()); 
		 
	}
//打印路径
	static void listDir(File dir) {

		 		File[] listf = dir.listFiles();
		 		String info = "目录:"+dir.getName()+"{";
		 		for(int i =0;i<listf.length;i++)
		 			info +=listf[i].getName();
		 		info+="}";
		 		
		 		System.out.println(info);
		 		
		 		for(int i = 0;i<listf.length;i++){
		 			
		 			File f = listf[i];
		 			
		 			
		 			
		 			if(f.isFile())
		 				printFileInfo(f);
		 			else 
		 				listDir(f);
		 			
		 		}
		 		
		 		
		 
	}

	 static void printFileInfo(File f) {

		 
		 System.out.println("文件名:"+f.getName());
		 System.out.println("文件父路径:"+f.getPath());
		 System.out.println("文件可读:"+f.canRead());
		 System.out.println("文长度:"+f.length()+"字节");
		 
		 
	}
	
}

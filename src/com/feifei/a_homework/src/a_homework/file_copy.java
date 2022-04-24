package a_homework;

import java.io.*;

public class file_copy {

	public static void main(String [] args) throws Exception{
		
		File fsrc = new File("1.txt");//此处可以键入指定的目标文件夹和文件名(源头)
		File fdec = new File("2.txt");//此处可以键入指定的目标文件夹和文件名(目标)
		
		FileInputStream fis_src = new FileInputStream(fsrc);//读出
		FileOutputStream fos_dec = new FileOutputStream(fdec);
		
		int i = 0;
		
		while((i = fis_src.read()) != -1){
			fos_dec.write(i);
		}
		fis_src.close();
		fos_dec.close();
	}
}

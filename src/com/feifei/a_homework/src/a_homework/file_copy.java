package a_homework;

import java.io.*;

public class file_copy {

	public static void main(String [] args) throws Exception{
		
		File fsrc = new File("1.txt");//�˴����Լ���ָ����Ŀ���ļ��к��ļ���(Դͷ)
		File fdec = new File("2.txt");//�˴����Լ���ָ����Ŀ���ļ��к��ļ���(Ŀ��)
		
		FileInputStream fis_src = new FileInputStream(fsrc);//����
		FileOutputStream fos_dec = new FileOutputStream(fdec);
		
		int i = 0;
		
		while((i = fis_src.read()) != -1){
			fos_dec.write(i);
		}
		fis_src.close();
		fos_dec.close();
	}
}

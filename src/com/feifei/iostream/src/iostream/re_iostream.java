package iostream;

import java.io.*;

public class re_iostream {

	public static void main(String [] args){
		PrintStream ps = System.out;//保存原来的console的输出流
		
		try {
			PrintStream new_ps = new PrintStream("1.txt");//重定向
			System.setOut(new_ps);//重定向新的输出流
			System.out.println("kk");//不显示在控制台  而是打印到文本文件中
			System.setOut(ps);//重新定位回去控制台输出流
			System.out.println("nn");//打印在控制台上
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

package a_homework;

import java.io.*;
import java.util.*;

public class random {

	public static void main(String [] args) throws Exception{
		
		File src = new File("1.txt");
		FileOutputStream fos = new FileOutputStream(src);

		
		Random rand = new Random();
		String str = null;
		for(int i = 1;i <= 5000;i++){
			
			str = String.valueOf(rand.nextInt(9999))+"\r\n";
			
			fos.write(str.getBytes());
		}
		
		fos.close();
		//¶Á³ö
		int sum = 0;
		int max;
		int min;
		float average = 0.0f;
		
		
		FileInputStream fis = new FileInputStream(src);
		BufferedReader dr=new BufferedReader(new InputStreamReader(fis));
		String line =  dr.readLine();
		
		int num = Integer.valueOf(line);
		
		max = min = num;
		while(line!= null){
			
			System.out.println(line);  
			sum += num;
			if((line = dr.readLine())!=null)
				num = Integer.valueOf(line);
				else
					break;
			if(num>max)
				max = num;
			if(num<min)
				min=num;
		} 
		fis.close();
		dr.close();
		System.out.println("average : "+sum/5000.0);
		System.out.println("max"+max+"min"+min);
	}

}

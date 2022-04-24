package arraylist;

import java.util.*;
//顺序表 顺序表

public class arraylist {
	
	public static void main(String[] args){
		
		ArrayList<String> stu = new ArrayList<String>();//创建一个String类型的顺序表
		Scanner in = new Scanner(System.in);
		String name;
		System.out.println("空行停止!");
		boolean goon = true;
		
		while(goon){
			name = in.nextLine();
			if(name.length()>0)
				stu.add(name);
			else
				goon = false;
		}
		
		
		System.out.print("delete who ? his (her) name:");
		goon = true;
		while(goon){
			
			name = in.nextLine();
			if(name.length()>0)
				if(stu.remove(name))
					System.out.println("success delete!");
				else
					System.out.println("no this person!");
			else
				goon = false;
		}
		
		System.out.println("these people");
		System.out.println();
		for(String _name:stu)
			System.out.println(_name);
		in.close();
		
	}

}

package arraylist;

import java.util.*;
//˳��� ˳���

public class arraylist {
	
	public static void main(String[] args){
		
		ArrayList<String> stu = new ArrayList<String>();//����һ��String���͵�˳���
		Scanner in = new Scanner(System.in);
		String name;
		System.out.println("����ֹͣ!");
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

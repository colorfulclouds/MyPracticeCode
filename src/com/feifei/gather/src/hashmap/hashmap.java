package hashmap;

import java.util.*;
///////¹Ø¼ü
////¹þÏ£Ó³Éä
public class hashmap {

	public static void main(String[] args) {

		HashMap<String,Integer> stu = new HashMap<String,Integer>();/////////
		Scanner in = new Scanner(System.in);
		String name;
		Integer score;
		
		System.out.println("name  grade space finish");
		boolean goon = true;
		
		while(goon){
			System.out.print("name:");
			name = in.nextLine();
			if(name.length()>0){
				System.out.print("grade:");
				score = new Integer(in.nextInt());
				stu.put(name, score);//////////
								
			}
			else
				goon = false;
			
		}
		System.out.println("find who?  name  space finish");
		
		goon = true;
		while(goon){
			
			name = in.nextLine();
			if(name.length()>0){
				
				score = stu.get(name);///////////////
				if(score != null)
					System.out.println("his score is "+ score);
				else
					System.out.println("no this person!");
			}
			else
				goon = false;
		}
	in.close();
	}
	

}

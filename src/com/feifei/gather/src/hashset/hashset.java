package hashset;

import java.util.*;

import map.people;
//哈希集合
public class hashset {

	public static void main(String[] args) {
		
		Set hash = new HashSet();
		hash.add("yufeifei");
		hash.add(125);
		//必须重写	hashcode() 和equals()

			hash.add(new people(new Integer(15),"wangxin"));
		hash.add(new people(new Integer(15),"wangxin"));
		System.out.println(hash);

		System.out.println("llllllllll");
		HashSet<String> stu = new HashSet<String>();
		Scanner in = new Scanner(System.in);
		

		
		System.out.println("****");
		
		System.out.println("students' names:空行结束");
		boolean goon = true;
		
		String name;
		while(goon){
			
			name = in.nextLine();//name = in.next();//执行不出来  无法 换行停止输入
			System.out.println(name.length());//why?
			if(name.length()>0)
				stu.add(name);
			else
				goon = false;
		}
		
		System.out.println("delete name:空行结束");
		goon = true;
		
		while(goon){
			
			name = in.nextLine();
			if(name.length()>0)
				if(stu.remove(name))
					System.out.println("success delete!");
				else
					System.out.println("no this person !");
			else
				goon = false;
		}
		
		
		System.out.println("还有这些人");
		for(String _name:stu)
			System.out.println(_name);
	
		in.close();
	}

}

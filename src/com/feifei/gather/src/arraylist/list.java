package arraylist;

import java.util.*;

public class list {

	public static void main(String [] args){
		
		List list = new ArrayList();
		
		list.add("yufeifei");
		list.add(122);
		list.add(true);
		
		System.out.println(list.contains("yueifei"));
		
		System.out.println(list);
	}
}

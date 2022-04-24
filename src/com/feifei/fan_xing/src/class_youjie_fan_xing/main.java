package class_youjie_fan_xing;

import class_tongpeifu_fan_xing.stats;

public class main {

	public static void main(String[] args) {

		Integer [] inum = {1,2,3,4};
		stats <Integer> iobj = new stats(inum);
		
		Double [] iinum = {2.3,5.5,1.2,1.5};
		stats <Double> iiobj = new stats(iinum);
		
		iiobj.dosomething(iobj);
		
	}

}

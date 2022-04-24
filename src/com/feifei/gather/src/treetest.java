import java.util.*;


public class treetest {

	public static void main(String [] args){
		
		Set test = new TreeSet();
//		test.add(123);
//		test.add(564);
//		test.add(85445);
//		test.add(102);
		
		test.add(new people(12,"yufeifei"));
		test.add(new people(13,"yuifei"));
		test.add(new people(14,"yueifei"));
		test.add(new people(15,"yfeifei"));
		test.add(new people(15,"kiki"));

//		test.add(new String("yufeifei"));
		
		System.out.println(test);
	}
}

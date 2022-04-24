package treeset;

import java.util.*;
//ÓĞĞòÊ÷(ºìºÚÊ÷)
public class demo {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		comparescore comp = new comparescore();
		TreeSet<_treeset> stutree = new TreeSet<_treeset> ();
		String name;
		Integer score;
		System.out.println("sd");
		boolean goon = true;
		
		while(goon){
			
			System.out.print("name");
			name = in.nextLine();
			if(name.length()>0){
				System.out.print("grade:");
				score = in.nextInt();
				stutree.add(new _treeset(name, score));
				
			}
			else
				goon = false;
		}
		in.close();
		System.out.println("½µĞò:");
		Iterator it = stutree.iterator();//»ñÈ¡µü´úÆ÷
		
		while(it.hasNext()){
			_treeset st = (_treeset)it.next();
			System.out.println(st.getname()+"  "+st.getscore());
		}
		
	}

}

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



class ppeople implements Comparable{

	int age ;
	String name;
	
	public ppeople(int age,String name) {
		this.age = age;
		this.name = name;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public int compareTo(Object o) {
		
		ppeople p = (ppeople)o;
		return age == p.age ? 0:(age<p.age ? 1:-1);
	}
	
}

public class treemap {

	public static void main(String[] args) {
		
		
//		m.put(new ppeople(18, "yufeifei"),20);
//		m.put(new ppeople(19, "wangxin"),22);
//		m.put(new ppeople(23, "lijing"),89);
//		m.put(new ppeople(11, "yangshuai"),44);
		
		Comparator com = new Comparator() {
			
			public int compare(Object o1, Object o2) {

				ppeople p1 = (ppeople)o1;
				ppeople p2 = (ppeople)o2;
				
				int i = new Integer(p1.getAge()).compareTo(new Integer(p2.getAge()));
				
				
				return i;
			}
		};
		
		Map m = new TreeMap(com);
		m.put(new ppeople(18, "yufeifei"),20);
		m.put(new ppeople(19, "wangxin"),22);
		m.put(new ppeople(23, "lijing"),89);
		m.put(new ppeople(11, "yangshuai"),44);
		
		Set s = m.keySet();//»ñÈ¡setÊÓÍ¼
		for(Object o:s)
			System.out.println(o +".."+m.get(o));
		
	}
}

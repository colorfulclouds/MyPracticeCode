import java.util.Comparator;
import java.util.TreeSet;


public class treeset_test {

	public static void main(String [] args){
		
		Comparator com = new Comparator() {

			public int compare(Object o1, Object o2) {
			
				customer c1 = (customer) o1;
				customer c2 = (customer) o2;
				
//				return 
				int i = c1.getNum().compareTo(c2.getNum());
				if(0 == i){
					return c1.getStr().compareTo(c2.getStr());
				}
				else
					return i;
				//				return 0;
			}
			
			
		};
		TreeSet list = new TreeSet(com);
		
		list.add(new customer("yufeifei", 12));
		list.add(new customer("wangxin", 42));
		list.add(new customer("lijing", 112));
		list.add(new customer("tianzhao", 112));
		
		for(Object obj : list){
			System.out.println(obj);
		}
	}
}

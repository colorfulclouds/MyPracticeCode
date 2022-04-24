import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class testemployee {

	public static void main(String[] args) {
		
//		employee e1 = new employee("yufeifei", 20, new mydate(2,11,1995));
//		employee e2 = new employee("yangshuai", 17, new mydate(2,1,1996));
//		employee e3 = new employee("lijing", 22, new mydate(2,11,1994));
//		employee e4 = new employee("weihang", 19, new mydate(2,11,5995));
//		employee e5 = new employee("tianzhao", 22, new mydate(7,7,1295));
//		
//		TreeSet set = new TreeSet();
//		
//		set.add(e1);
//		set.add(e2);
//		set.add(e3);
//		set.add(e4);
//		set.add(e5);
//		
//		Iterator i = set.iterator();
//		while(i.hasNext())
//			System.out.println(i.next());
//		
//		System.out.println("*****");
		Comparator com = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO 自动生成的方法存根
				employee1 e1 = (employee1)o1;
				employee1 e2 = (employee1)o2;
				
				mydate birth1 = e1.getBirthday();
				mydate birth2 = e2.getBirthday();
				
				if(birth1.getYear()!=birth2.getYear())
				
					return birth1.getYear() - birth2.getYear();
					
				else
					{
						if(birth1.getMonth() != birth2.getMonth())
						
							return birth1.getMonth() - birth2.getMonth();
						
						else
							return birth1.getDay() - birth2.getDay();
							
					}
						
				
				//return 0;
			}
			
		};
		TreeSet set = new TreeSet<>(com);
		
		employee1 e1 = new employee1("yufeifei", 20, new mydate(2,11,1995));
		employee1 e2 = new employee1("yangshuai", 17, new mydate(2,1,1996));
		employee1 e3 = new employee1("lijing", 22, new mydate(2,11,1994));
		employee1 e4 = new employee1("weihang", 19, new mydate(2,11,5995));
		employee1 e5 = new employee1("tianzhao", 22, new mydate(7,7,1295));
		
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		
		Iterator i = set.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}
}

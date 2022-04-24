import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
class MergeIterator implements Iterator<Integer>{
	public MergeIterator(Iterator<Integer> a , Iterator<Integer> b)
	{
		Set<Integer> arr = new TreeSet<Integer>();
		while(a.hasNext())
		{
			arr.add(a.next());
		}
		while(b.hasNext())
		{
			arr.add(b.next());
		}
		
		Iterator<Integer> value = arr.iterator();
		while (value.hasNext()) {
		    int s = value.next();
		    System.out.print(s);
		    if(value.hasNext())
		    	System.out.print(" ");
		}   
	}
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
	public Integer next() {
		// TODO Auto-generated method stub
		return null;
	}
}
class MockIterator implements Iterator<Integer>{
	int current, step, endValue;
	
	public MockIterator(int step , int endValue){
		this.step = step;
		this.endValue = endValue;
		this.current = endValue % step;
	}
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return this.current < this.endValue;
	}
	public Integer next() {
		// TODO Auto-generated method stub
		return this.current += this.step;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a,b,c,d;
		
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		d=sc.nextInt();
		
		MockIterator ita = new MockIterator(a , b);
		MockIterator itb = new MockIterator(c , d);
		Iterator<Integer> it = new MergeIterator(ita , itb);	
	}
}

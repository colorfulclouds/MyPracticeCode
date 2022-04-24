package linshi;

import java.util.Vector;

public class vector_test {

	public static void main(String[] args) {
		
		Vector<Integer> v = new Vector();
		v.add(11);
		v.add(22);
		v.add(32);
		v.add(424);
		v.add(523);
		v.remove(new Integer(22));
		
		System.out.println(v);
	}
}

package debug_study;

import java.util.*;

public class Main {
	
	static int f(int n){
		
		int sum;
		if(n == 0)
			return 1;
		sum = n * f(n - 1);
		return sum;
	}

	public static void main(String[] args) {
		//@SuppressWarnings(value = { "" })
		Scanner reader = new Scanner(System.in);
		int num = reader.nextInt();
		String str = reader.next();
		num += 1;
		
		System.out.println(str);
		System.out.println(num);
		
		System.out.println(f(5));
	}
}

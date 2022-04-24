import java.util.Scanner;
import java.util.Stack;


public class q1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc = new Scanner(System.in);
		String str_s = sc.nextLine();
		String str="";
		for(int i=0;i<str_s.length();i++)
			if(str_s.charAt(i) != ' ')
				str += String.valueOf(str_s.charAt(i));
		
		System.out.println(str.split(arg0));
		
		Stack<Integer> num = new Stack<Integer>();
		Stack<Character> op = new Stack<Character>();
		
		for(int i=0 ; i<str.length();i++)
		{
			
		}
	}

}

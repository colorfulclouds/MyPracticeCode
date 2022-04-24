import java.util.Scanner;
import java.util.Stack;


public class question3 {

	/**
	 * @param args
	 */
	
	public static void cal(String expr)
	{
		Stack<Integer> numStack = new Stack<Integer>(); //number
		Stack<Character> opStack = new Stack<Character>(); //operate
		
		int n=0;
		boolean flag=false;
		char [] cs = expr.toCharArray();
		
		///for(int i=0;i<cs.length;i++)
		for(int i=0 ; cs[i] != '#' ; i++)
		{
			//System.out.println( opStack+"#"+numStack);
			
			if(Character.isDigit(cs[i]))
			{
				n = Integer.parseInt(String.valueOf(cs[i])); //get 0/1
				flag = true;
			}
			else
			{
				if(flag)
				{
					numStack.push(n);
					n=0;
					flag = false;
				}
				
				if(cs[i] == '(')
				{
					opStack.push(cs[i]);
				}else if(cs[i] == ')')
				{
					while(opStack.peek() != '(')
					{System.out.println(opStack+"++"+numStack);
						int result = sub_cal(numStack.pop() , numStack.pop() , opStack.pop());
						numStack.push(result);
					}
					opStack.pop();
				}else if(comp(cs[i]) > 0)
				{
					if(opStack.isEmpty())
						opStack.push(cs[i]);
					else
					{
						if(comp(opStack.peek()) >= comp(cs[i]))
						{	System.out.println(opStack+"=="+numStack);
							int result = sub_cal(numStack.pop() , numStack.pop() , opStack.pop());
							
							numStack.push(result);
						}
					}
				}
			}
		}
		System.out.println(opStack+"^^"+numStack);
		System.out.println(numStack.pop());
	}
	
	private static int comp(char p)
	{
		if(p == '!')
			return 4;
		
		if(p == '&')
			return 3;
		
		if(p == '|')
			return 2;
		
		if(p == '#')
			return 1;
		
		return -1; //impossible
	}
	
	public static int sub_cal(int a , int b , char p)
	{	
		if(p == '!')
			return b==1?0:1;
		
		if(p == '&')
			return a&b;
		
		if(p == '|')
			return a|b;
		
		return -1; //impossible
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String expr = sc.nextLine();
		
		String trans_expr = "";
		
		for(int i=0 ; i<expr.length() ; i++)
		{
			if(expr.charAt(i) == '!')
				trans_expr += "0!";
			else
				trans_expr += expr.charAt(i);
		}
		
		trans_expr += '#';
		
		System.out.println(trans_expr);
		
		cal(trans_expr);
	}

}


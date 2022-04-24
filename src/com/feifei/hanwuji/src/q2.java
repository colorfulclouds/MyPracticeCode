import java.util.Scanner;


public class q2 {
	public static void main(String[] args)
	{
		int res=0;
		
		Scanner sc = new Scanner(System.in);
		
        int l = sc.nextInt();
        int r = sc.nextInt();
        int b = sc.nextInt();
        
        
        if(l<r)
        {
        	int sub = r-l;
        	
        	if(b>sub)
        	{
        		l += sub;
        		b -= sub;
        		
        		res = 2*l;
        		res += (b-b%2);
        		
        	}
        	else if(b<sub)
        	{
        		l += sub;
        		res = 2*l;
        	}
        	else
        		res = l+r+b;
        }
        else if(l>r)
        {
        	int sub = l-r;
        	
        	if(b>sub)
        	{
        		r += sub;
        		b -= sub;
        		
        		res = 2*l;
        		res += (b-b%2);
        		
        	}
        	else if(b<sub)
        	{
        		r += sub;
        		res = 2*r;
        	}
        	else
        		res = l+r+b;
        }
        else
        {
        	//l==r
        	res = 2*l;
        	res += (b-b%2);
        }
        
        System.out.print(res);
        
        
	}

}

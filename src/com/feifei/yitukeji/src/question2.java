import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class question2 {

	/**
	 * @param args
	 */
	
	public static Integer[] get_count(Integer [] a , Integer [][] b)
	{
		Integer [] counts = new Integer[b.length];
		
		for(int i=0;i<b.length;i++)
		{
			int count = 0;
			
			for(int j=0;j<a.length;j++)
			{
				if(a[j]>=b[i][0] && a[j]<=b[i][1])
					count ++;
			}
			
			counts[i] = count;
		}
		
		
		return counts;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T;
		
		T = sc.nextInt();
		
	    ArrayList <Integer[]> as = new ArrayList<Integer[]>();
	    ArrayList <Integer[][]> coords = new ArrayList<Integer[][]>();                                             
	    
		for(int i=0;i<T;i++)
		{
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			Integer [] a = new Integer[n];
			Integer [][] coord = new Integer[m][2];
			
			for(int j=0;j<n;j++)
			{
				a[j] = sc.nextInt();
			}
			
			as.add(a);
			
			for(int k=0;k<m;k++)
			{
				coord[k][0] = sc.nextInt();
				coord[k][1] = sc.nextInt();
			}
			
			coords.add(coord);
			
		}
		
		
		ArrayList <Integer[]> counts_s = new ArrayList<Integer[]>();
		
		for(int i=0;i<T;i++)
		{
			Integer [] counts = get_count(as.get(i) , coords.get(i));
			
			counts_s.add(counts);
			
			
		}
		
		for(int i=0;i<T;i++)
		{
			System.out.println("Case #"+(i+1)+":");
			
			for(int j=0;j<counts_s.get(i).length;j++)
			{
				System.out.println(counts_s.get(i)[j]);
			}
		}
	}

}

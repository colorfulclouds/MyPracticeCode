import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class question1 {

	/**
	 * @param args
	 */
	
	public static Integer[] get_count(int [] a , int [][] b)
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
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		
		int T;
		
		T = sc.nextInt();
		
	    ArrayList <List> results = new ArrayList();
	    
		for(int i=0;i<T;i++)
		{
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int [] a = new int[n];
			int [][] coord = new int[m][2];
			
			for(int j=0;j<n;j++)
			{
				a[j] = sc.nextInt();
			}
			
			for(int k=0;k<m;k++)
			{
				coord[k][0] = sc.nextInt();
				coord[k][1] = sc.nextInt();
			}
			
			Integer [] counts = new Integer[m];
			
			counts = get_count(a , coord);
			
			List<Integer> counts_a = Arrays.asList(counts);

			results.add(counts_a);
			
		}
		
		for(int i=0;i<T;i++)
		{
			System.out.println("Case #"+(i+1)+":");
			
			for(int j=0;j<results.get(i).size();j++)
			{
				System.out.println(results.get(i).get(j));
			}
		}
	}

}

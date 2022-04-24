import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 7 9
 4 2 1 1 1 1 4
 1 2
 1 3
 1 4
 6 3
 6 4
 7 4
 2 5
 3 5
 4 5
 */

public class question3 {

	public static int sum(int [] arr)
	{
		int result = 0;
		
		for(int i=0;i<arr.length;i++)
			result += arr[i];
		
		return result;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int [] P = new int[N];
		for(int i=0;i<N;i++)
			P[i] = sc.nextInt();
		
		int [][] D = new int[M][2];
		for(int i=0;i<M;i++)
		{
			D[i][0] = sc.nextInt();
			D[i][1] = sc.nextInt();
		}
		
		Set [] father = new Set[N];
		for(int i=0;i<N;i++)
		{
			father[i] = new HashSet<Integer>();
		}
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(D[j][1] == i+1)
					father[i].add(D[j][0]);
			}
		}
		
		//for(int i=0;i<father.length;i++)
		//	System.out.print(father[i]);
		
		int [] notfinished = new int[N];
		for(int i=0;i<N;i++)
			notfinished[i] = 1; //not print
		
		int flag = 0;
		
		while(sum(notfinished) != 0)
		{
			ArrayList <Integer> empty = new ArrayList();
			
			for(int i=0;i<N;i++)
			{
				if(father[i].isEmpty() && notfinished[i] == 1)
					empty.add(i);
			}			
			
			for(int i=0;i<empty.size()-1;i++)
				for(int j=i+1;j<empty.size();j++)
					if(P[empty.get(i)]>P[empty.get(j)])
					{
						int temp = empty.get(i);
						empty.set(i, empty.get(j));
						empty.set(j, temp);
					}
			System.out.println(empty);
			
			for(int i=0;i<empty.size();i++)
			{
				
				flag ++;
				
				System.out.print(empty.get(i)+1);
				
				if(flag < N)
					System.out.print(" ");
				
				notfinished[empty.get(i)] = 0;
				
				for(int j=0;j<N;j++)
				{
					father[j].remove(empty.get(i)+1);
				}
			}
			empty.clear();
		}
		//for(int i=0;i<father.length;i++)
		//	System.out.print(father[i]);
		
		/*
		while(sum(notfinished) != 0)
		{
			for(int i=0;i<N;i++)
			{
				if(! father[i].isEmpty())
				{
					for(int j=0;)
					System.out.print(i+1);
					notfinished[i] = 1;
				}
			}
		
		}*/
		
	}

}

/*
 7 9
 4 2 1 1 1 1 4
 1 2
 1 3
 1 4
 6 3
 6 4
 7 4
 2 5
 3 5
 4 5
*/

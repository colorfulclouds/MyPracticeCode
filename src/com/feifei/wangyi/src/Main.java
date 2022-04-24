import java.util.Arrays;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	
	private int n;
	private final int maxn=300000;
	
	private static int all = 0;
	private int counter = 0;
	private static int find;
	
	private boolean [] hashTable;
	private int [] p;
	
	public Main(int n)
	{
		this.n = n;
		hashTable = new boolean[maxn];
		p = new int[maxn];
		Arrays.fill(hashTable, false);
		Arrays.fill(p, 0);
	}
	
	public void generatep(int index , int [] comp)
	{
		if(index==n+1)
		{
			int i=1;
			for(;i<=n;i++)
			{
				
				if(p[i] != comp[i-1])
					break;

				
				//System.out.print(p[i]);
			}
			if(i == n+1)
				find = all;
			
			all++;
			
			return;
		}
		
		for(int x=1;x<=n;x++)
		{
			if(hashTable[x]==false)
			{
				p[index]=x;
				hashTable[x]=true;
				generatep(index+1 , comp);
				hashTable[x]=false;
			}
		}
	}
	
	public void generatep2(int index , int pos)
	{
		if(index==n+1)
		{
			if(counter == pos )
			for(int i=1;i<=n;i++)
			{
				System.out.print(p[i]);
				
				if(i<n)
					System.out.print(" ");
				
			}
			counter ++;
			
			return;
		}
		
		for(int x=1;x<=n;x++)
		{
			if(hashTable[x]==false)
			{
				p[index]=x;
				hashTable[x]=true;
				generatep2(index+1 , pos);
				hashTable[x]=false;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int [] number = new int[n];
		
		for(int i=0;i<n;i++)
		{
			number[i] = sc.nextInt();
		}
		
		Main generateP = new Main(n);
		generateP.generatep(1 , number);
		generateP.generatep2(1 , all-find-1);
	}

}

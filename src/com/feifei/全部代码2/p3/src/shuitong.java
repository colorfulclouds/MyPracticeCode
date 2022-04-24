
public class shuitong {
	public static int min_f(int a, int b) 
	{
		if(a<b)
			return a;
		
		return b;
	}
	public static void main(String[] args) 
	{
		int[] array = {1,8,6,2,5,4,8,3,7};
		int max=0;
		int area;
		
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=i+1;j<array.length;j++)
			{
				area = (j-i) * min_f(array[i], array[j]);
				if( area > max)
					max = area;
			}
		}
		
		System.out.println(max);
	}
}

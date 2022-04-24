
public class guanglianda {
	
	public static int sum(int [] array)
	{
		int sum=0;
		for(int i=0;i<array.length;i++)
		{
			sum += array[i];
		}
		return sum;
	}
	public static void main(String[] args) 
	{
		int[] A = {2};
		int[] B = {1,3};
		int temp_A;
		int temp_B;
		int flag=0;
		
		for(int i=0;i<A.length;i++)
		{
			temp_A = A[i];
			for(int j=0;j<B.length;j++)
			{
				temp_B = B[j];
				A[i]=temp_B;
				B[j]=temp_A;
				if(sum(A) == sum(B))
				{
					System.out.println(temp_A+" "+temp_B);
					flag=1;
					break;
				}
				else
				{
					A[i]=temp_A;
					B[j]=temp_B; 
				}
				
			}
			if(flag==1)
				break;
		}
	}
}

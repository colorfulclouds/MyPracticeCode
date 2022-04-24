

public class time {
	
	public static int _7_days(int[] number , int[] flag , int threshold) 
	{
		int max = -1;
		int max_i = -1;
		int max_j = -1;
		
		for(int i=0 ; i<number.length-1 ; i++)
		{
			for(int j=i+1 ; j<number.length ; j++)
			{
				if(flag[i] != -1 && flag[j] != -1)
				{
					int max_value_1 = 10*number[i] + number[j];
					if(max_value_1>max && max_value_1<=threshold)
					{
						max = max_value_1;
						max_i = i;
						max_j = j;
					}
					
					int max_value_2 = 10*number[j] + number[i];
					if(max_value_2>max && max_value_2<=threshold)
					{
						max = max_value_2;
						max_i = i;
						max_j = j;
					}
				}
			}
		}
		
		if(max_i != -1 || max_j != -1) // && || ÏàÍ¬
		{
			flag[max_i] = -1;
			flag[max_j] = -1;
		}
		
		return max;
	}
	
	public static void _happy_function(int[] number) 
	{
		int[] flag = {0,0,0,0,0,0};
		int[] thresholds = {23,59,59};
		
		String[] result = new String[3];
		
		int max;
		
		for(int i=0 ; i<thresholds.length ; i++)
		{
			max = _7_days(number , flag , thresholds[i]);
			
			if(-1 == max)
			{
				System.out.println("invalid");
				System.exit(-1);
			}
			else
			{
				if(10 > max)
					result[i] = "0" + String.valueOf(max); 
				else
					result[i] = String.valueOf(max);
			}
		}
		
		for(int i=0 ; i<result.length ; i++)
		{
			System.out.print(result[i]);
			
			if(i < result.length-1)
				System.out.print(":");
		}
	}
	
	public static void main(String[] args) 
	{
		int[] number = {2,5,4,1,2,3};//{9,9,9,9,9,9};//{0,2,3,0,5,6};//
		
		_happy_function(number);
		
	}
}

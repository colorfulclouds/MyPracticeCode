import java.util.Arrays;

public class coin {

	public static void main(String[] args) {
		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };
		//int[] res = 
		nextGE(nums1, nums2);
		
		//System.out.println(res.toString().toCharArray());
	}

	public static int find(int []num , int number)
	{
		for(int i=0;i<num.length;i++)
			if(num[i]== number )
				return i;
		
		return -1;
	}
	
	public static void nextGE(int[] nums1, int[] nums2) {
		int length1 = nums1.length; //3
		int length2 = nums2.length; //4
		
		int search;

		for (int i = 0; i < length1; i++) 
		{
			search = find(nums2, nums1[i]);
			
			if(search < 0)
			{
				System.out.println(-1);
				continue;
			}
			
			int j=search+1;
			
			//System.out.println(nums2[search]);
			
			for (; j < length2; j++) 
			{
				//System.out.println(nums2[j] +" " +nums1[search]);
				
				if(nums2[j] > nums1[i])
				{
					System.out.println(nums2[j]);
					break;
				}
			}
			
			if(j>=length2)
				System.out.println(-1);
		
		}
		
		
		//return nums1;
	}
}

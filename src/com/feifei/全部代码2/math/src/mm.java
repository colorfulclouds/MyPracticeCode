

import java.util.Arrays;

public class mm {

	public static void main(String[] args) {
		int[] nums1 = { 2,4 };
		int[] nums2 = { 1, 2,3,4};
		int[] res = nextGE(nums1, nums2);
		
		for(int i=0;i<nums1.length;i++)
			System.out.println(nums1[i]);
	}

	public static int find(int[] nums, int number) {
		for(int i=0;i<nums.length;i++)
			if(number == nums[i])
				return i;
		
		return -1;
	}
	
	public static int[] nextGE(int[] nums1, int[] nums2) {
		int length1 = nums1.length;
		int length2 = nums2.length;
		int search;

		for (int i = 0; i < length1; i++) {

			//search = Arrays.binarySearch(nums2, nums1[i]) + 1;
			
			search = find(nums2, nums1[i]) + 1;

			int j=search;
			
			for (; j < length2; j++) {
				if (j <= 0) {
					nums1[i] = -1;
					break;
				}else if(nums2[j] > nums1[i]){
					nums1[i] = nums2[j];
					break;
				}
			}
			
			//上面将循环中的j移动到外面 在这里可以利用j的值来判断 是否没有找到大于的（这样写 一种常用的手段）
			if(j>=length2)
				//没有找见大于的
				nums1[i]=-1;
		}
		

		return nums1;
	}
}

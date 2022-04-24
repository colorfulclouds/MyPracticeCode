import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class q1 {

	/**
	 * @param args
	 */
	
	public static boolean real(long[] arr)
	{
		long re = arr[0] - arr[1];
		
		for(int i=0;i<arr.length-1;i++)
			if(arr[i] - arr[i+1] != re )
				return false;
		
		
		return true;
		
	}
	
	
	public static int pro(long [] arr , int idx , int count , ArrayList<Integer> res)
	{
		if(idx == arr.length)
		{
			if(real(arr))
				res.add(count);
			
			return real(arr) == true ? count : 0;
		}
		
		long tmp = arr[idx];
		arr[idx] = tmp+1;
		int count_plus = pro(arr , idx+1 , count+1 , res);
		arr[idx] = tmp;
		
		arr[idx] = tmp;
		int count_zero = pro(arr , idx+1 , count , res);
		arr[idx] = tmp;
		
		arr[idx] = tmp-1;
		int count_minus= pro(arr , idx+1 , count+1 , res);
		arr[idx] = tmp;
	
		return -1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String[] arr_str = str.split(" ");
		
		long [] arr = new long[n];
		
		for(int i=0;i<n;i++)
			arr[i] = Long.valueOf(arr_str[i]).longValue();
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		int result = pro(arr , 0 , 0 , res);
		
		Collections.sort(res);
		
		if(res.size() == 0)
			System.out.println(-1);
		else
			System.out.println(res.get(0));
		
		
	}

}

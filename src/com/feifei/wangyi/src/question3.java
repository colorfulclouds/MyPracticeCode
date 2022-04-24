
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class question3 {

	/**
	 * @param args
	 */
	
	public static int max(List<Integer> list)
	{
		Collections.sort(list);
		int maxnum = list.get(list.size()-1);
		
		return maxnum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		String str = sc.nextLine();
		String [] strs = str.split(" ");
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			list.add(Integer.parseInt(strs[i]));
			int max = max(list);
			
			
			System.out.print(max);
			
			if(i<n-1)
			{
				System.out.print(" ");
			}
		}
	}

}

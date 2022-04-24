import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
1 3 7 4 10
2 1 5 8 9
*/
public class question1 {

	
	public static boolean compareto(ArrayList<Integer> list)
	{
		for(int i=0;i<list.size() -1 ;i++)
			if(list.get(i) > list.get(i+1))
				return false;
		
		return true;
	}
	
	public static int compare(ArrayList<Integer> list)
	{
		for(int i=0 ; i<list.size() -1 ;i++)
			if(list.get(i) > list.get(i+1))
				return i+1;
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String in1 = sc.nextLine();
		String [] a1 = in1.split(" ");
		
		String in2 = sc.nextLine();
		String [] a2 = in2.split(" ");
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		for(int i=0;i<a1.length;i++)
			list1.add(Integer.parseInt(a1[i]));
		
		for(int i=0;i<a2.length;i++)
			list2.add(Integer.parseInt(a2[i]));
		
		Collections.sort(list2);
		
		int x = compare(list1);
		
		int temp = list1.get(x);
		
		
		//System.out.print(x);
		
		
		for(int i=list2.size()-1;i>0;i--)
		{
			list1.set(x, list2.get(i));
			
			if(compareto(list1))
			{
				for(int j=0;j<list1.size();j++)
				{
					System.out.print(list1.get(j));
					
					if(j<list1.size()-1)
						System.out.print(" ");
				}
				
				return ;
			}
			list1.set(x, temp);
		}
		System.out.print("NO");
		
		
		
	}

}

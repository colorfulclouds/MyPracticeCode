import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class q1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int nn = sc.nextInt();
		
		for(int i=0;i<nn;i++)
		{
			int n = sc.nextInt();
			HashMap<Integer , Integer> map = new HashMap<>();
			
			for(int j=0;j<n;j++)
			{
				int c=sc.nextInt();
				if(map.containsKey(c))
				{
					map.put(c , map.get(c)+1);
				}
				else
				{
					map.put(c, 1);
				}
			}
			boolean b = false;
		
			for(Map.Entry<Integer, Integer> num : map.entrySet())
			{
				if(num.getValue()>n/2)
				{
					b = true;
					break;
				}
			}
			
			if(b)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
		
		
	}

}



30
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
10
aaaaaa
aaaa
aaaaaaaaaaaaa
aaaaaa
a
aaaaaaaaaaab
bbbaaa
aababa
avavavavav
aaaaaaaaaaaaaaaaaaaaaaaaaaaaab

import java.util.Scanner;


public class question1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String [] decomp = str.split("@");
		
		String all = decomp[0];
		if(decomp.length == 1)
		{
			System.out.print(all);
			return ;
		}
		
		String used = decomp[1];
		
		String [] all_one = all.split(",");
		String [] used_one = used.split(","); //a:1 b:2
		
		char [] all_char = new char[all_one.length];
		int [] all_count = new int[all_one.length];
		
		for(int i=0;i<all_one.length;i++)
		{
			String [] element = all_one[i].split(":");
			
			
			all_char[i] = element[0].charAt(0);
			all_count[i] = Integer.parseInt(element[1]);
		}
		
		for(int i=0;i<used_one.length;i++)
		{
			String [] element = used_one[i].split(":");
			
			for(int j=0;j<all_char.length;j++)
			{
				if(all_char[j] == element[0].charAt(0))
				{
					all_count[j] -= Integer.parseInt(element[1]);
					break ;
				}
			}
		}
		
		int pos=0;
		for(int i=0;i<all_count.length;i++)
		{
			if(all_count[i] != 0)
				pos=i;
		}
		
		for(int i=0;i<all_char.length;i++)
		{
			if(all_count[i] != 0)
			{
				System.out.print(all_char[i]+":"+all_count[i]);
				
				if(i<pos)
					System.out.print(",");
			}
		}
		
		
	}

}

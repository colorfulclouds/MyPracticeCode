import java.util.Scanner;


public class question3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		while(sc.hasNext())
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			
			String [] sn = new String[n];
			
			for(int i=0;i<n;i++)
			{
				sn[i]=sc.nextLine();
				
			}
			
			for(int k=0;k<m;k++)
			{
				int count=0;
				for(int i=0;i<n;i++)
				{
					for(int j=0;j<n&&j!=i;j++)
					{
						String [] smm = sn[k].split(" ");
						String [] sn1 = sn[i].split(" ");
						String [] sn2 = sn[j].split(" ");
						
						if(sn1[2].equals(smm[1])&& !sn2[2].equals(smm[1]) && Math.abs(Integer.parseInt(sn1[0])-Integer.parseInt(sn2[0]))<Integer.parseInt(smm[0])&&sn1[1].equals(sn2[1])&&!sn1[3].equals(sn2[3]))
						{
							count++;
						}
					}
				}
				
				System.out.println(count);
			}
		}
	}

}

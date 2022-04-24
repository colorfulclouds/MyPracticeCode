import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 
public class question2 {

	/**
	 * @param args
	 */
	
	private static void Solution(int people , int times)
	{
		int [][] jihe=new int[times+1][people];
		
		for(int i=1;i<=times;i++)
		{
			if(i==1)
			{
				jihe[i][(1+people)%people]=1;
				jihe[i][(-1+people)%people] = 1;
				
				continue;
			}
			
			for(int j=0;j<people;j++)
			{
				jihe[i][j]=jihe[i-1][(people-j-1)%people]+jihe[i-1][(people-j+1)%people];
			}
		}
		System.out.println(jihe[times][0]);
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while( (str=br.readLine()) != null)
		{
			String [] temp=str.split(" ");
			int people=Integer.valueOf(temp[0]);
			int times=Integer.valueOf(temp[1]);
			Solution(people , times);
		}
	}

}

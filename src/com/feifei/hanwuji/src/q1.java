import java.util.Scanner;

public class q1
{
    
    public static boolean comp(int [] pala , int [] palb)
    {
        if(pala[1] > palb[1])
        	return true;
        
        if(pala[1] == palb[1])
        {
        	if(pala[2] > palb[2])
        		return true;
        	
        	if(pala[2] == palb[2])
        	{
        		if(pala[0]>palb[0])
        			return true;
        		
        		if(pala[0] == palb[0])
        		{
        			if(pala[3] > palb[3])
        				return true;
        		}
        	}
        }
        
        return false;
    }
    
    
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int [][] mat = new int[N][4];
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<4;j++)
                mat[i][j] = sc.nextInt();
        }
        
        int [] tmp = new int[4];
        
        for(int i=0;i<N-1;i++)
        {
        	for(int j=N-1 ; j>i;j--)
        	{
        		if(comp(mat[i] , mat[j]))
        		{
        			tmp = mat[i];
        			mat[i] = mat[j];
        			mat[j] = tmp;
        		}
        	}
        }
        
        for(int i=0;i<N;i++)
        {
            System.out.print(mat[i][1]+" "+mat[i][2]+" "+mat[i][0]+" "+mat[i][3]);
            
            System.out.println();
        }
        
    }
}
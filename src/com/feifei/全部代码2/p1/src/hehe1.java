import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class hehe1 
{
	public static List<String> get() 
	{
		Scanner sc = new Scanner(System.in);
        int count;
        count = sc.nextInt();
        String [] strs = new String[count];
        sc = new Scanner(System.in);
        for(int i=0;i<count;i++)
        {
        	String s = new String(sc.nextLine());
        	strs[i] = s;
        }
        List<String> result=new ArrayList<>();
        for(int i=0;i<count;i++)
        {
            String s = strs[i];
            if(s.length()%8 !=0 )
                s = s + "00000000";
            while(s.length()>=8)
            {
                //System.out.println(s.substring(0, 8));
                result.add(s.substring(0, 8));
                s = s.substring(8);
            }
        }
        return result;
	}
	public static void main(String[] args)
	{
		List<String> result = get();
		
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));
    }
}


public class yuan {
	public static void main(String[] args) 
	{
		int N=1;
		int t=(int) Math.floor( Math.sqrt((N*N)/2) );
		
		int count=t*t*4;
		
		if( (N-t) == 2)
			count += ((2*t)*4);
		
		System.out.println( count ) ;
	}
}

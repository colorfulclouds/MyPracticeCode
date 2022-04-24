package hello;

public class smile {

	public static void main(String[] args) {
		
		mythead t = new mythead();
		
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		
		//System.out.println("sum:"+t.sum);
		
	}
	
	

}

class mythead implements Runnable{
	
	int index = 1;
	int sum = 0;
	String str = new String("");
	public void run(){
		
		while(true){
			
		/*	synchronized (str) {
			
				if(index <= 100){
					
					//try{Thread.sleep(5);} catch(Exception e){}
					sum += index;
					index ++;
					System.out.println(Thread.currentThread().getName()+":"+sum);
					
				}
				
			
			}//syn	*/
			
			add();
			
		}//while
			
		
	}
	
	public synchronized void add(){
		
		if(index <= 100){
			
			//try{Thread.sleep(5);} catch(Exception e){}
			sum += index;
			index ++;
			System.out.println(Thread.currentThread().getName()+":"+sum);
			
		}
		
	}
	
	/*int tickets = 100;
	String str = new String("");
	public void run(){
		
		while(true){
			synchronized (str) {
				if(tickets>0){
				try{Thread.sleep(10);} catch(Exception e){}
				System.out.println(Thread.currentThread().getName()+":"+tickets--);
				
			}
			}
			
			
		}
		
	}*/
	
	
}
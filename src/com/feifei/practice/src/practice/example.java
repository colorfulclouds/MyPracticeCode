package practice;



public class example   extends Thread{
	
	public static void main(String[] args) {
	
		
		testthread t = new testthread();
		//tt.setDaemon(true);
		//Thread tt = new Thread(t);
		/*
		 * tt.start();
		int index = 0;
		while(true){
		
			if(index++ ==100)
			
				try{
					tt.join(10000);
					}
			catch(Exception e){
				
			};
				
			System.out.println("main:"+Thread.currentThread().getName());
		}
		*/
		
		new Thread(t).start();
		try{Thread.sleep(10);} catch(Exception e){}
		t.str = "method";
		new Thread(t).start();
		//new Thread(t).start();
		//new Thread(t).start();
		
		
	}

}

	
class testthread /*extends Thread/*/implements Runnable
{
	int tickets = 100;
	String str = new String("");
	
	public void run(){
		
		if(str.equals("method")){
			
			while(true){
			sale();
		
			}
		}
		
		else
		{
		while(true){
			
			synchronized (str) {
				
			if(tickets>0){
				
				synchronized (this) { }
				
				try{Thread.sleep(10);}catch(Exception e){}
				
				System.out.println(Thread.currentThread().getName()+" is saling tickeks:"+tickets--);

			}
			
			}//synchronized
		}
		
		}
		
	}
	
	public synchronized void  sale(){

			if(tickets>0){
				
				synchronized (str) {
				}
				System.out.print("sale():");
				try{Thread.sleep(10);}catch(Exception e){}
				System.out.println(Thread.currentThread().getName()+" is saling tickeks:"+tickets--);

			}
			
		
		
	}
	
}

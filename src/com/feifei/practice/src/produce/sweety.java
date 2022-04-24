package produce;

 class _producer implements Runnable{

	 Q q;
	 
	 public _producer(Q q) {
		// TODO 自动生成的构造函数存根
		 this.q = q;
	}
	 
	public void run(){
		
		int i = 0;
		
		
		
		while(true){
			
			
			/*synchronized (q) {
				
				if(q.bFull == true)
						try{q.wait();} catch(Exception e){}
			
				if(i == 0){
					
					q.name = "zhangsan";
					
					try{Thread.sleep(1);} catch(Exception e){}
					
					q.sex = "male";
					
				}
				
				else{
					
					q.name = "lisi";
					q.sex = "female";
					
				}
				q.bFull = true;
				q.notify();
			}//syn*/
			if(i == 0)
				q.put("zhangsan", "male");
			else
				q.put("lisi", "female");
			i = (i+1)%2;
		}
		
	}

}

 class _customer implements Runnable {
	
	 Q q;
	 
	
	 
	 public _customer(Q q) {
		// TODO 自动生成的构造函数存根
		 this.q = q;
		 
	}
	 
	public void run(){
		
		while(true){
			/*synchronized (q) {
				
				
				if(q.bFull == false)
					try{q.wait();} catch(Exception e){}
				System.out.println(q.name+" : "+q.sex);
				q.bFull = false;
				q.notify();
			}//syn
			*/
			q.get();
		}
		
	}
	
}

 class Q{
	 
	 String name = "unknown";
	 String sex = "unknown";
	 boolean bFull = false;
	 
	 public synchronized void put(String name,String sex){
		 
		 if(bFull == true)
			 try{wait();}catch(Exception e){}
		 this.name = name;
		 try{Thread.sleep(1);} catch(Exception e){}
		 this.sex = sex;
		 bFull = true;
		 notify();
		 
	 }
	 
	 public synchronized void get(){
		 
		 if(bFull == false)
			 try{wait();} catch(Exception e){}
		 
		 System.out.println(name+" : "+sex);
		 
		 bFull = false;
		 notify();
		 
	 }
	 
 }
 
 
 class threadtest implements Runnable{
	 
	 private boolean flag = true;
	 
	 public void modify(){
		 
		 flag = false;
		 
	 }
	 
	 public void run(){
		 
		 while(flag)
			 System.out.println(Thread.currentThread().getName()+"   run");
		 
	 }
	 
 }
 
  class produce{
	 
	 public static void main(String [] args){
		 
		 /*Q q =new Q();
		 
		 new Thread(new _producer(q)).start();
		 
		 new Thread(new _customer(q)).start();
		 */
		 
		 threadtest tt = new threadtest();
		 
		 
		 new Thread(tt).start();
		  int i = 1;
		 
		  
		  /*try {
			Thread.currentThread().sleep(1);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
		}
		*/
		 
		 for(;i<=100;i++){
			 
			 if(i == 50)
				 tt.modify();
			 System.out.println("main:"+i);
			 
		 }
		 
	 }
	 
 }
 
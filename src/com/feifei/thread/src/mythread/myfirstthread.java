package mythread;


class counter{
	
	private int icounter = 0;
	
	public synchronized void add(){
		
		icounter ++;
		System.out.println(icounter);
		
	}
	
}

class counterthread extends Thread{
	
	private counter _counter;
	private int times;
	private boolean canrun = true;
	
	public counterthread(counter _counter,int times){
		
		this._counter = _counter;
		this.times = times;
		
	}
	
	public void stopthread(){
		
		canrun = false;
		
	}
	
	public void run(){
		
		int i = 0;
		while(canrun){
			
			_counter.add();
			Thread.yield();
			
			if(++i>=times)
				break;
			
		}
		
	}
	
	
}

public class myfirstthread {

	public static void main(String [] args){
		
		counter c = new counter();
		counterthread t1 = new counterthread(c, 100);
		counterthread t2 = new counterthread(c, 100);
		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
}

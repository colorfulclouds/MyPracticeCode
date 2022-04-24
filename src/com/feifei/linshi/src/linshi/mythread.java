package linshi;

class bank{
	int money;

	public  void put(int money){
	
			this.money = money;
		
	}
	
	public synchronized int get(){
		
		return money;
	}
}

class father extends Thread{

	bank q;
	
	public father(bank q) {

		this.q = q;
		
	}

	public void run() {
		
		for(int i = 0;i<10;i++){
			q.put(1000);
			System.out.println("father put "+ 1000 +"$");
			System.out.println("son get "+q.get()+"$");
		}
	}
	
	
}

public class mythread {

	public static void main(String[] args) {
	
		bank q = new bank();
		father p =new father(q);
		
		p.start();
	}
}


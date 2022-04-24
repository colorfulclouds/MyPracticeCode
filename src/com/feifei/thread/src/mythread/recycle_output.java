package mythread;

/**
 * 子线程打印10次
 * 主线程打印100次
 * 上面两个过程执行50次
 * @author 蓝色的心情
 *
 */
public class recycle_output {

	public static void main(String[] args) {
		
		ssub p = new ssub();
		
		new Thread(new Runnable() {
			
			public void run() {
				
				for(int i = 1;i<=50;i++){
					p.sub(i);
				}
				
			}
		}).start();
		
		for(int i = 1;i<=50;i++){
			p.main(i);
		}
		
	}
}

class ssub{
	
	private boolean b = true;
	
	public synchronized void sub(int i){
		
		while(!b){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		for(int j = 1;j<=10;j++){
			System.out.println("sub thread :"+j);
		}
		b = false;
		this.notify();
	}
	
	public synchronized void main(int i){
		
		while(b){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		for(int j = 1;j<=100;j++){
			System.out.println("main thread :"+j);
		}
		
		b = true;
		this.notify();
	}
}

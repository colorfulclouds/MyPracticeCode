package mythread;

/**
 * ���̴߳�ӡ10��
 * ���̴߳�ӡ100��
 * ������������ִ��50��
 * @author ��ɫ������
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
				// TODO �Զ����ɵ� catch ��
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
				// TODO �Զ����ɵ� catch ��
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

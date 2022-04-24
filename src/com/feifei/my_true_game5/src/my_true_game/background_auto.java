package my_true_game;

public class background_auto implements Runnable{

	mypanel _mypanel;
	
	public background_auto(mypanel _mypanel) {

		this._mypanel = _mypanel;
		
	}
	
	public void run() {

		while(true){
			
			try {
				
				Thread.sleep(3);//子弹速度、飞行速度
			} 
			catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			_mypanel.repaint();
		}
		
	}

}

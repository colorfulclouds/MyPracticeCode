package my_true_game;
import java.io.FileInputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class background_music implements Runnable{

	   public AudioStream as;
	   public boolean playSound = true;
	 
	   public void run() {
	     playBackgroundSound();
	   }
	 
	   private void playBackgroundSound() {
		   
	     while (this.playSound)
	     {
	       try {
	    	   
	         this.as = new AudioStream(new FileInputStream("rl.mid"));
	         AudioPlayer.player.start(this.as);
	         Thread.sleep(152000L);//˯һ����������ű�������
	         
	       } 
	       catch (Exception e) {
	         e.printStackTrace();
	       }
	     }
	   }
	 
}

package my_true_game;

import java.io.FileInputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class player_audio {
	
	public AudioStream as;
	String audio_file = null;
	   
	public player_audio(String audio_file){
		
		this.audio_file = audio_file;
	}
	
	public void playBackgroundSound() {
		   
	       try {
	    	   
	         this.as = new AudioStream(new FileInputStream(audio_file));
	         AudioPlayer.player.start(this.as);
	       
	         
	       } 
	       catch (Exception e) {
	         e.printStackTrace();
	       }
	     
	   }
}

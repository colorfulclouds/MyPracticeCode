package my_true_game;

import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class operate_plane2 implements Runnable{

	
	static boolean lock_plane2_life = true;//为玩家二的飞机加生命锁，为撞机做准备
	
	player_audio plane2_gun = null;//发子弹声音
	mypanel plane2_panel;
	//玩家二飞机初始位置
	static int plane2_x = 250;
	static int plane2_y = 600;
	
	bullet[] plane2_bullet_box = new bullet[100];//玩家二飞机弹夹
	static int plane2_bullet_no = 0;
	
	JFrame f;
	
	BufferedImage plane2_image = null;
	
	public operate_plane2(mypanel plane2_panel,JFrame f) {

		plane2_gun = new player_audio("gun.wav");//初始化发子弹声音
		
		this.plane2_panel = plane2_panel;
		this.f = f;
		
		try {
			plane2_image = ImageIO.read(new FileInputStream("plane2.png"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		f.addKeyListener(new KeyAdapter(){

			private boolean []choose = new boolean[]{false,false,false,false};
			
			private boolean bullet = false;
			public void keyPressed(KeyEvent e){
				
				switch (e.getKeyCode()) {
				//玩家一的飞机监听
				case KeyEvent.VK_D:
					choose[0] = true;
					break;

				case KeyEvent.VK_A:
					choose[1] = true;
					break;
					
				case KeyEvent.VK_W:
					choose[2] = true;
					break;
					
				case KeyEvent.VK_S:
					choose[3] = true;
					break;
			
				case KeyEvent.VK_R:
//					plane2_gun.playBackgroundSound();//不能放在这里 否则飞机撞机 死亡后 还能发出发射子弹的声音
					bullet = true;
					break;
				//子弹按钮	
				case KeyEvent.VK_1:
					operate_plane2.plane2_x = mypanel.plane2_x = 250;
					operate_plane2.plane2_y = mypanel.plane2_y = 600;
					operate_plane2.lock_plane2_life = true;//开锁 能够操作玩家二飞机
					break;
					
				default:
					break;
				}

				
				//这样的语句
				if(operate_plane2.lock_plane2_life){//锁住撞机后的一切操作
					
				if(choose[0] == true){
					plane2_x+=10;
					if(plane2_x >= 0 &&plane2_x <= 345)//345是因为飞机还有自己的大小
						plane2_panel.plane2_move(plane2_x, plane2_y);
					else
						plane2_x-=10;
				}
			
				if(choose[1] == true){
					plane2_x-=10;
					if(plane2_x >= 0 && plane2_x <= 345)
						plane2_panel.plane2_move(plane2_x, plane2_y);
					else
						plane2_x+=10;
				}

				if(choose[2] == true){
					plane2_y-=10;
					if(plane2_y >= 0 && plane2_y <= 620)//620是因为飞机有自己的大小
						plane2_panel.plane2_move(plane2_x, plane2_y);
					else
						plane2_y+=10;
				}

				if(choose[3] == true){
					plane2_y+=10;
					if(plane2_y >= 0 && plane2_y <= 620)
						plane2_panel.plane2_move(plane2_x, plane2_y);
					else
						plane2_y-=10;
				}
				
				System.out.println("玩家二坐标:"+"["+plane2_x+","+plane2_y+"]");
				
				if(bullet){
					plane2_bullet_box[plane2_bullet_no] = new bullet(plane2_x + 19, plane2_y);
					plane2_gun.playBackgroundSound();
					plane2_panel.bullet2_move(bullet, plane2_bullet_box[plane2_bullet_no], plane2_bullet_no);
					plane2_bullet_no++;
					if(plane2_bullet_no == 100)
						plane2_bullet_no = 0;
				
				}
				}
				//这里不用放置“这样的语句” 在这里全是false所以放了也不会执行
			}
			
			public void keyReleased(KeyEvent e){
				
				switch (e.getKeyCode()) {
				
				case KeyEvent.VK_D:
					
					choose[0] = false;
					break;

				case KeyEvent.VK_A:
					choose[1] = false;
					break;
					
				case KeyEvent.VK_W:
					choose[2] = false;
					break;
					
				case KeyEvent.VK_S:
					choose[3] = false;
					break;
					
				case KeyEvent.VK_R:
					bullet = false;
					break;
					
					
				default:
					break;

				}
				//这里不用放置“这样的语句” 在这里全是false所以放了也不会执行
			}
		});
	}

	//获得玩家二飞机的所占区域 为碰撞做准备
	public Rectangle get_plane2_rec(){
		
		return new Rectangle(plane2_x, plane2_y, 50, 50);
	}
		
	public void run() {

		//plane2_panel.repaint();
		
	}

}

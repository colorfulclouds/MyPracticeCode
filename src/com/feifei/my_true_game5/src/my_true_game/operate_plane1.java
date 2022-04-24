package my_true_game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class operate_plane1 implements Runnable{

	player_audio plane1_gun = null;//发子弹声音
	
	static boolean lock_plane1_life = true;//为玩家一的飞机加生命锁，为撞机做准备
	
	mypanel plane1_panel;
	//玩家一飞机初始位置
	static int plane1_x = 100;
	static int plane1_y = 600;

	bullet[] plane1_bullet_box = new bullet[100];//玩家一飞机的弹夹(100发子弹)
	static int plane1_bullet_no = 0;
	
	JFrame f;
	BufferedImage plane1_image = null;
	
	public operate_plane1(mypanel plane1_panel,JFrame f) {

		plane1_gun = new player_audio("gun.wav");//初始化发子弹声音
		
		this.plane1_panel = plane1_panel;
		this.f = f;
		
		try {
			plane1_image = ImageIO.read(new FileInputStream("plane1.png"));
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
					case KeyEvent.VK_RIGHT:
						
						choose[0] = true;
						break;

					case KeyEvent.VK_LEFT:
						choose[1] = true;
						break;
						
					case KeyEvent.VK_UP:
						choose[2] = true;
						break;
						
					case KeyEvent.VK_DOWN:
						choose[3] = true;
						break;
					//子弹按钮
					case KeyEvent.VK_NUMPAD0:
//						plane1_gun.playBackgroundSound();//不能放在这里 否则飞机撞机 死亡后 还能发出发射子弹的声音
						bullet = true;
						break;
						
					case KeyEvent.VK_NUMPAD9://玩家一的复活
						
						operate_plane1.plane1_x = mypanel.plane1_x = 100;
						operate_plane1.plane1_y = mypanel.plane1_y = 600;
						
						operate_plane1.lock_plane1_life = true;//开锁 能够操作玩家一飞机
						
						break;
						
					default:
						break;
					}
					
				//这样的语句
			if(operate_plane1.lock_plane1_life){//锁住撞机后的一切操作
					
				
				if(choose[0] == true){
					plane1_x+=10;
					if(plane1_x >= 0 && plane1_x <= 345)//345是因为飞机还有自己的大小
						plane1_panel.plane1_move(plane1_x, plane1_y);
					else
						plane1_x-=10;
				}
				if(choose[1] == true){
					plane1_x-=10;
					if(plane1_x >= 0 && plane1_x <= 345)
						plane1_panel.plane1_move(plane1_x, plane1_y);
					else
						plane1_x+=10;
				}
				if(choose[2] == true){
					plane1_y-=10;
					if(plane1_y >= 0 && plane1_y <= 620)//620是因为飞机有自己的大小
						plane1_panel.plane1_move(plane1_x, plane1_y);
					else
						plane1_y+=10;
				}
				if(choose[3] == true){
					plane1_y+=10;
					if(plane1_y >= 0 && plane1_y <= 620)
						plane1_panel.plane1_move(plane1_x, plane1_y);
					else
						plane1_y-=10;
				}
//					System.out.println("玩家一坐标:"+"["+plane1_x+","+plane1_y+"]");//测试玩家一的飞机坐标
					
				if(bullet){
					
					plane1_bullet_box[plane1_bullet_no] = new bullet(plane1_x+19, plane1_y);
					plane1_gun.playBackgroundSound();
					System.out.println(plane1_bullet_no+"发");
					plane1_panel.bullet1_move(bullet,plane1_bullet_box[plane1_bullet_no],plane1_bullet_no);
					plane1_bullet_no++;
					if(plane1_bullet_no == 100)
						plane1_bullet_no = 0;
						
				}
				}
					
			}
			
			public void keyReleased(KeyEvent e){
				
				
					switch (e.getKeyCode()) {
					
					case KeyEvent.VK_RIGHT:
						
						choose[0] = false;
						break;

					case KeyEvent.VK_LEFT:
						choose[1] = false;
						break;
						
					case KeyEvent.VK_UP:
						choose[2] = false;
						break;
						
					case KeyEvent.VK_DOWN:
						choose[3] = false;
						break;
		
					case KeyEvent.VK_NUMPAD0:
						bullet = false;
						break;
						
					default:
						break;
					}
				
				
				//这里不用放置“这样的语句” 在这里全是false所以放了也不会执行

			}
		});

	}

	//获得玩家一飞机的所占区域 为碰撞做准备
	public Rectangle get_plane1_rec(){
		
		return new Rectangle(plane1_x, plane1_y, 50, 50);
	}
	
	
	public void run() {
		
		//plane1_panel.repaint();//背景动画效果
	}

}

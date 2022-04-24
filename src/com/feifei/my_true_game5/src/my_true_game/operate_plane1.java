package my_true_game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class operate_plane1 implements Runnable{

	player_audio plane1_gun = null;//���ӵ�����
	
	static boolean lock_plane1_life = true;//Ϊ���һ�ķɻ�����������Ϊײ����׼��
	
	mypanel plane1_panel;
	//���һ�ɻ���ʼλ��
	static int plane1_x = 100;
	static int plane1_y = 600;

	bullet[] plane1_bullet_box = new bullet[100];//���һ�ɻ��ĵ���(100���ӵ�)
	static int plane1_bullet_no = 0;
	
	JFrame f;
	BufferedImage plane1_image = null;
	
	public operate_plane1(mypanel plane1_panel,JFrame f) {

		plane1_gun = new player_audio("gun.wav");//��ʼ�����ӵ�����
		
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
					
					//���һ�ķɻ�����
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
					//�ӵ���ť
					case KeyEvent.VK_NUMPAD0:
//						plane1_gun.playBackgroundSound();//���ܷ������� ����ɻ�ײ�� ������ ���ܷ��������ӵ�������
						bullet = true;
						break;
						
					case KeyEvent.VK_NUMPAD9://���һ�ĸ���
						
						operate_plane1.plane1_x = mypanel.plane1_x = 100;
						operate_plane1.plane1_y = mypanel.plane1_y = 600;
						
						operate_plane1.lock_plane1_life = true;//���� �ܹ��������һ�ɻ�
						
						break;
						
					default:
						break;
					}
					
				//���������
			if(operate_plane1.lock_plane1_life){//��סײ�����һ�в���
					
				
				if(choose[0] == true){
					plane1_x+=10;
					if(plane1_x >= 0 && plane1_x <= 345)//345����Ϊ�ɻ������Լ��Ĵ�С
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
					if(plane1_y >= 0 && plane1_y <= 620)//620����Ϊ�ɻ����Լ��Ĵ�С
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
//					System.out.println("���һ����:"+"["+plane1_x+","+plane1_y+"]");//�������һ�ķɻ�����
					
				if(bullet){
					
					plane1_bullet_box[plane1_bullet_no] = new bullet(plane1_x+19, plane1_y);
					plane1_gun.playBackgroundSound();
					System.out.println(plane1_bullet_no+"��");
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
				
				
				//���ﲻ�÷��á���������䡱 ������ȫ��false���Է���Ҳ����ִ��

			}
		});

	}

	//������һ�ɻ�����ռ���� Ϊ��ײ��׼��
	public Rectangle get_plane1_rec(){
		
		return new Rectangle(plane1_x, plane1_y, 50, 50);
	}
	
	
	public void run() {
		
		//plane1_panel.repaint();//��������Ч��
	}

}

package my_true_game;

import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class operate_plane2 implements Runnable{

	
	static boolean lock_plane2_life = true;//Ϊ��Ҷ��ķɻ�����������Ϊײ����׼��
	
	player_audio plane2_gun = null;//���ӵ�����
	mypanel plane2_panel;
	//��Ҷ��ɻ���ʼλ��
	static int plane2_x = 250;
	static int plane2_y = 600;
	
	bullet[] plane2_bullet_box = new bullet[100];//��Ҷ��ɻ�����
	static int plane2_bullet_no = 0;
	
	JFrame f;
	
	BufferedImage plane2_image = null;
	
	public operate_plane2(mypanel plane2_panel,JFrame f) {

		plane2_gun = new player_audio("gun.wav");//��ʼ�����ӵ�����
		
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
				//���һ�ķɻ�����
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
//					plane2_gun.playBackgroundSound();//���ܷ������� ����ɻ�ײ�� ������ ���ܷ��������ӵ�������
					bullet = true;
					break;
				//�ӵ���ť	
				case KeyEvent.VK_1:
					operate_plane2.plane2_x = mypanel.plane2_x = 250;
					operate_plane2.plane2_y = mypanel.plane2_y = 600;
					operate_plane2.lock_plane2_life = true;//���� �ܹ�������Ҷ��ɻ�
					break;
					
				default:
					break;
				}

				
				//���������
				if(operate_plane2.lock_plane2_life){//��סײ�����һ�в���
					
				if(choose[0] == true){
					plane2_x+=10;
					if(plane2_x >= 0 &&plane2_x <= 345)//345����Ϊ�ɻ������Լ��Ĵ�С
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
					if(plane2_y >= 0 && plane2_y <= 620)//620����Ϊ�ɻ����Լ��Ĵ�С
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
				
				System.out.println("��Ҷ�����:"+"["+plane2_x+","+plane2_y+"]");
				
				if(bullet){
					plane2_bullet_box[plane2_bullet_no] = new bullet(plane2_x + 19, plane2_y);
					plane2_gun.playBackgroundSound();
					plane2_panel.bullet2_move(bullet, plane2_bullet_box[plane2_bullet_no], plane2_bullet_no);
					plane2_bullet_no++;
					if(plane2_bullet_no == 100)
						plane2_bullet_no = 0;
				
				}
				}
				//���ﲻ�÷��á���������䡱 ������ȫ��false���Է���Ҳ����ִ��
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
				//���ﲻ�÷��á���������䡱 ������ȫ��false���Է���Ҳ����ִ��
			}
		});
	}

	//�����Ҷ��ɻ�����ռ���� Ϊ��ײ��׼��
	public Rectangle get_plane2_rec(){
		
		return new Rectangle(plane2_x, plane2_y, 50, 50);
	}
		
	public void run() {

		//plane2_panel.repaint();
		
	}

}

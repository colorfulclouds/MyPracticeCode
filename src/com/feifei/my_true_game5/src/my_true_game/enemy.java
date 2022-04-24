package my_true_game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import java.math.*;

import javax.imageio.ImageIO;

public class enemy implements Runnable{

	player_audio plane_death = new player_audio("plane_death.wav");//�ҷ��ķɻ�ײ���о��ɻ�������
	Random rand = new Random();
	BufferedImage enemy_to_plane_image = null;//�ɻ���ײЧ��ͼ
	//�о��ɻ�
	BufferedImage enemy_image = null;
	bullet []enemy_bullet = new bullet[20];//�о����ӵ���20��
	
	int enemy_plane_flag = 0;//����������ɵĵо��ɻ�,�о��ɻ��Ƿ������ʾ
	
	int enemy_bullet_no = 0;//�о��ӵ����
	//�о��ɻ�������
	 int enemy_x;	//staticԭ������� 	�ᵼ�¶���ɻ��ٶȵ��Ӷ���ֻ��ʾһ���ɻ�  ��Ϊ�Ǿ�̬����
	 int enemy_y;	//staticԭ�������	 �ᵼ�¶���ɻ��ٶȵ��Ӷ���ֻ��ʾһ���ɻ�	��Ϊ�Ǿ�̬����
	
	/***/
	//С���ɣ���ֹ�о��ɻ��ɵ�̫��
	 int i= 1;		//staticԭ�������	 �ᵼ�¶���ɻ��ٶȵ��Ӷ���ֻ��ʾһ���ɻ�	��Ϊ�Ǿ�̬����
	/***/
	public enemy(int enemy_x,int enemy_y) {
		
		//��ʼ���о��ɻ���λ��
		this.enemy_x = enemy_x;
		this.enemy_y = enemy_y;
		
		try {
			//���صо�ͼƬ
			enemy_image = ImageIO.read(new FileInputStream("enemy.png"));
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	//Ϊ������о��ɻ���ʼλ��ʹ��(1.�о��ɻ��ڱ��ҷ��ɻ����к� ʹ�� ģ��ɻ���ըû�˵�Ч��)
	public void enemy_pos_modify(int enemy_x,int enemy_y){
		
		this.enemy_x = enemy_x;
		this.enemy_y = enemy_y;
	}
	
	//���Ƶо��ɻ�
	public void draw(Graphics g){
		
		g.drawImage(enemy_image, enemy_x, enemy_y, null);//�ɻ�x�����겻�仯 ��ֱ�� (��б�� ��������е���)//	������������� ����-20������	g.drawImage(enemy_image, enemy_x, enemy_y-20, null);
		
		//�о��ɻ����ӵ��켣(v1:�ӵ��ߵ���ֱ�� ���ҳ�ȥֱ����10��  û�з�������� || v2:��ʵ���𽥷����ӵ���Ч����)
		int enemy_bullet_dy = 0;//��һ���ӵ� ��Ե�һ���ӵ���ƫ����
		
		for(int i = 0;i<10;i++){
			
			enemy_bullet[i] = new bullet( enemy_x + 19, enemy_y+50+enemy_bullet_dy);//�ӵ�����  ��������enemy_y��Ҫ���鼸��50Ϊ��һ���ӵ���ɻ�ͷ�ľ���
			/////****//enemy_bullet[i].enemy_bullet_draw(g);																	//��仰  ����ȥ��  ��ģ���� Ϊ�о��ɻ������ӵ��Ĺ���
			enemy_bullet_dy += 20;
		
		}
		
		move(g);
	}
	
	//�о��ɻ����ƶ� �Լ�������ӵ��Ļ���
	private void move(Graphics g) {
		
		System.out.println("enemy_y.."+enemy_y);//�о��ɻ�y����
		
		//�о��ɻ�����
		enemy_y = enemy_y + (i++ +1) % 2;					//С���ɣ���ֹ�о��ɻ��ɵ�̫�죬��һ�� ͣһ�� ������ �ɻ����еĸ���
		if(enemy_y > 750){				 					//�о��ɻ��ɳ�����ʱ  ����������������
			enemy_y = -1*(int)(Math.random()*100+200);		//����о��ɻ����ֵ�y����
			enemy_x = rand.nextInt(345);					//����о��ɻ����ֵ�x����
		}
		
		
		
	}

	//��õо��ɻ�����ռ���� Ϊ��ײ��׼��
	public Rectangle get_enemy_rec(){
		
		return new Rectangle(enemy_x, enemy_y, 50, 50);
	}
	
	/*���һ�ɻ���о��ɻ���ײ*/
	public void enemy_to_plane1(Graphics g){//g�Ժ��������
		
		Rectangle plane1_rec = new Rectangle(mypanel.plane1_x, mypanel.plane1_y, 50, 50);//�����˾�̬�������ص�
		
		if(this.get_enemy_rec().intersects(plane1_rec)){
			
			try {
				enemy_to_plane_image = ImageIO.read(new FileInputStream("enemy_to_plane_image.png"));
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			};//�ɻ���ײЧ��ͼ
			
			plane_death.playBackgroundSound();//����ײ������
			g.drawImage(enemy_to_plane_image, mypanel.plane1_x, mypanel.plane1_y, null);//��ըЧ��
			operate_plane1.lock_plane1_life = false;//�ҷ����һ�ɻ���ײ�󣬾Ͳ��ܼ���ʹ���ˣ�������Ϊfalse
			mypanel.plane1_x = operate_plane1.plane1_x = -50;//�����������һ�ķɻ���������  �����Դ��
			mypanel.plane1_y = operate_plane1.plane1_y = -10;
			
		}
		System.out.println("["+mypanel.plane1_x+ ".."+mypanel.plane1_y+"]");//���Եо� �ҷ��ɻ��Ƿ���ײ����
	}
	
	/*��Ҷ��ɻ���о��ɻ���ײ*/
	public void enemy_to_plane2(Graphics g){//g�Ժ��������
		
		Rectangle plane2_rec = new Rectangle(mypanel.plane2_x, mypanel.plane2_y, 50, 50);//�����˾�̬�������ص�
		
		if(this.get_enemy_rec().intersects(plane2_rec)){
			
			try {
				enemy_to_plane_image = ImageIO.read(new FileInputStream("enemy_to_plane_image.png"));
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			};//�ɻ���ײЧ��ͼ
			
			plane_death.playBackgroundSound();//����ײ������
			g.drawImage(enemy_to_plane_image, mypanel.plane2_x, mypanel.plane2_y, null);//��ըЧ��
			
			operate_plane2.lock_plane2_life = false;//�ҷ���Ҷ��ɻ���ײ�󣬾Ͳ��ܼ���ʹ���ˣ�������Ϊfalse
			
			mypanel.plane2_x = operate_plane2.plane2_x = -50;//����������Ҷ��ķɻ���������  �����Դ��
			mypanel.plane2_y = operate_plane2.plane2_y = -10;
			
		}
		System.out.println("["+mypanel.plane1_x+ ".."+mypanel.plane1_y+"]");//���Եо� �ҷ��ɻ��Ƿ���ײ����
	}
	
	public void run() {
		
	}
	
}

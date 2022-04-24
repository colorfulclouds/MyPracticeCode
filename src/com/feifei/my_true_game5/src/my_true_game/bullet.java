package my_true_game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import java.math.*;

import javax.imageio.ImageIO;

public class bullet {

	Random rand = new Random();//����ģ�� �о��ɻ�������� ��ʧ����   	��ʵ�����������˱�����ɻ������� ���������Ӵ����ϲ��ɽ�����   �о�����һ���µķɻ����˽�����ʱ��ʹ��
	player_audio hit_enemy = new player_audio("hit_enemy.wav");//���ео��ɻ�������
	BufferedImage bullet_plane_image = null;//�ӵ���ɻ�
	
	//����ӵ�������λ��
	int plane_bullet_x; 
	int plane_bullet_y;
	
	bullet (int plane_bullet_x,int plane_bullet_y){
		
		this.plane_bullet_x = plane_bullet_x;
		this.plane_bullet_y = plane_bullet_y;
		
	}
	//��ҷɻ�ר��
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.pink);
		g.fillOval(plane_bullet_x, plane_bullet_y, 10, 10);
		g.setColor(c);
		
		bullet_move();//�ӵ����ƶ�
	}
	
	//��ҷɻ�ר��
	public void bullet_move(){
		plane_bullet_y--;
//		if(plane_bullet_y < -10)//���������� �ᵼ�»�û�дӴ�������ɹ����ĵо��ɻ������� �Ӷ���������
//			plane_bullet_y = -10;//���ᵼ�� �ӵ�һֱ���ڴ����ϱ���  �о��ɻ���û�г���  �ͱ�������
		
	}
	
	//�о��ɻ�ר��
	public void enemy_bullet_draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.white);//�о������ɫ�ӵ�
		g.fillOval(plane_bullet_x, plane_bullet_y, 10, 10);
		g.setColor(c);
		
		enemy_bullet_move();//�ӵ����ƶ�
	}
	
	//�о��ɻ�ר��  ʵ�ַ�������ӵ����Ӻÿ�   Խ��Խ�� ��ɢ��Ч��
	public void enemy_bullet_modify(){
		
		
	}
	
	//�о��ɻ�ר��
	public void enemy_bullet_move(){

		plane_bullet_y += 20;
	}
	
	/**************/
	/*���濪ʼ�����ӵ������ײ��*/
	/*************/
	
	//����ӵ�����ռ���� ->Ϊ��ײ��׼��
	public Rectangle get_bullet_rec(){
		
		return new Rectangle(plane_bullet_x,plane_bullet_y,10,10);
	}
	
	//�ӵ�������Ч����
	
	public void plane_hit_enemy(enemy enemy_member,Graphics g){//���Ǽ������(enemy_member:�о���Ա)(Graphics g ��ײ�������ײЧ��ʹ��)
		
		if(this.get_bullet_rec().intersects(enemy_member.get_enemy_rec())){
			
			try {
			bullet_plane_image = ImageIO.read(new FileInputStream("bullet_plane.png"));//ֻ�з�����ײ��ʱ�� ����ʱ����ͼƬ��Դ
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
			
			g.drawImage(bullet_plane_image, plane_bullet_x, plane_bullet_y, null);
			enemy_member.enemy_pos_modify(rand.nextInt(345), -1*(int)(Math.random()*100+200));//����ģ�� �о��ɻ�������� ��ʧ����
			hit_enemy.playBackgroundSound();//���� δ�ڴ����ڲ��ĵо��ɻ�<voice>																				  //��ʵ�����������˱�����ɻ������� ���������Ӵ����ϲ��ɽ�����   �о�����һ���µķɻ����˽���
			plane_bullet_x = 0;//С����  ><����plane������ӵ�����һֱ�����ߵ�  ���Է���0,0�� �������� ��ʵ�ӵ��������Ϸɵģ��������� ���������ѣ� �����п��԰�0�ĳɱ�Ĵ���0��ֵ���ԣ�
			plane_bullet_y = 0;//><���� �Ϳ���ʵ�� �ӵ�������˺�  �ӵ�������Ч�� 

		}
		
	}
	
	public void enemy_hit_plane(){//�о���������
		
		
	}
	
	
	/**********/
	/*�ӵ������ײ�������*/
	/**********/
}

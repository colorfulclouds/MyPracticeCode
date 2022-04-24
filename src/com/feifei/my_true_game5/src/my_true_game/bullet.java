package my_true_game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import java.math.*;

import javax.imageio.ImageIO;

public class bullet {

	Random rand = new Random();//用来模拟 敌军飞机被消灭后 消失不见   	其实是重新设置了被消灭飞机的坐标 让它继续从窗体上部飞进窗体   感觉像是一个新的飞机飞了进来的时候使用
	player_audio hit_enemy = new player_audio("hit_enemy.wav");//击中敌军飞机的声音
	BufferedImage bullet_plane_image = null;//子弹打飞机
	
	//玩家子弹所处的位置
	int plane_bullet_x; 
	int plane_bullet_y;
	
	bullet (int plane_bullet_x,int plane_bullet_y){
		
		this.plane_bullet_x = plane_bullet_x;
		this.plane_bullet_y = plane_bullet_y;
		
	}
	//玩家飞机专用
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.pink);
		g.fillOval(plane_bullet_x, plane_bullet_y, 10, 10);
		g.setColor(c);
		
		bullet_move();//子弹的移动
	}
	
	//玩家飞机专用
	public void bullet_move(){
		plane_bullet_y--;
//		if(plane_bullet_y < -10)//不这样设置 会导致还没有从窗体上面飞过来的敌军飞机被击中 从而发出声音
//			plane_bullet_y = -10;//但会导致 子弹一直存在窗体上边沿  敌军飞机还没有出现  就被击中了
		
	}
	
	//敌军飞机专用
	public void enemy_bullet_draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.white);//敌军发射白色子弹
		g.fillOval(plane_bullet_x, plane_bullet_y, 10, 10);
		g.setColor(c);
		
		enemy_bullet_move();//子弹的移动
	}
	
	//敌军飞机专用  实现发射出的子弹更加好看   越来越快 离散的效果
	public void enemy_bullet_modify(){
		
		
	}
	
	//敌军飞机专用
	public void enemy_bullet_move(){

		plane_bullet_y += 20;
	}
	
	/**************/
	/*下面开始处理子弹相关碰撞了*/
	/*************/
	
	//获得子弹的所占区域 ->为碰撞做准备
	public Rectangle get_bullet_rec(){
		
		return new Rectangle(plane_bullet_x,plane_bullet_y,10,10);
	}
	
	//子弹可以有效果了
	
	public void plane_hit_enemy(enemy enemy_member,Graphics g){//我们歼灭敌人(enemy_member:敌军成员)(Graphics g 碰撞后绘制碰撞效果使用)
		
		if(this.get_bullet_rec().intersects(enemy_member.get_enemy_rec())){
			
			try {
			bullet_plane_image = ImageIO.read(new FileInputStream("bullet_plane.png"));//只有发生碰撞的时候 才临时加载图片资源
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
			
			g.drawImage(bullet_plane_image, plane_bullet_x, plane_bullet_y, null);
			enemy_member.enemy_pos_modify(rand.nextInt(345), -1*(int)(Math.random()*100+200));//用来模拟 敌军飞机被消灭后 消失不见
			hit_enemy.playBackgroundSound();//击中 未在窗体内部的敌军飞机<voice>																				  //其实是重新设置了被消灭飞机的坐标 让它继续从窗体上部飞进窗体   感觉像是一个新的飞机飞了进来
			plane_bullet_x = 0;//小技巧  ><本来plane发射的子弹就是一直向上走的  所以放在0,0处 看不出来 其实子弹还是向上飞的（窗体外面 看不见而已） （不行可以把0改成别的大于0的值试试）
			plane_bullet_y = 0;//><这样 就可以实现 子弹消灭敌人后  子弹不见的效果 

		}
		
	}
	
	public void enemy_hit_plane(){//敌军歼灭我们
		
		
	}
	
	
	/**********/
	/*子弹相关碰撞处理完成*/
	/**********/
}

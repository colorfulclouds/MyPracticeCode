package my_true_game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import java.math.*;

import javax.imageio.ImageIO;

public class enemy implements Runnable{

	player_audio plane_death = new player_audio("plane_death.wav");//我方的飞机撞到敌军飞机的声音
	Random rand = new Random();
	BufferedImage enemy_to_plane_image = null;//飞机相撞效果图
	//敌军飞机
	BufferedImage enemy_image = null;
	bullet []enemy_bullet = new bullet[20];//敌军的子弹夹20发
	
	int enemy_plane_flag = 0;//用于随机生成的敌军飞机,敌军飞机是否持续显示
	
	int enemy_bullet_no = 0;//敌军子弹编号
	//敌军飞机的坐标
	 int enemy_x;	//static原来有这个 	会导致多个飞机速度叠加而且只显示一个飞机  因为是静态变量
	 int enemy_y;	//static原来有这个	 会导致多个飞机速度叠加而且只显示一个飞机	因为是静态变量
	
	/***/
	//小技巧，防止敌军飞机飞得太快
	 int i= 1;		//static原来有这个	 会导致多个飞机速度叠加而且只显示一个飞机	因为是静态变量
	/***/
	public enemy(int enemy_x,int enemy_y) {
		
		//初始化敌军飞机的位置
		this.enemy_x = enemy_x;
		this.enemy_y = enemy_y;
		
		try {
			//加载敌军图片
			enemy_image = ImageIO.read(new FileInputStream("enemy.png"));
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	//为了随机敌军飞机初始位置使用(1.敌军飞机在被我方飞机击中后 使用 模拟飞机被炸没了的效果)
	public void enemy_pos_modify(int enemy_x,int enemy_y){
		
		this.enemy_x = enemy_x;
		this.enemy_y = enemy_y;
	}
	
	//绘制敌军飞机
	public void draw(Graphics g){
		
		g.drawImage(enemy_image, enemy_x, enemy_y, null);//飞机x的坐标不变化 走直线 (走斜线 走随机线有点难)//	本来是这个样子 但是-20忘记了	g.drawImage(enemy_image, enemy_x, enemy_y-20, null);
		
		//敌军飞机的子弹轨迹(v1:子弹走的是直线 而且出去直接是10颗  没有发射的现象 || v2:《实现逐渐发射子弹的效果》)
		int enemy_bullet_dy = 0;//后一个子弹 相对第一个子弹的偏移量
		
		for(int i = 0;i<10;i++){
			
			enemy_bullet[i] = new bullet( enemy_x + 19, enemy_y+50+enemy_bullet_dy);//子弹问题  可能这里enemy_y需要多检查几次50为第一个子弹与飞机头的距离
			/////****//enemy_bullet[i].enemy_bullet_draw(g);																	//这句话  不能去掉  它模拟了 为敌军飞机制造子弹的功能
			enemy_bullet_dy += 20;
		
		}
		
		move(g);
	}
	
	//敌军飞机的移动 以及发射的子弹的绘制
	private void move(Graphics g) {
		
		System.out.println("enemy_y.."+enemy_y);//敌军飞机y坐标
		
		//敌军飞机飞行
		enemy_y = enemy_y + (i++ +1) % 2;					//小技巧，防止敌军飞机飞的太快，飞一下 停一下 看起来 飞机飞行的更慢
		if(enemy_y > 750){				 					//敌军飞机飞出窗体时  进行重新设置坐标
			enemy_y = -1*(int)(Math.random()*100+200);		//随机敌军飞机出现的y坐标
			enemy_x = rand.nextInt(345);					//随机敌军飞机出现的x坐标
		}
		
		
		
	}

	//获得敌军飞机的所占区域 为碰撞做准备
	public Rectangle get_enemy_rec(){
		
		return new Rectangle(enemy_x, enemy_y, 50, 50);
	}
	
	/*玩家一飞机与敌军飞机碰撞*/
	public void enemy_to_plane1(Graphics g){//g以后可能有用
		
		Rectangle plane1_rec = new Rectangle(mypanel.plane1_x, mypanel.plane1_y, 50, 50);//利用了静态变量的特点
		
		if(this.get_enemy_rec().intersects(plane1_rec)){
			
			try {
				enemy_to_plane_image = ImageIO.read(new FileInputStream("enemy_to_plane_image.png"));
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			};//飞机相撞效果图
			
			plane_death.playBackgroundSound();//播放撞机声音
			g.drawImage(enemy_to_plane_image, mypanel.plane1_x, mypanel.plane1_y, null);//爆炸效果
			operate_plane1.lock_plane1_life = false;//我方玩家一飞机被撞后，就不能继续使用了，把锁置为false
			mypanel.plane1_x = operate_plane1.plane1_x = -50;//把死亡的玩家一的飞机隐藏以来  给人以错觉
			mypanel.plane1_y = operate_plane1.plane1_y = -10;
			
		}
		System.out.println("["+mypanel.plane1_x+ ".."+mypanel.plane1_y+"]");//测试敌军 我方飞机是否碰撞测试
	}
	
	/*玩家二飞机与敌军飞机碰撞*/
	public void enemy_to_plane2(Graphics g){//g以后可能有用
		
		Rectangle plane2_rec = new Rectangle(mypanel.plane2_x, mypanel.plane2_y, 50, 50);//利用了静态变量的特点
		
		if(this.get_enemy_rec().intersects(plane2_rec)){
			
			try {
				enemy_to_plane_image = ImageIO.read(new FileInputStream("enemy_to_plane_image.png"));
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			};//飞机相撞效果图
			
			plane_death.playBackgroundSound();//播放撞机声音
			g.drawImage(enemy_to_plane_image, mypanel.plane2_x, mypanel.plane2_y, null);//爆炸效果
			
			operate_plane2.lock_plane2_life = false;//我方玩家二飞机被撞后，就不能继续使用了，把锁置为false
			
			mypanel.plane2_x = operate_plane2.plane2_x = -50;//把死亡的玩家二的飞机隐藏以来  给人以错觉
			mypanel.plane2_y = operate_plane2.plane2_y = -10;
			
		}
		System.out.println("["+mypanel.plane1_x+ ".."+mypanel.plane1_y+"]");//测试敌军 我方飞机是否碰撞测试
	}
	
	public void run() {
		
	}
	
}

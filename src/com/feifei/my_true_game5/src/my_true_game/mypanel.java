package my_true_game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class mypanel extends JPanel {

	
	static int y = 0;//重置图片的打印
	
	//敌军资料
	enemy [] enemy_plane = new enemy[10];//敌军飞机 	15后面用
	static int enemy_plane_no = 0;//敌军飞机编号   之前前面
	Random rand = new Random();
	
	int flag = 0;//用来标记离散的敌军飞机
	//int []enemy_plane_flag = new int[]{0,0,0,0,0,0,0,0,0,0};//用于随机生成的敌军飞机,敌军飞机是否持续显示 	将次成员变量移动至enemy类中    用来持续不断的生成敌军飞机 以及敌军飞机飞出窗体外销毁对象
	//敌军全部资料
	//敌军资料

	//两个玩家的初始位置
	static int plane1_x = 100;
	static int plane1_y = 600;
	static int plane2_x = 250;
	static int plane2_y = 600;
	
	//各种图片资源
	BufferedImage image = null;//背景图片
	//两个玩家的飞机
	BufferedImage plane1_image = null;
	BufferedImage plane2_image = null;
	
	boolean bullet1_sure = false;
	boolean bullet2_sure = false;
	
	//玩家一飞机的弹夹
	bullet[] plane1_bullet_box = new bullet[100];//玩家一飞机的弹夹(100发子弹)
	static int plane1_bullet_no = 0;
	
	//玩家二飞机的弹夹
	bullet[] plane2_bullet_box = new bullet[100];//玩家二飞机的弹夹(100发子弹)
	static int plane2_bullet_no = 0;
		
	//构造方法，第一次很卡的原因就是  每次循环都进行初始化
	public mypanel() {
		
		
		//敌军飞机的初始化随机位置(10)架
		/***/
		for(int i = 0;i<10;i++)
			enemy_plane[i] = new enemy(rand.nextInt(345), -1*(int)(Math.random()*100+200));//这种随机会导致子弹直接出来了-1*rand.nextInt(300)//345为飞机的极限x位置    	-300为飞机初始的位置（y坐标）
		/***/
		
		try {
			
			image = ImageIO.read(new FileInputStream("background.jpg"));
			plane1_image = ImageIO.read(new FileInputStream("plane1.png"));
			plane2_image = ImageIO.read(new FileInputStream("plane2.png"));
			
		} 
		catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	//玩家一飞机的移动
	public void plane1_move(int plane1_x,int plane1_y){
		this.plane1_x = plane1_x;
		this.plane1_y = plane1_y;
	}
	
	//玩家二飞机的移动
	public void plane2_move(int plane2_x,int plane2_y){
		this.plane2_x = plane2_x;
		this.plane2_y = plane2_y;
	}
	
	//玩家一子弹的移动
	public void bullet1_move(boolean bullet1_sure,bullet plane1_bullet,int plane1_bullet_no){
		
		this.bullet1_sure = bullet1_sure;
		this.plane1_bullet_no = plane1_bullet_no;
		if(bullet1_sure){
			
			plane1_bullet_box[plane1_bullet_no] = plane1_bullet;
			
		}
		
	}
	
	//玩家二子弹的移动
	public void bullet2_move(boolean bullet2_sure,bullet plane2_bullet,int plane2_bullet_no){
			
		this.bullet2_sure = bullet2_sure;
		this.plane2_bullet_no = plane2_bullet_no;
		if(bullet2_sure){
			
			plane2_bullet_box[plane2_bullet_no] = plane2_bullet;
			
		}
		
	}

	
	public void paint(Graphics g){
		
		//背景图片在自动运动
		g.drawImage(image, 0, y,null);
		//控制背景图片动静与否
		y -= 5;
		if(y == -20000)//图片到完后 重新打印
			y = 0;
		
		
		
		//两个飞机的运动
		g.drawImage(plane1_image, plane1_x, plane1_y,null);
		
		g.drawImage(plane2_image, plane2_x, plane2_y,null);
		
		//敌军飞机的自动运动
		
		/**********
		 *模拟敌军飞机 *	
		 *^(*￣(oo)￣)^
		 *********/
		//flag第一遍先设置那些敌军飞机要一直重绘  第二遍 就不断的刷新重绘敌军飞机图片
		if(flag == 0)
//		for(enemy_plane_no = 0;enemy_plane_no<10;enemy_plane_no++)//10个敌军飞机
			for(enemy_plane_no = 0;enemy_plane_no<5;enemy_plane_no++)//5个敌军飞机
//			if((rand.nextInt(10)) % 2 == 1)//和上面的那个for结合使用    随机产生敌军飞机数量
				enemy_plane[enemy_plane_no].enemy_plane_flag = 1;
		
		
		//下一次就不进行上面的语句了   （其实上面的语句可以删除）
		flag = 1;
		
		for(int i = 0;i<10;i++)//这里不用更改i<10  有下面的if限定 不 不会绘制不该绘制的敌军飞机==1
			if(enemy_plane[i].enemy_plane_flag == 1){
				
				enemy_plane[i].draw(g);
				enemy_plane[i].enemy_to_plane1(g);//利用静态变量的特点(与玩家一飞机相撞)
				enemy_plane[i].enemy_to_plane2(g);//利用静态变量的特点(与玩家二飞机相撞)
//				System.out.println("["+plane1_x+ ".."+plane1_y+"]");//测试玩家一飞机坐标
//				System.out.println("["+plane2_x+ ".."+plane2_y+"]");//测试玩家一飞机坐标			
			}	
				
		
		/**********
		 *模拟敌军飞机 *	
		 *^(*￣(oo)￣)^
		 *********/
		
		//玩家一发射的子弹
		//这里处理的是发的最后一颗子弹的前一些子弹
		if(plane1_bullet_no>0){//将前面的子弹也打印
			for(int i = plane1_bullet_no - 1;i>=0;i--){
				plane1_bullet_box[i].draw(g);
				//看发射出去的子弹是否命中敌军飞机
				for(int j = 0;j<5;j++){
					plane1_bullet_box[i].plane_hit_enemy(enemy_plane[j], g);//子弹打住敌军飞机
					
				}
					
			}
				
		}
		//这里处理的是发射的第一颗子弹.
		if(bullet1_sure){
			
			plane1_bullet_box[plane1_bullet_no].draw(g);
			
			//消灭敌军飞机使用
			//第一颗子弹发射后 也要特殊处理   也可以消灭一个敌人
			for(int j = 0;j<5;j++)
				plane1_bullet_box[plane1_bullet_no].plane_hit_enemy(enemy_plane[j], g);
	
		}
		
		//玩家二发射的子弹
		if(plane2_bullet_no>0){//将前面的子弹也打印
			for(int i = plane2_bullet_no - 1;i>=0;i--){
				plane2_bullet_box[i].draw(g);
				//看发射出去的子弹是否命中敌军飞机
				for(int j = 0;j<5;j++){
					plane2_bullet_box[i].plane_hit_enemy(enemy_plane[j], g);
				}
					
			}
				
		}
		
		if(bullet2_sure){
			
			plane2_bullet_box[plane2_bullet_no].draw(g);
			//消灭敌军飞机使用
			//第一颗子弹发射后 也要特殊处理   也可以消灭一个敌人
			for(int j = 0;j<5;j++)
				plane2_bullet_box[plane2_bullet_no].plane_hit_enemy(enemy_plane[j], g);
	
		}
	}

}

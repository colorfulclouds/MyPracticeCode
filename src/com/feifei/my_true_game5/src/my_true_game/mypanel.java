package my_true_game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class mypanel extends JPanel {

	
	static int y = 0;//����ͼƬ�Ĵ�ӡ
	
	//�о�����
	enemy [] enemy_plane = new enemy[10];//�о��ɻ� 	15������
	static int enemy_plane_no = 0;//�о��ɻ����   ֮ǰǰ��
	Random rand = new Random();
	
	int flag = 0;//���������ɢ�ĵо��ɻ�
	//int []enemy_plane_flag = new int[]{0,0,0,0,0,0,0,0,0,0};//����������ɵĵо��ɻ�,�о��ɻ��Ƿ������ʾ 	���γ�Ա�����ƶ���enemy����    �����������ϵ����ɵо��ɻ� �Լ��о��ɻ��ɳ����������ٶ���
	//�о�ȫ������
	//�о�����

	//������ҵĳ�ʼλ��
	static int plane1_x = 100;
	static int plane1_y = 600;
	static int plane2_x = 250;
	static int plane2_y = 600;
	
	//����ͼƬ��Դ
	BufferedImage image = null;//����ͼƬ
	//������ҵķɻ�
	BufferedImage plane1_image = null;
	BufferedImage plane2_image = null;
	
	boolean bullet1_sure = false;
	boolean bullet2_sure = false;
	
	//���һ�ɻ��ĵ���
	bullet[] plane1_bullet_box = new bullet[100];//���һ�ɻ��ĵ���(100���ӵ�)
	static int plane1_bullet_no = 0;
	
	//��Ҷ��ɻ��ĵ���
	bullet[] plane2_bullet_box = new bullet[100];//��Ҷ��ɻ��ĵ���(100���ӵ�)
	static int plane2_bullet_no = 0;
		
	//���췽������һ�κܿ���ԭ�����  ÿ��ѭ�������г�ʼ��
	public mypanel() {
		
		
		//�о��ɻ��ĳ�ʼ�����λ��(10)��
		/***/
		for(int i = 0;i<10;i++)
			enemy_plane[i] = new enemy(rand.nextInt(345), -1*(int)(Math.random()*100+200));//��������ᵼ���ӵ�ֱ�ӳ�����-1*rand.nextInt(300)//345Ϊ�ɻ��ļ���xλ��    	-300Ϊ�ɻ���ʼ��λ�ã�y���꣩
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
	
	//���һ�ɻ����ƶ�
	public void plane1_move(int plane1_x,int plane1_y){
		this.plane1_x = plane1_x;
		this.plane1_y = plane1_y;
	}
	
	//��Ҷ��ɻ����ƶ�
	public void plane2_move(int plane2_x,int plane2_y){
		this.plane2_x = plane2_x;
		this.plane2_y = plane2_y;
	}
	
	//���һ�ӵ����ƶ�
	public void bullet1_move(boolean bullet1_sure,bullet plane1_bullet,int plane1_bullet_no){
		
		this.bullet1_sure = bullet1_sure;
		this.plane1_bullet_no = plane1_bullet_no;
		if(bullet1_sure){
			
			plane1_bullet_box[plane1_bullet_no] = plane1_bullet;
			
		}
		
	}
	
	//��Ҷ��ӵ����ƶ�
	public void bullet2_move(boolean bullet2_sure,bullet plane2_bullet,int plane2_bullet_no){
			
		this.bullet2_sure = bullet2_sure;
		this.plane2_bullet_no = plane2_bullet_no;
		if(bullet2_sure){
			
			plane2_bullet_box[plane2_bullet_no] = plane2_bullet;
			
		}
		
	}

	
	public void paint(Graphics g){
		
		//����ͼƬ���Զ��˶�
		g.drawImage(image, 0, y,null);
		//���Ʊ���ͼƬ�������
		y -= 5;
		if(y == -20000)//ͼƬ����� ���´�ӡ
			y = 0;
		
		
		
		//�����ɻ����˶�
		g.drawImage(plane1_image, plane1_x, plane1_y,null);
		
		g.drawImage(plane2_image, plane2_x, plane2_y,null);
		
		//�о��ɻ����Զ��˶�
		
		/**********
		 *ģ��о��ɻ� *	
		 *^(*��(oo)��)^
		 *********/
		//flag��һ����������Щ�о��ɻ�Ҫһֱ�ػ�  �ڶ��� �Ͳ��ϵ�ˢ���ػ�о��ɻ�ͼƬ
		if(flag == 0)
//		for(enemy_plane_no = 0;enemy_plane_no<10;enemy_plane_no++)//10���о��ɻ�
			for(enemy_plane_no = 0;enemy_plane_no<5;enemy_plane_no++)//5���о��ɻ�
//			if((rand.nextInt(10)) % 2 == 1)//��������Ǹ�for���ʹ��    ��������о��ɻ�����
				enemy_plane[enemy_plane_no].enemy_plane_flag = 1;
		
		
		//��һ�ξͲ���������������   ����ʵ�����������ɾ����
		flag = 1;
		
		for(int i = 0;i<10;i++)//���ﲻ�ø���i<10  �������if�޶� �� ������Ʋ��û��Ƶĵо��ɻ�==1
			if(enemy_plane[i].enemy_plane_flag == 1){
				
				enemy_plane[i].draw(g);
				enemy_plane[i].enemy_to_plane1(g);//���þ�̬�������ص�(�����һ�ɻ���ײ)
				enemy_plane[i].enemy_to_plane2(g);//���þ�̬�������ص�(����Ҷ��ɻ���ײ)
//				System.out.println("["+plane1_x+ ".."+plane1_y+"]");//�������һ�ɻ�����
//				System.out.println("["+plane2_x+ ".."+plane2_y+"]");//�������һ�ɻ�����			
			}	
				
		
		/**********
		 *ģ��о��ɻ� *	
		 *^(*��(oo)��)^
		 *********/
		
		//���һ������ӵ�
		//���ﴦ����Ƿ������һ���ӵ���ǰһЩ�ӵ�
		if(plane1_bullet_no>0){//��ǰ����ӵ�Ҳ��ӡ
			for(int i = plane1_bullet_no - 1;i>=0;i--){
				plane1_bullet_box[i].draw(g);
				//�������ȥ���ӵ��Ƿ����ео��ɻ�
				for(int j = 0;j<5;j++){
					plane1_bullet_box[i].plane_hit_enemy(enemy_plane[j], g);//�ӵ���ס�о��ɻ�
					
				}
					
			}
				
		}
		//���ﴦ����Ƿ���ĵ�һ���ӵ�.
		if(bullet1_sure){
			
			plane1_bullet_box[plane1_bullet_no].draw(g);
			
			//����о��ɻ�ʹ��
			//��һ���ӵ������ ҲҪ���⴦��   Ҳ��������һ������
			for(int j = 0;j<5;j++)
				plane1_bullet_box[plane1_bullet_no].plane_hit_enemy(enemy_plane[j], g);
	
		}
		
		//��Ҷ�������ӵ�
		if(plane2_bullet_no>0){//��ǰ����ӵ�Ҳ��ӡ
			for(int i = plane2_bullet_no - 1;i>=0;i--){
				plane2_bullet_box[i].draw(g);
				//�������ȥ���ӵ��Ƿ����ео��ɻ�
				for(int j = 0;j<5;j++){
					plane2_bullet_box[i].plane_hit_enemy(enemy_plane[j], g);
				}
					
			}
				
		}
		
		if(bullet2_sure){
			
			plane2_bullet_box[plane2_bullet_no].draw(g);
			//����о��ɻ�ʹ��
			//��һ���ӵ������ ҲҪ���⴦��   Ҳ��������һ������
			for(int j = 0;j<5;j++)
				plane2_bullet_box[plane2_bullet_no].plane_hit_enemy(enemy_plane[j], g);
	
		}
	}

}

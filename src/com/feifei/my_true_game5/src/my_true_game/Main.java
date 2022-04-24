/*
 * 5.30>运动的背景，飞机能够控制 ，能困在边界
 * 5.31>飞机能够发射子弹，能连续发射
 * 6.1>制造敌人，敌人能够无规律，随机的出现
 * 6.2>碰撞，子弹碰敌人，我们碰敌人
 */
package my_true_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;


public class Main {
		
	public static void main(String [] args){
		
		//播放背景音乐线程
		background_music b = new background_music();
		new Thread(b).start();
		//顶级容器相关设置
		JFrame f = new JFrame();
		ImageIcon mw_icon = new ImageIcon("enemy.png");
		
		f.setTitle("Fight for the earth!");
		f.setSize(400,700);
		f.setIconImage(mw_icon.getImage());//窗口图标
		f.setLocationRelativeTo(null);//屏幕居中显示
		f.setResizable(false);//不让用户改变界面尺寸
		

		mypanel _mypanel = new mypanel();
		_mypanel.setLayout(null);
		f.setContentPane(_mypanel);
		
		//背景图片的移动线程
		background_auto b_a = new background_auto(_mypanel);
		new Thread(b_a).start();
	
		//玩家一的飞机线程
		operate_plane1 op1 = new operate_plane1(_mypanel,f);
		new Thread(op1).start();
		
		//玩家二的飞机线程
		operate_plane2 op2 = new operate_plane2(_mypanel,f);
		new Thread(op2).start();
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}

/*
 * 5.30>�˶��ı������ɻ��ܹ����� �������ڱ߽�
 * 5.31>�ɻ��ܹ������ӵ�������������
 * 6.1>������ˣ������ܹ��޹��ɣ�����ĳ���
 * 6.2>��ײ���ӵ������ˣ�����������
 */
package my_true_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;


public class Main {
		
	public static void main(String [] args){
		
		//���ű��������߳�
		background_music b = new background_music();
		new Thread(b).start();
		//���������������
		JFrame f = new JFrame();
		ImageIcon mw_icon = new ImageIcon("enemy.png");
		
		f.setTitle("Fight for the earth!");
		f.setSize(400,700);
		f.setIconImage(mw_icon.getImage());//����ͼ��
		f.setLocationRelativeTo(null);//��Ļ������ʾ
		f.setResizable(false);//�����û��ı����ߴ�
		

		mypanel _mypanel = new mypanel();
		_mypanel.setLayout(null);
		f.setContentPane(_mypanel);
		
		//����ͼƬ���ƶ��߳�
		background_auto b_a = new background_auto(_mypanel);
		new Thread(b_a).start();
	
		//���һ�ķɻ��߳�
		operate_plane1 op1 = new operate_plane1(_mypanel,f);
		new Thread(op1).start();
		
		//��Ҷ��ķɻ��߳�
		operate_plane2 op2 = new operate_plane2(_mypanel,f);
		new Thread(op2).start();
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}

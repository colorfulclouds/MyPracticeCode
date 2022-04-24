package shuanghuanchong;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankClient extends Frame {

    private static final long serialVersionUID = 1L;
    private int X = 50, Y = 50;
    private int GAME_WIDTH = 800;
    private int GAME_HEIGHT = 600;
    private Image offScreenImage;

    public static void main(String[] args) {
        TankClient tc = new TankClient();
        tc.launchFrame();
    }


    public void update(Graphics g) {
        //1.�õ�����ͼ��
        if(this.offScreenImage == null) {
            this.offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        //2.�õ�����ͼ��Ļ���
        Graphics gOffScreen = this.offScreenImage.getGraphics();
        //3.���ƻ���ͼ��
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.GREEN);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        //4.����paint(),������ͼ��Ļ��ʴ���
        paint(gOffScreen);
        //5.�ٽ��˻���ͼ��һ���Ի浽������Ļ��Graphics���󣬼��÷�������ġ�g����
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(X, Y, 30, 30);
        g.setColor(c);
        Y += 5;
    }

    public void launchFrame() {
        this.setBounds(100, 100, GAME_WIDTH, GAME_HEIGHT);
        this.setBackground(Color.GREEN);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
        this.setTitle("TankWar");
        this.setResizable(false);
        this.setVisible(true);
        new Thread(new PaintThread()).start();
    }

    class PaintThread implements Runnable {

        public void run() {
            while (true) {
                repaint();
                
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
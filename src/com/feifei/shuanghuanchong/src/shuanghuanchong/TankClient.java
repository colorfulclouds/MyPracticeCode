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
        //1.得到缓冲图像
        if(this.offScreenImage == null) {
            this.offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        //2.得到缓冲图像的画笔
        Graphics gOffScreen = this.offScreenImage.getGraphics();
        //3.绘制缓冲图像
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.GREEN);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        //4.调用paint(),将缓冲图象的画笔传入
        paint(gOffScreen);
        //5.再将此缓冲图像一次性绘到代表屏幕的Graphics对象，即该方法传入的“g”上
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
package java_studio;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class java_studio_{

	
	int xpoints[] = {30,200,30,200,30};
	int ypoints[] = {30,30,200,200,30};
	
	
	public class my extends JPanel{
		public void paintComponent(Graphics g){
			
			int width;
			int height;
			
			width = getWidth();
			height = getHeight();
			g.setColor(Color.pink);
			//g.drawLine(0, 150, 300, 300);
			//g.drawLine(0, 150, 300, 300);
			
			//g.setColor(Color.BLUE);
			//g.drawRect(2, 7, 400, 500);
			//g.fillRect(2, 7, 400, 500);
			
			//g.setColor(Color.red);
			//g.drawOval(10, 10, 140,70);
			g.fillOval(0, 0, width,height);
			//g.drawArc(160, 120, 140, 80, 180, 180);
			//g.fillArc(160, 120, 140, 80, 180, 180);
			
			//g.setColor(Color.green);
			//g.drawPolygon(xpoints,ypoints,xpoints.length);
			//g.fillPolygon(xpoints,ypoints,xpoints.length);
		}
		
	}
	
	public static void main(String [] args){
		
		JFrame main_frame = new JFrame("java_studio");
		my main_panel = new java_studio_().new my();
		
		main_frame.setSize(710,710);
		main_frame.getContentPane().add(main_panel);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setVisible(true);
		
		
	}
	
}

package setimage;

import javax.swing.*;

public class _setimage {
	
	public static void main(String [] args){
		
		JFrame mainframe = new JFrame("image");
		JLabel mainlabel = new JLabel();
		JScrollPane mainpane = new JScrollPane(mainlabel);
		ImageIcon img = new ImageIcon("C:\\Users\\dell1\\Pictures\\Camera Roll\\±ÚÖ½\\2.jpg");
		mainlabel.setIcon(img);
		mainframe.add(mainpane);
		
		mainframe.setSize(300, 300);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setVisible(true);
		
		
	}

}

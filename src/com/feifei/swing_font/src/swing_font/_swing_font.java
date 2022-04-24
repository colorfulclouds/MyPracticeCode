package swing_font;

import java.awt.*;

import javax.swing.*;

public class _swing_font {

	private JFrame mainframe;
	private JList namelist;
	private JScrollPane namespane;
	
	public _swing_font(){
	
		mainframe = new JFrame("get system font");
		
		GraphicsEnvironment eq = GraphicsEnvironment.getLocalGraphicsEnvironment();//获取GraphicsEnvironment类型对象的引用
		
		String []availablefonts = eq.getAvailableFontFamilyNames();
		
		namelist = new JList(availablefonts);
		
		namespane = new JScrollPane(namelist);
		
		mainframe.add(namespane);
		
		mainframe.setSize(300, 300);
		
		mainframe.setVisible(true);
		
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	public static void main(String[] args) {

		new _swing_font();
	}

}

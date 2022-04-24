package swing_setfont;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class _swing_setfont implements ActionListener{

	private JFrame mainframe;
	private JComboBox namebox,stylebox;
	private JTextField sizetext;
	private JLabel fontlabel;
	private JButton showbtn;
	private JPanel panell;
	
	public _swing_setfont(){
		
		mainframe = new JFrame("show font given");
		GraphicsEnvironment eq = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		String [] availablefonts = eq.getAvailableFontFamilyNames();
		
		namebox = new JComboBox(availablefonts);
		namebox.setEditable(false);
		namebox.setSelectedItem("宋体");
		
		String [] style = {"正常","粗体","斜体","粗斜体"};
		stylebox = new JComboBox(style);
		stylebox.setEditable(false);
		
		sizetext = new JTextField("12");
		sizetext.setColumns(4);
		
		fontlabel = new JLabel("字体示例");
		
		showbtn = new JButton("显示字体");
		showbtn.addActionListener(this);
		
		
		panell = new JPanel();
		panell.setLayout(new FlowLayout());
		
		panell.add(namebox);
		panell.add(stylebox);
		panell.add(sizetext);
		
		mainframe.add(panell,BorderLayout.NORTH);
		mainframe.add(fontlabel,BorderLayout.CENTER);
		mainframe.add(showbtn,BorderLayout.SOUTH);
		mainframe.setSize(300,300);
		mainframe.setVisible(true);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		int styleindex = stylebox.getSelectedIndex();//匹配第一项选择
		String fontstr = (String)namebox.getSelectedItem();//返回当前选项
		int fontsize = Integer.parseInt(sizetext.getText());
		
		Font userfont = new Font(fontstr,styleindex,fontsize);
		fontlabel.setFont(userfont);
		
	}
	public static void main(String[] args) {
		new _swing_setfont();
		
		
	}

	

}

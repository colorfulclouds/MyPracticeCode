import java.awt.Color;
import java.awt.Frame;

class MyFrame extends Frame {
	private static final long serialVersionUID = 1L;
	static int id = 0;

	MyFrame(String a, int x, int y, int w, int h, Color color) {
		super(a);
		setBackground(color);
		setLayout(null);
		setBounds(x, y, w, h);
		setVisible(true);
		this.addWindowListener(new My());
	}
}
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class My extends WindowAdapter{                       //�رհ�ť
	public void windowClosing(WindowEvent e){
		setVisible(false);
		System.exit(0);
	}
	private void setVisible(boolean b) {

			}
}
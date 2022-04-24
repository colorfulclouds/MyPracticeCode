import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import javax.swing.JPopupMenu;  
import javax.swing.JToggleButton;  
import javax.swing.SwingConstants;  
public class 下拉菜单 extends JToggleButton{  
    private JPopupMenu menu;  
    private static int i=0;  
    public 下拉菜单(){  
        super();  
        this.setText("▲");  
        this.setHorizontalTextPosition(SwingConstants.RIGHT );  
        addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent arg0) {  
                if(isSelected()){  
                    setText("▼");  
                    menu.show(下拉菜单.this, 0, 下拉菜单.this.getHeight());  
                }else{  
                    setText("▲");  
                    menu.setVisible(false);  
                }  
                  
            }  
        });  
    }  
    public 下拉菜单(final String label){  
        super(label);  
        this.setText("▲ "+label);  
        this.setHorizontalTextPosition(SwingConstants.RIGHT );  
        addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent arg0) {  
                if(isSelected()){  
                    setText("▼"+label);  
                    menu.show(下拉菜单.this, 0, 下拉菜单.this.getHeight());  
                }else{  
                    setText("▲"+label);  
                    menu.setVisible(false);  
                }  
            }  
        });  
    }  
    public void addMenu(JPopupMenu menu){  
        this.menu=menu;  
    }  
}  
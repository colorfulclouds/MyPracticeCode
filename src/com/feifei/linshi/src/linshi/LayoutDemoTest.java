package linshi;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class LayoutDemoTest extends JFrame {
    private JPanel pane = null; // 主要的JPanel，该JPanel的布局管理将被设置成CardLayout
    private JPanel p = null; // 放按钮的JPanel
    private CardLayout card = null; // CardLayout布局管理器
    private JButton button_1 = null; // 上一步
    private JButton button_2 = null; // 下一步

    private JPanel p_1 = null, p_2 = null; // 要切换的三个JPanel

    public LayoutDemoTest() {
        super("CardLayout Test");
//        try {
//            // 将LookAndFeel设置成Windows样式
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        /**创建一个具有指定的水平和垂直间隙的新卡片布局*/
        card = new CardLayout(5, 5);
        pane = new JPanel(card); // JPanel的布局管理将被设置成CardLayout
        p = new JPanel(); // 构造放按钮的JPanel
        button_1 = new JButton("切换");
        button_2 = new JButton("返回");

        p.add(button_1);

        p.add(button_2);
        p_1 = new JPanel();
        p_2 = new JPanel();

        p_1.setBackground(Color.RED);
        p_2.setBackground(Color.BLUE);

        p_1.add(new JLabel("JPanel_1"));
        p_2.add(new JLabel("JPanel_2"));

        pane.add(p_1, "p1");
        pane.add(p_2, "p2");

        /**下面是翻转到卡片布局的某个组件，可参考API中的文档*/
        button_1.addActionListener(new ActionListener(){ // 上一步的按钮动作
            public void actionPerformed(ActionEvent e) {
                card.show(pane,"p2");
                button_1.setEnabled(false);
                button_2.setEnabled(true);
            }
        });
        button_2.addActionListener(new ActionListener(){ // 下一步的按钮动作
            public void actionPerformed(ActionEvent e) {
//                card.next(pane);
                card.show(pane,"p1");
                button_2.setEnabled(false);
                button_1.setEnabled(true);
            }
        });

        this.getContentPane().add(pane);
        this.getContentPane().add(p, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutDemoTest();
    }

}

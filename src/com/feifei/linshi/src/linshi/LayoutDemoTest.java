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
    private JPanel pane = null; // ��Ҫ��JPanel����JPanel�Ĳ��ֹ��������ó�CardLayout
    private JPanel p = null; // �Ű�ť��JPanel
    private CardLayout card = null; // CardLayout���ֹ�����
    private JButton button_1 = null; // ��һ��
    private JButton button_2 = null; // ��һ��

    private JPanel p_1 = null, p_2 = null; // Ҫ�л�������JPanel

    public LayoutDemoTest() {
        super("CardLayout Test");
//        try {
//            // ��LookAndFeel���ó�Windows��ʽ
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        /**����һ������ָ����ˮƽ�ʹ�ֱ��϶���¿�Ƭ����*/
        card = new CardLayout(5, 5);
        pane = new JPanel(card); // JPanel�Ĳ��ֹ��������ó�CardLayout
        p = new JPanel(); // ����Ű�ť��JPanel
        button_1 = new JButton("�л�");
        button_2 = new JButton("����");

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

        /**�����Ƿ�ת����Ƭ���ֵ�ĳ��������ɲο�API�е��ĵ�*/
        button_1.addActionListener(new ActionListener(){ // ��һ���İ�ť����
            public void actionPerformed(ActionEvent e) {
                card.show(pane,"p2");
                button_1.setEnabled(false);
                button_2.setEnabled(true);
            }
        });
        button_2.addActionListener(new ActionListener(){ // ��һ���İ�ť����
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

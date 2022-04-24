package test;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        JPanel jp = new JPanel();
        frame.getContentPane().setBackground(Color.GREEN);
        
       jp.setBackground(Color.pink);
        
        JLabel label = new JLabel("123");
        jp.add(label);
        
        frame.add(jp);
        //label.setOpaque(false);
//        frame.getContentPane().add(label, BorderLayout.CENTER);
        label = new JLabel("12323");
        //label.setOpaque(false);
//        frame.getContentPane().add(label, BorderLayout.EAST);
        frame.setVisible(true);
    }
}

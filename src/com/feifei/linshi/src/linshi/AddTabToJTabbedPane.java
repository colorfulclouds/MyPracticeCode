package linshi;


import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class AddTabToJTabbedPane {

    private static void createAndShowGUI() {

        // Create and set up the window.
        final JFrame frame = new JFrame("Split Pane Example");

        // Display the window.
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set grid layout for the frame
        //frame.getContentPane().setLayout(new GridLayout(1, 1));

//        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);//窗体的最顶端
        JTabbedPane tabbedPane = new JTabbedPane();//窗体的最顶端
        
        // add tab with title
        tabbedPane.addTab("Tab 1", new JLabel("This is tab 1"));

        // add tab with title and icon
        Icon icon = new ImageIcon("icon.gif");
        tabbedPane.addTab("Tab 2", icon, new JLabel("This is tab 2"));

        // add tab with title, icon and tooltip
        String tooltip = "This is a tab";
        tabbedPane.addTab("Tab 3", icon, new JLabel("This is tab 3"), tooltip);

        // insert tab after second tab
        int index = 2;
        tabbedPane.insertTab("Tab 4", icon, new JLabel("This is tab 4"), tooltip, index);

        frame.getContentPane().add(tabbedPane);

    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

}

import java.awt.*;
import java.awt.event.*;

public class AWTListDemo extends Frame implements ActionListener {
    List os, browser;
    String msg = "";

    public void AWTLabelDemo() {
        setLayout(new FlowLayout());

        os = new List(4, true);
        browser = new List(4);

        os.add("Windows");
        os.add("Linux");
        os.add("Android");
        os.add("Mac OS");

        browser.add("Edge");
        browser.add("Firefox");
        browser.add("Chrome");

        browser.select(1);
        os.select(0);

        add(os);
        add(browser);

        os.addActionListener(this);
        browser.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        repaint();
    }

    public void paint(Graphics g) {
        int[] idx;

        msg = "Current OS: ";
        idx = os.getSelectedIndexes();

        for (int i = 0; i < idx.length; i++) {
            msg += os.getItem(i) + " ";
        }

        g.drawString(msg, 20, 120);
        msg = "Current Browser: ";
        msg += browser.getSelectedItem();
        g.drawString(msg, 20, 140);
    }

    public static void main(String[] args) {
        AWTListDemo appwin = new AWTListDemo();

        appwin.setSize(new Dimension(300, 180));
        appwin.setTitle("ListDemo");
        appwin.setVisible(true);
    }
}

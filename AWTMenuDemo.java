import java.awt.*;
import java.awt.event.*;

public class AWTMenuDemo extends Frame {
    String msg = "";
    CheckboxMenuItem debug, test;

    public AWTMenuDemo() {
        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        Menu file = new Menu("File");
        MenuItem item1, item2, item3, item4, item5;
        file.add(item1 = new MenuItem("New..."));
        file.add(item2 = new MenuItem("Open..."));
        file.add(item3 = new MenuItem("Close..."));
        file.add(item4 = new MenuItem("-"));
        file.add(item5 = new MenuItem("Quit..."));

        Menu edit = new Menu("Edit");
        MenuItem item6, item7, item8, item9;
        file.add(item6 = new MenuItem("Cut"));
        file.add(item7 = new MenuItem("Copy"));
        file.add(item8 = new MenuItem("Paste"));
        file.add(item9 = new MenuItem("-"));

        Menu sub = new Menu("Special");
        MenuItem item10, item11, item12;
        file.add(item10 = new MenuItem("First"));
        file.add(item11 = new MenuItem("Second"));
        file.add(item12 = new MenuItem("Third"));

        debug = new CheckboxMenuItem("Debug");
        edit.add(debug);
        test = new CheckboxMenuItem("Testing");
        edit.add(test);

        menuBar.add(edit);
        menuBar.add(file);
        menuBar.add(edit);

        MyMenuHandler handler = new MyMenuHandler();

        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        item4.addActionListener(handler);
        item5.addActionListener(handler);
        item6.addActionListener(handler);
        item7.addActionListener(handler);
        item8.addActionListener(handler);
        item9.addActionListener(handler);
        item10.addActionListener(handler);
        item11.addActionListener(handler);
        item12.addActionListener(handler);
        debug.addItemListener(handler);
        test.addItemListener(handler);

        item5.addActionListener((ae) -> System.exit(0));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(Window we) {
                System.exit(0);
           } 
        });
    }

    public void paint(Graphics g) {
        g.drawString(msg, 10, 220);

        if (debug.getState()) {
            g.drawString("Debug is on", 10, 240);
        } else {
            g.drawString("Debug is off", 10, 240); 
        }

        if (test.getState()) {
            g.drawString("Test is on", 10, 260);
        } else {
            g.drawString("Test is off", 10, 260); 
        }
    }

    public static void main(String[] args) {
        AWTMenuDemo appwn = new AWTMenuDemo();

        appwn.setSize(new Dimension(250, 300));
        appwn.setTitle("Menu Demo");
        appwn.setVisible(true);
    }

    class MyMenuHandler implements ActionListener, ItemListener {
        public void actionPerformed(ActionEvent ae) {
            msg = "You selected ";
            String arg = ae.getActionCommand();
            msg += arg;
            repaint();
        }

        public void itemStateChanged(ItemEvent ie) {
            repaint();
        }
    }
}

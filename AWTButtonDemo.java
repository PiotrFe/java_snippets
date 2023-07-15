import java.awt.*;
import java.awt.event.*;

public class AWTButtonDemo extends Frame implements ActionListener {
    String msg = "";
    Button yes, no, maybe;

    public AWTButtonDemo() {
        setLayout(new FlowLayout());

        yes = new Button("Yes");
        no = new Button("No");
        maybe = new Button("Maybe");

        add(yes);
        add(no);
        add(maybe);

        yes.addActionListener(this);
        no.addActionListener(this);
        maybe.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        String actionCommand = ae.getActionCommand(); // by default it's the button's label

        if (actionCommand.equals("Yes")) {
            msg = "You pressed yes.";
        } else if (actionCommand.equals("No")) {
            msg = "You pressed no.";
        } else {
            msg = "You pressed undecided.";
        }

        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
    }

    public static void main(String[] args) {
        AWTButtonDemo appwin = new AWTButtonDemo();

        appwin.setSize(new Dimension(250, 150));
        appwin.setTitle("Button Demo");
        appwin.setVisible(true);
    }
}
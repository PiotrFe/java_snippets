import java.awt.*;
import java.awt.event.*;

public class AWTCheckboxGroupDemo extends Frame implements ItemListener {
    String msg = "";
    Checkbox windows, android, linux, mac;
    CheckboxGroup group;

    public AWTCheckboxGroupDemo() {
        setLayout(new FlowLayout());
        group = new CheckboxGroup();

        windows = new Checkbox("Windows", group, true);
        android = new Checkbox("Android", group, false);
        linux = new Checkbox("Linux", group, false);
        mac = new Checkbox("Mac", group, false);

        add(windows);
        add(android);
        add(linux);
        add(mac);

        windows.addItemListener(this);
        android.addItemListener(this);
        linux.addItemListener(this);
        mac.addItemListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }

    public void paint(Graphics g) {
        msg = "Current selection: ";
        msg += group.getSelectedCheckbox().getLabel();
        g.drawString(msg, 20, 120);
    }

    public static void main(String[] args) {
        AWTCheckboxGroupDemo appwin = new AWTCheckboxGroupDemo();

        appwin.setSize(new Dimension(240, 180));
        appwin.setTitle("Group");
        appwin.setVisible(true);
    }
}

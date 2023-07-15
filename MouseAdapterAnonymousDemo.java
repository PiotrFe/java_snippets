import java.awt.*;
import java.awt.event.*;

public class MouseAdapterAnonymousDemo extends Frame {
    String msg = "";

    public MouseAdapterAnonymousDemo() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                msg = "Mouse Pressed";
                repaint();     
            }
        });
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void paint (Graphics g) {
        g.drawString(msg, 20, 80);
    }

    public static void main(String[] args) {
        MouseAdapterAnonymousDemo appwin = new MouseAdapterAnonymousDemo();

        appwin.setSize(200, 150);
        appwin.setTitle("Demo");
        appwin.setVisible(true);
    }
}

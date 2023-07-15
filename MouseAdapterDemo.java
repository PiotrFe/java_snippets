import java.awt.*;
import java.awt.event.*;

class MyMouseAdapter extends MouseAdapter {
    MouseAdapterDemo adapterDemo;

    public MyMouseAdapter(MouseAdapterDemo mouseAdapterDemo) {
        this.adapterDemo = mouseAdapterDemo;
    }

    public void mouseClicked(MouseEvent me) {
        adapterDemo.msg = "Mouse clicked";
        adapterDemo.repaint();
    }

    public void mouseDragged(MouseEvent me) {
        adapterDemo.msg = "Mouse dragged";
        adapterDemo.repaint();
    }
}

class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}

public class MouseAdapterDemo extends Frame {
    String msg = "";

    public MouseAdapterDemo() {
        addMouseListener(new MyMouseAdapter(this));
        addMouseMotionListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdapter());
    }

    public void paint(Graphics g) {
        g.drawString(msg, 20, 80);
    }

    public static void main(String[] args) {
        MouseAdapterDemo appwin = new MouseAdapterDemo();

        appwin.setSize(new Dimension(200, 150));
        appwin.setTitle("Adapter Demo");
        appwin.setVisible(true);
    }
}

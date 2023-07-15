import java.awt.*;
import java.awt.event.*;

class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}

public class KeyboardEventsDemo extends Frame implements KeyListener {
    String msg = "";
    String keyState = "";

    public KeyboardEventsDemo() {
        addKeyListener(this);
        addWindowListener(null);
    }

    public void keyPressed(KeyEvent ke) {
        keyState = "Key Down";
        repaint();
    }

    public void keyReleased(KeyEvent ke) {
        keyState = "Key Up";
        repaint();
    }

    public void keyTyped(KeyEvent ke) {
        msg += ke.getKeyChar();
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
        g.drawString(keyState, 20, 50);
    }

    public static void main(String[] args) {
        KeyboardEventsDemo appwin = new KeyboardEventsDemo();

        appwin.setSize(new Dimension(200, 150));
        appwin.setTitle("SimpleKey");
        appwin.setVisible(true);
    }
}
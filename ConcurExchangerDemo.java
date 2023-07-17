import java.io.InterruptedIOException;
import java.util.concurrent.Exchanger;

public class ConcurExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(new UseString(exchanger)).start();
        new Thread(new MakeString(exchanger)).start();
    }

}

class MakeString implements Runnable {
    Exchanger<String> exchanger;
    String str;

    MakeString(Exchanger<String> e) {
        exchanger = e;
        str = new String();
    }

    public void run() {
        char ch = 'A';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                str += ch++;
            }

            // exchange a full buffer for an empty one
            try {
                str = exchanger.exchange(str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class UseString implements Runnable {
    Exchanger<String> exchanger;
    String str;

    UseString(Exchanger<String> e) {
        exchanger = e;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {

            // exchange an empty buffer for a full one
            try {
                str = exchanger.exchange(new String());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
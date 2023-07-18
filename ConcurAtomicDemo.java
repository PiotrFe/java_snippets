import java.util.concurrent.atomic.*;

public class ConcurAtomicDemo {
    public static void main(String[] args) {
        new Thread(new AtomicThread("A")).start();
        new Thread(new AtomicThread("B")).start();
        new Thread(new AtomicThread("C")).start();
    }
}

class AtomicShared {
    static AtomicInteger ai = new AtomicInteger(0);
}

class AtomicThread implements Runnable {
    String name;

    AtomicThread(String n) {
        name = n;
    }

    public void run() {
        System.out.println("Starting " + name);

        for (int i = 0; i <= 3; i++) {
            System.out.println(name + " got: " + AtomicShared.ai.getAndSet(i));
        }
    }
}

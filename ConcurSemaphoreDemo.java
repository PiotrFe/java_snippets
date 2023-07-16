import java.util.concurrent.*;

public class ConcurSemaphoreDemo {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        new Thread(new IncrementThread(sem, "A")).start();
        new Thread(new DecrementThread(sem, "B")).start();
    }

}

class Shared {
    static int count = 0;
}

class IncrementThread implements Runnable {
    String name;
    Semaphore sem;

    IncrementThread(Semaphore s, String n) {
        sem = s;
        name = n;
    }

    public void run() {
        System.out.println("Starting " + name);

        try {
            System.out.println(name + " waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit");

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(name + " releases the permit.");
        sem.release();
    }
}

class DecrementThread implements Runnable {
    String name;
    Semaphore sem;

    DecrementThread(Semaphore s, String n) {
        sem = s;
        name = n;
    }

    public void run() {
        System.out.println("Starting " + name);

        try {
            System.out.println(name + " is waiting for a permit");
            sem.acquire();
            System.out.println(name + " gets a permit");

            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(name + " releases the permit");
        sem.release();
    }
}
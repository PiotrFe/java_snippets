import java.util.concurrent.*;

public class ConcurPhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int currentPhase;

        System.out.println("Starting");

        new Thread(new MyPhaserThread(phaser, "A")).start();
        new Thread(new MyPhaserThread(phaser, "B")).start();
        new Thread(new MyPhaserThread(phaser, "C")).start();

        // Wait for all threads to complete phase one
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " Complete");

        // Wait for all threads to complete phase two
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " Complete");

        // Wait for all threads to complete phase three
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " Complete");
    }
}

class MyPhaserThread implements Runnable {
    Phaser phaser;
    String name;

    MyPhaserThread(Phaser p, String n) {
        phaser = p;
        name = n;

        phaser.register();
    }

    public void run() {
        System.out.println("Thread " + name + " Beginning Phase One");
        phaser.arriveAndAwaitAdvance();

        // Pause to prevent jumbled output. For illustration only
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Two");
        phaser.arriveAndAwaitAdvance();

        // Pause to prevent jumbled output. For illustration only
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Three");
        phaser.arriveAndDeregister();
    }
}

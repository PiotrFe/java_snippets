import java.util.concurrent.*;

// creating a custom phaser allows to decide when to advance / shut down
class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    @Override
    protected boolean onAdvance(int p, int regParties) {
        // for illustration only
        System.out.println("Phase " + p + " completed.\n");

        if (p == numPhases || regParties == 0) {
            // returning true means phaser will close
            return true;
        }

        return false;
    }
}

public class ConcurCustomPhaserDemo {
    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser(1, 4); // phaser will close after 4 phases

        new Thread(new MyCustomPhaserThread(myPhaser, "A")).start();
        new Thread(new MyCustomPhaserThread(myPhaser, "B")).start();
        new Thread(new MyCustomPhaserThread(myPhaser, "C")).start();

        while (!myPhaser.isTerminated()) {
            myPhaser.arriveAndAwaitAdvance();
        }
        System.out.println("Phaser is terminated");
    }

}

class MyCustomPhaserThread implements Runnable {
    Phaser phaser;
    String name;

    MyCustomPhaserThread(Phaser p, String n) {
        phaser = p;
        name = n;

        phaser.register();
    }

    public void run() {
        while (!phaser.isTerminated()) {
            System.out.println("Thread " + name + " Beginning Phase " + phaser.getPhase());

            phaser.arriveAndAwaitAdvance();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

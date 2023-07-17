import java.util.concurrent.*;

public class ConcurCyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarAction());

        System.out.println("Starting");

        new Thread(new MyThreadBarrier(cyclicBarrier, "A")).start();
        new Thread(new MyThreadBarrier(cyclicBarrier, "B")).start();
        new Thread(new MyThreadBarrier(cyclicBarrier, "C")).start();
    }
}

class MyThreadBarrier implements Runnable {
    CyclicBarrier cyclicBarrier;
    String name;

    MyThreadBarrier(CyclicBarrier c, String n) {
        cyclicBarrier = c;
        name = n;
    }

    public void run() {
        System.out.println(name);

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        }
    }
}

class BarAction implements Runnable {
    public void run() {
        System.out.println("Barrier reached!");
    }
}

import java.util.concurrent.*;

public class ConsurExecutorDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch1 = new CountDownLatch(5);
        CountDownLatch countDownLatch2 = new CountDownLatch(5);
        CountDownLatch countDownLatch3 = new CountDownLatch(5);
        CountDownLatch countDownLatch4 = new CountDownLatch(5);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // other options:
        // newCachedThreadPool --> adds threads as needed but reuses threads if possible
        // newScheduledThreadPool --> creates a thread pool that supports thread
        // scheduling

        System.out.println("Starting");

        executorService.execute(new MyExecutorThread(countDownLatch1, "A"));
        executorService.execute(new MyExecutorThread(countDownLatch2, "B"));
        executorService.execute(new MyExecutorThread(countDownLatch3, "C"));
        executorService.execute(new MyExecutorThread(countDownLatch4, "D"));

        try {
            countDownLatch1.await();
            countDownLatch2.await();
            countDownLatch3.await();
            countDownLatch4.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        executorService.shutdown();
        System.out.println("Done");

    }
}

class MyExecutorThread implements Runnable {
    String name;
    CountDownLatch countDownLatch;

    MyExecutorThread(CountDownLatch c, String n) {
        countDownLatch = c;
        name = n;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            countDownLatch.countDown();
        }
    }
}
import java.util.concurrent.CountDownLatch;

public class ConcurCountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        System.out.println("Starting");

        new Thread(new MyThread(countDownLatch)).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Done");

    }
}

class MyThread implements Runnable {
    CountDownLatch countDownLatch;

    MyThread(CountDownLatch c) {
        countDownLatch = c;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            countDownLatch.countDown();
        }
    }
}
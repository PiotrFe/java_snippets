
class MyNewThread implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    MyNewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
    }

    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                
                synchronized(this) {
                    while(suspendFlag){
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}


public class MultiThreadedSuspendDemo {
    public static void main(String[] args) {
        MyNewThread ob1 = new MyNewThread("One");
        MyNewThread ob2 = new MyNewThread("Two");

        ob1.t.start();
        ob2.t.start();

        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Suspending thread one");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Resuming thread one");
            ob2.mysuspend();
            System.out.println("Suspending thread two");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Resuming thread two");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        try {
            System.out.println("Waiting for threads to finish");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread exiting");
    }
}

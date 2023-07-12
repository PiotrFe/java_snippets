class CallMe {
    void call(String msg) {
        System.out.print("(" + msg);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.print(")");
    }
}


class Caller implements Runnable {
    String msg;
    CallMe target; 
    Thread t;

    public Caller(CallMe target, String msg) {
        this.target = target;
        this.msg = msg;

        t = new Thread(this);
    }

    public void startThread() {
        t.start();
    }

    public void run() {
        synchronized(target) {
            target.call(msg);
        }
        // target.call(msg);
    }

}


public class MultiThreadedSyncDemo {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller obj1 = new Caller(target, "Hello");
        Caller obj2 = new Caller(target, "Synchronised");
        Caller obj3 = new Caller(target, "World");

        obj1.startThread();
        obj2.startThread();
        obj3.startThread();

        try {
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}

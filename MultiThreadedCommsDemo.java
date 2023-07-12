class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while(valueSet) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        this.n = n;
        System.out.println("Put: " + n);
        valueSet = true;

        notify();
    }
}

class MyProducer implements Runnable {
    Q q;
    Thread t;

    MyProducer(Q q) {
        this.q = q;
        t = new Thread(this, "Producer");
    }

    public void run() {
        int i = 0;

        while (true) {
            q.put(i++);
        }
    }
}

class MyConsumer implements Runnable {
    Q q;
    Thread t;

    MyConsumer(Q q) {
        this.q = q;
        t = new Thread(this, "Consumer");
    }

    public void run() {
        while(true) {
            q.get();
        }
    }
}


public class MultiThreadedCommsDemo {
   public static void main(String[] args) {
    
   Q q = new Q();
   MyProducer p = new MyProducer(q);
   MyConsumer c = new MyConsumer(q);

   p.t.start();
   c.t.start();
}
}

class NewThread implements Runnable {
    String name;
    Thread t;
    

    NewThread(String name) {
        this.name = name;
        t = new Thread(this, name);
    }

  
    public static NewThread createAndStart(String name) {
        NewThread newThread = new NewThread(name);

        newThread.t.start();

        return newThread;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
   
    }
}

public class MultiThreadedDemo {
    public static void main(String[] args) {
        NewThread t1 =  NewThread.createAndStart("First");
        NewThread t2 =  NewThread.createAndStart("Second");
        NewThread t3 =  NewThread.createAndStart("Third");

        t1.t.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Thread one is alive: " + t1.t.isAlive());
        System.out.println("Thread one priority: " + t1.t.getPriority());
        System.out.println("Thread two is alive: " + t2.t.isAlive());
        System.out.println("Thread two priority: " + t2.t.getPriority());
        System.out.println("Thread three is alive: " + t3.t.isAlive());
        System.out.println("Thread three priority: " + t3.t.getPriority());

        try {
            System.out.println("Waiting for threads to finish");

            t1.t.join();
            t2.t.join();
            t3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Thread one is alive: " + t1.t.isAlive());
        System.out.println("Thread two is alive: " + t2.t.isAlive());
        System.out.println("Thread three is alive: " + t3.t.isAlive());
    }   
}

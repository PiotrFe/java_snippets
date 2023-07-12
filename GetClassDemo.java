class X {
    int a;
    float b;
}

class Y extends X {
    double c;
}


public class GetClassDemo {
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();

        Class<?> clObjX;
        Class<?> clObjY;

        clObjX = x.getClass(); 
        System.out.println("x is object of type " + clObjX.getName());
        System.out.println("x's superclass is " + clObjX.getSuperclass());

        clObjY = y.getClass();
        System.out.println("y is object of type " + clObjY.getName());
        System.out.println("y's superclass is " + clObjY.getSuperclass());
    }
}

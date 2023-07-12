enum Apple {
    Jonathan, GoldenDel, RedDel, Winesap
}

public class EnumDemo {
    public static void main(String[] args) {
        Apple ap = Apple.Jonathan;
        Apple[] vals = Apple.values();
        String valsStr = null;;
        Apple red = Apple.valueOf("RedDel");

        switch(ap) {
            case Jonathan: 
                System.out.println("The name is jonathan");
                break;
            default: 
                System.out.println("Some other name");
        }

        for (Apple val : vals) {
            valsStr += val.toString() + ", ";
        }

        System.out.println("Apple values are: " + valsStr);
        System.out.println("Value of red is: " + red);
    }
}

interface TypeFuncOne<T> {
    T run(T t);
}

interface TypeFuncTwo<T> {
    T run(T t1, T t2);
}

interface GenIntTransformer {
    IntTransformer run();
}

class IntTransformer {
    static int multiplyInt(int i, int multiplier) {
        return i * multiplier;
    }

    int doubleInt(int i) {
        return i * 2;
    }
}


public class LambdaMethodRefDemo {
    public static void main(String[] args) {
        GenIntTransformer getIntTransformer = IntTransformer::new;

        IntTransformer iTrans = getIntTransformer.run();

        TypeFuncOne<Integer> doubleInt = iTrans::doubleInt;
        TypeFuncTwo<Integer> multiplyInt = IntTransformer::multiplyInt;

        int x = 10;
        int y = 20;

        int xDoubled = doubleInt.run(x);
        int xTimesY = multiplyInt.run(x, y);

        System.out.println(xDoubled);
        System.out.println(xTimesY);
    }
    
}

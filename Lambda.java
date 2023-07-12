interface NumericTest {
    boolean test(int x, int y);
}

interface SomeFunc<T> {
    T run(T t1, T t2);
}

public class Lambda {
    public static void main(String[] args) {
        NumericTest isGreaterThan = (x, y) -> x > y;
        SomeFunc<String> strConcatenator = (s1, s2) -> s1.concat(s2);
    
        int x = 5;
        int y = 4; 

        if (isGreaterThan.test(x, y)) {
            System.out.format("%d is greater than %d\n", x, y);
        } else {
            System.out.format("%d is greater than %d\n", y, x);
        }

        String s1 = "First part";
        String s2 = "Second part";
        String result = strConcatenator.run(s1, s2);

        System.out.println(result + "\n");

        String result2 = Lambda.acceptLambda(strConcatenator, result);

        System.out.println("\nResult of passing lambda function to a method:\n");
        System.out.println(result2);
    }

    static String acceptLambda(SomeFunc<String> f, String s) {
        String firstPart = "first part default ";
        return f.run(firstPart, s);
    }
}

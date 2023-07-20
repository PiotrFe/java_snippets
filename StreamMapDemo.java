import java.util.*;
import java.util.stream.*;

public class StreamMapDemo {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);

        Stream<Double> squareRootStream = myList.stream().map((a) -> Math.sqrt(a));
        double productOfSquareRoots = squareRootStream.reduce(1.0, (a, b) -> a * b);

        System.out.println(productOfSquareRoots);

    }
}

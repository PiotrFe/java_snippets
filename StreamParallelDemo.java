import java.util.*;
import java.util.stream.*;

public class StreamParallelDemo {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(17.0);
        myList.add(5.0);

        double sumOfAll = myList.parallelStream().reduce(0.0, (a, b) -> a + b, (a, b) -> a + b);
        // first arg: identity
        // second arg: accumulator
        // third arg: combinator -> combines the results from parallel streams; should
        // be associative, i.e, allow to combine partial results in any order

        System.out.println(sumOfAll);
    }
}

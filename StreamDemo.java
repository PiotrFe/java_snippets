import java.util.*;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(33);
        myList.add(56);
        myList.add(234);
        myList.add(255);
        myList.add(4);
        myList.add(17);
        myList.add(3);
        myList.add(12);
        myList.add(5);

        System.out.println("Original list: " + myList);

        // Obtain a Stream
        Stream<Integer> myStream = myList.stream();

        Optional<Integer> minVal = myStream.min(Integer::compare);

        if (minVal.isPresent()) {
            System.out.println("Minimum value: " + minVal.get());
        }

        // Obtain a stream again (min is a terminal operation that consumed the stream)
        myStream = myList.stream();

        Optional<Integer> maxVal = myStream.max(Integer::compare);

        if (maxVal.isPresent()) {
            System.out.println("Maximum value: " + minVal.get());
        }

        // Sort stream
        Stream<Integer> sortedStream = myList.stream().sorted();
        System.out.println("Sorted stream: ");

        // Display contents using forEach
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // Filter stream
        Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.println("Odd values: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // Double filter
        oddVals = myList.stream().filter((n) -> (n % 2) == 1).filter((n) -> n > 5);
        System.out.println("Odd values > 5: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
}

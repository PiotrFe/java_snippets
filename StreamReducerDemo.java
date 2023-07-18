import java.util.*;
import java.util.stream.*;

public class StreamReducerDemo {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();

        myList.add(6);
        myList.add(4);
        myList.add(4);
        myList.add(3);
        myList.add(10);
        myList.add(2);

        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a * b); // a holds current val, b next elem

        if (productObj.isPresent()) {
            System.out.println(productObj);
            int product = myList.stream().reduce(1, (a, b) -> a * b);
            System.out.println(product);
        }
    }

}

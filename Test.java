import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<? extends Number> myNums = new ArrayList<Integer>();

    }
}

class Foo {
    public List<Integer> foo(Set<CharSequence> m) {
        return new ArrayList<>();
    }
}

class Bar extends Foo {
    @Override
    public List<Integer> foo(Set<CharSequence> m) {
        return new ArrayList<>();
    }
}

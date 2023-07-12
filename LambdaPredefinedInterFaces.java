import java.util.function.*;

class IntHolder {
    int i = 0;

    void initI(int num) {
        i = num;
    }
}

public class LambdaPredefinedInterFaces {
    public static void main(String[] args) {
        UnaryOperator<String> trimmer = (s1) -> s1.trim();
        BinaryOperator<String> concatter = (s1, s2) -> s1.concat(s2);
        Consumer<IntHolder> intInitializer = holder -> holder.initI(10);
        Supplier<IntHolder> intHolderSupplier = () -> new IntHolder();
        Function<IntHolder, Integer> getSquaredIntHolderVal = (holder) -> holder.i * holder.i;
        Predicate<IntHolder> valIsEven = holder -> holder.i % 2 == 0;

        String untrimmed = "    Im untrimmed ";
        String second = " I want to be concatted";
        System.out.println(concatter.apply(trimmer.apply(untrimmed), second));


        IntHolder intHolder = intHolderSupplier.get();
        intInitializer.accept(intHolder);
        System.out.println("The value of i on intHolder is: " + intHolder.i);
        System.out.println("The squared value of i on intHolder is: " + getSquaredIntHolderVal.apply(intHolder));
        System.out.println("The value of i on intHolder is even: " + valIsEven.test(intHolder));

    }
}

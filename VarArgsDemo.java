
class IntPrinter {
    int[] arr = null;

    IntPrinter(int ...args) {
        arr = args;
    }

    void print() {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}


public class VarArgsDemo {
    public static void main(String[] args) {
        IntPrinter printer = new IntPrinter(1, 2, 3, 4, 5, 6, 7);

        printer.print();
    }
    
}

public class RuntimeDemo {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        Process p = null;

        try {
            p = r.exec("chrome");
        } catch (Exception e) {
            System.out.println("Error opening clock");
        }

        long start, end;

        start = System.currentTimeMillis();

        for (long i = 0; i < 10000000L; i++) {}

        end = System.currentTimeMillis();

        System.out.println("Elapsed time: " + (end - start));
    }


}

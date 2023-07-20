import java.util.regex.*;

public class RegexDemo {
    public static void main(String[] args) {
        Pattern pattern;
        Matcher matcher;
        boolean found;

        System.out.println("Testing Java vs Java");
        pattern = Pattern.compile("Java");
        matcher = pattern.matcher("Java");
        found = matcher.matches();
        System.out.println(found);

        System.out.println("======");

        System.out.println("Testing Java vs Java SE");
        matcher = pattern.matcher("Java SE");
        found = matcher.matches();
        System.out.println(found);

        System.out.println("======");

        System.out.println("Multiple matches");
        matcher = pattern.matcher("Java 1 2 3 Java");

        while (matcher.find()) {
            System.out.println("Found at idx: " + matcher.start());
        }
    }
}

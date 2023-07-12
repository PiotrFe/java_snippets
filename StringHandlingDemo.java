class Box {
    double width;
    double height;
    double depth;

    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public String toString() {
        return "Dimensions are " + width + " by " + depth + " by " + height + ".";
    }
}

public class StringHandlingDemo {
    public static void main(String[] args) {
        // empty constructor
        String s1 = new String(); 

        // from char array
        char[] chars = { 'a', 'b', 'c'};
        String s2 = new String(chars);

        char[] chars1 = { 'a', 'b', 'c', 'd', 'e', 'f'};
        String s3 = new String(chars1, 2, 3);

        // from another string
        String s4 = new String(s3);

        // from byte array (ascii converted to char)
        byte[] ascii = {65, 66, 67, 68, 69, 70};
        String s5 = new String(ascii);
        String s6 = new String(ascii, 1, 2);

        // from string literal
        String s7 = "string literal";

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);

        // length
        System.out.println(s1.length());  
        System.out.println("string literal".length());  

        // to string method of objects
        Box box = new Box(10, 15, 20);
        System.out.println(box);

        // char extraction
        char b = "abde".charAt(1);
        String extractedChars = "This is a demo of get chars method";
        int start = 10;
        int end = 14;
        char[] buf = new char[end - start];
        char[] converted = new char[extractedChars.length()];

        extractedChars.getChars(start, end, buf, 0);
        // same as above, but converts all
        converted = extractedChars.toCharArray();

        System.out.println("=========");
        System.out.println(b);
        System.out.println(buf);
        System.out.println(converted);

        // comparison - equals
        System.out.println("=========");
        String hello = "hello";
        String hello1 = "HELLO";
        System.out.println(hello.equals(hello1));
        System.out.println(hello.equalsIgnoreCase(hello1));

        // comparison = regionMatches
        System.out.println("=========");
        String poland = "poland";
        String holand = "holand";
        System.out.println(poland.regionMatches(0, holand, 0, 5));
        System.out.println(poland.regionMatches(1, holand, 1, 4));

        // starts and ends with
        System.out.println("=========");
        String foobar = "foobar";
        System.out.println(foobar.startsWith("foo"));
        System.out.println(foobar.endsWith("bar"));

        // comparing strings
        System.out.println("=========");
        String[] words = {"Now", "is", "the"};
        System.out.println(words[0].compareTo(words[1]));
        System.out.println(words[1].compareTo(words[2]));
        System.out.println(words[1].compareToIgnoreCase(words[2]));
        System.out.println(words[1].compareToIgnoreCase(words[2]));

        // searching for strings
        System.out.println("=========");
        System.out.println(poland.indexOf("lan"));
        System.out.println(holand.indexOf("an"));

        // modifying a string

        // substring
        System.out.println("=========");
        String test = "this is a test";
        String subst = test.substring(test.indexOf("test"), test.length());
        System.out.println(subst);

        // concatenating
        String concatenated = test.concat(subst);
        System.out.println(concatenated);

        // replacing
        String bello = "hello".replace('h', 'b');
        System.out.println(bello);

        // trimming
        String messed = "    bam  ";
        System.out.println(messed);
        System.out.println("    bam  ".trim());
        System.out.println("    bam  ".strip());
        System.out.println("    bam  ".stripLeading());
        System.out.println("    bam  ".stripTrailing());

        // changing case
        System.out.println("HELLO".toLowerCase());
        System.out.println("Hello".toUpperCase());

        // joining with a delimited
        String joined = String.join("; ", "one", "two", "three");
        System.out.println(joined);

        // *******************
        // StringBuffer
        // *******************

        // StringBuilder is similar, but not synchronized. 
        
        System.out.println("*************");
        System.out.println("StringBuffer");
        System.out.println("*************");

        StringBuffer sb = new StringBuffer("hello");
        
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        
        sb.setLength(100);
        sb.ensureCapacity(1000);
      
        System.out.println(sb.length());
        System.out.println(sb.capacity());

        System.out.println(sb.charAt(3));
        sb.setCharAt(3, 'w');
        System.out.println(sb);

        sb.append(" world");
        System.out.println(sb);

        sb.insert(5, " mean");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);
        sb.reverse();

        sb.delete(5, 9);
        System.out.println(sb);

        sb.replace(0, "helwon".length(), "hello");
        System.out.println(sb);

        System.out.println(sb.substring(0, 4));
    }
}

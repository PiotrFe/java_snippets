public class StringBuilderDemo {


    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();

        builder.ensureCapacity(100);
        builder.append("I am hungry");

        System.out.println("Hungry appears at index: " + builder.indexOf("hungry", 0) + "\n");

        String stuffedStr = "stuffed";

        builder.replace(builder.indexOf("hungry", 0), builder.indexOf("hungry", 0) + stuffedStr.length(), "stuffed");

        System.out.println("Am I stuffed? " + builder.toString() + "\n");
        
    }
    
}

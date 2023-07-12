import java.io.*;

class MyClass implements Serializable {
    String str;
    int i;
    double d;

    MyClass(String str, int i, double d) {
        this.str = str;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return this.str + " - " + this.i + " - " + this.d;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        
        // Serialization
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("serial.txt"))) {
            MyClass obj1 = new MyClass("mark", 10, 19.99);
            System.out.println("obj1: " + obj1);

            objectOutputStream.writeObject(obj1);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e);
        }

        // Deserialization (using filter - optional)
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("serial.txt"))) {
            ObjectInputFilter objectInputFilter = ObjectInputFilter.Config.createFilter("MyClass;!*"); // allowed classes separated by coma; !* means that all other classes should be rejected (! - reject, * - all class names)
            objectInputStream.setObjectInputFilter(objectInputFilter);

            MyClass obj2 = (MyClass) objectInputStream.readObject();
            System.out.println("obj2: " + obj2);
        } catch (Exception e) {
            System.out.println("Deserialization error: " + e); 
        }
    }
}

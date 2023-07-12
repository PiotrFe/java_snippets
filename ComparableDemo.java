
record Employee(String name, int id) implements Comparable<Employee> {

    static int pendingId = -1;

    Employee {
        name = name.trim();
    }

    Employee(String name) {
        this(name, pendingId);
    }

    public int compareTo(Employee e) {
        if (id != e.id) {
            return id - e.id;
        }

        return name.compareTo(e.name);
    
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", 1);
        Employee e2 = new Employee("Adam", 1);

        System.out.println(e1.compareTo(e2));
    }
    
}

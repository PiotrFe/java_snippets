record Employee(String name, int idNum) {

static int pendingId = -1;

// Canonical constructor can be skipped. Using it here to trim name
// Employee(String name, int idNum) {
//     this.name = name.trim();
//     this.idNum = idNum;
// }

// Shorter version - compact constructor
Employee {
    name = name.trim();
}

// Non-canonical constructor. Calling "this" is mandatory;
Employee(String name) {
    this(name, pendingId);
}
}

public class RecordDemo {
    public static void main(String[] args) {
        Employee[] empList = new Employee[5];

        empList[0] = new Employee("Doe, John", 1);
        empList[1] = new Employee("Black, Mary", 2);
        empList[2] = new Employee("Sheen, Martin", 3);
        empList[3] = new Employee("Frank, Frank", 4);
        empList[4] = new Employee("Nark, Bark");

        for (var e : empList) {
            System.out.println(e.name() + " " + e.idNum());
        }
    }
}

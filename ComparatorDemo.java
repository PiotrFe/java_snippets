import java.util.*;

enum Department {
    HR, PD, Recruiting, TBC
}

class EmployeeEntry {
     String name;
     Department dept;

    public EmployeeEntry(String n) {
        name = n;
        dept = Department.TBC;
    }

    public EmployeeEntry(String n, Department d) {
        name = n;
        dept = d;
    }
}

class EmployeeDeptComparator implements Comparator<EmployeeEntry> {
    public int compare(EmployeeEntry e1, EmployeeEntry e2) {
        return e1.dept.toString().compareTo(e2.dept.toString());
    }
}

class EmployeeNameComparator implements Comparator<EmployeeEntry> {
    public int compare(EmployeeEntry e1, EmployeeEntry e2) {
        return e1.name.compareTo(e2.name);    
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        Comparator<EmployeeEntry> employeeComparator = new EmployeeDeptComparator().thenComparing(new EmployeeNameComparator());
        TreeSet<EmployeeEntry> employeeSet = new TreeSet<>(employeeComparator);

        EmployeeEntry e1 = new EmployeeEntry("Mary", Department.HR);
        EmployeeEntry e2 = new EmployeeEntry("Peter", Department.PD);
        EmployeeEntry e3 = new EmployeeEntry("Dennis", Department.Recruiting);
        EmployeeEntry e4 = new EmployeeEntry("Zazi", Department.Recruiting);

        employeeSet.add(e1);
        employeeSet.add(e2);
        employeeSet.add(e3);
        employeeSet.add(e4);

        for (var e : employeeSet) {
            System.out.println(e.dept + " - " + e.name);
        }
    }

}

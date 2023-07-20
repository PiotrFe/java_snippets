import java.util.*;
import java.util.stream.*;

class NamePhoneEmail {
    String name;
    String phone;
    String email;

    NamePhoneEmail(String n, String p, String e) {
        name = n;
        phone = p;
        email = e;
    }
}

class NamePhone {
    String name;
    String phone;

    NamePhone(String n, String p) {
        name = n;
        phone = p;
    }
}

public class StreamCollectDemo {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();

        myList.add(new NamePhoneEmail("larry", "555-5555", "larry@larry.com"));
        myList.add(new NamePhoneEmail("james", "444-4444", "james@james.com"));
        myList.add(new NamePhoneEmail("mary", "333-3333", "mary@mary.com"));

        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phone));
        List<NamePhone> namePhoneList = nameAndPhone.collect(Collectors.toList());

        nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phone));
        Set<NamePhone> namePhoneSet = nameAndPhone.collect(Collectors.toSet());

        for (NamePhone e : namePhoneList) {
            System.out.println(e.name + " " + e.phone);
        }

        for (NamePhone e : namePhoneSet) {
            System.out.println(e.name + " " + e.phone);
        }

        // version with supplier, accumulator and combiner (see StreamReducerDemo for
        // details)
        nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phone));
        LinkedList<NamePhone> namePhoneLinkedList = nameAndPhone.collect(() -> new LinkedList<>(),
                (list, element) -> list.add(element), (listA, listB) -> listA.addAll(listB));

    }
}

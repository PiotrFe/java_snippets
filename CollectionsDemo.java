/*
 Interfaces:
 - Collection
 - List
 - Queue
 - Deque -> double-ended queue
 - Set
 - NavigableSet -> supports retrieval of elements based on the closest match to a given value or values
 - SortedSet -> set sorted in ascending order
 */

 /*
 Abstract classes:
  - AbstractCollection
  - AbstractList
  - AbstractSequentialList
  - AbstractQueue
  - AbstractSet 
  */

/*
Implementation classes:
  - ArrayList
  - LinkedList
  - PriorityQueue -> uses comparator to sort elements; if not provided as param, will use a default one
  - ArrayDeque -> double-ended queue
  - HashSet
  - LinkedHashSet -> maintains insertion order
  - TreeSet -> stores elements in a tree; they're automatically sorted
  - EnumSet
 */

 /*
  In addition (part of Collections framework, but not a Collection itself since it doesn't implement Commection interface):

  * Interfaces:
  - Map (interface)
  - Map.Entry (interface)
  - NavigableMap -> supports retrieval based on the closest match to a given key or keys
  - SortedMap -> entries maintained in ascending order based on keys

  * Abstract Classes:
  - AbstractMap

  * Implementation Classes:
  - HashMap
  - LinkedHashMap -> maintains insertion order
  - WeakHashMap
  - IdentityHashMap -> uses reference equality when comparing elements; not for general use
  - TreeMap -> ascending key order
  - EnumMap -> for use with keys of an enum type
  */

import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

public class CollectionsDemo {
    public static void main(String[] args) {

        // ***************
        // ArrayList
        // ***************
        ArrayList<String> arrayList = new ArrayList<>();

        System.out.println("Initial size of arrayList: " + arrayList.size());

        arrayList.add("D");
        arrayList.add("A");
        arrayList.add("C");
        arrayList.add("F");

        System.out.println("ArrayList size after addition: " + arrayList.size());
        System.out.println("ArrayList contents: " + arrayList);

        arrayList.remove(2);
        arrayList.remove("F");

        System.out.println("ArrayList contents after removal: " + arrayList);

        String[] stringArr = new String[arrayList.size()];
        stringArr = arrayList.toArray(stringArr);

        // ***************
        // LinkedList
        // ***************
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("F");
        linkedList.add("B");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("C");
        linkedList.addLast("Z");
        linkedList.addFirst("A");

        System.out.println("Linked list contents: " + linkedList);

        linkedList.remove(2);
        linkedList.remove("C");

        System.out.println("Linked list contents after removal: " + linkedList);

        // ***************
        // HashSet
        // ***************
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("Beta");
        hashSet.add("Alpha");
        hashSet.add("Eta");
        hashSet.add("Gamma");
        hashSet.add("Epsilon");

        System.out.println("HashSet contents: " + hashSet);

        // ***************
        // LinkedHashSet
        // ***************
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("Beta");
        linkedHashSet.add("Alpha");
        linkedHashSet.add("Eta");
        linkedHashSet.add("Gamma");
        linkedHashSet.add("Epsilon");

        System.out.println("linkedHashSet contents: " + linkedHashSet);

        // ***************
        // TreeSet
        // ***************
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("Beta");
        treeSet.add("Alpha");
        treeSet.add("Eta");
        treeSet.add("Gamma");
        treeSet.add("Epsilon");

        System.out.println("treeSet contents: " + treeSet);

        // ***************
        // PriorityQueue
        // ***************
        Comparator<String> c = new Comparator<>() {
          public int compare(String s1, String s2) {
            return s2.length() - s1.length();
          };
        };

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(c);

        priorityQueue.add("BA");
        priorityQueue.add("A");
        priorityQueue.add("GFD");
        priorityQueue.add("FDEIJIJIJIJIJ");
        priorityQueue.add("CEEEEE");

        System.out.println("priorityQueue contents: " + priorityQueue);

        // ***************
        // ArrayDeque
        // ***************
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        arrayDeque.push("A");
        arrayDeque.push("B");
        arrayDeque.push("C");
        arrayDeque.push("D");
        arrayDeque.push("E");
        arrayDeque.push("F");

        System.out.println("Popping off arrayDeque stack");

        while(arrayDeque.peek() != null) {
            System.out.println(arrayDeque.pop() + " ");
            System.out.println();
        }

        // ***************
        // Iterator & List Iterator
        // ***************

        System.out.println("*********");
        System.out.println("ITERATION");
        System.out.println("*********");

        // Method 1 - Iterator & ListIterator
        java.util.Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String el = it.next();
            System.out.println(el);
        }

        // Modifying contents
        java.util.ListIterator<String> lit = arrayList.listIterator();
        while(lit.hasNext()) {
            String el = lit.next();
            lit.set(el + " - modified");
        }

        System.out.println(arrayList);

        // Method 2 - ForEach
        for (String v : arrayList) {
            System.out.println(v);
        }

        // ***************
        // Spliterator 
        // ***************
        ArrayList<Double> vals = new ArrayList<>();

        vals.add(1.0);
        vals.add(2.0);
        vals.add(3.0);
        vals.add(4.0);
        vals.add(5.0);

        // use tryAdvance() to display contents of vals
        Spliterator<Double> spliterator = vals.spliterator();
        while(spliterator.tryAdvance((n) -> System.out.println(n)));

        // create new vals that contain square roots
        ArrayList<Double> squared = new ArrayList<>();
        spliterator = vals.spliterator();
        while(spliterator.tryAdvance((n) -> squared.add(Math.sqrt(n))));

        // use for each remaining to display vals
        spliterator = squared.spliterator();
        spliterator.forEachRemaining((n) -> System.out.println(n));

        // ***************
        // HashMap 
        // *************** 
        HashMap<String, Double> hashMap = new HashMap<>();

        hashMap.put("pete", 1.020);
        hashMap.put("mary", 3.020);
        hashMap.put("gilbert", 5.020);
        hashMap.put("wardra", 6.020);
        hashMap.put("makku", 8.020);

        // get a set of entries
        Set<Map.Entry<String, Double>> hashMapSet = hashMap.entrySet();
        System.out.println("Looping through hashMap");

        for (var e : hashMapSet) {
            System.out.print(e.getKey() + ": " + e.getValue());
            System.out.println();
        }

        // ***************
        // LinkedHashMap 
        // *************** 
        LinkedHashMap<String, Double> linkedHashMap = new LinkedHashMap<>();
        
        linkedHashMap.put("pete", 1.020);
        linkedHashMap.put("mary", 3.020);
        linkedHashMap.put("gilbert", 5.020);

        Set<Map.Entry<String, Double>> linkedMapSet = linkedHashMap.entrySet();

        System.out.println("Looping through linkedHashMap");

        for (var e : linkedMapSet) {
            System.out.print(e.getKey() + ": " + e.getValue());
            System.out.println();
        }

        // ***************
        // TreeMap 
        // *************** 
        TreeMap<String, Double> treeMap = new TreeMap<>();

        treeMap.put("pete", 1.020);
        treeMap.put("mary", 3.020);
        treeMap.put("gilbert", 5.020);

        Set<Map.Entry<String, Double>> treeMapSet = treeMap.entrySet();

        System.out.println("Looping through treeMap");
        for (var e : treeMapSet) {
            System.out.println(e.getKey() + ": " + e.getValue());
            System.out.println();
        }

        // ***************
        // Arrays 
        // *************** 
    }
}

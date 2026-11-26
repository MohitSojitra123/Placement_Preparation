import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetMethodsDemo {

    public static void main(String[] args) {

        // Creating TreeSet
        TreeSet<Integer> set = new TreeSet<>();

        // ------------------------------
        // add()
        // ------------------------------
        set.add(50);
        set.add(20);
        set.add(10);
        set.add(40);
        set.add(30);
        set.add(60);
        set.add(70);
        set.add(20);   // Duplicate (Ignored)

        System.out.println("Original TreeSet : " + set);

        // ------------------------------
        // size()
        // ------------------------------
        System.out.println("Size : " + set.size());

        // ------------------------------
        // isEmpty()
        // ------------------------------
        System.out.println("Is Empty : " + set.isEmpty());

        // ------------------------------
        // contains()
        // ------------------------------
        System.out.println("Contains 30 : " + set.contains(30));
        System.out.println("Contains 100 : " + set.contains(100));

        // ------------------------------
        // first()
        // ------------------------------
        System.out.println("First Element : " + set.first());

        // ------------------------------
        // last()
        // ------------------------------
        System.out.println("Last Element : " + set.last());

        // ------------------------------
        // higher()
        // ------------------------------
        System.out.println("Higher than 30 : " + set.higher(30));

        // ------------------------------
        // lower()
        // ------------------------------
        System.out.println("Lower than 30 : " + set.lower(30));

        // ------------------------------
        // ceiling()
        // ------------------------------
        System.out.println("Ceiling of 35 : " + set.ceiling(35));

        // ------------------------------
        // floor()
        // ------------------------------
        System.out.println("Floor of 35 : " + set.floor(35));

        // ------------------------------
        // pollFirst()
        // ------------------------------
        System.out.println("Poll First : " + set.pollFirst());
        System.out.println("After pollFirst : " + set);

        // ------------------------------
        // pollLast()
        // ------------------------------
        System.out.println("Poll Last : " + set.pollLast());
        System.out.println("After pollLast : " + set);

        // ------------------------------
        // remove()
        // ------------------------------
        set.remove(40);
        System.out.println("After Remove 40 : " + set);

        // ------------------------------
        // addAll()
        // ------------------------------
        TreeSet<Integer> set2 = new TreeSet<>();
        set2.add(80);
        set2.add(90);

        set.addAll(set2);
        System.out.println("After addAll : " + set);

        // ------------------------------
        // headSet()
        // ------------------------------
        System.out.println("HeadSet(<50) : " + set.headSet(50));

        // ------------------------------
        // tailSet()
        // ------------------------------
        System.out.println("TailSet(50+) : " + set.tailSet(50));

        // ------------------------------
        // subSet()
        // ------------------------------
        System.out.println("SubSet(20-80) : " + set.subSet(20, 80));

        // ------------------------------
        // descendingSet()
        // ------------------------------
        System.out.println("Descending Set : " + set.descendingSet());

        // ------------------------------
        // iterator()
        // ------------------------------
        System.out.print("Iterator : ");

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();

        // ------------------------------
        // descendingIterator()
        // ------------------------------
        System.out.print("Descending Iterator : ");

        Iterator<Integer> dit = set.descendingIterator();

        while (dit.hasNext()) {
            System.out.print(dit.next() + " ");
        }

        System.out.println();

        // ------------------------------
        // clone()
        // ------------------------------
        TreeSet<Integer> clone = (TreeSet<Integer>) set.clone();
        System.out.println("Clone : " + clone);

        // ------------------------------
        // equals()
        // ------------------------------
        System.out.println("Equals Clone : " + set.equals(clone));

        // ------------------------------
        // toArray()
        // ------------------------------
        Object[] arr = set.toArray();

        System.out.print("Array : ");

        for (Object i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();

        // ------------------------------
        // clear()
        // ------------------------------
        clone.clear();
        System.out.println("Clone after clear : " + clone);

        // ------------------------------
        // isEmpty()
        // ------------------------------
        System.out.println("Clone is Empty : " + clone.isEmpty());

        // ------------------------------
        // Reverse Order TreeSet
        // ------------------------------
        TreeSet<Integer> reverse = new TreeSet<>(Collections.reverseOrder());

        reverse.add(10);
        reverse.add(30);
        reverse.add(20);
        reverse.add(50);

        System.out.println("Reverse TreeSet : " + reverse);
    }
}
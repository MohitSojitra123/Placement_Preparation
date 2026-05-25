import java.util.*;

public class Collection_Traversal_All_Ways {

    public static void main(String[] args) {

        // =====================================================
        // ARRAYLIST
        // =====================================================

        System.out.println("\n========== ARRAYLIST ==========");

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C");
        arrayList.add("JavaScript");

        // =====================================================
        // 1. Normal For Loop
        // =====================================================

        System.out.println("\n1. Normal For Loop");

        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        // =====================================================
        // 2. Enhanced For Loop
        // =====================================================

        System.out.println("\n2. Enhanced For Loop");

        for(String lang : arrayList){
            System.out.println(lang);
        }

        // =====================================================
        // 3. Iterator
        // =====================================================

        System.out.println("\n3. Iterator");

        Iterator<String> itr1 = arrayList.iterator();

        while(itr1.hasNext()){
            System.out.println(itr1.next());
        }

        // =====================================================
        // 4. ListIterator Forward
        // =====================================================

        System.out.println("\n4. ListIterator Forward");

        ListIterator<String> litr1 =
                arrayList.listIterator();

        while(litr1.hasNext()){
            System.out.println(litr1.next());
        }

        // =====================================================
        // 5. ListIterator Backward
        // =====================================================

        System.out.println("\n5. ListIterator Backward");

        while(litr1.hasPrevious()){
            System.out.println(litr1.previous());
        }

        // =====================================================
        // 6. forEach() Method
        // =====================================================

        System.out.println("\n6. forEach()");

        arrayList.forEach((x) -> {
            System.out.println(x);
        });

        // =====================================================
        // 7. Method Reference
        // =====================================================

        System.out.println("\n7. Method Reference");

        arrayList.forEach(System.out::println);

        // =====================================================
        // 8. Stream API
        // =====================================================

        System.out.println("\n8. Stream API");

        arrayList.stream().forEach(System.out::println);

        // =====================================================
        // 9. Parallel Stream
        // =====================================================

        System.out.println("\n9. Parallel Stream");

        arrayList.parallelStream()
                 .forEach(System.out::println);

        // =====================================================
        // 10. Spliterator
        // =====================================================

        System.out.println("\n10. Spliterator");

        Spliterator<String> sp1 =
                arrayList.spliterator();

        sp1.forEachRemaining(System.out::println);

        // =====================================================
        // LINKEDLIST
        // =====================================================

        System.out.println("\n========== LINKEDLIST ==========");

        LinkedList<String> linkedList =
                new LinkedList<>();

        linkedList.add("HTML");
        linkedList.add("CSS");
        linkedList.add("Bootstrap");
        linkedList.add("React");

        // =====================================================
        // 1. Normal For Loop
        // =====================================================

        System.out.println("\n1. Normal For Loop");

        for(int i = 0; i < linkedList.size(); i++){
            System.out.println(linkedList.get(i));
        }

        // =====================================================
        // 2. Enhanced For Loop
        // =====================================================

        System.out.println("\n2. Enhanced For Loop");

        for(String x : linkedList){
            System.out.println(x);
        }

        // =====================================================
        // 3. Iterator
        // =====================================================

        System.out.println("\n3. Iterator");

        Iterator<String> itr2 =
                linkedList.iterator();

        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }

        // =====================================================
        // 4. ListIterator Forward
        // =====================================================

        System.out.println("\n4. ListIterator Forward");

        ListIterator<String> litr2 =
                linkedList.listIterator();

        while(litr2.hasNext()){
            System.out.println(litr2.next());
        }

        // =====================================================
        // 5. ListIterator Backward
        // =====================================================

        System.out.println("\n5. ListIterator Backward");

        while(litr2.hasPrevious()){
            System.out.println(litr2.previous());
        }

        // =====================================================
        // 6. Descending Iterator
        // =====================================================

        System.out.println("\n6. Descending Iterator");

        Iterator<String> ditr =
                linkedList.descendingIterator();

        while(ditr.hasNext()){
            System.out.println(ditr.next());
        }

        // =====================================================
        // 7. forEach()
        // =====================================================

        System.out.println("\n7. forEach()");

        linkedList.forEach(System.out::println);

        // =====================================================
        // 8. Stream API
        // =====================================================

        System.out.println("\n8. Stream API");

        linkedList.stream()
                  .forEach(System.out::println);

        // =====================================================
        // 9. Parallel Stream
        // =====================================================

        System.out.println("\n9. Parallel Stream");

        linkedList.parallelStream()
                  .forEach(System.out::println);

        // =====================================================
        // 10. Spliterator
        // =====================================================

        System.out.println("\n10. Spliterator");

        Spliterator<String> sp2 =
                linkedList.spliterator();

        sp2.forEachRemaining(System.out::println);

        // =====================================================
        // HASHSET
        // =====================================================

        System.out.println("\n========== HASHSET ==========");

        HashSet<String> hashSet =
                new HashSet<>();

        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Mango");
        hashSet.add("Orange");

        // =====================================================
        // 1. Enhanced For Loop
        // =====================================================

        System.out.println("\n1. Enhanced For Loop");

        for(String fruit : hashSet){
            System.out.println(fruit);
        }

        // =====================================================
        // 2. Iterator
        // =====================================================

        System.out.println("\n2. Iterator");

        Iterator<String> itr3 =
                hashSet.iterator();

        while(itr3.hasNext()){
            System.out.println(itr3.next());
        }

        // =====================================================
        // 3. forEach()
        // =====================================================

        System.out.println("\n3. forEach()");

        hashSet.forEach(System.out::println);

        // =====================================================
        // 4. Lambda Expression
        // =====================================================

        System.out.println("\n4. Lambda Expression");

        hashSet.forEach((x) -> {
            System.out.println(x);
        });

        // =====================================================
        // 5. Stream API
        // =====================================================

        System.out.println("\n5. Stream API");

        hashSet.stream()
               .forEach(System.out::println);

        // =====================================================
        // 6. Parallel Stream
        // =====================================================

        System.out.println("\n6. Parallel Stream");

        hashSet.parallelStream()
               .forEach(System.out::println);

        // =====================================================
        // 7. Spliterator
        // =====================================================

        System.out.println("\n7. Spliterator");

        Spliterator<String> sp3 =
                hashSet.spliterator();

        sp3.forEachRemaining(System.out::println);

    }
}
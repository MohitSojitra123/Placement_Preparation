import java.util.*;

public class ArrayList_All_Methods{

    public static void main(String[] args) {

        // =========================================================
        // 1. CREATE ARRAYLIST
        // =========================================================

        ArrayList<String> list = new ArrayList<>();

        // add(E e)
        // Adds element at end
        list.add("Java");
        list.add("Python");
        list.add("C");
        list.add("Java");

        System.out.println("add(): " + list);

        // =========================================================
        // 2. add(int index, E element)
        // Insert element at specific position
        // =========================================================

        list.add(1, "HTML");

        System.out.println("add(index,element): " + list);

        // =========================================================
        // 3. addAll(Collection c)
        // Add all elements of another collection
        // =========================================================

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("React");
        list2.add("NodeJS");

        list.addAll(list2);

        System.out.println("addAll(): " + list);

        // =========================================================
        // 4. addAll(int index, Collection c)
        // =========================================================

        ArrayList<String> extra = new ArrayList<>();
        extra.add("MongoDB");
        extra.add("SQL");

        list.addAll(2, extra);

        System.out.println("addAll(index,c): " + list);

        // =========================================================
        // 5. get(int index)
        // Get element using index
        // =========================================================

        System.out.println("get(): " + list.get(0));

        // =========================================================
        // 6. set(int index, E element)
        // Replace element
        // =========================================================

        list.set(0, "JAVA");

        System.out.println("set(): " + list);

        // =========================================================
        // 7. remove(int index)
        // Remove using index
        // =========================================================

        list.remove(1);

        System.out.println("remove(index): " + list);

        // =========================================================
        // 8. remove(Object o)
        // Remove object
        // =========================================================

        list.remove("C");

        System.out.println("remove(object): " + list);

        // =========================================================
        // 9. removeAll(Collection c)
        // Remove all matching elements
        // =========================================================

        ArrayList<String> removeList = new ArrayList<>();
        removeList.add("React");
        removeList.add("NodeJS");

        list.removeAll(removeList);

        System.out.println("removeAll(): " + list);

        // =========================================================
        // 10. retainAll(Collection c)
        // Keep only matching elements
        // =========================================================

        ArrayList<String> retain = new ArrayList<>();
        retain.add("JAVA");
        retain.add("Python");

        list.retainAll(retain);

        System.out.println("retainAll(): " + list);

        // =========================================================
        // 11. contains(Object o)
        // Check element exists or not
        // =========================================================

        System.out.println("contains(): " + list.contains("JAVA"));

        // =========================================================
        // 12. containsAll(Collection c)
        // =========================================================

        System.out.println("containsAll(): " + list.containsAll(retain));

        // =========================================================
        // 13. indexOf(Object o)
        // First occurrence
        // =========================================================

        System.out.println("indexOf(): " + list.indexOf("Python"));

        // =========================================================
        // 14. lastIndexOf(Object o)
        // Last occurrence
        // =========================================================

        list.add("Python");

        System.out.println("lastIndexOf(): " + list.lastIndexOf("Python"));

        // =========================================================
        // 15. size()
        // =========================================================

        System.out.println("size(): " + list.size());

        // =========================================================
        // 16. isEmpty()
        // =========================================================

        System.out.println("isEmpty(): " + list.isEmpty());

        // =========================================================
        // 17. clone()
        // =========================================================

        ArrayList<String> cloneList =
                (ArrayList<String>) list.clone();

        System.out.println("clone(): " + cloneList);

        // =========================================================
        // 18. equals(Object o)
        // =========================================================

        System.out.println("equals(): " + list.equals(cloneList));

        // =========================================================
        // 19. clear()
        // Remove all elements
        // =========================================================

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(10);
        temp.add(20);

        temp.clear();

        System.out.println("clear(): " + temp);

        // =========================================================
        // 20. toArray()
        // Convert into array
        // =========================================================

        Object arr[] = list.toArray();

        System.out.println("toArray(): ");

        for(Object x : arr){
            System.out.println(x);
        }

        // =========================================================
        // 21. iterator()
        // =========================================================

        Iterator<String> itr = list.iterator();

        System.out.println("iterator(): ");

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        // =========================================================
        // 22. listIterator()
        // =========================================================

        ListIterator<String> litr = list.listIterator();

        System.out.println("listIterator(): ");

        while(litr.hasNext()){
            System.out.println(litr.next());
        }

        // =========================================================
        // 23. subList(int from, int to)
        // =========================================================

        System.out.println("subList(): " + list.subList(0,2));

        // =========================================================
        // 24. ensureCapacity(int minCapacity)
        // Increase internal capacity
        // =========================================================

        list.ensureCapacity(100);

        System.out.println("ensureCapacity() executed");

        // =========================================================
        // 25. trimToSize()
        // Remove extra capacity
        // =========================================================

        list.trimToSize();

        System.out.println("trimToSize() executed");

        // =========================================================
        // 26. forEach()
        // =========================================================

        System.out.println("forEach(): ");

        list.forEach((n) -> {
            System.out.println(n);
        });

        // =========================================================
        // 27. replaceAll()
        // =========================================================

        ArrayList<String> rep = new ArrayList<>();

        rep.add("java");
        rep.add("python");

        rep.replaceAll(str -> str.toUpperCase());

        System.out.println("replaceAll(): " + rep);

        // =========================================================
        // 28. sort()
        // =========================================================

        rep.sort(null);

        System.out.println("sort(): " + rep);

        // =========================================================
        // 29. spliterator()
        // =========================================================

        Spliterator<String> sp = list.spliterator();

        System.out.println("spliterator(): ");

        sp.forEachRemaining(System.out::println);

        // =========================================================
        // 30. stream()
        // =========================================================

        System.out.println("stream(): ");

        list.stream().forEach(System.out::println);

        // =========================================================
        // 31. parallelStream()
        // =========================================================

        System.out.println("parallelStream(): ");

        list.parallelStream().forEach(System.out::println);

        // =========================================================
        // 32. hashCode()
        // =========================================================

        System.out.println("hashCode(): " + list.hashCode());

        // =========================================================
        // 33. toString()
        // =========================================================

        System.out.println("toString(): " + list.toString());

    }
}
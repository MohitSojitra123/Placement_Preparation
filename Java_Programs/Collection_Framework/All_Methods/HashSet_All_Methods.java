import java.util.*;

public class HashSet_All_Methods {

    public static void main(String[] args) {

        // =====================================================
        // 1. CREATE HASHSET
        // =====================================================

        HashSet<String> set = new HashSet<>();

        // =====================================================
        // 2. add(E e)
        // Add element
        // =====================================================

        set.add("Java");
        set.add("Python");
        set.add("C");
        set.add("Java"); // Duplicate ignored

        System.out.println("add(): " + set);

        // =====================================================
        // 3. addAll(Collection c)
        // =====================================================

        HashSet<String> set2 = new HashSet<>();

        set2.add("HTML");
        set2.add("CSS");

        set.addAll(set2);

        System.out.println("addAll(): " + set);

        // =====================================================
        // 4. contains(Object o)
        // Check element exists or not
        // =====================================================

        System.out.println("contains(): " + set.contains("Java"));

        // =====================================================
        // 5. containsAll(Collection c)
        // =====================================================

        System.out.println("containsAll(): " + set.containsAll(set2));

        // =====================================================
        // 6. remove(Object o)
        // =====================================================

        set.remove("C");

        System.out.println("remove(): " + set);

        // =====================================================
        // 7. removeAll(Collection c)
        // =====================================================

        HashSet<String> removeSet = new HashSet<>();

        removeSet.add("HTML");
        removeSet.add("CSS");

        set.removeAll(removeSet);

        System.out.println("removeAll(): " + set);

        // =====================================================
        // 8. retainAll(Collection c)
        // Keep common elements only
        // =====================================================

        HashSet<String> retainSet = new HashSet<>();

        retainSet.add("Java");

        set.retainAll(retainSet);

        System.out.println("retainAll(): " + set);

        // =====================================================
        // 9. size()
        // =====================================================

        System.out.println("size(): " + set.size());

        // =====================================================
        // 10. isEmpty()
        // =====================================================

        System.out.println("isEmpty(): " + set.isEmpty());

        // =====================================================
        // 11. clone()
        // =====================================================

        HashSet<String> cloneSet =
                (HashSet<String>) set.clone();

        System.out.println("clone(): " + cloneSet);

        // =====================================================
        // 12. equals(Object o)
        // =====================================================

        System.out.println("equals(): " + set.equals(cloneSet));

        // =====================================================
        // 13. clear()
        // =====================================================

        HashSet<Integer> temp = new HashSet<>();

        temp.add(10);
        temp.add(20);

        temp.clear();

        System.out.println("clear(): " + temp);

        // =====================================================
        // 14. iterator()
        // =====================================================

        Iterator<String> itr = set.iterator();

        System.out.println("iterator(): ");

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        // =====================================================
        // 15. forEach()
        // =====================================================

        System.out.println("forEach(): ");

        set.forEach((n) -> {
            System.out.println(n);
        });

        // =====================================================
        // 16. toArray()
        // =====================================================

        Object arr[] = set.toArray();

        System.out.println("toArray(): ");

        for(Object x : arr){
            System.out.println(x);
        }

        // =====================================================
        // 17. spliterator()
        // =====================================================

        Spliterator<String> sp = set.spliterator();

        System.out.println("spliterator(): ");

        sp.forEachRemaining(System.out::println);

        // =====================================================
        // 18. stream()
        // =====================================================

        System.out.println("stream(): ");

        set.stream().forEach(System.out::println);

        // =====================================================
        // 19. parallelStream()
        // =====================================================

        System.out.println("parallelStream(): ");

        set.parallelStream().forEach(System.out::println);

        // =====================================================
        // 20. hashCode()
        // =====================================================

        System.out.println("hashCode(): " + set.hashCode());

        // =====================================================
        // 21. toString()
        // =====================================================

        System.out.println("toString(): " + set.toString());

    }
}
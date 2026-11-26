import java.util.*;

public class Queue_All_Methods_Demo {

    public static void main(String[] args) {

        // =====================================================
        // 1. CREATE QUEUE
        // =====================================================

        Queue<String> queue =
                new LinkedList<>();

        // =====================================================
        // 2. add(E e)
        // Insert element
        // =====================================================

        queue.add("Java");
        queue.add("Python");
        queue.add("C");

        System.out.println("add(): " + queue);

        // =====================================================
        // 3. offer(E e)
        // Insert element safely
        // =====================================================

        queue.offer("JavaScript");

        System.out.println("offer(): " + queue);

        // =====================================================
        // 4. element()
        // View front element
        // Throws exception if empty
        // =====================================================

        System.out.println(
                "element(): "
                + queue.element()
        );

        // =====================================================
        // 5. peek()
        // View front element
        // Returns null if empty
        // =====================================================

        System.out.println(
                "peek(): "
                + queue.peek()
        );

        // =====================================================
        // 6. remove()
        // Remove front element
        // Throws exception if empty
        // =====================================================

        System.out.println(
                "remove(): "
                + queue.remove()
        );

        System.out.println(queue);

        // =====================================================
        // 7. poll()
        // Remove front element
        // Returns null if empty
        // =====================================================

        System.out.println(
                "poll(): "
                + queue.poll()
        );

        System.out.println(queue);

        // =====================================================
        // 8. addAll(Collection c)
        // =====================================================

        Queue<String> q2 =
                new LinkedList<>();

        q2.add("HTML");
        q2.add("CSS");

        queue.addAll(q2);

        System.out.println("addAll(): " + queue);

        // =====================================================
        // 9. contains(Object o)
        // =====================================================

        System.out.println(
                "contains(): "
                + queue.contains("CSS")
        );

        // =====================================================
        // 10. containsAll(Collection c)
        // =====================================================

        System.out.println(
                "containsAll(): "
                + queue.containsAll(q2)
        );

        // =====================================================
        // 11. remove(Object o)
        // =====================================================

        queue.remove("HTML");

        System.out.println(
                "remove(object): "
                + queue
        );

        // =====================================================
        // 12. removeAll(Collection c)
        // =====================================================

        Queue<String> rem =
                new LinkedList<>();

        rem.add("CSS");

        queue.removeAll(rem);

        System.out.println(
                "removeAll(): "
                + queue
        );

        // =====================================================
        // 13. retainAll(Collection c)
        // =====================================================

        Queue<String> retain =
                new LinkedList<>();

        retain.add("C");

        queue.retainAll(retain);

        System.out.println(
                "retainAll(): "
                + queue
        );

        // =====================================================
        // 14. size()
        // =====================================================

        System.out.println(
                "size(): "
                + queue.size()
        );

        // =====================================================
        // 15. isEmpty()
        // =====================================================

        System.out.println(
                "isEmpty(): "
                + queue.isEmpty()
        );

        // =====================================================
        // 16. clear()
        // =====================================================

        Queue<Integer> temp =
                new LinkedList<>();

        temp.add(10);
        temp.add(20);

        temp.clear();

        System.out.println(
                "clear(): "
                + temp
        );

        // =====================================================
        // 17. iterator()
        // =====================================================

        Iterator<String> itr =
                queue.iterator();

        System.out.println("iterator(): ");

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        // =====================================================
        // 18. forEach()
        // =====================================================

        System.out.println("forEach(): ");

        queue.forEach(System.out::println);

        // =====================================================
        // 19. Stream API
        // =====================================================

        System.out.println("stream(): ");

        queue.stream()
             .forEach(System.out::println);

        // =====================================================
        // 20. parallelStream()
        // =====================================================

        System.out.println("parallelStream(): ");

        queue.parallelStream()
             .forEach(System.out::println);

        // =====================================================
        // 21. Spliterator
        // =====================================================

        Spliterator<String> sp =
                queue.spliterator();

        System.out.println("spliterator(): ");

        sp.forEachRemaining(
                System.out::println
        );

        // =====================================================
        // 22. toArray()
        // =====================================================

        Object arr[] = queue.toArray();

        System.out.println("toArray(): ");

        for(Object x : arr){
            System.out.println(x);
        }

        // =====================================================
        // 23. equals()
        // =====================================================

        Queue<String> q3 =
                new LinkedList<>();

        q3.add("C");

        System.out.println(
                "equals(): "
                + queue.equals(q3)
        );

        // =====================================================
        // 24. hashCode()
        // =====================================================

        System.out.println(
                "hashCode(): "
                + queue.hashCode()
        );

        // =====================================================
        // 25. toString()
        // =====================================================

        System.out.println(
                "toString(): "
                + queue.toString()
        );

    }
}
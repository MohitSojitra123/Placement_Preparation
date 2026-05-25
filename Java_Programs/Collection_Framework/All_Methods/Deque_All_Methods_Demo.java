import java.util.*;

public class Deque_All_Methods_Demo {

    public static void main(String[] args) {

        // =====================================================
        // 1. CREATE DEQUE
        // =====================================================

        Deque<String> dq =
                new ArrayDeque<>();

        // =====================================================
        // 2. add(E e)
        // Add at rear
        // =====================================================

        dq.add("Java");
        dq.add("Python");

        System.out.println("add(): " + dq);

        // =====================================================
        // 3. addFirst(E e)
        // =====================================================

        dq.addFirst("HTML");

        System.out.println("addFirst(): " + dq);

        // =====================================================
        // 4. addLast(E e)
        // =====================================================

        dq.addLast("CSS");

        System.out.println("addLast(): " + dq);

        // =====================================================
        // 5. offer(E e)
        // =====================================================

        dq.offer("JavaScript");

        System.out.println("offer(): " + dq);

        // =====================================================
        // 6. offerFirst(E e)
        // =====================================================

        dq.offerFirst("Bootstrap");

        System.out.println("offerFirst(): " + dq);

        // =====================================================
        // 7. offerLast(E e)
        // =====================================================

        dq.offerLast("React");

        System.out.println("offerLast(): " + dq);

        // =====================================================
        // 8. push(E e)
        // Stack insertion
        // =====================================================

        dq.push("STACK");

        System.out.println("push(): " + dq);

        // =====================================================
        // 9. pop()
        // Stack deletion
        // =====================================================

        System.out.println(
                "pop(): "
                + dq.pop()
        );

        System.out.println(dq);

        // =====================================================
        // 10. remove()
        // Remove front
        // =====================================================

        System.out.println(
                "remove(): "
                + dq.remove()
        );

        System.out.println(dq);

        // =====================================================
        // 11. removeFirst()
        // =====================================================

        System.out.println(
                "removeFirst(): "
                + dq.removeFirst()
        );

        System.out.println(dq);

        // =====================================================
        // 12. removeLast()
        // =====================================================

        System.out.println(
                "removeLast(): "
                + dq.removeLast()
        );

        System.out.println(dq);

        // =====================================================
        // 13. poll()
        // =====================================================

        System.out.println(
                "poll(): "
                + dq.poll()
        );

        System.out.println(dq);

        // =====================================================
        // 14. pollFirst()
        // =====================================================

        System.out.println(
                "pollFirst(): "
                + dq.pollFirst()
        );

        System.out.println(dq);

        // =====================================================
        // 15. pollLast()
        // =====================================================

        dq.offer("A");
        dq.offer("B");

        System.out.println(
                "pollLast(): "
                + dq.pollLast()
        );

        System.out.println(dq);

        // =====================================================
        // 16. getFirst()
        // =====================================================

        dq.offerFirst("X");

        System.out.println(
                "getFirst(): "
                + dq.getFirst()
        );

        // =====================================================
        // 17. getLast()
        // =====================================================

        System.out.println(
                "getLast(): "
                + dq.getLast()
        );

        // =====================================================
        // 18. peek()
        // =====================================================

        System.out.println(
                "peek(): "
                + dq.peek()
        );

        // =====================================================
        // 19. peekFirst()
        // =====================================================

        System.out.println(
                "peekFirst(): "
                + dq.peekFirst()
        );

        // =====================================================
        // 20. peekLast()
        // =====================================================

        System.out.println(
                "peekLast(): "
                + dq.peekLast()
        );

        // =====================================================
        // 21. element()
        // =====================================================

        System.out.println(
                "element(): "
                + dq.element()
        );

        // =====================================================
        // 22. contains()
        // =====================================================

        System.out.println(
                "contains(): "
                + dq.contains("A")
        );

        // =====================================================
        // 23. containsAll()
        // =====================================================

        Deque<String> d2 =
                new ArrayDeque<>();

        d2.offer("A");

        System.out.println(
                "containsAll(): "
                + dq.containsAll(d2)
        );

        // =====================================================
        // 24. remove(Object o)
        // =====================================================

        dq.remove("A");

        System.out.println(
                "remove(object): "
                + dq
        );

        // =====================================================
        // 25. removeFirstOccurrence()
        // =====================================================

        dq.offer("Java");
        dq.offer("Java");

        dq.removeFirstOccurrence("Java");

        System.out.println(
                "removeFirstOccurrence(): "
                + dq
        );

        // =====================================================
        // 26. removeLastOccurrence()
        // =====================================================

        dq.removeLastOccurrence("Java");

        System.out.println(
                "removeLastOccurrence(): "
                + dq
        );

        // =====================================================
        // 27. addAll()
        // =====================================================

        Deque<String> d3 =
                new ArrayDeque<>();

        d3.offer("NodeJS");
        d3.offer("MongoDB");

        dq.addAll(d3);

        System.out.println(
                "addAll(): "
                + dq
        );

        // =====================================================
        // 28. removeAll()
        // =====================================================

        dq.removeAll(d3);

        System.out.println(
                "removeAll(): "
                + dq
        );

        // =====================================================
        // 29. retainAll()
        // =====================================================

        Deque<String> retain =
                new ArrayDeque<>();

        retain.offer("X");

        dq.retainAll(retain);

        System.out.println(
                "retainAll(): "
                + dq
        );

        // =====================================================
        // 30. size()
        // =====================================================

        System.out.println(
                "size(): "
                + dq.size()
        );

        // =====================================================
        // 31. isEmpty()
        // =====================================================

        System.out.println(
                "isEmpty(): "
                + dq.isEmpty()
        );

        // =====================================================
        // 32. iterator()
        // =====================================================

        Iterator<String> itr =
                dq.iterator();

        System.out.println("iterator(): ");

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        // =====================================================
        // 33. descendingIterator()
        // =====================================================

        System.out.println(
                "descendingIterator(): "
        );

        Iterator<String> ditr =
                dq.descendingIterator();

        while(ditr.hasNext()){
            System.out.println(ditr.next());
        }

        // =====================================================
        // 34. forEach()
        // =====================================================

        System.out.println("forEach(): ");

        dq.forEach(System.out::println);

        // =====================================================
        // 35. Stream API
        // =====================================================

        System.out.println("stream(): ");

        dq.stream()
          .forEach(System.out::println);

        // =====================================================
        // 36. parallelStream()
        // =====================================================

        System.out.println("parallelStream(): ");

        dq.parallelStream()
          .forEach(System.out::println);

        // =====================================================
        // 37. Spliterator
        // =====================================================

        Spliterator<String> sp =
                dq.spliterator();

        System.out.println("spliterator(): ");

        sp.forEachRemaining(
                System.out::println
        );

        // =====================================================
        // 38. toArray()
        // =====================================================

        Object arr[] = dq.toArray();

        System.out.println("toArray(): ");

        for(Object x : arr){
            System.out.println(x);
        }

        // =====================================================
        // 39. clear()
        // =====================================================

        Deque<Integer> temp =
                new ArrayDeque<>();

        temp.offer(10);
        temp.offer(20);

        temp.clear();

        System.out.println(
                "clear(): "
                + temp
        );

        // =====================================================
        // 40. equals()
        // =====================================================

        Deque<String> d4 =
                new ArrayDeque<>();

        d4.offer("X");

        System.out.println(
                "equals(): "
                + dq.equals(d4)
        );

        // =====================================================
        // 41. hashCode()
        // =====================================================

        System.out.println(
                "hashCode(): "
                + dq.hashCode()
        );

        // =====================================================
        // 42. toString()
        // =====================================================

        System.out.println(
                "toString(): "
                + dq.toString()
        );

    }
}
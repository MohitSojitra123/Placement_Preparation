import java.util.*;

public class LinkedList_All_Methods{

    public static void main(String[] args) {

        // ======================================================
        // 1. CREATE LINKEDLIST
        // ======================================================

        LinkedList<String> list = new LinkedList<>();

        // ======================================================
        // 2. add(E e)
        // Add element at end
        // ======================================================

        list.add("Java");
        list.add("Python");
        list.add("C");

        System.out.println("add(): " + list);

        // ======================================================
        // 3. addFirst(E e)
        // ======================================================

        list.addFirst("HTML");

        System.out.println("addFirst(): " + list);

        // ======================================================
        // 4. addLast(E e)
        // ======================================================

        list.addLast("JavaScript");

        System.out.println("addLast(): " + list);

        // ======================================================
        // 5. add(int index, E element)
        // ======================================================

        list.add(2, "CSS");

        System.out.println("add(index,element): " + list);

        // ======================================================
        // 6. addAll(Collection c)
        // ======================================================

        LinkedList<String> list2 = new LinkedList<>();

        list2.add("React");
        list2.add("NodeJS");

        list.addAll(list2);

        System.out.println("addAll(): " + list);

        // ======================================================
        // 7. addAll(int index, Collection c)
        // ======================================================

        LinkedList<String> extra = new LinkedList<>();

        extra.add("MongoDB");
        extra.add("SQL");

        list.addAll(1, extra);

        System.out.println("addAll(index,c): " + list);

        // ======================================================
        // 8. get(int index)
        // ======================================================

        System.out.println("get(): " + list.get(0));

        // ======================================================
        // 9. getFirst()
        // ======================================================

        System.out.println("getFirst(): " + list.getFirst());

        // ======================================================
        // 10. getLast()
        // ======================================================

        System.out.println("getLast(): " + list.getLast());

        // ======================================================
        // 11. set(int index, E element)
        // ======================================================

        list.set(0, "JAVA");

        System.out.println("set(): " + list);

        // ======================================================
        // 12. remove()
        // Remove first element
        // ======================================================

        list.remove();

        System.out.println("remove(): " + list);

        // ======================================================
        // 13. remove(int index)
        // ======================================================

        list.remove(1);

        System.out.println("remove(index): " + list);

        // ======================================================
        // 14. remove(Object o)
        // ======================================================

        list.remove("C");

        System.out.println("remove(object): " + list);

        // ======================================================
        // 15. removeFirst()
        // ======================================================

        list.removeFirst();

        System.out.println("removeFirst(): " + list);

        // ======================================================
        // 16. removeLast()
        // ======================================================

        list.removeLast();

        System.out.println("removeLast(): " + list);

        // ======================================================
        // 17. removeFirstOccurrence()
        // ======================================================

        list.add("Python");
        list.add("Python");

        list.removeFirstOccurrence("Python");

        System.out.println("removeFirstOccurrence(): " + list);

        // ======================================================
        // 18. removeLastOccurrence()
        // ======================================================

        list.removeLastOccurrence("Python");

        System.out.println("removeLastOccurrence(): " + list);

        // ======================================================
        // 19. contains()
        // ======================================================

        System.out.println("contains(): " + list.contains("React"));

        // ======================================================
        // 20. containsAll()
        // ======================================================

        System.out.println("containsAll(): " + list.containsAll(list2));

        // ======================================================
        // 21. size()
        // ======================================================

        System.out.println("size(): " + list.size());

        // ======================================================
        // 22. isEmpty()
        // ======================================================

        System.out.println("isEmpty(): " + list.isEmpty());

        // ======================================================
        // 23. indexOf()
        // ======================================================

        System.out.println("indexOf(): " + list.indexOf("React"));

        // ======================================================
        // 24. lastIndexOf()
        // ======================================================

        list.add("React");

        System.out.println("lastIndexOf(): " + list.lastIndexOf("React"));

        // ======================================================
        // 25. clear()
        // ======================================================

        LinkedList<Integer> temp = new LinkedList<>();

        temp.add(10);
        temp.add(20);

        temp.clear();

        System.out.println("clear(): " + temp);

        // ======================================================
        // 26. clone()
        // ======================================================

        LinkedList<String> cloneList =
                (LinkedList<String>) list.clone();

        System.out.println("clone(): " + cloneList);

        // ======================================================
        // 27. peek()
        // Retrieve first element
        // ======================================================

        System.out.println("peek(): " + list.peek());

        // ======================================================
        // 28. peekFirst()
        // ======================================================

        System.out.println("peekFirst(): " + list.peekFirst());

        // ======================================================
        // 29. peekLast()
        // ======================================================

        System.out.println("peekLast(): " + list.peekLast());

        // ======================================================
        // 30. poll()
        // Remove first element
        // ======================================================

        System.out.println("poll(): " + list.poll());

        System.out.println(list);

        // ======================================================
        // 31. pollFirst()
        // ======================================================

        System.out.println("pollFirst(): " + list.pollFirst());

        System.out.println(list);

        // ======================================================
        // 32. pollLast()
        // ======================================================

        System.out.println("pollLast(): " + list.pollLast());

        System.out.println(list);

        // ======================================================
        // 33. offer()
        // ======================================================

        list.offer("JAVA");

        System.out.println("offer(): " + list);

        // ======================================================
        // 34. offerFirst()
        // ======================================================

        list.offerFirst("HTML");

        System.out.println("offerFirst(): " + list);

        // ======================================================
        // 35. offerLast()
        // ======================================================

        list.offerLast("CSS");

        System.out.println("offerLast(): " + list);

        // ======================================================
        // 36. push()
        // Stack push
        // ======================================================

        list.push("STACK");

        System.out.println("push(): " + list);

        // ======================================================
        // 37. pop()
        // Stack pop
        // ======================================================

        System.out.println("pop(): " + list.pop());

        System.out.println(list);

        // ======================================================
        // 38. element()
        // ======================================================

        System.out.println("element(): " + list.element());

        // ======================================================
        // 39. toArray()
        // ======================================================

        Object arr[] = list.toArray();

        System.out.println("toArray(): ");

        for(Object x : arr){
            System.out.println(x);
        }

        // ======================================================
        // 40. iterator()
        // ======================================================

        Iterator<String> itr = list.iterator();

        System.out.println("iterator(): ");

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        // ======================================================
        // 41. descendingIterator()
        // Reverse traversal
        // ======================================================

        Iterator<String> ditr = list.descendingIterator();

        System.out.println("descendingIterator(): ");

        while(ditr.hasNext()){
            System.out.println(ditr.next());
        }

        // ======================================================
        // 42. listIterator()
        // ======================================================

        ListIterator<String> litr = list.listIterator();

        System.out.println("listIterator(): ");

        while(litr.hasNext()){
            System.out.println(litr.next());
        }

        // ======================================================
        // 43. subList()
        // ======================================================

        System.out.println("subList(): " + list.subList(0,2));

        // ======================================================
        // 44. replaceAll()
        // ======================================================

        LinkedList<String> rep = new LinkedList<>();

        rep.add("java");
        rep.add("python");

        rep.replaceAll(str -> str.toUpperCase());

        System.out.println("replaceAll(): " + rep);

        // ======================================================
        // 45. sort()
        // ======================================================

        rep.sort(null);

        System.out.println("sort(): " + rep);

        // ======================================================
        // 46. forEach()
        // ======================================================

        System.out.println("forEach(): ");

        list.forEach((n) -> {
            System.out.println(n);
        });

        // ======================================================
        // 47. spliterator()
        // ======================================================

        Spliterator<String> sp = list.spliterator();

        System.out.println("spliterator(): ");

        sp.forEachRemaining(System.out::println);

        // ======================================================
        // 48. stream()
        // ======================================================

        System.out.println("stream(): ");

        list.stream().forEach(System.out::println);

        // ======================================================
        // 49. parallelStream()
        // ======================================================

        System.out.println("parallelStream(): ");

        list.parallelStream().forEach(System.out::println);

        // ======================================================
        // 50. hashCode()
        // ======================================================

        System.out.println("hashCode(): " + list.hashCode());

        // ======================================================
        // 51. equals()
        // ======================================================

        System.out.println("equals(): " + list.equals(cloneList));

        // ======================================================
        // 52. toString()
        // ======================================================

        System.out.println("toString(): " + list.toString());

    }
}
import java.util.*;

public class Stack_All_Methods_Demo {

    public static void main(String[] args) {

        // =====================================================
        // 1. CREATE STACK
        // =====================================================

        Stack<String> stack = new Stack<>();

        // =====================================================
        // 2. push(E item)
        // Insert element at top
        // =====================================================

        stack.push("Java");
        stack.push("Python");
        stack.push("C");
        stack.push("JavaScript");

        System.out.println("push(): " + stack);

        // =====================================================
        // 3. add(E e)
        // =====================================================

        stack.add("React");

        System.out.println("add(): " + stack);

        // =====================================================
        // 4. addElement(E obj)
        // =====================================================

        stack.addElement("NodeJS");

        System.out.println("addElement(): " + stack);

        // =====================================================
        // 5. insertElementAt(E obj, int index)
        // =====================================================

        stack.insertElementAt("HTML", 1);

        System.out.println("insertElementAt(): " + stack);

        // =====================================================
        // 6. peek()
        // View top element
        // =====================================================

        System.out.println("peek(): " + stack.peek());

        // =====================================================
        // 7. pop()
        // Remove top element
        // =====================================================

        System.out.println("pop(): " + stack.pop());

        System.out.println(stack);

        // =====================================================
        // 8. search(Object o)
        // Position from top
        // =====================================================

        System.out.println(
                "search(): "
                + stack.search("Python")
        );

        // =====================================================
        // 9. empty()
        // =====================================================

        System.out.println(
                "empty(): "
                + stack.empty()
        );

        // =====================================================
        // 10. size()
        // =====================================================

        System.out.println(
                "size(): "
                + stack.size()
        );

        // =====================================================
        // 11. capacity()
        // =====================================================

        System.out.println(
                "capacity(): "
                + stack.capacity()
        );

        // =====================================================
        // 12. contains()
        // =====================================================

        System.out.println(
                "contains(): "
                + stack.contains("Java")
        );

        // =====================================================
        // 13. get(int index)
        // =====================================================

        System.out.println(
                "get(): "
                + stack.get(0)
        );

        // =====================================================
        // 14. firstElement()
        // =====================================================

        System.out.println(
                "firstElement(): "
                + stack.firstElement()
        );

        // =====================================================
        // 15. lastElement()
        // =====================================================

        System.out.println(
                "lastElement(): "
                + stack.lastElement()
        );

        // =====================================================
        // 16. set(int index, E element)
        // =====================================================

        stack.set(0, "JAVA");

        System.out.println("set(): " + stack);

        // =====================================================
        // 17. setElementAt(E obj, int index)
        // =====================================================

        stack.setElementAt("PYTHON", 1);

        System.out.println("setElementAt(): " + stack);

        // =====================================================
        // 18. remove(Object o)
        // =====================================================

        stack.remove("C");

        System.out.println("remove(object): " + stack);

        // =====================================================
        // 19. remove(int index)
        // =====================================================

        stack.remove(0);

        System.out.println("remove(index): " + stack);

        // =====================================================
        // 20. removeElement(Object obj)
        // =====================================================

        stack.removeElement("React");

        System.out.println("removeElement(): " + stack);

        // =====================================================
        // 21. removeElementAt(int index)
        // =====================================================

        stack.removeElementAt(0);

        System.out.println("removeElementAt(): " + stack);

        // =====================================================
        // 22. removeAllElements()
        // =====================================================

        Stack<Integer> temp = new Stack<>();

        temp.push(10);
        temp.push(20);

        temp.removeAllElements();

        System.out.println(
                "removeAllElements(): "
                + temp
        );

        // =====================================================
        // 23. clear()
        // =====================================================

        Stack<String> temp2 = new Stack<>();

        temp2.push("A");
        temp2.push("B");

        temp2.clear();

        System.out.println("clear(): " + temp2);

        // =====================================================
        // 24. isEmpty()
        // =====================================================

        System.out.println(
                "isEmpty(): "
                + stack.isEmpty()
        );

        // =====================================================
        // 25. clone()
        // =====================================================

        Stack<String> cloneStack =
                (Stack<String>) stack.clone();

        System.out.println(
                "clone(): "
                + cloneStack
        );

        // =====================================================
        // 26. equals()
        // =====================================================

        System.out.println(
                "equals(): "
                + stack.equals(cloneStack)
        );

        // =====================================================
        // 27. hashCode()
        // =====================================================

        System.out.println(
                "hashCode(): "
                + stack.hashCode()
        );

        // =====================================================
        // 28. toString()
        // =====================================================

        System.out.println(
                "toString(): "
                + stack.toString()
        );

        // =====================================================
        // 29. iterator()
        // =====================================================

        Iterator<String> itr =
                stack.iterator();

        System.out.println("iterator(): ");

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        // =====================================================
        // 30. ListIterator
        // =====================================================

        ListIterator<String> litr =
                stack.listIterator();

        System.out.println("listIterator(): ");

        while(litr.hasNext()){
            System.out.println(litr.next());
        }

        // =====================================================
        // 31. Enumeration
        // Old traversal method
        // =====================================================

        Enumeration<String> en =
                stack.elements();

        System.out.println("Enumeration(): ");

        while(en.hasMoreElements()){
            System.out.println(
                    en.nextElement()
            );
        }

        // =====================================================
        // 32. forEach()
        // =====================================================

        System.out.println("forEach(): ");

        stack.forEach(System.out::println);

        // =====================================================
        // 33. Stream API
        // =====================================================

        System.out.println("stream(): ");

        stack.stream()
             .forEach(System.out::println);

        // =====================================================
        // 34. parallelStream()
        // =====================================================

        System.out.println("parallelStream(): ");

        stack.parallelStream()
             .forEach(System.out::println);

        // =====================================================
        // 35. Spliterator
        // =====================================================

        Spliterator<String> sp =
                stack.spliterator();

        System.out.println("spliterator(): ");

        sp.forEachRemaining(System.out::println);

        // =====================================================
        // 36. toArray()
        // =====================================================

        Object arr[] = stack.toArray();

        System.out.println("toArray(): ");

        for(Object x : arr){
            System.out.println(x);
        }

        // =====================================================
        // 37. subList()
        // =====================================================

        System.out.println(
                "subList(): "
                + stack.subList(0,1)
        );

        // =====================================================
        // 38. indexOf()
        // =====================================================

        System.out.println(
                "indexOf(): "
                + stack.indexOf("JavaScript")
        );

        // =====================================================
        // 39. lastIndexOf()
        // =====================================================

        stack.push("JavaScript");

        System.out.println(
                "lastIndexOf(): "
                + stack.lastIndexOf("JavaScript")
        );

        // =====================================================
        // 40. sort()
        // =====================================================

        Stack<Integer> num =
                new Stack<>();

        num.push(50);
        num.push(10);
        num.push(40);

        num.sort(null);

        System.out.println("sort(): " + num);

        // =====================================================
        // 41. replaceAll()
        // =====================================================

        Stack<String> rep =
                new Stack<>();

        rep.push("java");
        rep.push("python");

        rep.replaceAll(str ->
                str.toUpperCase());

        System.out.println(
                "replaceAll(): "
                + rep
        );
    }
}

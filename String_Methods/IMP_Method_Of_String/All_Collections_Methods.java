public /*
===============================================================================
                JAVA COLLECTIONS CLASS - ALL METHODS DEMO
===============================================================================

✔ Covers java.util.Collections Utility Class
✔ Basic To Advanced Methods
✔ Overloaded Methods
✔ Sorting Methods
✔ Searching Methods
✔ Modification Methods
✔ Conversion Methods
✔ Synchronization Methods
✔ Unmodifiable Collection Methods
✔ Real World Examples

IMPORT:
import java.util.Collections;

===============================================================================
*/


import java.util.*;

public class All_Collections_Methods {


    public static void main(String[] args) {


        // =========================================================================
        // COLLECTION DECLARATION
        // =========================================================================


        List<Integer> numbers =
                new ArrayList<>(Arrays.asList(50,20,90,10,70));


        List<String> names =
                new ArrayList<>(
                        Arrays.asList(
                                "Java",
                                "Python",
                                "C++",
                                "JavaScript"
                        )
                );


        System.out.println("Original Numbers : "+numbers);
        System.out.println("Original Names : "+names);



        // =========================================================================
        // 1. sort()
        // =========================================================================
        /*
            Use:
            Sort collection ascending order

            Real World:
            Product price sorting
        */


        System.out.println("\n1. Collections.sort()");


        Collections.sort(numbers);


        System.out.println(numbers);



        // =========================================================================
        // 2. sort() with Comparator
        // =========================================================================
        /*
            Overloaded:
            sort(List<T>)
            sort(List<T>, Comparator)

            Custom sorting
        */


        System.out.println("\n2. Collections.sort Comparator");


        Collections.sort(
                names,
                Collections.reverseOrder()
        );


        System.out.println(names);





        // =========================================================================
        // 3. reverse()
        // =========================================================================

        /*
            Reverse order of collection

            Example:
            Latest orders first
        */


        System.out.println("\n3. Collections.reverse()");


        Collections.reverse(numbers);


        System.out.println(numbers);




        // =========================================================================
        // 4. shuffle()
        // =========================================================================


        /*
            Randomly rearrange elements

            Example:
            Card game
        */


        System.out.println("\n4. Collections.shuffle()");


        Collections.shuffle(names);


        System.out.println(names);




        // =========================================================================
        // 5. swap()
        // =========================================================================


        /*
            Swap two index values

            Example:
            Move priority item
        */


        System.out.println("\n5. Collections.swap()");


        Collections.swap(numbers,0,2);


        System.out.println(numbers);




        // =========================================================================
        // 6. min()
        // =========================================================================


        /*
            Find smallest element

            Example:
            Cheapest product
        */


        System.out.println("\n6. Collections.min()");


        System.out.println(
                Collections.min(numbers)
        );





        // =========================================================================
        // 7. max()
        // =========================================================================


        /*
            Find largest value

            Example:
            Highest salary
        */


        System.out.println("\n7. Collections.max()");


        System.out.println(
                Collections.max(numbers)
        );






        // =========================================================================
        // 8. frequency()
        // =========================================================================


        /*
            Count occurrence

            Example:
            Word frequency
        */


        System.out.println("\n8. Collections.frequency()");


        List<String> colors =
                Arrays.asList(
                        "Red",
                        "Blue",
                        "Red",
                        "Green"
                );


        System.out.println(
                Collections.frequency(colors,"Red")
        );





        // =========================================================================
        // 9. binarySearch()
        // =========================================================================


        /*
            Search element
            Collection must be sorted
        */


        System.out.println("\n9. Collections.binarySearch()");


        Collections.sort(numbers);


        System.out.println(
                Collections.binarySearch(numbers,50)
        );





        // =========================================================================
        // 10. fill()
        // =========================================================================


        /*
            Replace all elements

            Example:
            Reset values
        */


        System.out.println("\n10. Collections.fill()");


        List<Integer> data =
                new ArrayList<>(
                        Arrays.asList(1,2,3,4)
                );


        Collections.fill(data,100);


        System.out.println(data);





        // =========================================================================
        // 11. copy()
        // =========================================================================


        /*
            Copy source list into destination
        */


        System.out.println("\n11. Collections.copy()");


        List<Integer> destination =
                new ArrayList<>(
                        Arrays.asList(0,0,0,0)
                );


        Collections.copy(
                destination,
                Arrays.asList(5,6,7,8)
        );


        System.out.println(destination);






        // =========================================================================
        // 12. replaceAll()
        // =========================================================================


        /*
            Replace old value with new value
        */


        System.out.println("\n12. Collections.replaceAll()");


        List<String> city =
                new ArrayList<>(
                        Arrays.asList(
                                "Delhi",
                                "Mumbai",
                                "Delhi"
                        )
                );


        Collections.replaceAll(
                city,
                "Delhi",
                "Rajkot"
        );


        System.out.println(city);






        // =========================================================================
        // 13. rotate()
        // =========================================================================


        /*
            Shift elements

            Example:
            Circular queue
        */


        System.out.println("\n13. Collections.rotate()");


        Collections.rotate(numbers,2);


        System.out.println(numbers);






        // =========================================================================
        // 14. disjoint()
        // =========================================================================


        /*
            Check two collections
            have common elements or not
        */


        System.out.println("\n14. Collections.disjoint()");


        List<Integer> a =
                Arrays.asList(1,2,3);


        List<Integer> b =
                Arrays.asList(4,5,6);



        System.out.println(
                Collections.disjoint(a,b)
        );






        // =========================================================================
        // 15. addAll()
        // =========================================================================


        /*
            Add multiple elements
        */


        System.out.println("\n15. Collections.addAll()");


        List<String> fruits =
                new ArrayList<>();


        Collections.addAll(
                fruits,
                "Apple",
                "Mango",
                "Banana"
        );


        System.out.println(fruits);






        // =========================================================================
        // 16. nCopies()
        // =========================================================================


        /*
            Create collection with same value
        */


        System.out.println("\n16. Collections.nCopies()");


        List<String> copyList =
                Collections.nCopies(
                        5,
                        "Java"
                );


        System.out.println(copyList);






        // =========================================================================
        // 17. emptyList()
        // =========================================================================


        System.out.println("\n17. Collections.emptyList()");


        List<String> empty =
                Collections.emptyList();


        System.out.println(empty);






        // =========================================================================
        // 18. singleton()
        // =========================================================================


        /*
            Collection containing only one element
        */


        System.out.println("\n18. Collections.singleton()");


        Set<String> single =
                Collections.singleton("Admin");


        System.out.println(single);






        // =========================================================================
        // 19. unmodifiableList()
        // =========================================================================


        /*
            Read only collection
        */


        System.out.println("\n19. Collections.unmodifiableList()");


        List<Integer> readOnly =
                Collections.unmodifiableList(numbers);


        System.out.println(readOnly);



        // readOnly.add(100);
        // Error





        // =========================================================================
        // 20. synchronizedList()
        // =========================================================================


        /*
            Thread safe list

            Real World:
            Multiple users accessing data
        */


        System.out.println("\n20. Collections.synchronizedList()");


        List<Integer> sync =
                Collections.synchronizedList(
                        new ArrayList<>()
                );


        sync.add(10);
        sync.add(20);


        System.out.println(sync);







        // =========================================================================
        // 21. synchronizedSet()
        // =========================================================================


        System.out.println("\n21. Collections.synchronizedSet()");


        Set<Integer> set =
                Collections.synchronizedSet(
                        new HashSet<>()
                );


        set.add(1);
        set.add(2);


        System.out.println(set);






        // =========================================================================
        // 22. synchronizedMap()
        // =========================================================================


        System.out.println("\n22. Collections.synchronizedMap()");


        Map<Integer,String> map =
                Collections.synchronizedMap(
                        new HashMap<>()
                );


        map.put(1,"Java");


        System.out.println(map);





        // =========================================================================
        // 23. emptySet()
        // =========================================================================


        System.out.println("\n23. Collections.emptySet()");


        System.out.println(
                Collections.emptySet()
        );






        // =========================================================================
        // 24. emptyMap()
        // =========================================================================


        System.out.println("\n24. Collections.emptyMap()");


        System.out.println(
                Collections.emptyMap()
        );






        // =========================================================================
        // REAL WORLD EXAMPLE
        // =========================================================================


        System.out.println(
                "\n========= REAL WORLD ========="
        );


        List<Integer> prices =
                new ArrayList<>(
                        Arrays.asList(
                                500,
                                200,
                                900,
                                100
                        )
                );


        // Sort product prices

        Collections.sort(prices);


        System.out.println(
                "Sorted Product Price : "
                + prices
        );



        // Cheapest product

        System.out.println(
                "Cheapest Product : "
                + Collections.min(prices)
        );



        // Expensive Product


        System.out.println(
                "Most Expensive Product : "
                + Collections.max(prices)
        );



        System.out.println(
                "\n======================================"
        );

        System.out.println(
                "ALL COLLECTIONS METHODS COMPLETED"
        );

        System.out.println(
                "======================================"
        );



    }

} {
    
}

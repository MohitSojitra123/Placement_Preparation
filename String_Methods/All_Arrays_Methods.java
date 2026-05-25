

// https://chatgpt.com/share/6a088f25-a958-8321-867c-f30268306049



/*
===============================================================================
                    JAVA ARRAYS CLASS - ALL METHODS DEMO
===============================================================================

✔ Covers Basic To Advanced Arrays Methods
✔ Covers Arrays Utility Class
✔ Covers Overloaded Methods
✔ Covers Sorting, Searching, Copying
✔ Covers Array ↔ String Conversion
✔ Covers String ↔ Char Array
✔ Covers String ↔ Byte Array
✔ Covers Stream Methods
✔ Covers Java 8+ Methods
✔ Covers Parallel Methods
✔ Single Complete Program

PACKAGE:
import java.util.Arrays;

===============================================================================
*/

import java.util.*;
import java.util.stream.*;

public class All_Arrays_Methods {

    public static void main(String[] args) {

        // =========================================================================
        // ARRAY DECLARATION
        // =========================================================================

        int numbers[] = {5, 2, 9, 1, 7};
        int numbers2[] = {5, 2, 9, 1, 7};

        String fruits[] = {"Mango", "Apple", "Banana"};

        char letters[] = {'J', 'A', 'V', 'A'};

        System.out.println("ORIGINAL ARRAYS");

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(fruits));

        // =========================================================================
        // 1. toString()
        // =========================================================================

        System.out.println("\n1. Arrays.toString()");
        System.out.println(Arrays.toString(numbers));

        // =========================================================================
        // 2. deepToString()
        // =========================================================================

        System.out.println("\n2. Arrays.deepToString()");

        int matrix[][] = {
                {1, 2},
                {3, 4}
        };

        System.out.println(Arrays.deepToString(matrix));

        // =========================================================================
        // 3. sort()
        // =========================================================================

        System.out.println("\n3. Arrays.sort()");

        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));

        // =========================================================================
        // 4. parallelSort()
        // =========================================================================

        System.out.println("\n4. Arrays.parallelSort()");

        int arr[] = {9, 4, 1, 7, 3};

        Arrays.parallelSort(arr);

        System.out.println(Arrays.toString(arr));

        // =========================================================================
        // 5. binarySearch()
        // =========================================================================

        System.out.println("\n5. Arrays.binarySearch()");

        int index = Arrays.binarySearch(arr, 7);

        System.out.println("Index : " + index);

        // =========================================================================
        // 6. equals()
        // =========================================================================

        System.out.println("\n6. Arrays.equals()");

        System.out.println(Arrays.equals(numbers, numbers2));

        // =========================================================================
        // 7. deepEquals()
        // =========================================================================

        System.out.println("\n7. Arrays.deepEquals()");

        int a[][] = {{1,2},{3,4}};
        int b[][] = {{1,2},{3,4}};

        System.out.println(Arrays.deepEquals(a, b));

        // =========================================================================
        // 8. fill()
        // =========================================================================

        System.out.println("\n8. Arrays.fill()");

        int fillArray[] = new int[5];

        Arrays.fill(fillArray, 100);

        System.out.println(Arrays.toString(fillArray));

        // =========================================================================
        // 9. copyOf()
        // =========================================================================

        System.out.println("\n9. Arrays.copyOf()");

        int copy[] = Arrays.copyOf(numbers, 3);

        System.out.println(Arrays.toString(copy));

        // =========================================================================
        // 10. copyOfRange()
        // =========================================================================

        System.out.println("\n10. Arrays.copyOfRange()");

        int range[] = Arrays.copyOfRange(numbers, 1, 4);

        System.out.println(Arrays.toString(range));

        // =========================================================================
        // 11. mismatch() Java 9
        // =========================================================================

        System.out.println("\n11. Arrays.mismatch()");

        int x[] = {1,2,3};
        int y[] = {1,2,5};

        System.out.println(Arrays.mismatch(x, y));

        // =========================================================================
        // 12. compare() Java 9
        // =========================================================================

        System.out.println("\n12. Arrays.compare()");

        System.out.println(Arrays.compare(x, y));

        // =========================================================================
        // 13. compareUnsigned()
        // =========================================================================

        System.out.println("\n13. Arrays.compareUnsigned()");

        System.out.println(Arrays.compareUnsigned(x, y));

        // =========================================================================
        // 14. setAll()
        // =========================================================================

        System.out.println("\n14. Arrays.setAll()");

        int setArray[] = new int[5];

        Arrays.setAll(setArray, i -> i * 2);

        System.out.println(Arrays.toString(setArray));

        // =========================================================================
        // 15. parallelSetAll()
        // =========================================================================

        System.out.println("\n15. Arrays.parallelSetAll()");

        int parallelSet[] = new int[5];

        Arrays.parallelSetAll(parallelSet, i -> i * 10);

        System.out.println(Arrays.toString(parallelSet));

        // =========================================================================
        // 16. spliterator()
        // =========================================================================

        System.out.println("\n16. Arrays.spliterator()");

        Spliterator<Integer> sp =
                Arrays.spliterator(new Integer[]{1,2,3});

        sp.forEachRemaining(System.out::println);

        // =========================================================================
        // 17. stream()
        // =========================================================================

        System.out.println("\n17. Arrays.stream()");

        Arrays.stream(numbers)
                .forEach(System.out::println);

        // =========================================================================
        // 18. asList()
        // =========================================================================

        System.out.println("\n18. Arrays.asList()");

        List<String> list = Arrays.asList(fruits);

        System.out.println(list);

        // =========================================================================
        // STRING ↔ ARRAY CONVERSION
        // =========================================================================

        System.out.println("\n==============================");
        System.out.println("STRING ↔ ARRAY CONVERSION");
        System.out.println("==============================");

        // =========================================================================
        // 19. String → Char Array
        // =========================================================================

        System.out.println("\n19. String → Char Array");

        String name = "JAVA";

        char charArray[] = name.toCharArray();

        System.out.println(Arrays.toString(charArray));

        // =========================================================================
        // 20. Char Array → String
        // =========================================================================

        System.out.println("\n20. Char Array → String");

        String newString = new String(charArray);

        System.out.println(newString);

        // =========================================================================
        // 21. String → Byte Array
        // =========================================================================

        System.out.println("\n21. String → Byte Array");

        byte byteArray[] = name.getBytes();

        System.out.println(Arrays.toString(byteArray));

        // =========================================================================
        // 22. Byte Array → String
        // =========================================================================

        System.out.println("\n22. Byte Array → String");

        String byteToString = new String(byteArray);

        System.out.println(byteToString);

        // =========================================================================
        // 23. Array → String
        // =========================================================================

        System.out.println("\n23. Array → String");

        String arrayString = Arrays.toString(numbers);

        System.out.println(arrayString);

        // =========================================================================
        // 24. String → Array
        // =========================================================================

        System.out.println("\n24. String → Array");

        String language = "Java Python C++";

        String langArray[] = language.split(" ");

        System.out.println(Arrays.toString(langArray));

        // =========================================================================
        // 25. String Array → Single String
        // =========================================================================

        System.out.println("\n25. String Array → Single String");

        String joined = String.join("-", fruits);

        System.out.println(joined);

        // =========================================================================
        // 26. int Array → Integer List
        // =========================================================================

        System.out.println("\n26. int Array → List");

        List<Integer> numberList =
                Arrays.stream(numbers)
                        .boxed()
                        .collect(Collectors.toList());

        System.out.println(numberList);

        // =========================================================================
        // 27. List → Array
        // =========================================================================

        System.out.println("\n27. List → Array");

        String listArray[] =
                list.toArray(new String[0]);

        System.out.println(Arrays.toString(listArray));

        // =========================================================================
        // MULTI DIMENSION ARRAY METHODS
        // =========================================================================

        System.out.println("\n==============================");
        System.out.println("MULTI DIMENSION ARRAYS");
        System.out.println("==============================");

        // =========================================================================
        // 28. deepHashCode()
        // =========================================================================

        System.out.println("\n28. Arrays.deepHashCode()");

        System.out.println(Arrays.deepHashCode(matrix));

        // =========================================================================
        // 29. deepToString()
        // =========================================================================

        System.out.println("\n29. Arrays.deepToString()");

        System.out.println(Arrays.deepToString(matrix));

        // =========================================================================
        // ARRAY LOOPING TECHNIQUES
        // =========================================================================

        System.out.println("\n==============================");
        System.out.println("ARRAY LOOPING");
        System.out.println("==============================");

        // =========================================================================
        // 30. Traditional Loop
        // =========================================================================

        System.out.println("\n30. Traditional Loop");

        for(int i=0; i<numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }

        // =========================================================================
        // 31. Enhanced For Loop
        // =========================================================================

        System.out.println("\n\n31. Enhanced For Loop");

        for(int value : numbers){
            System.out.print(value + " ");
        }

        // =========================================================================
        // 32. Stream Loop
        // =========================================================================

        System.out.println("\n\n32. Stream Loop");

        Arrays.stream(numbers)
                .forEach(n -> System.out.print(n + " "));

        // =========================================================================
        // ADVANCED STREAM METHODS
        // =========================================================================

        System.out.println("\n\n==============================");
        System.out.println("ADVANCED STREAM METHODS");
        System.out.println("==============================");

        // =========================================================================
        // 33. sum()
        // =========================================================================

        System.out.println("\n33. Sum");

        int sum = Arrays.stream(numbers).sum();

        System.out.println(sum);

        // =========================================================================
        // 34. average()
        // =========================================================================

        System.out.println("\n34. Average");

        double avg =
                Arrays.stream(numbers)
                        .average()
                        .orElse(0);

        System.out.println(avg);

        // =========================================================================
        // 35. max()
        // =========================================================================

        System.out.println("\n35. Max");

        int max =
                Arrays.stream(numbers)
                        .max()
                        .orElse(0);

        System.out.println(max);

        // =========================================================================
        // 36. min()
        // =========================================================================

        System.out.println("\n36. Min");

        int min =
                Arrays.stream(numbers)
                        .min()
                        .orElse(0);

        System.out.println(min);

        // =========================================================================
        // 37. count()
        // =========================================================================

        System.out.println("\n37. Count");

        long count =
                Arrays.stream(numbers)
                        .count();

        System.out.println(count);

        // =========================================================================
        // 38. distinct()
        // =========================================================================

        System.out.println("\n38. Distinct");

        int dup[] = {1,2,2,3,4,4};

        Arrays.stream(dup)
                .distinct()
                .forEach(System.out::println);

        // =========================================================================
        // 39. filter()
        // =========================================================================

        System.out.println("\n39. Filter");

        Arrays.stream(numbers)
                .filter(n -> n > 5)
                .forEach(System.out::println);

        // =========================================================================
        // 40. map()
        // =========================================================================

        System.out.println("\n40. Map");

        Arrays.stream(numbers)
                .map(n -> n * 2)
                .forEach(System.out::println);

        // =========================================================================
        // FINAL MESSAGE
        // =========================================================================

        System.out.println("\n==========================================");
        System.out.println("ALL IMPORTANT ARRAY METHODS COMPLETED");
        System.out.println("==========================================");
    }
}
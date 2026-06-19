package IMP_Method_Of_String;
/*
================================================================================
                    JAVA STRING CLASS - ALL METHODS DEMO
================================================================================

✔ Covers Basic To Advanced String Methods
✔ Covers Overloaded Methods
✔ Covers Arguments and Parameters
✔ Covers String Comparison
✔ Covers Searching
✔ Covers Modification
✔ Covers Conversion
✔ Covers Formatting
✔ Covers Regex Methods
✔ Covers Java 11+ Methods
✔ Covers Static Methods
✔ Single Complete Program

NOTE:
Some methods are available in newer Java versions (Java 11+).

================================================================================
*/

import java.util.Arrays;
import java.util.Locale;

public class All_String_Methods {

    public static void main(String[] args) {

        // =========================================================================
        // STRING DECLARATION
        // =========================================================================

        String str = "Hello World";
        String str2 = "hello world";
        String empty = "";
        String spaces = "   Java Programming   ";
        String number = "123";
        String csv = "Apple,Banana,Mango";

        System.out.println("Original String : " + str);

        // =========================================================================
        // 1. length()
        // =========================================================================

        System.out.println("\n1. length()");
        System.out.println(str.length());

        // =========================================================================
        // 2. charAt(int index)
        // =========================================================================

        System.out.println("\n2. charAt()");
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(6));

        // =========================================================================
        // 3. substring()
        // Overloaded Methods:
        // substring(int beginIndex)
        // substring(int beginIndex, int endIndex)
        // =========================================================================

        System.out.println("\n3. substring()");
        System.out.println(str.substring(6));
        System.out.println(str.substring(0, 5));

        // =========================================================================
        // 4. contains(CharSequence s)
        // =========================================================================

        System.out.println("\n4. contains()");
        System.out.println(str.contains("World"));

        // =========================================================================
        // 5. equals(Object obj)
        // =========================================================================

        System.out.println("\n5. equals()");
        System.out.println(str.equals("Hello World"));

        // =========================================================================
        // 6. equalsIgnoreCase(String anotherString)
        // =========================================================================

        System.out.println("\n6. equalsIgnoreCase()");
        System.out.println(str.equalsIgnoreCase(str2));

        // =========================================================================
        // 7. compareTo(String anotherString)
        // =========================================================================

        System.out.println("\n7. compareTo()");
        System.out.println("Apple".compareTo("Banana"));

        // =========================================================================
        // 8. compareToIgnoreCase(String str)
        // =========================================================================

        System.out.println("\n8. compareToIgnoreCase()");
        System.out.println("HELLO".compareToIgnoreCase("hello"));

        // =========================================================================
        // 9. startsWith()
        // Overloaded:
        // startsWith(String prefix)
        // startsWith(String prefix, int offset)
        // =========================================================================

        System.out.println("\n9. startsWith()");
        System.out.println(str.startsWith("Hello"));
        System.out.println(str.startsWith("World", 6));

        // =========================================================================
        // 10. endsWith(String suffix)
        // =========================================================================

        System.out.println("\n10. endsWith()");
        System.out.println(str.endsWith("World"));

        // =========================================================================
        // 11. indexOf()
        // Overloaded Methods
        // =========================================================================

        System.out.println("\n11. indexOf()");
        System.out.println(str.indexOf('o'));
        System.out.println(str.indexOf('o', 5));
        System.out.println(str.indexOf("World"));
        System.out.println(str.indexOf("o", 5));

        // =========================================================================
        // 12. lastIndexOf()
        // =========================================================================

        System.out.println("\n12. lastIndexOf()");
        System.out.println(str.lastIndexOf('o'));
        System.out.println(str.lastIndexOf("o"));

        // =========================================================================
        // 13. toUpperCase()
        // =========================================================================

        System.out.println("\n13. toUpperCase()");
        System.out.println(str.toUpperCase());

        // =========================================================================
        // 14. toLowerCase()
        // =========================================================================

        System.out.println("\n14. toLowerCase()");
        System.out.println(str.toLowerCase());

        // =========================================================================
        // 15. trim()
        // =========================================================================

        System.out.println("\n15. trim()");
        System.out.println(spaces.trim());

        // =========================================================================
        // 16. strip() (Java 11)
        // =========================================================================

        System.out.println("\n16. strip()");
        System.out.println(spaces.strip());

        // =========================================================================
        // 17. stripLeading()
        // =========================================================================

        System.out.println("\n17. stripLeading()");
        System.out.println(spaces.stripLeading());

        // =========================================================================
        // 18. stripTrailing()
        // =========================================================================

        System.out.println("\n18. stripTrailing()");
        System.out.println(spaces.stripTrailing());

        // =========================================================================
        // 19. replace()
        // Overloaded
        // =========================================================================

        System.out.println("\n19. replace()");
        System.out.println(str.replace('o', '0'));
        System.out.println(str.replace("World", "Java"));

        // =========================================================================
        // 20. replaceFirst()
        // =========================================================================

        System.out.println("\n20. replaceFirst()");
        System.out.println("one two one".replaceFirst("one", "1"));

        // =========================================================================
        // 21. replaceAll()
        // =========================================================================

        System.out.println("\n21. replaceAll()");
        System.out.println("a1b2c3".replaceAll("[0-9]", "*"));

        // =========================================================================
        // 22. concat(String str)
        // =========================================================================

        System.out.println("\n22. concat()");
        System.out.println(str.concat(" Programming"));

        // =========================================================================
        // 23. split()
        // Overloaded
        // =========================================================================

        System.out.println("\n23. split()");
        String arr[] = csv.split(",");
        System.out.println(Arrays.toString(arr));

        String arr2[] = csv.split(",", 2);
        System.out.println(Arrays.toString(arr2));

        // =========================================================================
        // 24. join() STATIC METHOD
        // =========================================================================

        System.out.println("\n24. join()");
        System.out.println(String.join("-", "Java", "Python", "C++"));

        // =========================================================================
        // 25. isEmpty()
        // =========================================================================

        System.out.println("\n25. isEmpty()");
        System.out.println(empty.isEmpty());

        // =========================================================================
        // 26. isBlank() Java 11
        // =========================================================================

        System.out.println("\n26. isBlank()");
        System.out.println("   ".isBlank());

        // =========================================================================
        // 27. repeat(int count) Java 11
        // =========================================================================

        System.out.println("\n27. repeat()");
        System.out.println("Hi ".repeat(3));

        // =========================================================================
        // 28. matches(String regex)
        // =========================================================================

        System.out.println("\n28. matches()");
        System.out.println(number.matches("[0-9]+"));

        // =========================================================================
        // 29. toCharArray()
        // =========================================================================

        System.out.println("\n29. toCharArray()");
        char ch[] = str.toCharArray();
        System.out.println(Arrays.toString(ch));

        // =========================================================================
        // 30. getBytes()
        // =========================================================================

        System.out.println("\n30. getBytes()");
        byte bytes[] = str.getBytes();
        System.out.println(Arrays.toString(bytes));

        // =========================================================================
        // 31. valueOf() STATIC METHOD
        // Overloaded
        // =========================================================================

        System.out.println("\n31. valueOf()");
        System.out.println(String.valueOf(100));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(10.5));

        // =========================================================================
        // 32. format() STATIC METHOD
        // =========================================================================

        System.out.println("\n32. format()");
        String formatted = String.format("Name: %s Age: %d", "Mohit", 21);
        System.out.println(formatted);

        // =========================================================================
        // 33. intern()
        // =========================================================================

        System.out.println("\n33. intern()");
        String s1 = new String("Java");
        String s2 = s1.intern();
        System.out.println(s2);

        // =========================================================================
        // 34. lines() Java 11
        // =========================================================================

        System.out.println("\n34. lines()");
        String multi = "Java\nPython\nC++";

        multi.lines().forEach(System.out::println);

        // =========================================================================
        // 35. codePointAt()
        // =========================================================================

        System.out.println("\n35. codePointAt()");
        System.out.println(str.codePointAt(0));

        // =========================================================================
        // 36. codePointBefore()
        // =========================================================================

        System.out.println("\n36. codePointBefore()");
        System.out.println(str.codePointBefore(1));

        // =========================================================================
        // 37. codePointCount()
        // =========================================================================

        System.out.println("\n37. codePointCount()");
        System.out.println(str.codePointCount(0, str.length()));

        // =========================================================================
        // 38. offsetByCodePoints()
        // =========================================================================

        System.out.println("\n38. offsetByCodePoints()");
        System.out.println(str.offsetByCodePoints(0, 5));

        // =========================================================================
        // 39. regionMatches()
        // Overloaded
        // =========================================================================

        System.out.println("\n39. regionMatches()");
        System.out.println(str.regionMatches(0, "Hello", 0, 5));

        System.out.println(
                str.regionMatches(true, 0, "hello", 0, 5));

        // =========================================================================
        // 40. contentEquals()
        // =========================================================================

        System.out.println("\n40. contentEquals()");
        System.out.println(str.contentEquals("Hello World"));

        // =========================================================================
        // 41. copyValueOf()
        // =========================================================================

        System.out.println("\n41. copyValueOf()");
        char data[] = {'J', 'A', 'V', 'A'};

        System.out.println(String.copyValueOf(data));
        System.out.println(String.copyValueOf(data, 1, 2));

        // =========================================================================
        // 42. subSequence()
        // =========================================================================

        System.out.println("\n42. subSequence()");
        System.out.println(str.subSequence(0, 5));

        // =========================================================================
        // 43. hashCode()
        // =========================================================================

        System.out.println("\n43. hashCode()");
        System.out.println(str.hashCode());

        // =========================================================================
        // 44. describeConstable() Java 12
        // =========================================================================

        System.out.println("\n44. describeConstable()");
        System.out.println(str.describeConstable());

        // =========================================================================
        // 45. transform() Java 12
        // =========================================================================

        System.out.println("\n45. transform()");
        String result = str.transform(s -> s.toUpperCase());
        System.out.println(result);

        // =========================================================================
        // 46. chars()
        // =========================================================================

        System.out.println("\n46. chars()");
        str.chars().forEach(c -> System.out.print((char)c + " "));
        System.out.println();

        // =========================================================================
        // 47. codePoints()
        // =========================================================================

        System.out.println("\n47. codePoints()");
        str.codePoints().forEach(System.out::println);

        // =========================================================================
        // 48. indent() Java 12
        // =========================================================================

        System.out.println("\n48. indent()");
        System.out.println(str.indent(5));

        // =========================================================================
        // 49. translateEscapes() Java 15
        // =========================================================================

        System.out.println("\n49. translateEscapes()");
        String esc = "Hello\\nWorld";
        System.out.println(esc.translateEscapes());

        // =========================================================================
        // 50. formatted() Java 15
        // =========================================================================

        System.out.println("\n50. formatted()");
        String msg = "My Name is %s and Age is %d".formatted("Mohit", 21);
        System.out.println(msg);

        // =========================================================================
        // 51. repeat()
        // =========================================================================

        System.out.println("\n51. repeat()");
        System.out.println("*".repeat(10));

        // =========================================================================
        // 52. CASE CONVERSION WITH LOCALE
        // =========================================================================

        System.out.println("\n52. Locale Methods");
        System.out.println(str.toUpperCase(Locale.US));
        System.out.println(str.toLowerCase(Locale.US));

        // =========================================================================
        // 53. String Builder Conversion
        // =========================================================================

        System.out.println("\n53. StringBuilder Conversion");
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb);

        // =========================================================================
        // 54. String Buffer Conversion
        // =========================================================================

        System.out.println("\n54. StringBuffer Conversion");
        StringBuffer sbf = new StringBuffer(str);
        System.out.println(sbf);

        // =========================================================================
        // 55. CASE INSENSITIVE SEARCH
        // =========================================================================

        System.out.println("\n55. Case Insensitive Search");
        System.out.println(str.toLowerCase().contains("hello"));

        // =========================================================================
        // IMMUTABLE DEMO
        // =========================================================================

        System.out.println("\nIMMUTABLE STRING DEMO");

        String x = "Java";
        x.concat(" Programming");

        System.out.println(x);

        x = x.concat(" Programming");

        System.out.println(x);

        // =========================================================================
        // STRING POOL DEMO
        // =========================================================================

        System.out.println("\nSTRING POOL DEMO");

        String a = "Hello";
        String b = "Hello";

        System.out.println(a == b);

        String c = new String("Hello");

        System.out.println(a == c);

        // =========================================================================
        // FINAL MESSAGE
        // =========================================================================

        System.out.println("\n=================================================");
        System.out.println("ALL IMPORTANT STRING METHODS COMPLETED");
        System.out.println("=================================================");
    }
}
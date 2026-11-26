/*
===============================================================================
                 JAVA STRINGBUFFER CLASS - ALL METHODS DEMO
===============================================================================

✔ Covers Basic To Advanced StringBuffer Methods
✔ Covers All Overloaded Methods
✔ Covers Mutable String Operations
✔ Covers Capacity Management
✔ Covers Append / Insert / Replace
✔ Covers Delete / Reverse
✔ Covers Conversion Methods
✔ Covers Searching Methods
✔ Covers Comparison Methods
✔ Covers Synchronization Property
✔ Covers Real World Examples

PACKAGE:
java.lang.StringBuffer (Automatically Imported)

===============================================================================
*/


public class All_StringBuffer_Methods {


    public static void main(String[] args) {


        // =========================================================================
        // STRINGBUFFER CREATION
        // =========================================================================


        StringBuffer sb1 =
                new StringBuffer();


        StringBuffer sb2 =
                new StringBuffer("Java");


        StringBuffer sb3 =
                new StringBuffer(50);



        System.out.println("Original StringBuffer : " + sb2);





        // =========================================================================
        // 1. length()
        // =========================================================================


        System.out.println("\n1. length()");


        System.out.println(sb2.length());





        // =========================================================================
        // 2. capacity()
        // =========================================================================


        System.out.println("\n2. capacity()");


        System.out.println(sb2.capacity());

        /*
            Default Capacity:

            new StringBuffer()
            = 16

            StringBuffer("Java")
            = 16 + String Length

        */





        // =========================================================================
        // 3. append()
        // Overloaded Methods
        //
        // append(String)
        // append(int)
        // append(char)
        // append(boolean)
        // append(double)
        // append(Object)
        // =========================================================================



        System.out.println("\n3. append()");


        sb2.append(" Programming");


        sb2.append(100);


        sb2.append(true);


        sb2.append('A');



        System.out.println(sb2);







        // =========================================================================
        // 4. insert()
        //
        // insert(int,String)
        // insert(int,char)
        // insert(int,int)
        // insert(int,Object)
        // =========================================================================



        System.out.println("\n4. insert()");


        sb2.insert(5,"JAVA");


        System.out.println(sb2);







        // =========================================================================
        // 5. replace()
        // =========================================================================



        System.out.println("\n5. replace()");


        StringBuffer replace =
                new StringBuffer("Java Programming");


        replace.replace(
                5,
                16,
                "Language"
        );


        System.out.println(replace);







        // =========================================================================
        // 6. delete()
        // =========================================================================



        System.out.println("\n6. delete()");


        StringBuffer delete =
                new StringBuffer("Java Programming");


        delete.delete(4,15);


        System.out.println(delete);







        // =========================================================================
        // 7. deleteCharAt()
        // =========================================================================



        System.out.println("\n7. deleteCharAt()");


        StringBuffer delChar =
                new StringBuffer("JAVA");


        delChar.deleteCharAt(1);


        System.out.println(delChar);








        // =========================================================================
        // 8. reverse()
        // =========================================================================



        System.out.println("\n8. reverse()");


        StringBuffer reverse =
                new StringBuffer("Java");


        reverse.reverse();


        System.out.println(reverse);








        // =========================================================================
        // 9. charAt()
        // =========================================================================



        System.out.println("\n9. charAt()");


        System.out.println(
                sb2.charAt(0)
        );








        // =========================================================================
        // 10. setCharAt()
        // =========================================================================



        System.out.println("\n10. setCharAt()");


        StringBuffer setChar =
                new StringBuffer("JAVA");


        setChar.setCharAt(
                0,
                'M'
        );


        System.out.println(setChar);








        // =========================================================================
        // 11. substring()
        //
        // substring(int)
        // substring(int,int)
        // =========================================================================



        System.out.println("\n11. substring()");


        StringBuffer sub =
                new StringBuffer("Java Programming");


        System.out.println(
                sub.substring(5)
        );


        System.out.println(
                sub.substring(0,4)
        );









        // =========================================================================
        // 12. subSequence()
        // =========================================================================



        System.out.println("\n12. subSequence()");


        System.out.println(
                sb2.subSequence(0,4)
        );









        // =========================================================================
        // 13. indexOf()
        //
        // indexOf(String)
        // indexOf(String,int)
        // =========================================================================



        System.out.println("\n13. indexOf()");


        StringBuffer search =
                new StringBuffer("Java Programming Java");


        System.out.println(
                search.indexOf("Java")
        );


        System.out.println(
                search.indexOf("Java",5)
        );









        // =========================================================================
        // 14. lastIndexOf()
        //
        // lastIndexOf(String)
        // lastIndexOf(String,int)
        // =========================================================================



        System.out.println("\n14. lastIndexOf()");


        System.out.println(
                search.lastIndexOf("Java")
        );



        System.out.println(
                search.lastIndexOf("Java",15)
        );








        // =========================================================================
        // 15. ensureCapacity()
        // =========================================================================



        System.out.println("\n15. ensureCapacity()");


        StringBuffer capacity =
                new StringBuffer();


        System.out.println(
                capacity.capacity()
        );


        capacity.ensureCapacity(100);


        System.out.println(
                capacity.capacity()
        );








        // =========================================================================
        // 16. trimToSize()
        // =========================================================================



        System.out.println("\n16. trimToSize()");


        StringBuffer trim =
                new StringBuffer(100);


        trim.append("Java");


        System.out.println(
                trim.capacity()
        );


        trim.trimToSize();


        System.out.println(
                trim.capacity()
        );









        // =========================================================================
        // 17. setLength()
        // =========================================================================



        System.out.println("\n17. setLength()");


        StringBuffer setLength =
                new StringBuffer("Programming");


        setLength.setLength(5);


        System.out.println(setLength);










        // =========================================================================
        // 18. capacity expansion
        // =========================================================================



        System.out.println("\n18. Capacity Growth");


        StringBuffer grow =
                new StringBuffer();


        System.out.println(
                grow.capacity()
        );


        grow.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");


        System.out.println(
                grow.capacity()
        );









        // =========================================================================
        // 19. toString()
        // =========================================================================



        System.out.println("\n19. toString()");


        String normalString =
                sb2.toString();


        System.out.println(normalString);









        // =========================================================================
        // 20. equals()
        // =========================================================================



        System.out.println("\n20. equals()");


        StringBuffer a =
                new StringBuffer("Java");


        StringBuffer b =
                new StringBuffer("Java");



        System.out.println(
                a.equals(b)
        );



        /*
            StringBuffer equals()
            compares reference

            Unlike String
        */







        // =========================================================================
        // 21. compareTo()
        // =========================================================================



        System.out.println("\n21. compareTo()");


        StringBuffer c =
                new StringBuffer("Apple");


        StringBuffer d =
                new StringBuffer("Banana");



        System.out.println(
                c.compareTo(d)
        );









        // =========================================================================
        // 22. chars()
        // Java 8
        // =========================================================================



        System.out.println("\n22. chars()");


        sb2.chars()
                .forEach(
                        x -> System.out.print((char)x+" ")
                );









        // =========================================================================
        // 23. codePoints()
        // =========================================================================



        System.out.println("\n\n23. codePoints()");


        sb2.codePoints()
                .forEach(System.out::println);









        // =========================================================================
        // STRINGBUFFER PROPERTIES
        // =========================================================================



        System.out.println("\n========= PROPERTIES =========");



        // Length

        System.out.println(
                "Length : "
                +
                sb2.length()
        );



        // Capacity

        System.out.println(
                "Capacity : "
                +
                sb2.capacity()
        );



        // Mutable

        StringBuffer mutable =
                new StringBuffer("Hello");


        mutable.append(" World");


        System.out.println(
                "Mutable : "
                +
                mutable
        );








        // =========================================================================
        // REAL WORLD EXAMPLES
        // =========================================================================



        System.out.println("\n========= REAL WORLD =========");





        // 1. Building Dynamic SQL Query


        StringBuffer query =
                new StringBuffer();


        query.append("SELECT * FROM USER WHERE ID=");


        query.append(101);



        System.out.println(
                query
        );





        // 2. Reverse Password


        StringBuffer password =
                new StringBuffer("Admin123");


        System.out.println(
                password.reverse()
        );





        // 3. Dynamic Message


        StringBuffer message =
                new StringBuffer();


        message.append("Welcome ");


        message.append("Mohit");


        message.append(" To Java");


        System.out.println(
                message
        );






        System.out.println(
                "\n===================================="
        );


        System.out.println(
                "ALL STRINGBUFFER METHODS COMPLETED"
        );


        System.out.println(
                "===================================="
        );


    }

}
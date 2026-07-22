/*
===============================================================================
                 JAVA STRINGBUILDER CLASS - ALL METHODS DEMO
===============================================================================

✔ Covers Basic To Advanced StringBuilder Methods
✔ Covers All Important Methods
✔ Covers Overloaded Methods
✔ Covers Mutable String Operations
✔ Covers Append / Insert / Replace
✔ Covers Delete / Reverse
✔ Covers Capacity Management
✔ Covers Searching
✔ Covers Conversion
✔ Covers Java 8+ Stream Methods
✔ Covers Real World Examples

PACKAGE:
java.lang.StringBuilder (Automatically Imported)

NOTE:
StringBuilder is NOT synchronized (Not Thread Safe)
StringBuffer is synchronized (Thread Safe)

===============================================================================
*/


public class All_StringBuilder_Methods {


    public static void main(String[] args) {



        // =========================================================================
        // STRINGBUILDER CREATION
        // =========================================================================


        StringBuilder sb1 =
                new StringBuilder();


        StringBuilder sb2 =
                new StringBuilder("Java");


        StringBuilder sb3 =
                new StringBuilder(50);



        System.out.println(
                "Original StringBuilder : "
                +
                sb2
        );






        // =========================================================================
        // 1. length()
        // =========================================================================


        System.out.println("\n1. length()");


        System.out.println(
                sb2.length()
        );







        // =========================================================================
        // 2. capacity()
        // =========================================================================


        System.out.println("\n2. capacity()");


        System.out.println(
                sb2.capacity()
        );



        /*
           Default Capacity

           new StringBuilder()
           = 16

           new StringBuilder("Java")
           = 16 + length
        */








        // =========================================================================
        // 3. append()
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



        sb2.insert(
                5,
                "JAVA"
        );



        System.out.println(sb2);









        // =========================================================================
        // 5. replace()
        // =========================================================================



        System.out.println("\n5. replace()");



        StringBuilder replace =
                new StringBuilder(
                        "Java Programming"
                );



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



        StringBuilder delete =
                new StringBuilder(
                        "Java Programming"
                );



        delete.delete(
                4,
                15
        );



        System.out.println(delete);









        // =========================================================================
        // 7. deleteCharAt()
        // =========================================================================



        System.out.println("\n7. deleteCharAt()");



        StringBuilder deleteChar =
                new StringBuilder(
                        "JAVA"
                );



        deleteChar.deleteCharAt(1);



        System.out.println(deleteChar);









        // =========================================================================
        // 8. reverse()
        // =========================================================================



        System.out.println("\n8. reverse()");



        StringBuilder reverse =
                new StringBuilder(
                        "Java"
                );



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



        StringBuilder setChar =
                new StringBuilder(
                        "JAVA"
                );



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



        StringBuilder sub =
                new StringBuilder(
                        "Java Programming"
                );



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
                sb2.subSequence(
                        0,
                        4
                )
        );









        // =========================================================================
        // 13. indexOf()
        //
        // indexOf(String)
        // indexOf(String,int)
        // =========================================================================



        System.out.println("\n13. indexOf()");



        StringBuilder search =
                new StringBuilder(
                        "Java Programming Java"
                );



        System.out.println(
                search.indexOf("Java")
        );



        System.out.println(
                search.indexOf(
                        "Java",
                        5
                )
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
                search.lastIndexOf(
                        "Java",
                        15
                )
        );









        // =========================================================================
        // 15. ensureCapacity()
        // =========================================================================



        System.out.println("\n15. ensureCapacity()");



        StringBuilder capacity =
                new StringBuilder();



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



        StringBuilder trim =
                new StringBuilder(100);



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



        StringBuilder length =
                new StringBuilder(
                        "Programming"
                );



        length.setLength(5);



        System.out.println(length);









        // =========================================================================
        // 18. toString()
        // =========================================================================



        System.out.println("\n18. toString()");



        String normalString =
                sb2.toString();



        System.out.println(
                normalString
        );



        // =========================================================================
        // 19. compareTo()
        // =========================================================================



        System.out.println("\n19. compareTo()");



        StringBuilder a =
                new StringBuilder(
                        "Apple"
                );


        StringBuilder b =
                new StringBuilder(
                        "Banana"
                );



        System.out.println(
                a.compareTo(b)
        );



        // =========================================================================
        // 20. equals()
        // =========================================================================



        System.out.println("\n20. equals()");



        StringBuilder x =
                new StringBuilder(
                        "Java"
                );


        StringBuilder y =
                new StringBuilder(
                        "Java"
                );



        System.out.println(
                x.equals(y)
        );



        /*
            StringBuilder equals()

            Checks reference

            Not content comparison
        */










        // =========================================================================
        // 21. chars()
        // Java 8
        // =========================================================================



        System.out.println("\n21. chars()");



        sb2.chars()
                .forEach(
                        c ->
                        System.out.print(
                                (char)c+" "
                        )
                );









        // =========================================================================
        // 22. codePoints()
        // Java 8
        // =========================================================================



        System.out.println("\n\n22. codePoints()");



        sb2.codePoints()
                .forEach(
                        System.out::println
                );









        // =========================================================================
        // STRINGBUILDER PROPERTIES
        // =========================================================================



        System.out.println(
                "\n========= PROPERTIES ========="
        );



        System.out.println(
                "Length : "
                +
                sb2.length()
        );


        System.out.println(
                "Capacity : "
                +
                sb2.capacity()
        );



        StringBuilder mutable =
                new StringBuilder(
                        "Hello"
                );



        mutable.append(
                " World"
        );



        System.out.println(
                "Mutable : "
                +
                mutable
        );









        // =========================================================================
        // REAL WORLD EXAMPLES
        // =========================================================================



        System.out.println(
                "\n========= REAL WORLD ========="
        );





        // 1. Dynamic SQL Query


        StringBuilder query =
                new StringBuilder();



        query.append(
                "SELECT * FROM USER WHERE ID="
        );



        query.append(101);



        System.out.println(
                query
        );







        // 2. Dynamic Email Message



        StringBuilder email =
                new StringBuilder();



        email.append(
                "Hello "
        );


        email.append(
                "User"
        );


        email.append(
                ", Welcome"
        );



        System.out.println(
                email
        );







        // 3. Reverse Data



        StringBuilder password =
                new StringBuilder(
                        "Admin123"
                );



        System.out.println(
                password.reverse()
        );







        System.out.println(
                "\n================================="
        );


        System.out.println(
                "ALL STRINGBUILDER METHODS COMPLETED"
        );


        System.out.println(
                "================================="
        );



    }

}
/*
================================================================================
                 JAVA COMPLETE DATA TYPE CONVERSION DEMO
================================================================================

Topics Covered:

1. Primitive Data Type Conversion
   --------------------------------
   byte ↔ short
   short ↔ int
   int ↔ long
   long ↔ float
   float ↔ double
   char ↔ int


2. String Conversion
   --------------------------------
   int → String
   String → int

   double → String
   String → double

   float → String
   String → float

   long → String
   String → long

   boolean → String
   String → boolean


3. Character Conversion
   --------------------------------
   char → String
   String → char
   String → char[]
   char[] → String


4. Byte Conversion
   --------------------------------
   String → byte[]
   byte[] → String


5. Array Conversion
   --------------------------------
   Array → String
   String → Array
   String Array → Single String


6. Wrapper Conversion
   --------------------------------
   int ↔ Integer
   double ↔ Double


Real World Usage:

- API Request Data Conversion
- Database Value Conversion
- JSON Processing
- File Handling
- Encryption
- Network Communication

================================================================================
*/


import java.util.Arrays;


public class All_Data_Type_Conversion {

    public static void main(String[] args) {

        /*
        ============================================================
                    1. PRIMITIVE TYPE CONVERSION
        ============================================================
        Widening:
        Small Data Type → Large Data Type

        Automatic Conversion

        byte → short → int → long → float → double

        ============================================================
        */

        int number = 100;

        // int → double

        double doubleValue = number;

        System.out.println("int to double : " + doubleValue);


        /*
        ============================================================
        Narrowing Conversion

        Large Data Type → Small Data Type

        Manual Casting Required

        ============================================================
        */

        double price = 99.99;

        int intPrice = (int) price;

        System.out.println("double to int : " + intPrice);
        /*
        ============================================================
                    2. INTEGER CONVERSION
        ============================================================
        */

        // int → String

        int id = 101;


        String idString = String.valueOf(id);

        System.out.println("int to String : " + idString);

        // String → int


        int convertedId =
                Integer.parseInt(idString);

        System.out.println("String to int : " + convertedId);

        /*
        ============================================================
                    3. DOUBLE CONVERSION
        ============================================================
        */

        double amount = 450.50;

        // double → String

        String amountString =
                String.valueOf(amount);

        System.out.println(
                "double to String : "
                + amountString
        );

        // String → double

        double newAmount =
                Double.parseDouble(amountString);


        System.out.println(
                "String to double : "
                + newAmount
        );

        /*
        ============================================================
                    4. FLOAT CONVERSION
        ============================================================
        */

        float rating = 4.5f;

        // float → String

        String ratingString =
                Float.toString(rating);

        System.out.println(
                "float to String : "
                + ratingString
        );


        // String → float

        float newRating =
                Float.parseFloat(ratingString);

        System.out.println(
                "String to float : "
                + newRating
        );

        /*
        ============================================================
                    5. LONG CONVERSION
        ============================================================
        */

        long mobileNumber = 987654321;

        // long → String

        String mobileString =
                Long.toString(mobileNumber);

        System.out.println(
                "long to String : "
                + mobileString
        );

        // String → long

        long newMobile =
                Long.parseLong(mobileString);

        System.out.println(
                "String to long : "
                + newMobile
        );

        /*
        ============================================================
                    6. BOOLEAN CONVERSION
        ============================================================
        */

        boolean status = true;

        // boolean → String

        String statusString =
                String.valueOf(status);

        System.out.println(
                "boolean to String : "
                + statusString
        );


        // String → boolean

        boolean newStatus =
                Boolean.parseBoolean(statusString);

        System.out.println(
                "String to boolean : "
                + newStatus
        );

        /*
        ============================================================
                    7. CHARACTER CONVERSION
        ============================================================
        */


        char letter = 'A';

        // char → String


        String charString =
                String.valueOf(letter);

        System.out.println(
                "char to String : "
                + charString
        );

        // String → char


        char newChar =
                charString.charAt(0);

        System.out.println(
                "String to char : "
                + newChar
        );

        /*
        ============================================================
                    8. STRING AND CHAR ARRAY
        ============================================================
        */


        String language = "JAVA";

        // String → char[]

        char chars[] =
                language.toCharArray();


        System.out.println(
                "String to char array : "
                + Arrays.toString(chars)
        );

        // char[] → String


        String charArrayString =
                new String(chars);

        System.out.println(
                "char array to String : "
                + charArrayString
        );

        /*
        ============================================================
                    9. STRING AND BYTE ARRAY
        ============================================================
        */


        String data = "Java";



        // String → byte[]


        byte bytes[] =
                data.getBytes();

        System.out.println(
                "String to byte array : "
                + Arrays.toString(bytes)
        );


        // byte[] → String


        String byteString =
                new String(bytes);


        System.out.println(
                "byte array to String : "
                + byteString
        );

        /*
        ============================================================
                    10. ARRAY CONVERSION
        ============================================================
        */

        int numbers[] =
                {10,20,30};

        // Array → String

        String arrayString =
                Arrays.toString(numbers);


        System.out.println(
                "Array to String : "
                + arrayString
        );

        /*
        ============================================================
                    11. STRING → ARRAY

        split() divides String into array

        Real World:
        CSV File Processing

        ============================================================
        */

        String skills =
                "Java Python SQL";


        String skillArray[] =
                skills.split(" ");



        System.out.println(
                "String to Array : "
                + Arrays.toString(skillArray)
        );

        /*
        ============================================================
                    12. STRING ARRAY → SINGLE STRING

        join()

        ============================================================
        */

        String names[] =
                {
                        "Mohit",
                        "Rahul",
                        "Amit"
                };


        String joinedString =
                String.join("-", names);


        System.out.println(
                "Array to Single String : "
                + joinedString
        );

        /*
        ============================================================
                    13. INTEGER OBJECT CONVERSION

        Autoboxing

        Primitive → Wrapper Object

        ============================================================
        */

        int value = 500;

        Integer integerObject = value;

        System.out.println(
                "int to Integer Object : "
                + integerObject
        );

        /*
        ============================================================
                    14. INTEGER OBJECT TO PRIMITIVE

        Unboxing

        ============================================================
        */
        Integer obj = 700;

        int primitiveValue = obj;

        System.out.println(
                "Integer Object to int : "
                + primitiveValue
        );
        /*
        ============================================================
                    15. CHAR AND ASCII VALUE

        char → int

        ============================================================
        */


        char asciiChar = 'A';


        int asciiValue =
                (int)asciiChar;

        System.out.println(
                "char to ASCII : "
                + asciiValue
        );

        /*
        int → char

        ASCII to Character

        */

        int ascii = 66;


        char asciiCharacter =
                (char)ascii;


        System.out.println(
                "ASCII to char : "
                + asciiCharacter
        );

        /*
        ============================================================
                    FINAL OUTPUT

        ALL JAVA DATA TYPE CONVERSIONS COMPLETED

        ============================================================
        */

        System.out.println(
                "\n================================"
        );


        System.out.println(
                "ALL DATA TYPE CONVERSION COMPLETED"
        );


        System.out.println(
                "================================"
        );

    }
}
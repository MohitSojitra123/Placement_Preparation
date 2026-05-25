/*
===============================================================================
                 JAVA CHARACTER CLASS - ALL METHODS DEMO
===============================================================================

✔ Covers Basic To Advanced Character Methods
✔ Covers Unicode Methods
✔ Covers ASCII Methods
✔ Covers Conversion Methods
✔ Covers Validation Methods
✔ Covers Comparison Methods
✔ Covers Character Properties
✔ Covers Static Utility Methods
✔ Covers Code Point Methods
✔ Covers Real World Examples
✔ Single Complete Program

PACKAGE:
import java.lang.Character;

===============================================================================
*/

public class All_Character_Methods {

    public static void main(String[] args) {

        // =========================================================================
        // CHARACTER DECLARATION
        // =========================================================================

        char ch1 = 'A';
        char ch2 = 'a';
        char digit = '5';
        char space = ' ';
        char symbol = '@';

        System.out.println("ORIGINAL CHARACTERS");
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(digit);

        // =========================================================================
        // 1. isLetter()
        // =========================================================================

        System.out.println("\n1. Character.isLetter()");
        System.out.println(Character.isLetter(ch1));
        System.out.println(Character.isLetter(digit));

        // =========================================================================
        // 2. isDigit()
        // =========================================================================

        System.out.println("\n2. Character.isDigit()");
        System.out.println(Character.isDigit(digit));
        System.out.println(Character.isDigit(ch1));

        // =========================================================================
        // 3. isLetterOrDigit()
        // =========================================================================

        System.out.println("\n3. Character.isLetterOrDigit()");
        System.out.println(Character.isLetterOrDigit(ch1));
        System.out.println(Character.isLetterOrDigit(symbol));

        // =========================================================================
        // 4. isUpperCase()
        // =========================================================================

        System.out.println("\n4. Character.isUpperCase()");
        System.out.println(Character.isUpperCase(ch1));
        System.out.println(Character.isUpperCase(ch2));

        // =========================================================================
        // 5. isLowerCase()
        // =========================================================================

        System.out.println("\n5. Character.isLowerCase()");
        System.out.println(Character.isLowerCase(ch2));
        System.out.println(Character.isLowerCase(ch1));

        // =========================================================================
        // 6. toUpperCase()
        // =========================================================================

        System.out.println("\n6. Character.toUpperCase()");
        System.out.println(Character.toUpperCase(ch2));

        // =========================================================================
        // 7. toLowerCase()
        // =========================================================================

        System.out.println("\n7. Character.toLowerCase()");
        System.out.println(Character.toLowerCase(ch1));

        // =========================================================================
        // 8. toString()
        // =========================================================================

        System.out.println("\n8. Character.toString()");
        System.out.println(Character.toString(ch1));

        // =========================================================================
        // 9. valueOf()
        // =========================================================================

        System.out.println("\n9. Character.valueOf()");
        Character obj = Character.valueOf('Z');
        System.out.println(obj);

        // =========================================================================
        // 10. compare()
        // =========================================================================

        System.out.println("\n10. Character.compare()");
        System.out.println(Character.compare('A', 'B'));

        // =========================================================================
        // 11. compareTo()
        // =========================================================================

        System.out.println("\n11. compareTo()");
        Character c1 = 'C';
        Character c2 = 'D';

        System.out.println(c1.compareTo(c2));

        // =========================================================================
        // 12. equals()
        // =========================================================================

        System.out.println("\n12. equals()");
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals('C'));

        // =========================================================================
        // 13. hashCode()
        // =========================================================================

        System.out.println("\n13. hashCode()");
        System.out.println(Character.hashCode(ch1));

        // =========================================================================
        // 14. charValue()
        // =========================================================================

        System.out.println("\n14. charValue()");
        Character cc = 'X';

        System.out.println(cc.charValue());

        // =========================================================================
        // 15. isWhitespace()
        // =========================================================================

        System.out.println("\n15. isWhitespace()");
        System.out.println(Character.isWhitespace(space));

        // =========================================================================
        // 16. isSpaceChar()
        // =========================================================================

        System.out.println("\n16. isSpaceChar()");
        System.out.println(Character.isSpaceChar(space));

        // =========================================================================
        // 17. isAlphabetic()
        // =========================================================================

        System.out.println("\n17. isAlphabetic()");
        System.out.println(Character.isAlphabetic(ch1));

        // =========================================================================
        // 18. isJavaIdentifierStart()
        // =========================================================================

        System.out.println("\n18. isJavaIdentifierStart()");
        System.out.println(Character.isJavaIdentifierStart('A'));
        System.out.println(Character.isJavaIdentifierStart('1'));

        // =========================================================================
        // 19. isJavaIdentifierPart()
        // =========================================================================

        System.out.println("\n19. isJavaIdentifierPart()");
        System.out.println(Character.isJavaIdentifierPart('1'));

        // =========================================================================
        // 20. isISOControl()
        // =========================================================================

        System.out.println("\n20. isISOControl()");
        System.out.println(Character.isISOControl('\n'));

        // =========================================================================
        // 21. getNumericValue()
        // =========================================================================

        System.out.println("\n21. getNumericValue()");
        System.out.println(Character.getNumericValue('9'));

        // =========================================================================
        // 22. digit()
        // =========================================================================

        System.out.println("\n22. digit()");
        System.out.println(Character.digit('A', 16));

        // =========================================================================
        // 23. forDigit()
        // =========================================================================

        System.out.println("\n23. forDigit()");
        System.out.println(Character.forDigit(10, 16));

        // =========================================================================
        // 24. reverseBytes()
        // =========================================================================

        System.out.println("\n24. reverseBytes()");
        System.out.println((int)Character.reverseBytes('A'));

        // =========================================================================
        // 25. getType()
        // =========================================================================

        System.out.println("\n25. getType()");
        System.out.println(Character.getType('A'));

        // =========================================================================
        // 26. getDirectionality()
        // =========================================================================

        System.out.println("\n26. getDirectionality()");
        System.out.println(Character.getDirectionality('A'));

        // =========================================================================
        // 27. isMirrored()
        // =========================================================================

        System.out.println("\n27. isMirrored()");
        System.out.println(Character.isMirrored('('));

        // =========================================================================
        // 28. codePointAt()
        // =========================================================================

        System.out.println("\n28. codePointAt()");

        char arr[] = {'J','A','V','A'};

        System.out.println(Character.codePointAt(arr, 0));

        // =========================================================================
        // 29. codePointBefore()
        // =========================================================================

        System.out.println("\n29. codePointBefore()");
        System.out.println(Character.codePointBefore(arr, 2));

        // =========================================================================
        // 30. codePointCount()
        // =========================================================================

        System.out.println("\n30. codePointCount()");

        char unicode[] = {'J','A','V','A'};

        System.out.println(
                Character.codePointCount(
                        unicode,
                        0,
                        unicode.length
                )
        );

        // =========================================================================
        // 31. offsetByCodePoints()
        // =========================================================================

        System.out.println("\n31. offsetByCodePoints()");

        System.out.println(
                Character.offsetByCodePoints(
                        unicode,
                        0,
                        unicode.length,
                        0,
                        2
                )
        );

        // =========================================================================
        // 32. toChars()
        // =========================================================================

        System.out.println("\n32. toChars()");

        char chars[] = Character.toChars(65);

        System.out.println(chars);

        // =========================================================================
        // 33. toCodePoint()
        // =========================================================================

        System.out.println("\n33. toCodePoint()");

        System.out.println(
                Character.toCodePoint(
                        '\uD800',
                        '\uDC00'
                )
        );

        // =========================================================================
        // 34. isDefined()
        // =========================================================================

        System.out.println("\n34. isDefined()");
        System.out.println(Character.isDefined('A'));

        // =========================================================================
        // 35. isBmpCodePoint()
        // =========================================================================

        System.out.println("\n35. isBmpCodePoint()");
        System.out.println(Character.isBmpCodePoint(65));

        // =========================================================================
        // 36. isValidCodePoint()
        // =========================================================================

        System.out.println("\n36. isValidCodePoint()");
        System.out.println(Character.isValidCodePoint(1000));

        // =========================================================================
        // 37. isSupplementaryCodePoint()
        // =========================================================================

        System.out.println("\n37. isSupplementaryCodePoint()");
        System.out.println(
                Character.isSupplementaryCodePoint(0x1F600)
        );

        // =========================================================================
        // 38. UnicodeBlock.of()
        // =========================================================================

        System.out.println("\n38. UnicodeBlock.of()");

        System.out.println(
                Character.UnicodeBlock.of('A')
        );

        // =========================================================================
        // 39. UnicodeScript.of()
        // =========================================================================

        System.out.println("\n39. UnicodeScript.of()");

        System.out.println(
                Character.UnicodeScript.of('A')
        );

        // =========================================================================
        // 40. SIZE
        // =========================================================================

        System.out.println("\n40. Character.SIZE");
        System.out.println(Character.SIZE);

        // =========================================================================
        // 41. BYTES
        // =========================================================================

        System.out.println("\n41. Character.BYTES");
        System.out.println(Character.BYTES);

        // =========================================================================
        // 42. MIN_VALUE
        // =========================================================================

        System.out.println("\n42. Character.MIN_VALUE");
        System.out.println((int)Character.MIN_VALUE);

        // =========================================================================
        // 43. MAX_VALUE
        // =========================================================================

        System.out.println("\n43. Character.MAX_VALUE");
        System.out.println((int)Character.MAX_VALUE);

        // =========================================================================
        // 44. TYPE
        // =========================================================================

        System.out.println("\n44. Character.TYPE");
        System.out.println(Character.TYPE);

        // =========================================================================
        // REAL WORLD EXAMPLES
        // =========================================================================

        System.out.println("\n==============================");
        System.out.println("REAL WORLD EXAMPLES");
        System.out.println("==============================");

        // =========================================================================
        // PASSWORD VALIDATION
        // =========================================================================

        String password = "Java123";

        boolean hasDigit = false;
        boolean hasUpper = false;

        for(int i=0; i<password.length(); i++){

            char ch = password.charAt(i);

            if(Character.isDigit(ch)){
                hasDigit = true;
            }

            if(Character.isUpperCase(ch)){
                hasUpper = true;
            }
        }

        System.out.println("Password Has Digit : " + hasDigit);
        System.out.println("Password Has Uppercase : " + hasUpper);

        // =========================================================================
        // LETTER COUNT
        // =========================================================================

        String text = "Java Programming 123";

        int letters = 0;

        for(int i=0; i<text.length(); i++){

            if(Character.isLetter(text.charAt(i))){
                letters++;
            }
        }

        System.out.println("Total Letters : " + letters);

        // =========================================================================
        // DIGIT COUNT
        // =========================================================================

        int digits = 0;

        for(int i=0; i<text.length(); i++){

            if(Character.isDigit(text.charAt(i))){
                digits++;
            }
        }

        System.out.println("Total Digits : " + digits);

        // =========================================================================
        // FINAL MESSAGE
        // =========================================================================

        System.out.println("\n==============================================");
        System.out.println("ALL IMPORTANT CHARACTER METHODS COMPLETED");
        System.out.println("==============================================");
    }
}
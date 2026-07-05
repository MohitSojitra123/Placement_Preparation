
//  s1 ==>  ABCD 
//  s1+s1 ==> ABCDABCD
// s2 ==> BCDA
// s2 ==> BCAD

// (s1+s1).contains(s2) ==> True
// (s1+s1).contains(s2) ==> False



public class RotationCheck {

    public static void main(String[] args) {

        String s1 = "ABCDE";
        // String s2 = "CDBA";
        String s2 = "CDEAB";

        if (s1.length() == s2.length() &&
            (s1 + s1).contains(s2)) {

            System.out.println("Rotation");
        } else {
            System.out.println("Not Rotation");
        }
    }
}
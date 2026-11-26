// 34 Given a time in the format of hh:mm (12-hour format)  
// 0 < hh < 12, 0 <= mm < 60. The task is to convert it into words as shown:  
// Input: h = 5, m = 0 
// Output: five o' clock  
// Input: h = 6, m = 24 
// Output: twenty four minutes past six  
// 5:00 → five o’ clock 
// 5:01 → one minute past five 
// 5:10 → ten minutes past five 
// 5:15 → quarter past five 
// 5:30 → half past five 
// 5:40 → twenty minutes to six 
// 5:45 → quarter to six 
// 5:47 → thirteen minutes to six 
// 5:28 → twenty eight minutes past five

public class Problem_34 {

    static String[] words = {
            "zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen", "twenty", "twenty one", "twenty two",
            "twenty three", "twenty four", "twenty five",
            "twenty six", "twenty seven", "twenty eight",
            "twenty nine"
    };

    public static void main(String[] args) {

        int h = 5;
        int m = 47;

        if (m == 0) {
            System.out.println(words[h] + " o' clock");
        } 
        else if (m == 15) {
            System.out.println("quarter past " + words[h]);
        } 
        else if (m == 30) {
            System.out.println("half past " + words[h]);
        } 
        else if (m == 45) {
            System.out.println("quarter to " + words[(h % 12) + 1]);
        } 
        else if (m < 30) {

            if (m == 1) {
                System.out.println(words[m] + " minute past " + words[h]);
            } else {
                System.out.println(words[m] + " minutes past " + words[h]);
            }

        } 
        else {

            int remaining = 60 - m;
            int nextHour = (h % 12) + 1;

            if (remaining == 1) {
                System.out.println(words[remaining] + " minute to " + words[nextHour]);
            } else {
                System.out.println(words[remaining] + " minutes to " + words[nextHour]);
            }
        }
    }
}
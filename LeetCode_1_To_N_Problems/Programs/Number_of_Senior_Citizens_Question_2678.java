public class Number_of_Senior_Citizens_Question_2678 {

    public static void main(String[] args) {

        // Static Input
        String[] details = {
            "7868190130M7522",
            "5303914400F9211",
            "9273338290F4011"
        };

        int result = countSeniors(details);

        System.out.println("Number of Senior Citizens : " + result);
    }

    public static int countSeniors(String[] details) {

        int count = 0;

        // Traverse through all passenger details
        for (int i = 0; i < details.length; i++) {

            // Extract age from index 11 to 12
            // substring(11, 13) means index 11 and 12
            int age = Integer.parseInt(details[i].substring(11, 13));

            // Check if age is greater than 60
            if (age > 60) {
                count++;
            }
        }

        return count;
    }
}
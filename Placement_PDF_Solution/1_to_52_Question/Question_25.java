// WAP for following Scenario. 
// Given  n  rupees  and  a  chocolate  price  of  m  for  each  chocolate,  with  a  wrapper  exchange  offer  of  1 
// chocolate per k wrappers, calculate the total number of chocolates you can eat with n rupees. 

public class Question_25 {
    public static void main(String[] args) {
        int n = 15; // Total money
        int m = 1;  // Price of one chocolate
        int k = 3;  // Wrappers needed for one free chocolate

        int chocolates = n / m; 
        int wrappers = chocolates;
        int totalChocolates = chocolates;

        while (wrappers >= k) {
            int freeChocolates = wrappers / k;
            totalChocolates += freeChocolates;

            wrappers = (wrappers % k) + freeChocolates;
        }

        System.out.println("Total chocolates eaten = " + totalChocolates);
    }
}
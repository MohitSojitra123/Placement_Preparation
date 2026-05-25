// Create a class which ask the user to enter a sentence, and it should display count of
// each vowel type in the sentence. The program should continue till user enters a word
// “quit”. Display the total count of each vowel for all sentences.

import java.util.Scanner;

public class Program_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalA = 0, totalE = 0, totalI = 0, totalO = 0, totalU = 0;

        while (true) {
            System.out.print("Enter a sentence (or type 'quit' to exit): ");
            String sentence = sc.nextLine();

            // Stop condition
            if (sentence.equalsIgnoreCase("quit")) {
                break;
            }


            int countA = 0, countE = 0, countI = 0, countO = 0, countU = 0;

            sentence = sentence.toLowerCase();

            for (int i = 0; i < sentence.length(); i++) {
                char ch = sentence.charAt(i);
                switch (ch) {
                    case 'a': countA++; break;
                    case 'e': countE++; break;
                    case 'i': countI++; break;
                    case 'o': countO++; break;
                    case 'u': countU++; break;
                }
            }

            // Display counts for current sentence
            System.out.println("Vowel counts in this sentence:");
            System.out.println("A: " + countA + ", E: " + countE + ", I: " + countI + ", O: " + countO + ", U: " + countU);

            totalA += countA;
            totalE += countE;
            totalI += countI;
            totalO += countO;
            totalU += countU;

            System.out.println("-----------------------------------");
        }

        // Display total vowel counts
        System.out.println("\nTotal vowel counts for all sentences:");
        System.out.println("A: " + totalA + ", E: " + totalE + ", I: " + totalI + ", O: " + totalO + ", U: " + totalU);

        sc.close();
    }
}


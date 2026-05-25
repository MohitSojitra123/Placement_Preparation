import java.util.Scanner;

public class Number_System_Conversion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Decimal Input
        System.out.print("Enter Decimal Number : ");
        int decimal = sc.nextInt();

        // Decimal to Other Number Systems
        String binary = Integer.toBinaryString(decimal);
        String octal = Integer.toOctalString(decimal);
        String hexa = Integer.toHexString(decimal);

        System.out.println("\n----- Decimal Conversions -----");

        System.out.println("Binary       : " + binary);
        System.out.println("Octal        : " + octal);
        System.out.println("Hexadecimal  : " + hexa);

        // Binary to Decimal
        System.out.print("\nEnter Binary Number : ");
        String binaryInput = sc.next();

        int binaryToDecimal = Integer.parseInt(binaryInput, 2);

        System.out.println("Binary To Decimal : " + binaryToDecimal);

        // Octal to Decimal
        System.out.print("\nEnter Octal Number : ");
        String octalInput = sc.next();

        int octalToDecimal = Integer.parseInt(octalInput, 8);

        System.out.println("Octal To Decimal : " + octalToDecimal);

        // Hexadecimal to Decimal
        System.out.print("\nEnter Hexadecimal Number : ");
        String hexaInput = sc.next();

        int hexaToDecimal = Integer.parseInt(hexaInput, 16);

        System.out.println("Hexadecimal To Decimal : " + hexaToDecimal);
    }
}
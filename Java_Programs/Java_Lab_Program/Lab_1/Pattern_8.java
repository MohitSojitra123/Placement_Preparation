//             d
//           d a
//         d a r
//       d a r s
//     d a r s h
//    d a r s h a
//  d a r s h a n

import java.util.Scanner;

public class Pattern_8 {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

        System.out.println("Enter String => ");
        String str=sc.nextLine();

        for(int i=0;  i<str.length(); i++){

            for(int space=i; space<str.length(); space++){
                System.out.print(" ");
            }

            for(int j=0; j<=i; j++){
                System.out.print(str.charAt(j)+" ");
            }

            System.out.println();
        }
    }
}

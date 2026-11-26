// // class InValidAge extends Exception {

// //     InValidAge(String str) {
// //         super(str);
// //     }
// // }

// // public class Custome_throw {

// //     public static void main(String[] args) throws InValidAge {

// //         int Age = 10;

// //         if (Age >= 18) {
// //             System.out.println("Eligible");
// //         } else {
// //             throw new InValidAge("Not Eligible");
// //         }
// //     }
// // }

// class InValidAge extends Exception {

//     InValidAge(String str) {
//         super(str);
//     }
// }

// public class Custome_throw {

//     public static void main(String[] args) {

//         int Age = 10;

//         try {

//             if (Age >= 18) {
//                 System.out.println("Eligible");
//             } else {
//                 throw new InValidAge("Not Eligible");
//             }

//         } catch (InValidAge e) {

//             System.out.println(e.getMessage());

//         }
//     }
// }
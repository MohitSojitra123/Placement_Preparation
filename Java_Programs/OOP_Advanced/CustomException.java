// class InvalidAgeException extends Exception {

//     InvalidAgeException(String message) {
//         super(message);
//     }
// }

// public class CustomException {

//     static void checkAge(int age) throws InvalidAgeException {

//         if (age < 18) {

//             throw new InvalidAgeException(
//                 "Age is less than 18"
//             );

//         }

//         System.out.println("You are eligible");
//     }

//     public static void main(String[] args) {

//         try {

//             checkAge(15);

//         }
//         catch (InvalidAgeException e) {

//             System.out.println(e.getMessage());
//         }
//     }
// }
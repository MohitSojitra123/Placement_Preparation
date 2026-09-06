// class InvalidAgeException extends Exception {

//     InvalidAgeException(String message) {
//         super(message);
//     }
// }

// class InvalidSalaryException extends Exception {

//     InvalidSalaryException(String message) {
//         super(message);
//     }
// }

// public class Employee {

//     public static void main(String[] args) {

//         int age = 15;
//         int salary = 5000;

//         try {

//             if (age < 18) {

//                 throw new InvalidAgeException(
//                     "Employee age must be 18 or above"
//                 );
//             }

//             if (salary < 10000) {

//                 throw new InvalidSalaryException(
//                     "Salary must be at least 10000"
//                 );
//             }

//             System.out.println("Employee is valid");

//         }
//         catch (InvalidAgeException e) {

//             System.out.println(e.getMessage());

//         }
//         catch (InvalidSalaryException e) {

//             System.out.println(e.getMessage());
//         }
//     }
// }
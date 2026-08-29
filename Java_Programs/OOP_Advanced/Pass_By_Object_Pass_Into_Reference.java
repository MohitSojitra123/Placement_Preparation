// class Student{
//       String student_name;

//       Student(String sn){
//        this.student_name=sn;
//       }

//       Student(Student s){
//         this.student_name=s.student_name;
//       }

//     void   Change_Original_Name(Student s){
//             s.student_name="Ommmm";
//       }

// }


// public class Pass_By_Object_Pass_Into_Reference{
//       public static void main(String[] args) {
        
//           Student s1=new Student("Mohit");

//           System.out.println(s1.student_name);
          
//           Student s2=new Student(s1);
          
//           System.out.println(s2.student_name);
          
          
//         //   s1.student_name="Keval";
//         //   System.out.println(s1.student_name);
//         //   System.out.println(s2.student_name);


//           s2.Change_Original_Name(s1);
//           System.out.println(s1.student_name);
//           System.out.println(s2.student_name);

//       }
// }
// Implement an array with 5 elements in class A. Create four methods for array
// operation(sortArray(), searchArray(), SumArray(), and avgArray()) and call all the four
// methods using object.

import java.util.Scanner;

class Array_Crud{
       int array_size;
       int array[];

      public void Create_array(){
      Scanner sc=new Scanner(System.in); 

      System.out.println("Enter Array Size => ");
      array_size=sc.nextInt();

      array=new int[array_size];

      for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element => "+(i+1));
            array[i]=sc.nextInt();
      }
      }

      public void view_array(){
            for(int i=0; i<array_size; i++){
                  System.out.print(array[i]+" ");
            }
            System.out.println();
      }   
      

      public void sortArray(){
            int temp=0;
            for(int i=0; i<array_size; i++){
                  for(int j=i+1;  j<array_size;  j++ ){
                        if(array[i] > array[j]){
                              temp=array[j];
                              array[j]=array[i];
                              array[i]=temp;
                        }
                  }
            }
      }

      public void SearchElement(){
          Scanner sc=new Scanner(System.in);
          
          System.out.println("Enter Search Element => ");
          int user_search=sc.nextInt();

          int user=0;
          int count=0;

          for(int i=0; i<array_size; i++){
              if(array[i] == user_search){
                     user=i; 
                     count=1;
                     break;
              }
          }

          if(count == 1){
              System.out.println("Element Index Number Is => "+user);
          }else{
            System.out.println("Element Is Not Present In Array ");
          }
      }

      
            public void sumArray(){
                  int sum=0;
                  for(int i=0; i<array_size; i++){
                      sum+=array[i];
                }
                System.out.println("Sum Of All The Array Element => "+(sum));
            }

            public void avgArray(){
                      int sum=0;
                  for(int i=0; i<array_size; i++){
                      sum+=array[i];
                }
                System.out.println("Avg  Of  The Array Element => "+(sum/array_size));
            }

}
public class Program_4 {
      public static void main(String[] args) {
            
            Array_Crud ac=new Array_Crud();

            ac.Create_array();
            System.out.println("---------------------------");
            ac.view_array();
            System.out.println("---------------------------");
            ac.sortArray();
            System.out.println("---------------------------");
            ac.view_array();
            System.out.println("---------------------------");
            ac.SearchElement();
            System.out.println("---------------------------");
             ac.sumArray();
            System.out.println("---------------------------");
            ac.avgArray();
            System.out.println("---------------------------");
            
      }
}

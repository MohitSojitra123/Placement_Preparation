// 5 WAP to find weather given number is Pronic or not. 
// A Pronic Number is defined as a number that is the product of two consecutive non-negative integers. In 
// other words, N is a Pronic Number if there exists a non-negative integer k such that N = k * (k + 1).  
// E.g. 6 is a Pronic Number because 6=2*3 

import java.util.Scanner;

public class Question_5 {
  public static void main(String[] args) {
      
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter Any Number To Check Number Is Pronic Or Not : ");
    int num=sc.nextInt();

    boolean flag=false;

    for(int i=1; i<num; i++){
          if((i*(i+1))==num){
            System.out.println("Number Is Pronic : ");
            flag=true;
            break;
          }
    }

    if(!flag){
        System.out.println("Number Is Not Pronic : ");
    }
      

    
  }    
}

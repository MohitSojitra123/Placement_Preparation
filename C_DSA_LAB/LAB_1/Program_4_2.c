// 4. Write a program to find GCD using loop and recursion. 

#include<stdio.h>

int GCD(int n1,int n2){
    if(n2==0){
          return n1;
    }else{
        return GCD(n2,n1%n2);
    }
}

int main(){

     int num1,num2;

     printf("Enter Num 1 : ");
     scanf("%d",&num2);

     printf("ENter Num 2 : ");
     scanf("%d",&num2);

     printf("GCD ->  %d ",GCD(num1,num2));

}
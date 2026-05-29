// 1. Write a program to find factorial of a number using loop and recursion. 

int fact(int n){
    if(n==1){
        return 1;
    }else{
        return n*fact(n-1);
    }
}

#include<stdio.h>

int main(){

     int n;

     printf("Enter Any Number To Find Factorial : ");
     scanf("%d",&n);

     printf("Factorial Is : %d ",fact(n));


}
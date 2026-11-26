// 1. Write a program to find factorial of a number using loop and recursion. 

#include<stdio.h>

int main(){

    int n,fact=1;

    printf("Enter Any Number To Find Factorial : ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){
        fact*=i;
    }

    printf("Factorial Is : %d ",fact);

}
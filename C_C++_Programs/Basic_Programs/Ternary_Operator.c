#include<stdio.h>

int main(){

    int n;

    printf("Enter Any Number : ");
    scanf("%d",&n);

    (n%2==0) ? printf("Nmber Is Even : %d",n)  : printf("Number Is Odd : %d ",n); 

}
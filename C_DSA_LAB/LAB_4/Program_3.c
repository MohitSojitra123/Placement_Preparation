// Write a C program to swap two numbers, calling an UDF by reference.

#include<stdio.h>

void swap(int *x,int *y){
       int Temp=*x;
       *x=*y;
       *y=Temp;

       printf("Value Of a : %d  \n ",*x);
       printf("Value Of b : %d \n ",*y);

}

int main(){

    int a,b;

    printf("Enter Value Of a : ");
    scanf("%d",&a);

    printf("Enter Value Of b : ");
    scanf("%d",&b);

    printf("Value Of a  : %d \n",a);
    printf("Value Of b  : %d \n",b);

    printf("\n-----------------------\n");
    swap(&a,&b);
    printf("\n-----------------------\n");

    printf("Value Of a  : %d \n",a);
    printf("Value Of b  : %d \n",b);

    printf("\n-----------------------\n");


}
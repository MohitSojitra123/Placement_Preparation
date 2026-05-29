// Write a C program to swap two numbers, calling an UDF by value. 

#include<stdio.h>

void swap_val(int x,int y){
    x=x+y;
    y=x-y;
    x=x-y;

    printf("Value Of a : %d \n",x);
    printf("Value Of b : %d \n",y);
}

int main(){

    int a,b;

    printf("Enter Value Of a : ");
    scanf("%d",&a);

    printf("Enter Value Of b : ");
    scanf("%d",&b);

    printf("Value Of a : %d \n",a);
    printf("Value Of b : %d \n",b);

    printf("\n------------------------\n");
    
    swap_val(a,b);

    printf("\n------------------------\n");
    printf("Value Of a : %d \n",a);
    printf("Value Of b : %d \n",b);
    printf("\n------------------------\n");

}
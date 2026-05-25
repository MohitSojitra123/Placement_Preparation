#include<stdio.h>

int main(){

int a,b;

printf("Enter Value Of A...");
scanf("%d",&a);

printf("Enter Value Of B...");
scanf("%d",&b);

// a=10,b=5

a=a+b; //10 + 5  = 15
b=a-b;  // 15 - 5 = 10
a=a-b;  // 15 - 10 = 5;  

printf("b Swap Value...%d \n",b);
printf("a Swap Value...%d \n",a);

}
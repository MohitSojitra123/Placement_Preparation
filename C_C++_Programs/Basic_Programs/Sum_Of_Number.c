#include<stdio.h>

int main(){

     int num;

     printf("Enter Number : ");
     scanf("%d",&num);

     int sum=0;
     int last_digit;

     while (num!=0)
     {
        last_digit=num%10;
        sum+=last_digit;
        num/=10;
     }

     printf("Sum Is : %d : ",sum);
}
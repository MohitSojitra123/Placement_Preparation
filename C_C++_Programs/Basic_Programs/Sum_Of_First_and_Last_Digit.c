#include<stdio.h>

int main(){

    int num;

    printf("Enter Digit : ");
    scanf("%d",&num);

    int Last_Digit=num%10;

    while (num>10){ 
        num/=10; 
    }

    printf("First Digit :  %d \n",num);
    printf("Last Digit :  %d \n",Last_Digit);
    printf("Sum : %d",Last_Digit+num);

}
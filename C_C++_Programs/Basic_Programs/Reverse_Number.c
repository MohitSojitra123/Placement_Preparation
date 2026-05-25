#include<stdio.h>

int main(){

    int num;

    printf("Enter  Number : ");
    scanf("%d",&num);

    int reverse_num=0;

    while (num!=0)
    {
        int last_digit=num%10;
        reverse_num=(reverse_num*10)+last_digit;
        num/=10;
    }

    printf("\n Reverse Digit : %d",reverse_num);
    


}
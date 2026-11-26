#include<stdio.h>

int main(){

    int num1,num2,reverse_num=0,last_digit;


    printf("Enter Any Number To Check Number Is Palindrom Or Not :  ");
   scanf("%d",&num1);

   num2=num1;

    while(num1!=0){
        last_digit=num1%10;
        reverse_num=(reverse_num*10)+last_digit;
        num1/=10;
    }

    if(num2==reverse_num){
        printf("Number Is Palindrom :  %d ",reverse_num);
    }else{
        printf("Number Is Not Palindrom : %d",reverse_num);
    }
}
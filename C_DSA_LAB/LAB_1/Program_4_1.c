// 4. Write a program to find GCD using loop and recursion. 

#include<stdio.h>

int main(){
    
    int num1,num2;

    printf("Enter Num 1 : ");
    scanf("%d",&num1);

    printf("Enter Num 2 : ");
    scanf("%d",&num2);

    int GCD=0;

    for(int i=1; (i<=num1 || i<=num2); i++){
             if(num1%i==0 && num2%i==0){
                GCD=i;    
             }
    }

    printf("Num1 : %d and Num2 : %d GCD Is : %d",num1,num2,GCD);

}
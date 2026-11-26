#include<stdio.h>

int main(){

    int num;

    printf("Enter Number : ");
    scanf("%d",&num);

    int sum=0;

    while (num!=0)
    {
        sum+=num%10;
        num/=10;
    }
    
    printf("Sum -> %d ",sum);

}
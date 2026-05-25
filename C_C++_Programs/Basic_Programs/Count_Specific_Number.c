#include<stdio.h>

int main(){

    int num,count_number,count=0,last_digit;

    printf("Enter Number   : ");
    scanf("%d",&num);

    printf("Enter Count Number : ");
    scanf("%d",&count_number);


    while(num!=0){
       last_digit=num%10;

       if(last_digit == count_number){
         count++;
       }

       num/=10;
    }

   printf("\n--------------\n");
   printf("Total  Count :  %d",count);
   printf("\n--------------\n");


}
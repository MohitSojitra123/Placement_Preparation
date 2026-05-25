#include<stdio.h>

int main(){

     int Random_Number=23;

     int User_Number,guess_attemp=0;

     do{
         printf("Guess The Number ! \n");
         scanf("%d",&User_Number);

         if(User_Number>Random_Number){
            printf("Guess The Small Number ! \n");
         }else if(User_Number<Random_Number){
           printf("Guess The Big Number ! \n");
         }else{
            printf("Correct ! ");
         }
       guess_attemp++;         
     }while(User_Number != Random_Number);
     

     printf("Total Attemp Is : %d",guess_attemp);
}
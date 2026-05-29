// Write a program to calculate power using loop and recursion. 

#include<stdio.h>

int main(){
   
      int x,y;

     printf("Enter x : ");
     scanf("%d",&x);

     printf("Enter y : ");
     scanf("%d",&y);

     int power=1;

     for(int i=1; i<=y; i++){
         power*=x;
     }

     printf("Power Is %d ",power);
}
#include<stdio.h>

int main(){

     int User_num;

     printf("Enter Any Number To Check Number Is Three Digit : ");
     scanf("%d",&User_num);

     if(User_num>99 && User_num<1000){
        printf("Number Is 3 Digit %d ",User_num);
     }else{
        printf("Number Is Not 3 Digit : %d ",User_num);
     }

}
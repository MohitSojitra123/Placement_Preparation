// Write a program to calculate power using loop and recursion. 

int power(int x,int y){
     if(y==0){
        return 1;
     }else{
        return x*power(x,y-1);
     }
}

#include<stdio.h>

int main(){

    int x,y;

    printf("Enter x : ");
    scanf("%d",&x);

    printf("Enter y : ");
    scanf("%d",&y);
  
     printf("Power Is : %d ",power(x,y));


}
#include<stdio.h>

int main(){

     int a,b,c;

     printf("Enter a Value : ");
     scanf("%d",&a);

     printf("Enter b Value : ");
     scanf("%d",&b);

     printf("Enter c Value : ");
     scanf("%d",&c);

     if(((a+b)>c) && ((c+b)>a) && ((c+a)>b) ){
          printf("Tringle Is Valid...");
     }else{
        printf("Tringle Is Not Valid...");
     }


}
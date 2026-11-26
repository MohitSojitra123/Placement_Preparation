#include<stdio.h>

void Swap_Value(int *a,int *b){
    int Temp=*a;
    *a=*b;
    *b=Temp;
}

int main(){

     int a=100;
     int b=200;

     printf("a Value %d \n",a);
     printf("b Value %d \n",b);

     printf("\n----------------------\n");
     printf("After Swap : ");
     printf("\n----------------------\n");

     Swap_Value(&a,&b);

     printf("a Value %d \n",a);
     printf("b Value %d \n",b);
     

}
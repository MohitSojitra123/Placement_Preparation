#include<stdio.h>

void Pointer_Ref(int* a,int*b){
    
     *a=100;
     *b=200;

     printf("a Value %d \n",*a);
     printf("b Value %d \n",*b);
    
}

int main(){
 
     int x=10;
     int y=20;
    
     Pointer_Ref(&x,&y);
     printf("x Value %d \n",x);
     printf("y Value %d \n",y);

}
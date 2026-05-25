#include<stdio.h>

void pass_ref(int* a,int* b){
     *a+=10;
     *b+=20;
     printf("a -> %d \n",*a);
     printf("b -> %d \n",*b);
}

int main(){

    int a=1;
    int b=2;

    printf("a ->  %d \n",a);
    printf("b ->  %d \n",b);
    
    printf("\n");
    
    pass_ref(&a,&b);

    printf("\n");

    printf("a ->  %d \n",a);
    printf("b ->  %d \n",b);
    

}
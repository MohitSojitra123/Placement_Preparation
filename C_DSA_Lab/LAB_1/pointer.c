#include<stdio.h>

int main(){

    int a=10;
    int *p=&a;

    printf("a %d \n",a);   // a 10 
    printf("&a %d \n",&a);   // &a 6422300 
    printf("p %d \n",p);  // p 6422300 
    printf("&p %d \n",&p);  // &p 6422296 
    printf("*p %d \n",*p);   // *p 10 

}






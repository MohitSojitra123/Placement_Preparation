#include<stdio.h>

int main(){

     int a=10;
     int b=20;

     int* ptra=&a;
     int* ptrb=&b;

     *ptra=*ptra+*ptrb;
     *ptrb=*ptra-*ptrb;
     *ptra=*ptra-*ptrb;

     printf("a ->  %d \n",*ptra);
     printf("b -> %d \n",*ptrb);


}
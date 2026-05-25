#include<stdio.h>

int main(){

     int a=101;
    int b=102;

    int *ptra=&a;
    int *ptrb=&b;

    int sum=*ptra+*ptrb;

    printf("Sum : %d : ",sum);
}
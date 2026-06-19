#include<stdio.h>

int main(){

     char ch='M';
     char* ptrch=&ch;

     printf("ptrch -> %d \n",ptrch);
     printf("ptrch* -> %c \n",*ptrch);
     printf("ch& -> %d \n",&ch);

     int a=101;
     int *ptra=&a;

     printf("ptra -> %d \n ",ptra);
     printf("ptra* -> %c \n ",*ptra);

}
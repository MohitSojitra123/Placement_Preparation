#include<stdio.h>

int main(){

     char ch='M';
     char* ptrch=&ch;

     printf("ptrch -> %d \n",ptrch);
     printf("ptrch* -> %c \n",*ptrch);

     int a=101;
     int *ptra=&a;

     printf("ptra -> %d \n ",ptra);
     printf("ptra* -> %c \n ",*ptra);

}
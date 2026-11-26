#include<stdio.h>

int main(){

  char name[30];

  printf("Enter Name : ");
  gets(name);

  printf("Name : ");
  puts(name);
  

    printf("%c \n",name[0]);
    printf("%c \n",name[1]);
    printf("%c \n",name[2]);

}
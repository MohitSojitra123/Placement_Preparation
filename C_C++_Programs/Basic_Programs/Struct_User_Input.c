#include<stdio.h>

int main(){

     struct Student {
        char name[20];
        int age;
        int std;
     };

     struct Student s1;

     printf("Enter Student Name : ");
     gets(s1.name);

     printf("Enter Student age : ");
     scanf("%d",&s1.age);

     printf("Enter Student std : ");
     scanf("%d",&s1.std);

     printf("Name : ");
     puts(s1.name);
     printf("---------------------\n");
     printf("age : %d ",s1.age);
     printf("\n---------------------\n");
     printf("std : %d ",s1.std);
     printf("\n---------------------\n");
}

#include<stdio.h>

struct student {
    char name[20];
    int age;
    int std; 
};

int main(){

    struct student  st1;

    printf("Enter Student Name : ");
    gets(st1.name);

    printf("Enter age : ");
    scanf("%d",&st1.age);
    
    printf("Enter std : ");
    scanf("%d",&st1.std);

    printf("\n-------------------\n");
    printf("Name :-  %s \n",st1.name);
    printf("Age :-  %d \n",st1.age);
    printf("Std :-  %d \n",st1.std);
    printf("\n-------------------\n");

}
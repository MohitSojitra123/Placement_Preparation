#include<stdio.h>
#include<string.h>

int main(){

    struct Student{
        int age;
        int std;
        char name[20];
    };

    struct Student s1;

    s1.age=15;
    s1.std=10;
    strcpy(s1.name,"Mohit");

    printf("%d \n",s1.age);
    printf("%d \n",s1.std);
    printf("%s \n",s1.name);

}
#include<stdio.h>

int main(){
 
    struct Student {
        char name[20];
        int age;
        int std;
    };
    
    struct Student st[3];

    for(int i=0; i<3; i++){
        printf("Enter Student Name : ");
        scanf("%s",&st[i].name);
        printf("\n");
        printf("Enter Student age : ");
        scanf("%d",&st[i].age);
        printf("\n");
        printf("Enter Student std : ");
        scanf("%d",&st[i].std);
        printf("\n");
    }

    
    printf("\n---------------------\n");
    for(int i=0; i<3; i++){
        printf("Name : ");
        puts(st[i].name);
        printf("age : %d",st[i].age);
        printf("std : %d",st[i].std);
        printf("\n---------------------\n");
    }

}
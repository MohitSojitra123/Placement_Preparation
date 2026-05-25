#include<stdio.h>

int main(){

    char name1[20];

    
    printf("\n----------------------------\n");
    printf("fgets fputs");
    printf("\n----------------------------\n");


    printf("Enter Name : ");
    fgets(name1,sizeof(name1),stdin);
    
    fputs(name1,stdout);

}
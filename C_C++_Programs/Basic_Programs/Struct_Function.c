#include<stdio.h>

struct student{
    int id;
    char name[50];
    float marks;
};

void readData(struct student *s){
    printf("Enter Student Id...");
    scanf("%d",&s->id);

    printf("Enter Student Name...");
    scanf(" %[^\n]",s->name);

    printf("Enter Marks...");
    scanf("%f",&s->marks);
}

void printfData(struct student s){
    printf("\n---- Student Detail ----\n");
    printf("Id   :  %d \n",s.id);
    printf("Name  :  %d\n",s.name);
    printf("Marks  : %2.f\n ",s.marks);
}

int main(){

    struct student stu1;

    readData(&stu1);
    printfData(stu1);

    return 0;
}
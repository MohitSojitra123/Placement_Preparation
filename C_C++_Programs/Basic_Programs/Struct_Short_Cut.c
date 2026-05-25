#include<stdio.h>

struct Employee{
    char name[20];
    char department[20];
    int age;
    float salary;
};

int main(){

    struct Employee emp1={"rahul","IT",21,34000};

    printf("Emp Name : %s \n",emp1.name);
    printf("Emp Department : %s \n",emp1.department);
    printf("Emp age : %d \n",emp1.age);
    printf("Emp Salary : %f \n",emp1.salary);

}
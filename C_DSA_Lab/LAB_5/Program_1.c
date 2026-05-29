// Create a structure Employee_Detail (Employee_id, Name, Designation,
// Salary). Write a program to read the detail from user and print it. 

#include <stdio.h>

struct Employee_Detail {
    int Emp_id;
    char Emp_name[50];
    char Emp_Designation[50];
    float Emp_Salary;
};

int main() {

    struct Employee_Detail Emp1;

    printf("Enter Employee ID: ");
    scanf("%d", &Emp1.Emp_id);

    printf("Enter Employee Name: ");
    scanf(" %[^\n]", Emp1.Emp_name);   // reads full name with spaces

    printf("Enter Employee Designation: ");
    scanf(" %[^\n]", Emp1.Emp_Designation);

    printf("Enter Employee Salary: ");
    scanf("%f", &Emp1.Emp_Salary);


    printf("\n------------------------\n");
    printf("ID: %d\n", Emp1.Emp_id);
    printf("Name: %s\n", Emp1.Emp_name);
    printf("Designation: %s\n", Emp1.Emp_Designation);
    printf("Salary: %.2f\n", Emp1.Emp_Salary);
    printf("\n------------------------\n");

    return 0;
}

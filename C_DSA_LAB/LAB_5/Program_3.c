// Create a structure Employee_Detail (Employee_id, Name, Designation,
// Salary). Write a program to read the detail from user and print it using
// Structure Pointer. 

#include <stdio.h>

struct Employee_Detail {
    int Employee_id;
    char Name[50];
    char Designation[50];
    float Salary;
};

int main() {

    struct Employee_Detail emp;          // structure variable
    struct Employee_Detail *ptr = &emp;  // structure pointer

    printf("Enter Employee ID: ");
    scanf("%d", &ptr->Employee_id);

    printf("Enter Employee Name: ");
    scanf(" %[^\n]", ptr->Name);

    printf("Enter Designation: ");
    scanf(" %[^\n]", ptr->Designation);

    printf("Enter Salary: ");
    scanf("%f", &ptr->Salary);

   
    printf("\n--- Employee Details ---\n");
    printf("Employee ID: %d\n", ptr->Employee_id);
    printf("Name: %s\n", ptr->Name);
    printf("Designation: %s\n", ptr->Designation);
    printf("Salary: %.2f\n", ptr->Salary);
    printf("\n------------------------\n");

    return 0;
}

// Create an array of structure Student_Detail (Enrollment_no, Name, Sem, CPI)
// for 5 students, scan their information and print it.

#include <stdio.h>

struct Student_Detail {
    int Enrollment_no;
    char Name[50];
    int Sem;
    float CPI;
};

int main() {

    struct Student_Detail stu[5];


    for (int i = 0; i < 5; i++) {
        printf("\nEnter details of Student %d\n", i + 1);

        printf("Enrollment No: ");
        scanf("%d", &stu[i].Enrollment_no);

        printf("Name: ");
        scanf(" %[^\n]", stu[i].Name);   
        printf("Semester: ");
        scanf("%d", &stu[i].Sem);

        printf("CPI: ");
        scanf("%f", &stu[i].CPI);
    }

    
    printf("\n--- Student Details ---\n");

    for (int i = 0; i < 5; i++) {

        printf("\nStudent %d\n", i + 1);
        printf("Enrollment No: %d\n", stu[i].Enrollment_no);
        printf("Name: %s\n", stu[i].Name);
        printf("Semester: %d\n", stu[i].Sem);
        printf("CPI: %.2f\n", stu[i].CPI);
    }

    return 0;
}

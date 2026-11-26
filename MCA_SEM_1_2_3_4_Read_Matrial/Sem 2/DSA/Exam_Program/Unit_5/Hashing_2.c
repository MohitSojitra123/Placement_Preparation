#include<stdio.h>

#define M 10

struct stu_detail{
    int roll_number;
    int spi;
};

struct stu_detail StuArray[M];

// Initialize Hash Table
void init(){
    for(int i = 0; i < M; i++){
        StuArray[i].roll_number = -1;
        StuArray[i].spi = -1;
    }
}

// Insert using Linear Probing
void insert(int stu_roll_number, int stu_spi){
    
    int index = stu_roll_number % M;

    for(int i = 0; i < M; i++){
        int j = (index + i) % M;

        if(StuArray[j].roll_number == -1 || 
           StuArray[j].roll_number == stu_roll_number){

            StuArray[j].roll_number = stu_roll_number;
            StuArray[j].spi = stu_spi;
            return;
        }
    }

    printf("Hash Map is Full\n");
}

// Search Function
void search(int stu_roll_number){
    
    int index = stu_roll_number % M;

    for(int i = 0; i < M; i++){
        int j = (index + i) % M;

        // If empty slot found → not present
        if(StuArray[j].roll_number == -1){
            printf("Student Not Found\n");
            return;
        }

        if(StuArray[j].roll_number == stu_roll_number){
            printf("Student Found\n");
            printf("Roll Number: %d\n", StuArray[j].roll_number);
            printf("SPI: %d\n", StuArray[j].spi);
            return;
        }
    }

    printf("Student Not Found\n");
}

// Display Hash Table
void display(){
    for(int i = 0; i < M; i++){
        printf("\nIndex %d\n", i);
        printf("-------------------------\n");
        printf("Roll No: %d\n", StuArray[i].roll_number);
        printf("SPI    : %d\n", StuArray[i].spi);
        printf("-------------------------\n");
    }
}

// Main Function
int main(){

    init();

    insert(101,7);
    insert(111,8);
    insert(121,9);

    display();

    printf("\n--- Search Operation ---\n");
    search(111);
    search(200);

    return 0;
}
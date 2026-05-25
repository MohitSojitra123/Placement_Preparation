#include<stdio.h>

int main(){

     int Subject_Marks;

    for(int i=1; i<=3; i++){
        printf("Student %d Subject Marks : \n",i);
        for(int j=1; j<=5; j++){
           printf("Enter Subject %d Marks : ",j);
           scanf("%d",&Subject_Marks);
           printf("%d \n",Subject_Marks);
        }
        printf("\n---------------------\n");
    }
    
}
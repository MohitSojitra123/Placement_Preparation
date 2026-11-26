#include<stdio.h>

int Change_Value(int *num){
     *num=100;
     return *num;
}

int main(){
    int a=10;

    printf("%d \n ",Change_Value(&a));
    printf("Variable Value : %d",a);

}
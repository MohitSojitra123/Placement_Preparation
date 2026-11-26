#include<stdio.h>

int Change_value(int num){
    num=100;
    return num;
}

int main(){

    int a=10;

    printf("Function Value : %d \n",Change_value(a));

    printf("Variable Value :  %d \n",a);

}  
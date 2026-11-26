// 2. Write a program to reverse a string using Stack.

#include<stdio.h>

char Stack[50];
int Top=-1;

void Push(char x){
    if(Top>=49){
        printf("Stack Is Overflow : ");
    }else{
        Stack[++Top]=x;
    }
}

char Pop(){
    return Stack[Top--];
}


int main(){

    char user[50];

    printf("Enter Strgin : ");
    scanf("%s",user);

    for(int i=0; user[i]!='\0'; i++){
          Push(user[i]);
    }

    for(int i=0; i<user[i]!='\0'; i++){
          printf("%c",Pop());
    }



}
#include<stdio.h>
#define N 5

int S[N];
int top = -1;

void push(int x){
    if(top >= N-1){
        printf("Stack Overflow.");
        return;
    }
    top++;
    S[top] = x;
}

int pop(){
    if(top == -1){
        printf("Stack Undereflow.");
        return -1;
    }
    top--;
    return S[top+1];
}

int peep(int i){
    if(top-i+1 < 0){
        printf("Element not available.");
        return -1;
    }
    return S[top-i+1];

}

void change(int i, int x){
    if(top-i+1 < 0){
        printf("Element is not available.");
        return;
    }
    S[top-i+1] = x;
}

void display(){
    if(top == -1){
        printf("stack is empty.");
        return;
    }
    for(int i=top ; i>=0 ; i--){
        printf("\n%d",S[i]);
    }
}





void main(){
    push(10);
    push(20);
    push(30);
    push(40);
    push(50);
    push(60);
    printf("%d",pop());
    printf("%d",peep(3));
    change(1,100);
    display();
 

}
#include<stdio.h>
#define Size 100

int stack[Size];
int top = -1;


void push(int x){
    if(top < Size-1)
        stack[++top] = x;
}


int pop(){
    return stack[top--];
}


void deleteMiddle(int current, int mid){
    int x;

    if(current == mid){
        pop();      
        return;
    }

    x = pop();      
    deleteMiddle(current + 1, mid);
    push(x);         
}

void display(){
    for(int i = top; i >= 0; i--)
        printf("%d ", stack[i]);
    printf("\n");
}

int main(){
    push(10);
    push(20);
    push(30);
    push(40);
    push(50);   

    printf("Original Stack:\n");
    display();

    int n = top + 1;
    int mid = (n / 2) + 1;

    deleteMiddle(1, mid);

    printf("After Deleting Middle:\n");
    display();

    return 0;
}

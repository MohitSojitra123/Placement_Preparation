#include<stdio.h>
#define N 5

int Q[N];
int front = -1;
int rear = -1;

void enqueue(int y){
    if(rear >= N-1){
        printf("Queue Overflow.");
        return;
    }
    rear++;
    Q[rear] = y;
    if(front == -1)
        front = 0;
}

int dequeue(){
    if(front == -1){
        printf("Queue Underflow");
        return -1;
    }
    int y = Q[front];
    if(front == rear)
        front = rear = -1;
    else
        front++;
    return y;
}

void display(){
    if(front == -1){
        printf("Queue is empty.");
        return;
    }
    for(int i=front; i<=rear ; i++){
        printf("%d\t", Q[i]);
    }
}

void main(){
    enqueue(10);
    enqueue(20);
    enqueue(30);
    enqueue(40);
    enqueue(50);
    //enqueue(60);
    int x = dequeue();
    int y = dequeue();
    display();
}
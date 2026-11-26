#include<stdio.h>
#define N 5

struct element{
    int data;
    int priority;
};

struct element PQ[N];

int front = -1;
int rear = -1;

void enquque(int x, int y){
    if(rear >= N-1){
        printf("Priority Queue is Overflow.");
        return;
    }
    rear++;
    PQ[rear].data = x;
    PQ[rear].priority = y;
    if(front == -1)
        front = 0;
}

void dequeue(){
    if(front == -1){
        printf("Priority Queue Underflow.");
        return;
    }
    if(front == rear){
        front = -1;
        rear = -1;
        return;
    }
    int max_ind = front;
    for(int i = front+1; i<=rear ; i++){
        if(PQ[i].priority > PQ[max_ind].priority){
            max_ind = i;
        }
    }
    for(int i = max_ind; i<rear; i++){
        PQ[i] = PQ[i+1];
    }
    rear--;
}

void display(){
    if(front == -1){
        printf("Priority Queue is empty.");
        return;
    }
    for(int i=front; i<=rear; i++){
        printf("\n(%d : %d)",PQ[i].data, PQ[i].priority);
    }
}

void main(){
    enquque(105,9);
    enquque(101,8);
    enquque(108,10);
    enquque(104,5);
    enquque(112,8);
    dequeue();
    display();

}
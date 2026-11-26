#include<stdio.h>
#define max 5

int queue[max];
int front=-1,rear=-1;

void enqueue(int x){
    // if(rear==max-1){
    //     rear=0;
    // }else{rear++;}
    // if(rear==front){
    //     printf("queue overflow");
    //     return;
    // }
    // queue[rear]=x;
    // if(front==-1){
    //     front=0;
    //     return;
    // }
    if((rear+1)%max==front){
        printf("circular queue is overflow");
        return;
    }
    rear=(rear+1)%max;
    queue[rear]=x;
    if(front==-1){
        front=0;
    }
}

int dequeue(){
    // if(front == -1){
    //     printf("underflow");
    //     return 0;
    // }
    // int y=queue[front];
    // if(front==rear){
    //     front=rear=0;
    //     return y;
    // }
    if(front==-1){
        printf("queue is underflow");
        return -1;
    }
    int y=queue[front];
    if(front==rear){
        front=rear=-1;
    }else{
        front=(front+1)%max;
    }
    return y;
}

void display(){
    if(front == -1){
        printf("queue is empty");
        return;
    }int i=front;
    while (i!=rear)
    {
        printf("%d\t",queue[i]);
        i=(i+1)%max;
    }
    
    printf("%d",queue[rear]);
}

void main(){
    enqueue(10);
    enqueue(20);
    enqueue(30);
    enqueue(40);
    enqueue(50);
    int res = dequeue();
    enqueue(60);
    enqueue(70);
    display();
}
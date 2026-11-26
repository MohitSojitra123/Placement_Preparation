#include<stdio.h>

#define size 5

int array1[size];
int front = -1;
int rear  = -1;

void enqueue(int element) {
    if (rear == size - 1) {
        printf("Queue Overflow\n");
    } else {
        if (front == -1) {   
            front = 0;
        }
        array1[++rear] = element;
        printf("%d inserted\n", element);
    }
}

void dequeue() {
    if (front == -1 || front > rear) {
        front==-1;
        printf("Queue Underflow\n");
    } else {
        printf("%d deleted\n", array1[front++]);
    }
}


void display() {
    if (front == -1 || front > rear) {
        printf("Queue is Empty\n");
    } else {
        printf("Queue Elements: ");
        for (int i = front; i <= rear; i++) {
            printf("%d ", array1[i]);
        }
        printf("\n");
    }
}

int main() {
    enqueue(10);
    enqueue(20);
    enqueue(30);

    display();

    dequeue();
    display();

    enqueue(40);
    enqueue(50);
    enqueue(60);   

    display();

    return 0;
}

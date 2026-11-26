#include <stdio.h>
#define MAX 5

int deque[MAX];
int front = -1, rear = -1;

int isFull() {
    return (front == 0 && rear == MAX - 1);
}

int isEmpty() {
    return (front == -1);
}

void enqueueFront(int x) {
    if (isFull()) {
        printf("Deque is Full\n");
    } else {
        if (front == -1)
            front = rear = 0;
        else if (front > 0)
            front--;
        else {
            printf("No space at front\n");
            return;
        }
        deque[front] = x;
    }
}

void enqueueRear(int x) {
    if (isFull()) {
        printf("Deque is Full\n");
    } else {
        if (rear == -1)
            front = rear = 0;
        else if (rear < MAX - 1)
            rear++;
        else {
            printf("No space at rear\n");
            return;
        }
        deque[rear] = x;
    }
}

void dequeueFront() {
    if (isEmpty()) {
        printf("Deque is Empty\n");
    } else {
        printf("Deleted: %d\n", deque[front]);
        if (front == rear)
            front = rear = -1;
        else
            front++;
    }
}

void dequeueRear() {
    if (isEmpty()) {
        printf("Deque is Empty\n");
    } else {
        printf("Deleted: %d\n", deque[rear]);
        if (front == rear)
            front = rear = -1;
        else
            rear--;
    }
}

void display() {
    if (isEmpty()) {
        printf("Deque is Empty\n");
    } else {
        for (int i = front; i <= rear; i++)
            printf("%d ", deque[i]);
        printf("\n");
    }
}

int main() {
    enqueueRear(10);
    enqueueRear(20);
    enqueueFront(5);
    enqueueRear(30);

    display();

    dequeueFront();
    dequeueRear();

    display();
}
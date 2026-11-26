#include <stdio.h>
#define MAX 5

int queue[MAX];
int front = -1, rear = -1;

// Enqueue Operation
void enqueue(int value) {
    // Overflow condition
    if (rear == MAX - 1) {
        printf("Queue Overflow! Cannot insert %d\n", value);
        return;
    }

    // First element insertion
    if (front == -1)
        front = 0;

    rear++;
    queue[rear] = value;
    printf("%d inserted into queue\n", value);
}

// Dequeue Operation
void dequeue() {
    // Underflow condition
    if (front == -1 || front > rear) {
        printf("Queue Underflow! Cannot delete\n");
        return;
    }

    printf("%d deleted from queue\n", queue[front]);
    front++;

    // Reset queue when empty
    if (front > rear) {
        front = rear = -1;
    }
}

// Display Operation
void display() {
    if (front == -1 || front > rear) {
        printf("Queue is empty\n");
        return;
    }

    printf("Queue elements: ");
    for (int i = front; i <= rear; i++) {
        printf("%d ", queue[i]);
    }
    printf("\n");
}

// Main Function
int main() {
    int choice, value;

    while (1) {
        printf("\n--- Queue Menu ---\n");
        printf("1. Enqueue\n");
        printf("2. Dequeue\n");
        printf("3. Display\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value: ");
                scanf("%d", &value);
                enqueue(value);
                break;

            case 2:
                dequeue();
                break;

            case 3:
                display();
                break;

            case 4:
                printf("Exiting...\n");
                return 0;

            default:
                printf("Invalid choice!\n");
        }
    }

    return 0;
}
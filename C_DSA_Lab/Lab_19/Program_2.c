  // 2. Write a program to implement queue using linked list.

  #include <stdio.h>
#include <stdlib.h>

// Node structure
struct Node {
    int data;
    struct Node* next;
};

struct Node *front = NULL, *rear = NULL;

// ENQUEUE operation
void enqueue(int value) {
    struct Node* newNode;

    newNode = (struct Node*)malloc(sizeof(struct Node));

    if (newNode == NULL) {
        printf("Queue Overflow\n");
        return;
    }

    newNode->data = value;
    newNode->next = NULL;

    if (rear == NULL) {  // Queue is empty
        front = rear = newNode;
    } else {
        rear->next = newNode;
        rear = newNode;
    }

    printf("Inserted: %d\n", value);
}

// DEQUEUE operation
void dequeue() {
    struct Node* temp;

    if (front == NULL) {
        printf("Queue Underflow\n");
        return;
    }

    temp = front;
    printf("Deleted: %d\n", front->data);

    front = front->next;

    if (front == NULL) { // Queue becomes empty
        rear = NULL;
    }

    free(temp);
}

// PEEK operation
void peek() {
    if (front == NULL) {
        printf("Queue is Empty\n");
    } else {
        printf("Front Element: %d\n", front->data);
    }
}

// DISPLAY operation
void display() {
    struct Node* temp;

    if (front == NULL) {
        printf("Queue is Empty\n");
        return;
    }

    temp = front;
    printf("Queue Elements:\n");

    while (temp != NULL) {
        printf("%d\n", temp->data);
        temp = temp->next;
    }
}

// MAIN function
int main() {
    int choice, value;

    while (1) {
        printf("\n--- QUEUE USING LINKED LIST ---\n");
        printf("1. Enqueue\n");
        printf("2. Dequeue\n");
        printf("3. Peek\n");
        printf("4. Display\n");
        printf("5. Exit\n");
        printf("Enter Choice: ");
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
                peek();
                break;

            case 4:
                display();
                break;

            case 5:
                exit(0);

            default:
                printf("Invalid Choice\n");
        }
    }

    return 0;
}
// 1. Write a program to implement stack using linked list.

#include <stdio.h>
#include <stdlib.h>

// Node structure
struct Node {
    int data;
    struct Node* next;
};

struct Node* top = NULL;

// PUSH operation
void push(int value) {
    struct Node* newNode;

    newNode = (struct Node*)malloc(sizeof(struct Node));

    if (newNode == NULL) {
        printf("Stack Overflow\n");
        return;
    }

    newNode->data = value;
    newNode->next = top;
    top = newNode;

    printf("Inserted: %d\n", value);
}

// POP operation
void pop() {
    struct Node* temp;

    if (top == NULL) {
        printf("Stack Underflow\n");
        return;
    }

    temp = top;
    printf("Deleted: %d\n", top->data);
    top = top->next;
    free(temp);
}

// PEEK operation
void peek() {
    if (top == NULL) {
        printf("Stack is Empty\n");
    } else {
        printf("Top Element: %d\n", top->data);
    }
}

// DISPLAY operation
void display() {
    struct Node* temp;

    if (top == NULL) {
        printf("Stack is Empty\n");
        return;
    }

    temp = top;
    printf("Stack Elements:\n");

    while (temp != NULL) {
        printf("%d\n", temp->data);
        temp = temp->next;
    }
}

// MAIN function
int main() {
    int choice, value;

    while (1) {
        printf("\n--- STACK USING LINKED LIST ---\n");
        printf("1. Push\n");
        printf("2. Pop\n");
        printf("3. Peek\n");
        printf("4. Display\n");
        printf("5. Exit\n");
        printf("Enter Choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value: ");
                scanf("%d", &value);
                push(value);
                break;

            case 2:
                pop();
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
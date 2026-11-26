#include <stdio.h>
#define MAX 5
int stack[MAX];
int top = -1;

// 🔹 PUSH Operation
void push(int value) {
    if (top == MAX - 1) {
        printf("Stack Overflow! Cannot insert %d\n", value);
    } else {
        top++;
        stack[top] = value;
        printf("%d inserted into stack\n", value);
    }
}

// 🔹 POP Operation
void pop() {
    if (top == -1) {
        printf("Stack Underflow! Stack is empty\n");
    } else {
        printf("%d deleted from stack\n", stack[top]);
        top--;
    }
}

// 🔹 PEEP Operation (View element at position)
void peep(int position) {
    int index = top - position + 1;

    if (index < 0) {
        printf("Invalid position!\n");
    } else {
        printf("Element at position %d is %d\n", position, stack[index]);
    }
}

// 🔹 CHANGE Operation
void change(int position, int value) {
    int index = top - position + 1;

    if (index < 0) {
        printf("Invalid position!\n");
    } else {
        stack[index] = value;
        printf("Value changed at position %d\n", position);
    }
}

// 🔹 DISPLAY Operation
void display() {
    if (top == -1) {
        printf("Stack is empty\n");
    } else {
        printf("Stack elements are:\n");
        for (int i = top; i >= 0; i--) {
            printf("%d\n", stack[i]);
        }
    }
}

// 🔹 MAIN FUNCTION
int main() {
    int choice, value, position;

    while (1) {
        printf("\n--- STACK MENU ---\n");
        printf("1. Push\n2. Pop\n3. Peep\n4. Change\n5. Display\n6. Exit\n");
        printf("Enter your choice: ");
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
                printf("Enter position: ");
                scanf("%d", &position);
                peep(position);
                break;

            case 4:
                printf("Enter position and new value: ");
                scanf("%d %d", &position, &value);
                change(position, value);
                break;

            case 5:
                display();
                break;

            case 6:
                return 0;

            default:
                printf("Invalid choice!\n");
        }
    }
}
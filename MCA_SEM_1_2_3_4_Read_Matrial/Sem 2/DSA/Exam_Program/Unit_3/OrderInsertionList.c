#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* head = NULL;

// Ordered Insert (Ascending)
void insertOrdered(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->next = NULL;

    // Case 1: Empty list OR insert at beginning
    if (head == NULL || value < head->data) {
        newNode->next = head;
        head = newNode;
        return;
    }

    // Case 2: Insert in middle or end
    struct Node* temp = head;

    while (temp->next != NULL && temp->next->data < value) {
        temp = temp->next;
    }

    newNode->next = temp->next;
    temp->next = newNode;
}

// Display List
void display() {
    struct Node* temp = head;
    printf("List: ");

    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }

    printf("NULL\n");
}

// Main Function
int main() {
    insertOrdered(20);
    insertOrdered(10);
    insertOrdered(30);
    insertOrdered(25);
    insertOrdered(5);

    display();

    return 0;
}
#include <stdio.h>
#include <stdlib.h>

// Structure for Doubly Linked List Node
struct Node {
    int data;
    struct Node* prev;
    struct Node* next;
};

struct Node* head = NULL;

// Insert at First
void insertFirst(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->prev = NULL;
    newNode->next = head;

    if (head != NULL) {
        head->prev = newNode;
    }

    head = newNode;
    printf("Inserted at first: %d\n", value);
}

// Insert at Last
void insertLast(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->next = NULL;

    if (head == NULL) {
        newNode->prev = NULL;
        head = newNode;
        return;
    }

    struct Node* temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
    newNode->prev = temp;

    printf("Inserted at last: %d\n", value);
}

// Delete First
void deleteFirst() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct Node* temp = head;

    if (head->next == NULL) {
        head = NULL;
    } else {
        head = head->next;
        head->prev = NULL;
    }

    printf("Deleted from first: %d\n", temp->data);
    free(temp);
}

// Delete Last
void deleteLast() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct Node* temp = head;

    // Only one node
    if (temp->next == NULL) {
        head = NULL;
        printf("Deleted from last: %d\n", temp->data);
        free(temp);
        return;
    }

    // Traverse to last node
    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->prev->next = NULL;

    printf("Deleted from last: %d\n", temp->data);
    free(temp);
}

// Traverse / Display
void display() {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct Node* temp = head;
    printf("List: ");

    while (temp != NULL) {
        printf("%d <-> ", temp->data);
        temp = temp->next;
    }

    printf("NULL\n");
}

// Main Function
int main() {
    insertFirst(10);
    insertFirst(5);
    insertLast(20);
    insertLast(30);

    display();

    deleteFirst();
    display();

    deleteLast();
    display();

    return 0;
}
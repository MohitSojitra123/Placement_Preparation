#include <stdio.h>
#include <stdlib.h>

// Structure
struct Node {
    int data;
    struct Node* next;
};

struct Node* head = NULL;

// Insert at End
void insertEnd(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->next = NULL;

    if (head == NULL) {
        head = newNode;
        return;
    }

    struct Node* temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
}

// Display
void display() {
    struct Node* temp = head;

    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    printf("List: ");
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}

// Bubble Sort (Using for loop)
void bubbleSort() {
    if (head == NULL || head->next == NULL) {
        return;
    }

    struct Node *i, *j;

    for (i = head; i->next != NULL; i = i->next) {
        for (j = head; j->next != NULL; j = j->next) {
            if (j->data > j->next->data) {
                // Swap data
                int temp = j->data;
                j->data = j->next->data;
                j->next->data = temp;
            }
        }
    }
}

// Main
int main() {
    insertEnd(5);
    insertEnd(3);
    insertEnd(8);
    insertEnd(1);
    insertEnd(2);

    printf("Before Sorting:\n");
    display();

    bubbleSort();

    printf("After Sorting:\n");
    display();

    return 0;
}
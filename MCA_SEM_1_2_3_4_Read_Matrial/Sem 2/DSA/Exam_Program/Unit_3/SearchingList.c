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

// Linear Search
void linearSearch(int key) {
    struct Node* temp = head;
    int pos = 1;
    int found = 0;

    while (temp != NULL) {
        if (temp->data == key) {
            printf("Element %d found at position %d\n", key, pos);
            found = 1;
            // break;   // use this if you want only first occurrence
        }
        temp = temp->next;
        pos++;
    }

    if (!found) {
        printf("Element not found\n");
    }
}

// Main
int main() {
    insertEnd(10);
    insertEnd(20);
    insertEnd(30);
    insertEnd(20);
    insertEnd(50);

    display();

    int key;
    printf("Enter element to search: ");
    scanf("%d", &key);

    linearSearch(key);

    return 0;
}
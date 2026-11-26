// Write  a  program  to  remove  the  duplicates  nodes  from  given  sorted  Linked 
// List.  
// Input: 1 → 1 → 6 → 13 → 13 → 13 → 27 → 27  
// Output: 1 → 6 → 13 → 27 


#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

// Insert at beginning
struct Node* insertAtFirst(struct Node *head, int value) {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));

    newNode->data = value;
    newNode->next = head;

    return newNode;
}

// Sort the linked list (optional if already sorted)
void sortList(struct Node *head) {
    struct Node *i, *j;
    int temp;

    for (i = head; i != NULL; i = i->next) {
        for (j = i->next; j != NULL; j = j->next) {
            if (i->data > j->data) {
                temp = i->data;
                i->data = j->data;
                j->data = temp;
            }
        }
    }
}

// Remove duplicates from sorted list
void removeDuplicates(struct Node *head) {
    struct Node *temp = head;

    while (temp != NULL && temp->next != NULL) {
        if (temp->data == temp->next->data) {
            struct Node *duplicate = temp->next;
            temp->next = temp->next->next;
            free(duplicate);
        } else {
            temp = temp->next;
        }
    }
}

// Traverse and print list
void traverse(struct Node *head) {
    struct Node *temp = head;

    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}

int main() {
    struct Node *head = NULL;

    // Insert values (reverse order because insertAtFirst)
    head = insertAtFirst(head, 27);
    head = insertAtFirst(head, 27);
    head = insertAtFirst(head, 13);
    head = insertAtFirst(head, 13);
    head = insertAtFirst(head, 13);
    head = insertAtFirst(head, 6);
    head = insertAtFirst(head, 1);
    head = insertAtFirst(head, 1);

    printf("Original List:\n");
    traverse(head);

    // Sort (only needed if list not guaranteed sorted)
    sortList(head);
    printf("\nSorted List:\n");
    traverse(head);

    // Remove duplicates
    removeDuplicates(head);
    printf("\nAfter Removing Duplicates:\n");
    traverse(head);

    return 0;
}
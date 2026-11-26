#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node* insertAtFirst(struct Node *head, int value) {
    struct Node *newNode;

    newNode = (struct Node*)malloc(sizeof(struct Node));

    newNode->data = value;
    newNode->next = head;

    head = newNode;
    return head;
}


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

    head = insertAtFirst(head, 10);
    head = insertAtFirst(head, 20);
    head = insertAtFirst(head, 30);

    printf("Linked List Elements:\n");
    traverse(head);

    return 0;
}

// Linked List Elements:
// 30 -> 20 -> 10 -> NULL


// Write a program to copy a linked list.

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


struct Node* copyList(struct Node *head) {
    if (head == NULL)
        return NULL;

    struct Node *newHead = NULL;
    struct Node *temp = head;
    struct Node *copyTemp = NULL;

    while (temp != NULL) {
        struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
        newNode->data = temp->data;
        newNode->next = NULL;

        if (newHead == NULL) {
            newHead = newNode;
            copyTemp = newNode;
        } else {
            copyTemp->next = newNode;
            copyTemp = newNode;
        }

        temp = temp->next;
    }

    return newHead;
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
    struct Node *copiedList = NULL;

    head = insertAtFirst(head, 10);
    head = insertAtFirst(head, 20);
    head = insertAtFirst(head, 30);

    printf("Original List:\n");
    traverse(head);

    printf("\n--------------------\n");

    copiedList = copyList(head);

    printf("Copied List:\n");
    traverse(copiedList);

    return 0;
}
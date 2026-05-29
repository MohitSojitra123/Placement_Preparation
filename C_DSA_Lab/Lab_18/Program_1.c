// Write a program to sort elements of a linked list.

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

void traverse(struct Node *head) {
    struct Node *temp = head;

    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int main() {
    struct Node *head = NULL;

    head = insertAtFirst(head, 30);
    head = insertAtFirst(head, 10);
    head = insertAtFirst(head, 20);

    traverse(head);

    printf("\n--------------------\n");
    
    sortList(head);  
    
    printf("\n--------------------\n");

    traverse(head);

    return 0;
}
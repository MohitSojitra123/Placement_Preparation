#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};


struct Node* insertAtLast(struct Node *head, int value) {
    struct Node *newNode, *temp;

    newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->next = NULL;

    if (head == NULL) {
        head = newNode;
        return head;
    }

    temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
    return head;
}


void updateElement(struct Node *head, int oldValue, int newValue) {
    struct Node *temp = head;
    int found = 0;

    while (temp != NULL) {
        if (temp->data == oldValue) {
            temp->data = newValue;
            found = 1;
            break; 
        }
        temp = temp->next;
    }

    if (found == 0) {
        printf("Element %d not found in the list.\n", oldValue);
    } else {
        printf("Element updated successfully.\n");
    }
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

    head = insertAtLast(head, 10);
    head = insertAtLast(head, 20);
    head = insertAtLast(head, 30);

    printf("Before Update:\n");
    traverse(head);

    updateElement(head, 20, 25);

    printf("After Update:\n");
    traverse(head);

    return 0;
}

#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

struct node* InsertAtLast(int x, struct node *head) {
    struct node *NewNode, *temp;

    NewNode = (struct node*)malloc(sizeof(struct node));
    NewNode->data = x;
    NewNode->next = NULL;

    if (head == NULL) {
        return NewNode;
    }

    temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = NewNode;
    return head;
}

struct node* DeleteAtLast(struct node *head) {
    struct node *temp, *prev;

    // Case 1: Empty list
    if (head == NULL) {
        printf("List is empty. Nothing to delete.\n");
        return head;
    }

    // Case 2: Only one node
    if (head->next == NULL) {
        free(head);
        return NULL;
    }

    // Case 3: More than one node
    temp = head;
    while (temp->next != NULL) {
        prev = temp;
        temp = temp->next;
    }

    prev->next = NULL;
    free(temp);

    return head;
}

void Traverse(struct node *head) {
    struct node *temp = head;

    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}



int main() {

    struct node *head = NULL;

    head = InsertAtLast(10, head);
    head = InsertAtLast(20, head);
    head = InsertAtLast(30, head);
    head = InsertAtLast(40, head);

    printf("Before Deletion:\n");
    Traverse(head);

    head = DeleteAtLast(head);

    printf("After Deletion at Last:\n");
    Traverse(head);

    return 0;
}

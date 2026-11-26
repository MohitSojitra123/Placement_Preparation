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
        head = NewNode;
        return head;
    }

    temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = NewNode;
    return head;
}


struct node* DeleteAtBeginning(struct node *head) {
    struct node *temp;

    if (head == NULL) {
        printf("Linked List is empty. Nothing to delete.\n");
        return head;
    }

    temp = head;          // store old head
    head = head->next;    // move head to next node
    free(temp);           // free old head

    return head;          // return new head
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

    head = DeleteAtBeginning(head);

    printf("After Deletion at Beginning:\n");
    Traverse(head);

    return 0;
}

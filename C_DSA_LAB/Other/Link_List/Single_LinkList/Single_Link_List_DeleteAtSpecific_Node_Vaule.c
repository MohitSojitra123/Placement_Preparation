#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

struct node* insertAtLast(struct node *head, int value)
{
    struct node *newNode, *temp;

    newNode = (struct node*)malloc(sizeof(struct node));
    newNode->data = value;
    newNode->next = NULL;

    if (head == NULL)
        return newNode;

    temp = head;
    while (temp->next != NULL)
        temp = temp->next;

    temp->next = newNode;

    return head;
}


struct node* deleteByValue(struct node *head, int value)
{
    struct node *temp, *previous;

    // Case 1: Empty List
    if (head == NULL) {
        printf("List is Empty\n");
        return head;
    }

    temp = head;

    // Case 2: Value is in first node
    // No Need To Link in Previous Node Because Node Is First 
    if (temp->data == value) {
        head = temp->next;
        free(temp);
        return head;
    }

    // Case 3: Search for value
    while (temp != NULL && temp->data != value) {
        previous = temp;
        temp = temp->next;
    }

    // Value not found
    if (temp == NULL) {
        printf("Value not found in list\n");
        return head;
    }

    // Delete node
    previous->next = temp->next;
    free(temp);

    return head;
}


void traverse(struct node *head)
{
    struct node *temp = head;

    if (head == NULL) {
        printf("List is Empty\n");
        return;
    }

    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }

    printf("NULL\n");
}


int main()
{
    struct node *head = NULL;

    head = insertAtLast(head, 10);
    head = insertAtLast(head, 20);
    head = insertAtLast(head, 30);
    head = insertAtLast(head, 40);
    head = insertAtLast(head, 50);

    printf("Before Deletion:\n");
    traverse(head);

    head = deleteByValue(head, 30);

    printf("After Deleting 30:\n");
    traverse(head);

    return 0;
}


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


struct node* delete_after(struct node *head, int key)
{
    struct node *ptr1, *ptr2;

    ptr1 = head;

    while (ptr1->next != NULL)
    {
        if (ptr1->data == key)
        {
            ptr2 = ptr1->next;
            ptr1->next = ptr2->next;
            free(ptr2);
            break;
        }

        ptr1 = ptr1->next;
    }

    return head;
}


void traverse(struct node *head)
{
    struct node *temp = head;

    while (temp != NULL)
    {
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

    head = delete_after(head, 30);

    printf("After Deleting Node After 30:\n");
    traverse(head);

    return 0;
}

#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};


struct node* insert(struct node *head, int value)
{
    struct node *newNode, *temp;

    newNode = (struct node*)malloc(sizeof(struct node));
    newNode->data = value;

    // First node
    if (head == NULL) {
        newNode->next = newNode;
        return newNode;
    }

    temp = head;
    while (temp->next != head)
        temp = temp->next;

    temp->next = newNode;
    newNode->next = head;

    return head;
}


void search(struct node *head, int key)
{
    struct node *temp;
    int position = 1;
    int found = 0;

    if (head == NULL) {
        printf("List is Empty\n");
        return;
    }

    temp = head;

    do {
        if (temp->data == key) {
            printf("Element %d found at position %d\n", key, position);
            found = 1;
            break;
        }

        temp = temp->next;
        position++;

    } while (temp != head);

    if (!found)
        printf("Element %d not found in the list\n", key);
}

void traverse(struct node *head)
{
    struct node *temp;

    if (head == NULL) {
        printf("List is Empty\n");
        return;
    }

    temp = head;

    do {
        printf("%d -> ", temp->data);
        temp = temp->next;
    } while (temp != head);

    printf("(Back to Head)\n");
}



int main()
{
    struct node *head = NULL;

    head = insert(head, 10);
    head = insert(head, 20);
    head = insert(head, 30);
    head = insert(head, 40);

    printf("Circular Linked List:\n");
    traverse(head);

    search(head, 30);
    search(head, 50);

    return 0;
}

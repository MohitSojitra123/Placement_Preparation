// 1. Write  a  menu  driven  program  to  implement  following  operations  on  the 
// Ordered linked list: 
// • Insert a node  
// • Delete a node  
// • Display the list  
// • Count number of nodes 

#include <stdio.h>
#include <stdlib.h>

struct node {
    int info;
    struct node *link;
};


struct node* Insert(struct node *first, int x) {
    struct node *newnode = (struct node*)malloc(sizeof(struct node));
    newnode->info = x;
    newnode->link = NULL;


    if (first == NULL) {
        return newnode;
    }


    if (x < first->info) {
        newnode->link = first;
        return newnode;
    }

  
    struct node *temp = first;
    while (temp->link != NULL && temp->link->info < x) {
        temp = temp->link;
    }

    newnode->link = temp->link;
    temp->link = newnode;

    return first;
}


struct node* Delete(struct node *first, int x) {
    if (first == NULL) {
        printf("List is empty.\n");
        return first;
    }

    struct node *temp = first;
    struct node *prev = NULL;


    if (temp->info == x) {
        first = temp->link;
        free(temp);
        return first;
    }

    while (temp != NULL && temp->info != x) {
        prev = temp;
        temp = temp->link;
    }

    if (temp == NULL) {
        printf("Element not found.\n");
        return first;
    }

    prev->link = temp->link;
    free(temp);

    return first;
}


void Display(struct node *first) {
    if (first == NULL) {
        printf("List is empty.\n");
        return;
    }

    while (first != NULL) {
        printf("%d -> ", first->info);
        first = first->link;
    }
    printf("NULL\n");
}


int Count(struct node *first) {
    int count = 0;
    while (first != NULL) {
        count++;
        first = first->link;
    }
    return count;
}

int main() {
    struct node *first = NULL;
    int choice, value;

    do {
        printf("\n--- Ordered Linked List Menu ---\n");
        printf("1. Insert\n");
        printf("2. Delete\n");
        printf("3. Display\n");
        printf("4. Count\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                first = Insert(first, value);
                break;

            case 2:
                printf("Enter value to delete: ");
                scanf("%d", &value);
                first = Delete(first, value);
                break;

            case 3:
                Display(first);
                break;

            case 4:
                printf("Total nodes: %d\n", Count(first));
                break;

            case 5:
                printf("Exiting...\n");
                break;

            default:
                printf("Invalid choice.\n");
        }

    } while (choice != 5);

    return 0;
}

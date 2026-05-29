// 1. Write  a  menu  driven  program  to  implement  following  operations  on  the 
// Circular Linked List. 
// • Delete a node at the beginning of the circular linked list  
// • Delete a node at the end of the circular linked list  
// • Display the list 
// • Delete a specific node


#include<stdio.h>
#include<stdlib.h>

struct node {
    int info;
    struct node *link;
};

struct node *last = NULL;

struct node* create_node(int x) {
    struct node *newnode = (struct node*)malloc(sizeof(struct node));
    newnode->info = x;
    newnode->link = NULL;
    return newnode;
}


void insert(int x) {
    struct node *newnode = create_node(x);

    if (last == NULL) {
        last = newnode;
        last->link = last;
    } else {
        newnode->link = last->link;
        last->link = newnode;
        last = newnode;
    }
}

void delete_begin() {
    if (last == NULL) {
        printf("\nList is empty");
        return;
    }

    struct node *temp = last->link;

    if (last->link == last) {  
        free(temp);
        last = NULL;
    } else {
        last->link = temp->link;
        free(temp);
    }

    printf("\nNode deleted from beginning");
}


void delete_end() {
    if (last == NULL) {
        printf("\nList is empty");
        return;
    }

    struct node *temp = last->link;

    if (last->link == last) {
        free(last);
        last = NULL;
        return;
    }

    while (temp->link != last) {
        temp = temp->link;
    }

    temp->link = last->link;
    free(last);
    last = temp;

    printf("\nNode deleted from end");
}


void delete_specific(int key) {
    if (last == NULL) {
        printf("\nList is empty");
        return;
    }

    struct node *curr = last->link;
    struct node *prev = last;

    do {
        if (curr->info == key) {

            if (curr == last && curr == last->link) {
                free(curr);
                last = NULL;
            }
            else {
                prev->link = curr->link;

                if (curr == last)
                    last = prev;

                free(curr);
            }

            printf("\nNode deleted");
            return;
        }

        prev = curr;
        curr = curr->link;

    } while (curr != last->link);

    printf("\nValue not found");
}


void display() {
    if (last == NULL) {
        printf("\nList is empty");
        return;
    }

    struct node *temp = last->link;

    printf("\nCircular Linked List: ");

    do {
        printf("%d -> ", temp->info);
        temp = temp->link;
    } while (temp != last->link);

    printf("(Back to Start)");
}


void main() {
    int choice, value;

    while (1) {
        printf("\n\n--- MENU ---");
        printf("\n1. Insert");
        printf("\n2. Delete at Beginning");
        printf("\n3. Delete at End");
        printf("\n4. Delete Specific Node");
        printf("\n5. Display");
        printf("\n6. Exit");
        printf("\nEnter choice: ");
        scanf("%d", &choice);

        switch (choice) {

            case 1:
                printf("Enter value: ");
                scanf("%d", &value);
                insert(value);
                break;

            case 2:
                delete_begin();
                break;

            case 3:
                delete_end();
                break;

            case 4:
                printf("Enter value to delete: ");
                scanf("%d", &value);
                delete_specific(value);
                break;

            case 5:
                display();
                break;

            case 6:
                exit(0);

            default:
                printf("\nInvalid choice");
        }
    }
}
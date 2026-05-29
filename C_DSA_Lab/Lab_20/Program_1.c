// 1. Write  a  menu  driven  program  to  implement  following  operations  on  the 
// Circular Linked List. 
// •  Insert a node at the beginning of the circular linked list  
// •  Insert a node at the end of the circular linked list  
// •  Display the list  
// •  Count the nodes


#include<stdio.h>
#include<stdlib.h>

struct node {
    int info;
    struct node *link;
};

struct node *last = NULL;  

void insert_begin(int x) {
    struct node *new = (struct node*)malloc(sizeof(struct node));
    new->info = x;

    if (last == NULL) {
        new->link = new;
        last = new;
    }
    else {
        new->link = last->link;   
        last->link = new;        
    }
}


void insert_end(int x) {
    struct node *new = (struct node*)malloc(sizeof(struct node));
    new->info = x;

    if (last == NULL) {
        new->link = new;
        last = new;
    }
    else {
        new->link = last->link;  
        last->link = new;        
        last = new;              
    }
}


void display() {
    if (last == NULL) {
        printf("\nList is empty\n");
        return;
    }

    struct node *temp = last->link; 

    printf("\nCircular Linked List:\n");
    do {
        printf("%d -> ", temp->info);
        temp = temp->link;
    } while (temp != last->link);

    printf("(back to first)\n");
}


void count_nodes() {
    if (last == NULL) {
        printf("\nTotal Nodes: 0\n");
        return;
    }

    int count = 0;
    struct node *temp = last->link;

    do {
        count++;
        temp = temp->link;
    } while (temp != last->link);

    printf("\nTotal Nodes: %d\n", count);
}

int main() {
    int choice, value;

    while (1) {
        printf("\n--- Circular Linked List Menu ---");
        printf("\n1. Insert at Beginning");
        printf("\n2. Insert at End");
        printf("\n3. Display");
        printf("\n4. Count Nodes");
        printf("\n5. Exit");
        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value: ");
                scanf("%d", &value);
                insert_begin(value);
                break;

            case 2:
                printf("Enter value: ");
                scanf("%d", &value);
                insert_end(value);
                break;

            case 3:
                display();
                break;

            case 4:
                count_nodes();
                break;

            case 5:
                exit(0);

            default:
                printf("\nInvalid choice!\n");
        }
    }

    return 0;
}
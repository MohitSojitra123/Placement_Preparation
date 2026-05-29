// 1. Write a menu driven program to implement following operations on the singly
// linked list:
// • Insert a node at the beginning of the linked list
// • Insert a node at the end of the linked list
// • Display the list
// • Count number of nodes 

#include<stdio.h>
#include<stdlib.h>

struct node {
    int info;
    struct node *link;
};

// Create Node
struct node *creat_node(int x, struct node *first){
    struct node *new = (struct node *)malloc(sizeof(struct node));
    new->info = x;
    new->link = NULL;
    return new;
}

// Insert at Beginning
struct node *insertf(int x, struct node *first){
    struct node *new = creat_node(x, first);
    new->link = first;
    first = new;
    return first;
}

// Insert at End
struct node *inserte(int x, struct node *first){
    struct node *new = creat_node(x, first);

    if(first == NULL){
        return new;
    }

    struct node *save = first;
    while(save->link != NULL){
        save = save->link;
    }

    save->link = new;
    return first;
}

// Display List
void display(struct node *first){
    if(first == NULL){
        printf("\nList is Empty\n");
        return;
    }

    printf("\nLinked List Elements:\n");
    while(first != NULL){
        printf("%d -> ", first->info);
        first = first->link;
    }
    printf("NULL\n");
}

// Count Nodes
int count(struct node *first){
    int cnt = 0;
    while(first != NULL){
        cnt++;
        first = first->link;
    }
    return cnt;
}


void main(){
    struct node *first = NULL;
    int choice, value;

    do{
        printf("\n----- MENU -----\n");
        printf("1. Insert at Beginning\n");
        printf("2. Insert at End\n");
        printf("3. Display List\n");
        printf("4. Count Nodes\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch(choice){

            case 1:
                printf("Enter value: ");
                scanf("%d", &value);
                first = insertf(value, first);
                break;

            case 2:
                printf("Enter value: ");
                scanf("%d", &value);
                first = inserte(value, first);
                break;

            case 3:
                display(first);
                break;

            case 4:
                printf("Total Nodes = %d\n", count(first));
                break;

            case 5:
                printf("Exiting Program...\n");
                break;

            default:
                printf("Invalid Choice!\n");
        }

    }while(choice != 5);
}

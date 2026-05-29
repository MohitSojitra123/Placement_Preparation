// 1. Write a menu driven program to implement following operations on the singly 
// linked list: 
// •  Delete the first node of the linked list  
// •  Delete the last node of the linked list  
// •  Display the list  
// •  Delete a specific node 


#include<stdio.h>
#include<stdlib.h>

struct node {
    int info;
    struct node *link;
};

struct node *create_node(int x){
    struct node *newnode = (struct node *)malloc(sizeof(struct node));
    newnode->info = x;
    newnode->link = NULL;
    return newnode;
}

/* Insert at First */
struct node *insertf(int x, struct node *first){
    struct node *newnode = create_node(x);
    newnode->link = first;
    first = newnode;
    return first;
}

/* Insert at End */ 
struct node *inserte(int x, struct node *first){
    struct node *newnode = create_node(x);

    if(first == NULL)
        return newnode;

    struct node *save = first;
    while(save->link != NULL)
        save = save->link;

    save->link = newnode;
    return first;
}

/* Delete First */
struct node *deletef(struct node *first){
    if(first == NULL){
        printf("\nList is empty!");
        return first;
    }

    struct node *temp = first;
    first = first->link;
    free(temp);

    printf("\nFirst node deleted successfully.");
    return first;
}

/* Delete Last */
struct node *deletee(struct node *first){
    if(first == NULL){
        printf("\nList is empty!");
        return first;
    }

    if(first->link == NULL){
        free(first);
        printf("\nLast node deleted successfully.");
        return NULL;
    }

    struct node *save = first;
    struct node *prev = NULL;

    while(save->link != NULL){
        prev = save;
        save = save->link;
    }

    prev->link = NULL;
    free(save);

    printf("\nLast node deleted successfully.");
    return first;
}

/* Delete Specific Element */
struct node *deleteele(int x, struct node *first){
    if(first == NULL){
        printf("\nList is empty!");
        return first;
    }

    struct node *save = first;
    struct node *prev = NULL;

    while(save != NULL && save->info != x){
        prev = save;
        save = save->link;
    }

    if(save == NULL){
        printf("\nElement not found!");
        return first;
    }

    if(prev == NULL)   // deleting first node
        first = save->link;
    else
        prev->link = save->link;

    free(save);
    printf("\nElement deleted successfully.");
    return first;
}

/* Display */
void display(struct node *first){
    if(first == NULL){
        printf("\nList is empty!");
        return;
    }

    printf("\nLinked List Elements:\n");
    while(first != NULL){
        printf("%d -> ", first->info);
        first = first->link;
    }
    printf("NULL\n");
}


int main(){
    struct node *first = NULL;
    int choice, value;

    do{
        printf("\n===== MENU =====");
        printf("\n1. Insert at First");
        printf("\n2. Insert at End");
        printf("\n3. Delete First Node");
        printf("\n4. Delete Last Node");
        printf("\n5. Delete Specific Node");
        printf("\n6. Display List");
        printf("\n7. Exit");
        printf("\nEnter your choice: ");
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
                first = deletef(first);
                break;

            case 4:
                first = deletee(first);
                break;

            case 5:
                printf("Enter value to delete: ");
                scanf("%d", &value);
                first = deleteele(value, first);
                break;

            case 6:
                display(first);
                break;

            case 7:
                printf("\nExiting program...");
                break;

            default:
                printf("\nInvalid choice!");
        }

    } while(choice != 7);

    return 0;
}

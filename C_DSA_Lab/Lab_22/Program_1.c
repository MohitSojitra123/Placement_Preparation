// Write  a  menu  driven  program  to  implement  following  operations  on  the 
// Doubly Linked List. 
// • Insert a node in doubly linked list 
// • Delete a node in doubly linked list 
// • Display the list 
// • Count the number of nodes 

#include<stdio.h>
#include<stdlib.h>

struct node{
    int info;
    struct node *prev;
    struct node *next;
};

struct node *start = NULL;

/* Insert at Beginning */
void insert_first(int x){
    struct node *new = (struct node*)malloc(sizeof(struct node));
    new->info = x;

    if(start == NULL){
        new->prev = NULL;
        new->next = NULL;
        start = new;
    }
    else{
        new->next = start;
        new->prev = NULL;
        start->prev = new;
        start = new;
    }
}

/* Insert at End */
void insert_last(int x){
    struct node *new = (struct node*)malloc(sizeof(struct node));
    new->info = x;

    if(start == NULL){
        new->prev = NULL;
        new->next = NULL;
        start = new;
        return;
    }

    struct node *temp = start;
    while(temp->next != NULL){
        temp = temp->next;
    }

    temp->next = new;
    new->prev = temp;
    new->next = NULL;
}

/* Insert at Specific Position */
void insert_pos(int x, int pos){
    struct node *new = (struct node*)malloc(sizeof(struct node));
    new->info = x;

    struct node *temp = start;
    int i;

    for(i=1;i<pos-1;i++){
        temp = temp->next;
        if(temp == NULL){
            printf("Position not found\n");
            return;
        }
    }

    new->next = temp->next;
    new->prev = temp;

    if(temp->next != NULL)
        temp->next->prev = new;

    temp->next = new;
}

/* Delete First Node */
void delete_first(){
    if(start == NULL){
        printf("List Empty\n");
        return;
    }

    struct node *temp = start;
    start = start->next;

    if(start != NULL)
        start->prev = NULL;

    free(temp);
}

/* Delete Last Node */
void delete_last(){
    if(start == NULL){
        printf("List Empty\n");
        return;
    }

    struct node *temp = start;

    while(temp->next != NULL){
        temp = temp->next;
    }

    if(temp->prev != NULL)
        temp->prev->next = NULL;
    else
        start = NULL;

    free(temp);
}

/* Delete at Specific Position */
void delete_pos(int pos){
    struct node *temp = start;
    int i;

    for(i=1;i<pos;i++){
        temp = temp->next;
        if(temp == NULL){
            printf("Position not found\n");
            return;
        }
    }

    if(temp->prev != NULL)
        temp->prev->next = temp->next;

    if(temp->next != NULL)
        temp->next->prev = temp->prev;

    if(temp == start)
        start = temp->next;

    free(temp);
}

/* Display List */
void display(){
    struct node *temp = start;

    if(start == NULL){
        printf("List Empty\n");
        return;
    }

    printf("List: ");
    while(temp != NULL){
        printf("%d <-> ", temp->info);
        temp = temp->next;
    }
    printf("NULL\n");
}

/* Count Nodes */
void count_nodes(){
    int count = 0;
    struct node *temp = start;

    while(temp != NULL){
        count++;
        temp = temp->next;
    }

    printf("Total Nodes: %d\n",count);
}

int main(){
    int ch,val,pos;

    while(1){
        printf("\n--- Doubly Linked List Menu ---");
        printf("\n1 Insert First");
        printf("\n2 Insert Last");
        printf("\n3 Insert at Position");
        printf("\n4 Delete First");
        printf("\n5 Delete Last");
        printf("\n6 Delete at Position");
        printf("\n7 Display");
        printf("\n8 Count Nodes");
        printf("\n9 Exit");
        printf("\nEnter Choice: ");
        scanf("%d",&ch);

        switch(ch){

        case 1:
            printf("Enter value: ");
            scanf("%d",&val);
            insert_first(val);
            break;

        case 2:
            printf("Enter value: ");
            scanf("%d",&val);
            insert_last(val);
            break;

        case 3:
            printf("Enter value: ");
            scanf("%d",&val);
            printf("Enter position: ");
            scanf("%d",&pos);
            insert_pos(val,pos);
            break;

        case 4:
            delete_first();
            break;

        case 5:
            delete_last();
            break;

        case 6:
            printf("Enter position: ");
            scanf("%d",&pos);
            delete_pos(pos);
            break;

        case 7:
            display();
            break;

        case 8:
            count_nodes();
            break;

        case 9:
            exit(0);

        default:
            printf("Invalid Choice\n");
        }
    }

    return 0;
}
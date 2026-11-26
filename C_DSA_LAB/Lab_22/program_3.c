#include<stdio.h>
#include<stdlib.h>

struct node{
    int info;
    struct node *prev;
    struct node *next;
};

/* Insert at beginning */
struct node* insert_first(struct node *head, int x){
    struct node *new = (struct node*)malloc(sizeof(struct node));
    new->info = x;
    new->prev = NULL;
    new->next = head;

    if(head != NULL)
        head->prev = new;

    head = new;
    return head;
}

/* Insert at end */
struct node* insert_last(struct node *head, int x){
    struct node *new = (struct node*)malloc(sizeof(struct node));
    new->info = x;
    new->next = NULL;

    if(head == NULL){
        new->prev = NULL;
        return new;
    }

    struct node *temp = head;

    while(temp->next != NULL)
        temp = temp->next;

    temp->next = new;
    new->prev = temp;

    return head;
}

/* Delete first node */
struct node* delete_first(struct node *head){
    if(head == NULL){
        printf("List Empty\n");
        return head;
    }

    struct node *temp = head;
    head = head->next;

    if(head != NULL)
        head->prev = NULL;

    free(temp);
    return head;
}

/* Delete last node */
struct node* delete_last(struct node *head){
    if(head == NULL){
        printf("List Empty\n");
        return head;
    }

    struct node *temp = head;

    while(temp->next != NULL)
        temp = temp->next;

    if(temp->prev != NULL)
        temp->prev->next = NULL;
    else
        head = NULL;

    free(temp);
    return head;
}

/* Display list */
void display(struct node *head){
    struct node *temp = head;

    if(head == NULL){
        printf("List Empty\n");
        return;
    }

    while(temp != NULL){
        printf("%d <-> ", temp->info);
        temp = temp->next;
    }
    printf("NULL\n");
}

/* Count nodes */
int count_nodes(struct node *head){
    int count = 0;
    struct node *temp = head;

    while(temp != NULL){
        count++;
        temp = temp->next;
    }

    return count;
}

int main(){
    struct node *head = NULL;
    int ch,val;

    while(1){
        printf("\n1 Insert First");
        printf("\n2 Insert Last");
        printf("\n3 Delete First");
        printf("\n4 Delete Last");
        printf("\n5 Display");
        printf("\n6 Count");
        printf("\n7 Exit");
        printf("\nEnter choice: ");
        scanf("%d",&ch);

        switch(ch){

        case 1:
            printf("Enter value: ");
            scanf("%d",&val);
            head = insert_first(head,val);
            break;

        case 2:
            printf("Enter value: ");
            scanf("%d",&val);
            head = insert_last(head,val);
            break;

        case 3:
            head = delete_first(head);
            break;

        case 4:
            head = delete_last(head);
            break;

        case 5:
            display(head);
            break;

        case 6:
            printf("Total Nodes: %d\n",count_nodes(head));
            break;

        case 7:
            exit(0);

        default:
            printf("Invalid Choice\n");
        }
    }

    return 0;
}
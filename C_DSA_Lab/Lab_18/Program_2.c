// Write  a  program  to  remove  the  duplicates  nodes  from  given  sorted  Linked 
// List.  
// Input: 1 → 1 → 6 → 13 → 13 → 13 → 27 → 27  
// Output: 1 → 6 → 13 → 27 


#include<stdio.h>
#include<stdlib.h>


struct node{
    int data;
    struct node *next;
};

struct node* insert(struct node *head, int value){

    struct node *newnode, *temp;

    newnode = (struct node*)malloc(sizeof(struct node));

    newnode->data = value;
    newnode->next = NULL;

    if(head == NULL){
        head = newnode;
    }
    else{
        temp = head;

        while(temp->next != NULL){
            temp = temp->next;
        }

        temp->next = newnode;
    }

    return head;
}


void display(struct node *head){

    struct node *temp = head;

    while(temp != NULL){

        printf("%d", temp->data);

        if(temp->next != NULL){
            printf(" -> ");
        }

        temp = temp->next;
    }
}


struct node* removeDuplicate(struct node *head){

    struct node *i, *j, *prev, *duplicate;


    for(i = head; i != NULL; i = i->next){

        prev = i;

        for(j = i->next; j != NULL; ){

            if(i->data == j->data){
                duplicate = j;
                prev->next = j->next;
                j = j->next;
                free(duplicate);
            }
            else{
                prev = j;
                j = j->next;
            }
        }
    }

    return head;
}

int main(){

    struct node *head = NULL;

    // Input:
    // 1 -> 1 -> 6 -> 13 -> 13 -> 13 -> 27 -> 27

    head = insert(head, 1);
    head = insert(head, 1);
    head = insert(head, 6);
    head = insert(head, 13);
    head = insert(head, 13);
    head = insert(head, 13);
    head = insert(head, 27);
    head = insert(head, 27);

    printf("Original Linked List:\n");
    display(head);

    head = removeDuplicate(head);

    printf("\n\nAfter Removing Duplicates:\n");
    display(head);

    return 0;
}
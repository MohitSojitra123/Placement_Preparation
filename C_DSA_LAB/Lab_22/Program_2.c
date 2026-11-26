// Write  a  menu  driven  program  to  implement  following  operations  on  the 
// Doubly Linked List. 
// • Insert a node in doubly linked list (first - last and specific  index) 
// • Delete a node in doubly linked list  (first - last - specific index)
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

void display(){
    struct node *temp=start;
    while ((temp!=NULL))
    {
        printf(" %d ",temp->info);
        temp=temp->next;
    }
}




int main(){
    
    insert_first(10);
    insert_first(20);
    insert_first(30);

    display();

}

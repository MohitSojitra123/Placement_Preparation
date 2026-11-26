// 1. Write  a  menu  driven  program  to  implement  following  operations  on  the 
// Ordered linked list: 
// • Insert a node  
// • Delete a node  
// • Display the list  
// • Count number of nodes 

#include<stdio.h>
#include<stdlib.h>

struct node{
    int info;
    struct node* link;
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

void Display(struct node *first){
           struct node *save=first;

           while(save!=NULL){
              printf(" %d ",save->info);
              save=save->link;
           }
}

int main(){

    struct node* first=NULL;

    first=Insert(first,10);
    first=Insert(first,30);
    first=Insert(first,20);

    Display(first);
    
}
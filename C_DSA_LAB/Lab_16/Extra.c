// A 1. Write a menu driven program to implement following operations on the singly 
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

// struct node *first;
struct node *creat_node(int x,struct node *first){
    struct node * new = (struct node *)malloc(sizeof(struct node));
    new->info=x;
    new->link=NULL;
    return new;
}

struct node *insertf(int x,struct node *first){
    struct node * new = creat_node(x,first);
    new->link=first;
    first=new;
    return first;
}

struct node *inserte(int x,struct node *first){
    struct node * new = creat_node(x,first);
    if(first == NULL){
        return new;
    }
    struct node *save=first;
    while (save->link!=NULL)
    {
        save=save->link;
    }
    save->link=new;
    return first;
}

struct node *deletef(struct node *first){
    struct node * save = first;
    if(first==NULL){
        printf("stack is empty");
        return first;
    }
    if(first->link==NULL){
        free(save);
        first =NULL;
        return first;
    }
    first = save->link;
    free(save);
    return first;
}

struct node *deletee(struct node *first){
    struct node *save = first;
    struct node *prev = first;
    if(first==NULL){
        printf("stack is empty");
        return first;
    }
    if(first->link==NULL){
        free(save);
        first =NULL;
        return first;
    }
    while(save->link!=NULL){
        prev = save;
        save=save->link;
    }
    prev->link=NULL;
    free(save);
    return first;
}

struct node *deleteele(int x,struct node *first){
    struct node *save = first;
    struct node *prev = first;
    if(first==NULL){
        printf("stack is empty");
        return first;
    }
    if(first->link==NULL){
        free(save);
        first =NULL;
        return first;
    }
    while(save->info!=x && save->link!=NULL){
        prev = save;
        save=save->link;
    }
    if(first->info==x){
        first=first->link;
        return first;
    }else{
        prev->link=save->link;
        free(save);
        return first;
    }
}

void display(struct node *first){
    if(first==NULL){
        printf("stack is empty");
        return;
    }
    while(first!=NULL){
        printf("\n%d",first->info);
        first=first->link;
    }
}

void main(){
    struct node *first =NULL;
    first=insertf(10,first);
    first=insertf(20,first);
    first=inserte(30,first);
    first=inserte(40,first);
    first=deletef(first);
    first=deletee(first);
    first=deleteele(10,first);
    first=deletee(first);
    // first=deletee(first);
    display(first);
}
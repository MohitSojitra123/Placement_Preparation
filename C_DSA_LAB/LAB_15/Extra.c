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

void display(struct node *first){
    while(first!=NULL){
        printf("\n%d",first->info);
        first=first->link;
    }
    // printf("%d",first->info);
}

void main(){
    struct node *first =NULL;
    first=insertf(10,first);
    first=insertf(10,first);
    first=inserte(10,first);
    first=inserte(10,first);
    display(first);
}
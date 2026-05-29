// 1. Write  a  menu  driven  program  to  perform  following  operations  on  Simple 
// Queue: ENQUEUE, DEQUEUE and DISPLAY. 

#include <stdio.h>
#define Max 5

int queue[Max];
int f=-1,r=-1;

void enqueue(){
    int item;
    if(r==Max-1){
        printf("overflow");
    }
    else{
        if(f==-1){
            f=0;
        }
        printf("enter element to insert: ");
        scanf("%d",&item);
        queue[++r]=item;
        printf("\ninserted");
    }
}

void dequeue(){
    if(f==-1 || f>r){
        printf("queue underflow");
    }
    else{
        printf("deleted elemets: %d\n",queue[f]);
        f++;
        if(f>r){
            f=r=-1;
        }
    }
}

void display(){
    if(f==-1){
        printf("underflow");
    }
    else{
        for(int i=f;i<=r;i++){
            printf("%d",queue[i]);
        }
        printf("\n");
    }
}

int main(){
    int choice;
    int a=1;
    while(a!=0){
        printf("enter 1 for enqueue, 2 for dequeue, 3 for display,4 for exit: ");
        scanf("%d",&choice);
        switch (choice)
        {
        case 1:
            enqueue();
            break;
        case 2:
            dequeue();
            break;
        case 3:
            display();
            break;
        case 4:
            a=0;
            break;
        default:
            printf("\nenter number between 1 to 4 only");
            break;
        }
    }
}
#include<stdio.h>
#define size 5

int front=-1;
int rear=-1;

struct Pqueue{
    int data;
    int priority;
};

struct Pqueue pq[size];

void Enqueue(int value,int priority){
       
     if(rear == size-1){
            printf("PQ Is Overflow : ");
     }else{
        
        if(front == -1){
            front=0;
        }

        rear++;

        pq[rear].data=value;
        pq[rear].priority=priority;
     }
}

void Dequeue(){
    
     int max=0;

     for(int i=1; i<=rear; i++){
           if(pq[max].priority < pq[i].priority){
            max=i;
           }
     }
        
     
     printf("%d -> %d \n",pq[max].data,pq[max].priority);
     
     for(int j=max; j<rear; j++){
         pq[j]=pq[j+1];
        }
        
        
        rear--;
}

void Display(){
     for(int i=0; i<=rear; i++){
        printf("%d ->  %d \n",pq[i].data , pq[i].priority);
     }
}

int main(){

    Enqueue(101,4);
    Enqueue(102,5);
    Enqueue(103,6);
    Enqueue(104,1);
    Enqueue(105,2);

    printf("\n------------------\n");
    
    Display();
    
    printf("\n------------------\n");
    
    Dequeue();
    Dequeue();
    Dequeue();
    Dequeue();
    
    printf("\n------------------\n");

    Display();


}
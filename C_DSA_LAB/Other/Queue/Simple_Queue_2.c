#include<stdio.h>
#define size 5

int Queue[size];
int rear=-1;
int front=-1;


void Enqueue(int element){
    if(rear ==  size-1){
         printf("Queue Is Overflow : \n");
    }else{
        Queue[++rear]=element;
        if(front == -1){
            front=0;
        }
    }
}

int Dequeue(){
    if(front == -1){
        printf("Queue Is Underflow : \n");
        return ;
    }else{
 
        int y=Queue[front];

        if(rear == front){
              rear=-1;
              front=-1; 
        }else{
            front++;
        } 

        return y;
    }
}

void Display(){
    if(rear == -1){
        printf("Queue Is Empty : \n");
    }else{
       for(int i=front; i<=rear; i++){
            printf("%d \n",Queue[i]);
        }
    }
}

int main(){

Enqueue(10);   
Enqueue(20);   
Enqueue(30);   
Enqueue(40);   
Enqueue(50);   
Enqueue(60);

Display();

printf("\n-------------------\n");
printf(" %d \n",Dequeue());
printf(" %d \n",Dequeue());
printf(" %d \n",Dequeue());
printf(" %d \n",Dequeue());
printf(" %d \n",Dequeue());
printf(" %d \n",Dequeue());

Enqueue(10);
Enqueue(20);
Enqueue(30);
Enqueue(40);
Enqueue(50);


Display();

}
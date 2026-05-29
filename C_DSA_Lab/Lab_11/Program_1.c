// 1. Write  a  menu  driven  program  to  perform  following  operations  on  Circular  
// Queue: ENQUEUE, DEQUEUE and DISPLAY. 

#include<stdio.h>
#define max 5

int queue[max];
int front = -1, rear = -1;

void enqueue(int x){
    if((rear + 1) % max == front){
        printf("\nCircular Queue is Overflow\n");
        return;
    }

    rear = (rear + 1) % max;
    queue[rear] = x;

    if(front == -1){
        front = 0;
    }

    printf("\n%d inserted successfully\n", x);
}

int dequeue(){
    if(front == -1){
        printf("\nCircular Queue is Underflow\n");
        return -1;
    }

    int y = queue[front];

    if(front == rear){
        front = rear = -1;
    } else {
        front = (front + 1) % max;
    }

    return y;
}

void display(){
    if(front == -1){
        printf("\nCircular Queue is Empty\n");
        return;
    }

    printf("\nCircular Queue Elements:\n");
    int i = front;

    while(i != rear){
        printf("%d\t", queue[i]);
        i = (i + 1) % max;
    }
    printf("%d\n", queue[rear]);
}

int main(){
    int choice, value, result;

    do{
        printf("\n\n===== Circular Queue Menu =====");
        printf("\n1. ENQUEUE");
        printf("\n2. DEQUEUE");
        printf("\n3. DISPLAY");
        printf("\n4. EXIT");
        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch(choice){
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                enqueue(value);
                break;

            case 2:
                result = dequeue();
                if(result != -1){
                    printf("Deleted element: %d\n", result);
                }
                break;

            case 3:
                display();
                break;

            case 4:
                printf("\nExiting program...\n");
                break;

            default:
                printf("\nInvalid choice! Try again.\n");
        }

    } while(choice != 4);

    return 0;
}

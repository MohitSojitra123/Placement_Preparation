// 1. Write  a  menu  driven  program  to  perform  following  operations  on  Double 
// Ended  Queue:  
// • ENQUEUE Front  
// • ENQUEUE Rear  
// • DISPLAY  
// • DEQUEUE Front 
// • DEQUEUE Rear 
 

// #include <stdio.h>
// #define Max 5

// int queue[Max];
// int f=-1,r=-1;

// void enqueue_rear(){
//     int item;
//     if(r==Max-1){
//         printf("overflow");
//     }
//     else{
//         if(f==-1){
//             f=0;
//         }
//         printf("enter element to insert: ");
//         scanf("%d",&item);
//         queue[++r]=item;
//         printf("\ninserted");
//     }
// }

// void enqueue_front(int x){
//     if(f==0){
//         printf("overflow");
//         return;
//     }
//     if(f==-1){
//         f=r=0;
//     }
//     f--;
//     queue[f]=x;
//     return;
// }

// void dequeue_front(){
//     if(f==-1 || f>r){
//         printf("queue underflow");
//     }
//     else{
//         printf("deleted elemets: %d\n",queue[f]);
//         f++;
//         if(f>r){
//             f=r=-1;
//         }
//     }
// }

// int dequeue_rear(){
//     if(r==-1){
//         printf("queue is underflow");
//         return 0;
//     }
//     int y=queue[r];
//     if(r==f){
//         r=f=-1;
//     }
//     r--;
//     return y;
// }

// void display(){
//     if(f==-1){
//         printf("underflow");
//     }
//     else{
//         for(int i=f;i<=r;i++){
//             printf("%d",queue[i]);
//         }
//         printf("\n");
//     }
// }

// void display_queue(){
//     if(f==-1){
//         printf("underflow");
//         return;
//     }
//     for(int i=f;i<=r;i++){
//         printf("%d\n",queue[i]);
//     }
// }

// int main(){
//     int choice;
//     int a=1;
//     while(a!=0){
//         int item,y;
//         printf("enter 1 for enqueue front,\n 2 for enqueue rear,\n3 for diaplay,\n4 for dequeue front,\n5 dequeue rear,\n6 for exit: ");
//         scanf("%d",&choice);
//         switch (choice)
//         {
//             case 1:
//                 printf("enter element to insert: ");
//                 scanf("%d",&item);
//                 enqueue_front(item);
//                 break;
//             case 2:
//                 enqueue_rear();
//                 break;
//             case 3:
//                 display_queue();
//                 break;
//             case 4:
//                 dequeue_front();
//                 break;
//             case 5:
//                 y = dequeue_rear();
//                 printf("%d",y);
//                 break;
//             case 6:
//                 a=0;
//                 break;
//             default:
//                 printf("\nenter number between 1 to 4 only");
//                 break;
//         }
//     }
// }

#include <stdio.h>

#define MAX 5

int deque[MAX];
int front = -1, rear = -1;

// ENQUEUE FRONT
void enqueueFront(int x) {
    if ((front == 0 && rear == MAX - 1) || (front == rear + 1)) {
        printf("Deque Overflow\n");
        return;
    }

    if (front == -1) { // first element
        front = rear = 0;
    }
    else if (front == 0) {
        front = MAX - 1;
    }
    else {
        front--;
    }

    deque[front] = x;
    printf("Inserted at front\n");
}

// ENQUEUE REAR
void enqueueRear(int x) {
    if ((front == 0 && rear == MAX - 1) || (front == rear + 1)) {
        printf("Deque Overflow\n");
        return;
    }

    if (front == -1) {
        front = rear = 0;
    }
    else if (rear == MAX - 1) {
        rear = 0;
    }
    else {
        rear++;
    }

    deque[rear] = x;
    printf("Inserted at rear\n");
}

// DEQUEUE FRONT
void dequeueFront() {
    if (front == -1) {
        printf("Deque Underflow\n");
        return;
    }

    printf("Deleted from front: %d\n", deque[front]);

    if (front == rear) { // only one element
        front = rear = -1;
    }
    else if (front == MAX - 1) {
        front = 0;
    }
    else {
        front++;
    }
}

// DEQUEUE REAR
void dequeueRear() {
    if (front == -1) {
        printf("Deque Underflow\n");
        return;
    }

    printf("Deleted from rear: %d\n", deque[rear]);

    if (front == rear) {
        front = rear = -1;
    }
    else if (rear == 0) {
        rear = MAX - 1;
    }
    else {
        rear--;
    }
}

// DISPLAY
void display() {
    if (front == -1) {
        printf("Deque is empty\n");
        return;
    }

    printf("Deque elements: ");
    int i = front;

    while (1) {
        printf("%d ", deque[i]);
        if (i == rear)
            break;
        i = (i + 1) % MAX;
    }
    printf("\n");
}

// MAIN MENU
int main() {
    int choice, value;

    while (1) {
        printf("\n--- DEQUE MENU ---\n");
        printf("1. Enqueue Front\n");
        printf("2. Enqueue Rear\n");
        printf("3. Dequeue Front\n");
        printf("4. Dequeue Rear\n");
        printf("5. Display\n");
        printf("6. Exit\n");

        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value: ");
                scanf("%d", &value);
                enqueueFront(value);
                break;

            case 2:
                printf("Enter value: ");
                scanf("%d", &value);
                enqueueRear(value);
                break;

            case 3:
                dequeueFront();
                break;

            case 4:
                dequeueRear();
                break;

            case 5:
                display();
                break;

            case 6:
                return 0;

            default:
                printf("Invalid choice\n");
        }
    }
}
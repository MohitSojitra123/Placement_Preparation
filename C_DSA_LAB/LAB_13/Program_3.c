#include <stdio.h>
#define MAX 100

// Structure for Priority Queue Element
struct PriorityQueue {
    int data;
    int priority;
};

struct PriorityQueue pq[MAX];
int size = 0;

// Enqueue function (Insert based on priority)
void enqueue(int data, int priority) {
    if (size == MAX) {
        printf("Queue is Full\n");
        return;
    }

    int i = size - 1;

    // Shift elements with lower priority
    // (Higher number means lower priority)
    while (i >= 0 && pq[i].priority > priority) {
        pq[i + 1] = pq[i];
        i--;
    }

    pq[i + 1].data = data;
    pq[i + 1].priority = priority;
    size++;

    printf("Inserted: %d (Priority: %d)\n", data, priority);
}

// Dequeue function (Remove highest priority element)
void dequeue() {
    if (size == 0) {
        printf("Queue is Empty\n");
        return;
    }

    printf("Dequeued Element: %d (Priority: %d)\n",
           pq[0].data, pq[0].priority);

    // Shift all elements left
    for (int i = 1; i < size; i++) {
        pq[i - 1] = pq[i];
    }

    size--;
}

// Display function
void display() {
    if (size == 0) {
        printf("Queue is Empty\n");
        return;
    }

    printf("\nPriority Queue:\n");
    for (int i = 0; i < size; i++) {
        printf("Data: %d  Priority: %d\n", pq[i].data, pq[i].priority);
    }
}

int main() {
    enqueue(101, 34);
    enqueue(102, 33);
    enqueue(103, 40);

    display();

    dequeue();
    display();

    return 0;
}

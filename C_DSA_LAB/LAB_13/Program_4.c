#include <stdio.h>
#define MAX 100

// Structure for Priority Queue
struct PriorityQueue {
    int data;
    int priority;
};

struct PriorityQueue pq[MAX];
int size = 0;

// Enqueue (Insert in sorted order - smaller number = higher priority)
void enqueue(int data, int priority) {
    if (size == MAX) {
        printf("Queue is Full\n");
        return;
    }

    int i = size - 1;

    // Shift elements with lower priority
    while (i >= 0 && pq[i].priority > priority) {
        pq[i + 1] = pq[i];
        i--;
    }

    pq[i + 1].data = data;
    pq[i + 1].priority = priority;
    size++;

    printf("Inserted: %d (Priority: %d)\n", data, priority);
}

// Dequeue Lowest Priority (Remove last element)
void dequeueLowest() {
    if (size == 0) {
        printf("Queue is Empty\n");
        return;
    }

    printf("Dequeued Lowest Priority Element: %d (Priority: %d)\n",
           pq[size - 1].data, pq[size - 1].priority);

    size--;   // Just reduce size (no shifting needed)
}

// Display
void display() {
    if (size == 0) {
        printf("Queue is Empty\n");
        return;
    }

    printf("\nPriority Queue:\n");
    for (int i = 0; i < size; i++) {
        printf("Data: %d  Priority: %d\n", pq[i].data, pq[i].priority);
    }
    printf("\n");
}

int main() {
    enqueue(101, 34);
    enqueue(102, 33);
    enqueue(103, 40);

    display();

    dequeueLowest();
    display();

    return 0;
}

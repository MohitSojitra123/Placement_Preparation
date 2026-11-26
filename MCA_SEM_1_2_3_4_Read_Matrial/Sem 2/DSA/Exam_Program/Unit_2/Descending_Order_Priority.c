#include <stdio.h>

#define MAX 5

struct item {
    int data;
    int priority;
};

struct item pq[MAX];
int size = -1;

// Insert function
void insert(int data, int priority) {
    if (size == MAX - 1) {
        printf("Queue is Full\n");
        return;
    }

    size++;
    pq[size].data = data;
    pq[size].priority = priority;
}

// Delete function (largest priority first)
void delete() {
    if (size == -1) {
        printf("Queue is Empty\n");
        return;
    }

    int max = 0;
    for (int i = 1; i <= size; i++) {
        if (pq[i].priority > pq[max].priority) {
            max = i;
        }
    }

    printf("Deleted: %d\n", pq[max].data);

    // Shift elements
    for (int i = max; i < size; i++) {
        pq[i] = pq[i + 1];
    }

    size--;
}

// Display
void display() {
    for (int i = 0; i <= size; i++) {
        printf("Data: %d Priority: %d\n", pq[i].data, pq[i].priority);
    }
}

int main() {
    insert(10, 2);
    insert(20, 5);
    insert(30, 3);

    display();
    delete();
    display();
}
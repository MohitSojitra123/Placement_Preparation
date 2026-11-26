#include <stdio.h>
#include <ctype.h>

#define MAX 50

int stack[MAX];
int top = -1;

// Push
void push(int x) {
    stack[++top] = x;
}

// Pop
int pop() {
    return stack[top--];
}

int main() {
    char exp[MAX];
    int i, op1, op2, result;

    printf("Enter PREFIX Expression: ");
    scanf("%s", exp);

    // Find length
    int len = 0;
    while (exp[len] != '\0') {
        len++;
    }

    // Scan from right to left
    for (i = len - 1; i >= 0; i--) {

        // If operand
        if (isdigit(exp[i])) {
            push(exp[i] - '0');
        }

        // If operator
        else {
            op1 = pop();   // First pop
            op2 = pop();   // Second pop

            switch (exp[i]) {
                case '+': result = op1 + op2; break;
                case '-': result = op1 - op2; break;
                case '*': result = op1 * op2; break;
                case '/': result = op1 / op2; break;
            }
            push(result);
        }
    }

    printf("Result = %d\n", pop());
    return 0;
}

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

    printf("Enter POSTFIX Expression: ");
    scanf("%s", exp);

    for (i = 0; exp[i] != '\0'; i++) {

        // If operand
        if (isdigit(exp[i])) {
            push(exp[i] - '0');
        }

        // If operator
        else {
            op2 = pop();   // First pop
            op1 = pop();   // Second pop

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

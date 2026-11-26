#include <stdio.h>
#include <ctype.h>
#include <string.h>

char stack[100];
int top = -1;

void push(char ch) {
    stack[++top] = ch;
}

char pop() {
    return stack[top--];
}

int priority(char ch) {
    if (ch == '+' || ch == '-') return 1;
    if (ch == '*' || ch == '/') return 2;
    if (ch == '^') return 3;
    return 0;
}

int main() {
    char infix[100], prefix[100], postfix[100];
    int i, j = 0;

    printf("Enter infix expression: ");
    scanf("%s", infix);

    /* STEP 1: Reverse infix */
    strrev(infix);

    /* STEP 2: Replace brackets */
    for (i = 0; infix[i] != '\0'; i++) {
        if (infix[i] == '(')
            infix[i] = ')';
        else if (infix[i] == ')')
            infix[i] = '(';
    }

    /* STEP 3: Infix to Postfix */
    i = 0;
    while (infix[i] != '\0') {
        char ch = infix[i];

        if (isalnum(ch)) {
            postfix[j++] = ch;
        }
        else if (ch == '(') {
            push(ch);
        }
        else if (ch == ')') {
            while (stack[top] != '(') {
                postfix[j++] = pop();
            }
            pop();
        }
        else {
            while (top != -1 && priority(stack[top]) > priority(ch)) {
                postfix[j++] = pop();
            }
            push(ch);
        }
        i++;
    }

    while (top != -1){
        postfix[j++] = pop();
    }

    postfix[j] = '\0';

    /* STEP 4: Reverse postfix to get prefix */
    strrev(postfix);
    strcpy(prefix, postfix);

    printf("Prefix expression: %s\n", prefix);
    return 0;
}


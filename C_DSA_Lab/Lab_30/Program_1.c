#include <stdio.h>
#include <string.h>

#define MAX 100

char stack[MAX];
int top = -1;


void push(char c) {
    if (top == MAX - 1) {
        printf("Stack Overflow\n");
        return;
    }
    stack[++top] = c;
}

char pop() {
    if (top == -1) {
        return '\0';
    }
    return stack[top--];
}


int CheckParanthisis(char open, char close) {
    if (open == '(' && close == ')') {
        return 1;
    }
    if (open == '{' && close == '}') {
        return 1;
    }
    if (open == '[' && close == ']'){
        return 1;
    } 
    return 0;
}

int isValid(char userstr[]) {
    for (int i = 0; i < strlen(userstr); i++) {
        

        if (userstr[i] == '(' || userstr[i] == '{' || userstr[i] == '[') {
            push(userstr[i]);
        }
        
       
        else if (userstr[i] == ')' || userstr[i] == '}' || userstr[i] == ']') {
            
            if (top == -1) return 0; 
            
            char popped = pop();
            
            if (!CheckParanthisis(popped, userstr[i])) {
                return 0;
            }
        }
    }

    if(top == -1){
         return 1;
    }
}


int main() {
    char userstr[MAX];
    
    printf("Enter Strgin  : ");
    scanf("%s", &userstr);

    if (isValid(userstr))
        printf("Valid Parentheses\n");
    else
        printf("Invalid Parentheses\n");

    return 0;
}
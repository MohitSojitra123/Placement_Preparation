#include<stdio.h>
#include<string.h>

char stack[100];
int top = -1;

void push(char x){
    stack[++top] = x;
}

char pop(){
    return stack[top--];
}

int G(char c){
    if(c == '+' || c == '-')
        return 1;
    if(c == '*' || c == '/')
        return 3;
    if(c == '^')
        return 6;
    if(c == '(')
        return 0;
    else    
        return 8;
}

int F(char c){
    if(c == '+' || c == '-')
        return 2;
    if(c == '*' || c == '/')
        return 4;
    if(c == '^')
        return 5;
    if(c == '(')
        return 9;
    if(c == ')')
        return 0;
    else    
        return 7;
}

int R(char c){
    if(c == '+' || c == '-' || c == '*' || c == '/' ||c == '^')
        return -1;
    else    
        return 1;
}

void revpol(char infix[]){
    push('(');
    char polish[strlen(infix)];
    int rank = 0;
    int j = 0;
    for(int i=0 ; i<strlen(infix); i++){
        char next = infix[i];
        if(top < 0){
            printf("Invalid.");
            return;
        }
        while(G(stack[top]) > F(next)){
            char temp = pop();
            polish[j++] = temp;
            rank = rank + R(temp);
            if(rank < 1){
                printf("Invalid");
                return;
            }
        }
        if(G(stack[top]) != F(next))
            push(next);
        else{
            char x = pop();
        }
    }
    // a + (b-c)  +a-bc
    polish[j] = '\0';
    if(top != -1 || rank != 1)
        printf("Invalid");
    else    
        printf("Postfix expression : %s", strrev(polish));

}

void main(){
    char infix[100], rev_infix[100];
    int j = 0;
    printf("Enter infix expression:");
    scanf("%s",infix); // a+b
    for(int i=strlen(infix)-1; i>=0; i--){
        if(infix[i] == '(')
            rev_infix[j++] = ')';
        else if(infix[i] == ')')
            rev_infix[j++] = '(';
        else
            rev_infix[j++] = infix[i];
    }
    rev_infix[j] = '\0';
    strcat(rev_infix,")"); // b+a)
    revpol(rev_infix);
}
#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<math.h>

int stack[100];
int top = -1;

void push(int x){
    stack[++top] = x;
}

int pop(){
    return stack[top--];
}

void main(){
    char postfix[50];
    printf("Enter postfix expression:");
    scanf("%s",postfix); //13+
    for(int i=0; i<strlen(postfix);i++){
        char temp = postfix[i];
        if(isdigit(temp)){ //'1'-'0' = 49-48 = 1
            push(temp-'0');
        }
        else{
            int op2 = pop();
            int op1 = pop();
            switch(temp){
                case '+':
                push(op1 + op2);
                break;

                case '-':
                push(op1 - op2);
                break;

                case '*':
                push(op1 * op2);
                break;

                case '/':
                push(op1 / op2);
                break;

                case '^':
                push(pow(op1,op2));
                break;

            }
        }
    }
    printf("Answer is : %d", pop());
}
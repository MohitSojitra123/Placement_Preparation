#include<stdio.h>
#include<string.h>
#include<math.h>
#include<ctype.h>

int stack[100];
int top = -1;

void push(int x){
    if(top >= 99){
        printf("Stack Overflow.");
        return;
    }
    stack[++top] = x;
}

int pop(){
    return stack[top--];
}

void main(){
    char prefix[50];
    printf("Enter Prefix Expression:");
    scanf("%s",prefix);
    for(int i=strlen(prefix)-1 ; i>=0 ; i--){
        char temp = prefix[i];
        if(isdigit(temp)){
            push(temp-'0');
        }
        else{
            int op1 = pop();
            int op2 = pop();
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
                case '^':
                push(pow(op1,op2));
                break;

            }
        }
    }
    printf("Answer is : %d", pop());
}
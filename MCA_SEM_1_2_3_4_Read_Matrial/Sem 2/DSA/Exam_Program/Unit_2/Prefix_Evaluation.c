// Input: *+235
// Output: 25

#include<stdio.h>
#include<ctype.h>
#include<string.h>

int Stack[100];
int Top = -1;

// Push
void Push(int element){
    Stack[++Top] = element;
}

// Pop
int Pop(){
    return Stack[Top--];
}

int main(){
    char Prefix[100];
    int op1, op2, result = 0;

    printf("Enter Prefix : ");
    scanf("%s", Prefix);

    int length = strlen(Prefix);

    for(int i = length - 1; i >= 0; i--){
        char Temp = Prefix[i];

        if(isdigit(Temp)){
            Push(Temp - '0');
        }else{
            op1 = Pop();
            op2 = Pop();

            switch(Temp){
                case '+': result = op1 + op2; break;
                case '-': result = op1 - op2; break;
                case '*': result = op1 * op2; break;
                case '/': result = op1 / op2; break;
            }
            Push(result);
        }
    }

    printf("Result : %d", Pop());
    return 0;
}
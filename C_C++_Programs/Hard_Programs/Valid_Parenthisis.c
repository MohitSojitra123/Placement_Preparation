#include<stdio.h>
#define max 10

// Given a string s representing an expression containing various types of brackets: {},
// (), and [], the task is to determine whether the brackets in the expression are
// balanced or not. A balanced expression is one where every opening bracket has a
// corresponding closing bracket in the correct order.
// Input: s = “[{()}]”
// Output: true
// Explanation: All the brackets are well-formed.
// Input: s = “([]”
// Output: false
// Explanation: The expression is not balanced as there is a missing ‘)’ at the end.

char stack[max];
int top=-1;

void push(char ch){
     stack[++top]=ch;
}

char pop(){
   return stack[top--];
}



int main(){

    char ch[100];
    int Isvalid=1;

    printf("Enter Paremthisis : ");
    scanf("%s",&ch);

    printf("\n");
    printf("%s",ch);
    printf("\n");

    for(int i=0; ch[i]!='\0'; i++){
        
          if(ch[i] == '{' || ch[i] == '(' || ch[i] == '[' || ch[i]== '<' ){
            push(ch[i]);
          }else{
            
            if(top==-1){
                Isvalid=0;
                break;
            }

            char Pop_Char=pop();

            if(ch[i]=='}' && Pop_Char=='{'){
                continue;
            }else if(ch[i]==')' && Pop_Char=='('){
                continue;
            }else if(ch[i]==']' && Pop_Char=='['){
                continue;
            }else if (ch[i]=='>' && Pop_Char=='<')
            {
                continue;
            }else{
                Isvalid=0;
                break;
            }
          }
    }

    if(Isvalid==1){
        printf("Valid : ");
    }else{
        printf("In Valid : ");
    }

}
// 1. Write a program to convert the given infix notation to prefix notation. 

// Online C compiler to run C program online
#include <stdio.h>
#include <string.h>

char arr[100];
int top = -1;

int f(char c){
    if(c == '+' || c == '-'){
        return 2;
    }
    if(c == '*' || c == '/'){
        return 4;
    }
    if( c == '^'){
        return 5;
    }
    if(c == '('){
        return 9;
    }
    if(c== ')'){
        return 0;
    }
    return  7;
}

int g(char c){
    if(c == '+' || c == '-'){
        return 1;
    }
    if(c == '*' || c == '/'){
        return 3;
    }
    if( c == '^'){
        return 6;
    }
    if(c == '('){
        return 0;  
    } 
    return  8;
}

int r(char c){
    if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^'){
        return -1;
    }
    return  1;
}

void push(char c){
    arr[++top]=c;
}

int pop(){
    return arr[top--];
}

void rever(char a[]){
    int i,j;
    char temp;
    for(i=0;j=strlen(a)-1,i<j;i++,j--){
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}

int main() {
    // Write C code here
    char c[100];
    char s[100];
    int w=0;
    printf("enter string infix: ");
    scanf("%s",c);
    for(int i=strlen(c)-1;i>=0;i--){
        if(c[i]=='('){
            s[w++]=')';
        }
        else if (c[i]==')')
        {
            s[w++]='(';
        }
        else{
            s[w++]=c[i];
        }
    }
    strcat(s,")");
    push('(');
    int rank=0;
    char polish[100]="";
    char next,temp;
    int i=0;
    while(s[i]!='\0'){
        next=s[i];
        if(top<0){
            printf("invalid");
            return 0;
        }
        while(g(arr[top])>f(next)){
            temp=pop();
            char tempStr[2] = {temp,'\0'};
            strcat(polish, tempStr);
            rank=rank+r(temp);
            if(rank<1){
                printf("invalid");
                return 0;
            }
        }
        if(g(arr[top])!=f(next)){
            push(next);
        }else{
            pop();
        }
        i++;
    }
    if(top!=-1 || rank != 1){
        printf("invalid");
    }else{
        w=0;
        // for(int i=strlen(polish)-1;i>=0;i--){
        //     s[w++]=polish[i];
        // }
        rever(polish);
        printf("polish %s",polish);
    }
    return 0;
}
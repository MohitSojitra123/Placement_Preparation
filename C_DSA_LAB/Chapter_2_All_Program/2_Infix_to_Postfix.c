#include<stdio.h>
#include<string.h>
#define N 10

char str[N];
int top = -1;

void push(char x){
    str[++top] = x;
}

char pop(){
    return str[top--];
}

void main(){
    char s1[] = "abcde";
    char ans[strlen(s1)];
    int j = 0;
    for(int i=0; i<strlen(s1); i++){
        push(s1[i]);
    }
    while(top != -1){
        ans[j++] = pop();
    }
    ans[j] = '\0';
    printf("\n%s",ans);
}
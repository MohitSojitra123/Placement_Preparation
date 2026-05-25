#include<stdio.h>

int main(){
    int ch[200];

    printf("Enter String : ");
    scanf("%s",&ch);

    int count=0;

    for(int i=0; ch[i]!='\0'; i++){
        count++;
    }

    printf("String Length : %d ",count);

}
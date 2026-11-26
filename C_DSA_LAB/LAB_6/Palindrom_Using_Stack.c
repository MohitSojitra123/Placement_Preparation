#include<stdio.h>
#define Size 100

char Stack[Size];
int Top=-1;


void Push(char x){
    if(Top>=Size-1){
        printf("Stack Is Overflow : ");
    }else{
        Stack[++Top]=x;
    }
}


char Pop(){
    return Stack[Top--];
}

int main(){

    char str[100];

    printf("Enter String : ");
    scanf("%s",str);

    for(int i=0; str[i]!='\0'; i++){
         Push(str[i]);
    }

    int isvalid=1;

    for(int i=0; str[i]!='\0'; i++){
        if(i<=Top){
            if(Pop() != str[i]){
                isvalid=0;
                break;
            }
        }
    }

    if(isvalid==1){
        printf("Valide String : ");
    }else{
        printf("Not Valide String : ");
    }

}
#include<stdio.h>
#include<ctype.h>

int main(){

    char str[100];

    printf("Enter String : a2d5g8 : ");
    scanf("%s",&str);

    // printf("%s",str);

    for(int i=0; str[i]!='\0'; i++){
        if(isdigit(str[i])){
            int num=str[i]-'0';
            for(int j=1; j<=num; j++){
                 printf("%c",str[i+1]);
            }
            i++;
        }
        else{
            printf("%c",str[i]);
        }
    }

}


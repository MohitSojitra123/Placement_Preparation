#include<stdio.h>

int main(){

        char str[100];

    printf("Enter Strgin Upper To  LowerCase : ");
    gets(str);

    for(int i=0; str[i]!='\0'; i++){
        if(str[i] >=65 && str[i]<=91){
              str[i]=str[i]+32;
        }
    }

    puts(str); 

}
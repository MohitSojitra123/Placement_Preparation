#include<stdio.h>

// Enter Any Number...2r3t4y
// rrtttyyyy

int main(){

    char str[100];

    printf("Enter Syntax : ");
    scanf("%s",&str);

    int loop_counter=0;

    for(int i=0; str[i]!='\0'; i++){
        if(str[i]>='1' && str[i]<='9'){
            loop_counter=str[i]-'0';

            for(int j=1; j<loop_counter; j++){
                printf("%c",str[i+1]);
            }
        }else if((str[i] >= 'a' && str[i]<='z') || (str[i]>='A' && str[i]<='Z')){
             printf("%c",str[i]); 
        }
    }

}
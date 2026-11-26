#include<stdio.h>
#include<string.h>

int main(){
     
     char ch[100];

    printf("Enter String : ");
    scanf("%s",&ch);

    printf("%s",ch);


    int last_index=strlen(ch)-1;
    int first_index=0;
    
    int IsPalindrom=1;

    while(first_index<=last_index){
        if(ch[first_index]==ch[last_index]){
             first_index++;
             last_index--;
        }
        else{
            IsPalindrom=0;
            break;
        }
    }

    if(IsPalindrom==1){
      printf("\n String Is Palindrom : \n");
    }else{
        printf("\n String Is Not Palindrom : \n ");
    }

}
#include<stdio.h>
#include<string.h>

int main(){

    char str[100];

    printf("Enter String : ");
    scanf("%s",&str);

    int half_str_length=(strlen(str)-1)/2;
    int start=0;

    printf("\n");
    printf("%s",str);
    printf("\n");

    while (start<=half_str_length)
    {
          char temp=str[start];
          str[start]=str[half_str_length];
          str[half_str_length]=temp;

          start++;
          half_str_length--;
    }

    printf("\n");
    printf("%s",str);
    printf("\n");
    
    






}
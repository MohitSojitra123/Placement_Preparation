#include<stdio.h>
#include<string.h>

int main(){

    char str1[]="mohit";
    char str2[]="patel";
    char str3[20];


    printf("Length : %d \n",strlen(str1));
   
    strcat(str3,str1);
    strcat(str3,str2);

    printf("Concate :  %s \n",str3);
 

}
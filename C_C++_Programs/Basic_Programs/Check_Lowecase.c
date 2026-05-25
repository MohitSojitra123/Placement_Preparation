#include<stdio.h>

// a -> z ==> 97-122
// A -> Z ==> 65-90

int main(){

     char a='A';
     int b=70;


     printf("ASCII Value Of a => %d \n",a);
    printf("Integer To Latter => %c \n",b);

     if(a>=97 && a<=122){
         printf("Latter Is Lower Case....");
     }else{
        printf("Latter Is Upper Case....");
     }

}
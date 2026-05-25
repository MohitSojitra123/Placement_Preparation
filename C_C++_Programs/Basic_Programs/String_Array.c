#include<stdio.h>
#include<string.h>

int main(){

     char name[]={'M','o','h','i','t'};

     for(int i=0; i<strlen(name); i++){
        printf("%c",name[i]);
     }

     printf("\n---------------------\n");
     
     char name2[]="Mohit";
     
     for(int j=0; j<strlen(name2); j++){
         printf("%c",name2[j]);
        }
        printf("\n---------------------\n");

}


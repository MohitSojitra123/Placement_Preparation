#include<stdio.h>
#include<string.h>

int main(){
    
      char name[]="Mohit Sojitra";

      for(int i=0; i<strlen(name); i++){
           printf("%c",name[i]);
      }

      printf("\n-------------------------\n");

      for(int i=0; i<strlen(name); i++){
          name[i]=name[i]+1;
      }

        for(int i=0; i<strlen(name); i++){
           printf("%c",name[i]);
      }

      printf("\n-------------------------\n");

}
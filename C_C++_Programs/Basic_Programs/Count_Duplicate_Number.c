#include<stdio.h>

int main(){

    char str[100];

    printf("Enter String : ");
    scanf("%s",&str);

    printf("%s \n",str);

    int array[100];
    int count=1;
   
      for(int i=0;  str[i]!='\0'; i++){
          if(array[i] == -1){
              continue;
          }else{
            
            count=1;

             for(int j=i+1; str[j]!='\0'; j++){
                if(str[i] == str[j]){
                     count++;
                     array[j]=-1;
                }
             }

             if(count>1){
                  printf("%c -> %d \n ",str[i] ,count);
             }
             
          }
      }


}
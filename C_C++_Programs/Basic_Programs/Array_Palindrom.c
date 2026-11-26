#include<stdio.h>


int main(){

    int array_size;

    printf("Enter Array Size : ");
    scanf("%d",&array_size);

    char array[array_size];

    for(int i=0; i<array_size; i++){
         printf("Enter Character : ");
         scanf(" %c",&array[i]);
    }

    printf("\n---------------\n");
      for(int i=0; i<array_size; i++){
         printf(" %c ",array[i]);
      }
    printf("\n---------------\n");

    int start=0;
    int end=array_size-1;
    int isPalindrom=1;

    while(start<=end){
         if(array[start]==array[end]){
               start++;
               end--;
         }
         else{
             isPalindrom=0;
            break;
         }
    }

    if(isPalindrom==1){
        printf("Array Is Palindrom :  \n");
    }else{
        printf("Array Is Not Palindrom : \n");
    }

}
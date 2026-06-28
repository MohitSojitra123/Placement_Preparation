#include<stdio.h>

//  1 0 1 0 1
//    0 1 0 1
//      1 0 1
//        0 1
//          1

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=n; i>=1; i--){
 
         for(int space=i; space<n; space++){
            printf(" ");
         }

          for(int j=i; j>=1; j--){
             if(j%2==0){
                printf("0");
             }else{
                printf("1");  
             }
          }
          printf("\n");
    }

}
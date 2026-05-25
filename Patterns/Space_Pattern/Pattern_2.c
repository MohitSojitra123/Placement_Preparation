#include<stdio.h>

// - - - - - - - - 9 
// - - - - - - - 8 8 
// - - - - - - 7 7 7 
// - - - - - 6 6 6 6 
// - - - - 5 5 5 5 5 
// - - - 4 4 4 4 4 4 
// - - 3 3 3 3 3 3 3 
// - 2 2 2 2 2 2 2 2 
// 1  1  1  1  1  1  1  1  1 

int main(){

    int n; 
    
    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=n; i>=1; i--){
          
        for(int space=1; space<i; space++){
              printf("-");
          }

          for(int j=i; j<=n; j++){
            printf("%d",i);
          }

         printf("\n");

    }

}
#include<stdio.h>

// E D C B A
// D C B A
// C B A
// B A
// A

int main(){

      int n;

      printf("Enter N : ");
      scanf("%d",&n);

      for(int i=n-1; i>=0; i--){
        for(int j=i; j>=0; j--){
            printf("%c",'A'+j);
        }
        printf("\n");
      }

}
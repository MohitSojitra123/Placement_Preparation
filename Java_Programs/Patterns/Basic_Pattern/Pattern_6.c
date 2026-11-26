#include<stdio.h>

// 1 2 3 4 5
// 2 3 4 5
// 3 4 5
// 4 5
// 5

int main(){

    int n;

    printf("Enter n : ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){
      for(int j=i; j<=n; j++){
        printf("%d",j);
      }
      printf("\n");
    }


}
#include<stdio.h>

// 5
// 5 4
// 5 4 3
// 5 4 3 2
// 5 4 3 2 1

int main(){
    
    int n;

    printf("Enter n : ");
    scanf("%d",&n);

    for(int i=n; i>=1; i--){
        for(int j=n; j>=i; j--){
            printf("%d ",j);
        }
        printf("\n");
    }

}
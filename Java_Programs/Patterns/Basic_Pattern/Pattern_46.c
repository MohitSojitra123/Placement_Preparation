#include<stdio.h>

// 1
// A B
// 1 2 3
// A B C D
// 1 2 3 4 5 

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){
        if(i%2!=0){
           for(int j=1; j<=i; j++){
            printf("%d",j);
           }
        }else{
            for(int j=0; j<i; j++){
                printf("%c",'A'+j);
            }
        }
        printf("\n");
    }


}
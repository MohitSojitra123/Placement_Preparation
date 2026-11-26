#include<stdio.h>

// D P D P D P D P
// D P D P D P
// D P D P
// D P

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=n; i>=1; i--){
        for(int j=1; j<=i; j++){
           if(i%2==0){
               if(j%2==0){
                printf("P");
               }else{
                printf("D");
               }
           }else{
            continue;
           }
        }
        if(i%2==0){
            printf("\n");
        }
    }

}
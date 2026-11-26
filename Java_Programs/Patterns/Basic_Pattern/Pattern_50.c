#include<stdio.h>

// 1
// 0 1
// 1 0 1
// 0 1 0 1 

int main(){
    
     int n;

     printf("Enter N : ");
     scanf("%d",&n);

     for(int i=1; i<=n; i++){
        for(int j=i; j>=1; j--){
            if(j%2!=0){
                printf("1");
            }else{
                printf("0");
            }
        }
        printf("\n");
     }

}
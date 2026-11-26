#include<stdio.h>

// 1 6 11 16 21 
// 2 7 12 17 22 
// 3 8 13 18 23 
// 4 9 14 19 24 
// 5 10 15 20 25 

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);
    
    int count=1;
    
    for(int i=1; i<=n; i++){
        count=i;
        for(int j=1; j<=n; j++){
            printf(" %d ",count);
            count+=5;
        }
        printf("\n");
    }

    // int count=5;

    // for(int i=1; i<=n; i++){
    //     printf("%d",i);
    //     int val=count;
    //     for(int j=1; j<n; j++){
    //         printf(" %d ",val=j+count);
    //     }
    //     printf("\n");
    //     count++;
    // }

    
}
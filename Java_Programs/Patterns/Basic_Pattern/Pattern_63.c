#include<stdio.h>

// 11   12  13
// 21  22  23
// 31  32  33
// 41  42  43
// 51  52  53

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    int count=10;

    for(int i=1; i<=n; i++){
        int val=count;
        for(int j=1; j<=n; j++){
            printf(" %d ",++val);
        }
        count+=11;
        printf("\n");
    }

}
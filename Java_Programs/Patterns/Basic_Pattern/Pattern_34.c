#include<stdio.h>
#include<math.h>

// 1
// 11 11
// 121 121 121
// 1331 1331 1331 1331

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){
        int val=(int)pow(11,i);
        for(int j=1; j<=i; j++){
            printf(" %d ",val);
        }
        printf("\n");
    }

}
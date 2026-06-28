#include<stdio.h>

// E D C B A
// E D C B
// E D C
// E D
// E

int main(){

    int n; 

    printf("Enter n : ");
    scanf("%d",&n);

    for(int i=0;  i<n; i++){
        for(int j=n; j>i; j--){
            printf("%c",'A'+j);
        }
        printf("\n");
    }

}
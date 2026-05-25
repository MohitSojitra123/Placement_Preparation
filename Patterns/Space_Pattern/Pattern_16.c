#include<stdio.h>

//              1 
//          1 2 1 
//       1 2 3 2 1 
//    1 2 3 4 3 2 1 
// 1 2 3 4 5 4 3 2 1 

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    for(int i=1; i<=n; i++){

        for(int space=n; space>i; space--){
             printf(" ");
        }

        int  count =1;

        for(int j=1; j<=((i*2)-1); j++){

            if(j>=i){
               printf("%d",count--);
            }else{
                printf("%d",count++);
            }
        }

        printf("\n");
    }

}
#include<stdio.h>

//       A
//     A B A
//   A B C B A 
// A B C D C B A


int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

 
    for(int i=1; i<=n; i++){

        for(int space=i; space<n; space++){
            printf("-");
        }

        for(int j1=1; j1<=i; j1++){
            int val=j1-1;
            printf("%c",'A'+val);
        }

        char ch=('A'+i)-1;

        for(int j2=1; j2<i; j2++){
            printf("%c",ch-j2);
        }

        printf("\n");
    }


}
#include<stdio.h>

// 1 2 3 4 5 6 7
// 1 2 3   5 6 7 
// 1 2         6 7 
// 1               7 

int main(){
  
    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    
    int val=(n*2)-1;

    for(int i=1; i<=val; i++){
        printf("%d",i);
    }

    printf("\n");

    int space_num=1;
    
    for(int i=n; i>1; i--){

        int current_num=1;

        for(int j1=1; j1<i; j1++){
           printf("%d",current_num);
           current_num++;
        }

        for(int space=1; space<=(space_num*2)-1; space++){
            printf("-");
            current_num++;
        }

        for(int j2=1; j2<i; j2++){
            printf("%d",current_num);
            current_num++;
        }

       space_num++;
       printf("\n");

    }


}
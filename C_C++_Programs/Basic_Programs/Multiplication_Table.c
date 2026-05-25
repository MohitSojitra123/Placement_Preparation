#include<stdio.h>

int main(){

      int arr[3][10];
      int table[]={2,4,6};

    printf("-------------------------\n");

      for(int i=0; i<3; i++){
        for(int j=0; j<10; j++){
            arr[i][j]=table[i]*(j+1);
        }
      }

      for(int i=0; i<3; i++){
        for(int j=0; j<10; j++){
            printf("%d * %d =  %d \n",table[i] , (j+1) , arr[i][j]);
        }
        printf("-------------------------\n");
      }

}
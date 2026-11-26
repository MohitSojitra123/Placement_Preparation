#include<stdio.h>

//  1 
//  2  6
//  3  7  10
//  4  8  11  13
//  5  9  12  14  15

int main(){

     int n;

     printf("Enter N : ");
     scanf("%d",&n);
     
     int count=0;
     int difference=n-1;

     for(int i=1; i<=n; i++){
          count=i;
          difference=n-1;
        for(int j=1; j<=i; j++){
            printf(" %d ",count);
            count=difference+count;
            difference--;
        }
        printf("\n");
     }

}
#include<stdio.h>

// Given a number n then print n terms of fibonacci series in reverse order.
// Input : n = 5
// Output : 3 2 1 1 0
// Input : n = 8
// Output : 13 8 5 3 2 1 1 0

int main(){

    int n;

    printf("Enter N : ");
    scanf("%d",&n);

    int array[n];

    int a=0;
    int b=1;
    int c=0;

    for(int i=0; i<n; i++){
      array[i]=a;
       c=a+b; 
        a=b;   
        b=c; 
    }

    for(int i=n-1; i>=0; i--){
        printf(" %d ",array[i]);
    }
    


}
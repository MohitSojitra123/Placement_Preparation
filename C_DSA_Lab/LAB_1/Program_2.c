// 2. Write a program to find factors of a given number. 

#include<stdio.h>

int main(){
    
     int n;

     printf("Enter Any Number To Find Factors : ");
     scanf("%d",&n);

     printf("Factors Is : ");

     for(int i=1; i<=n; i++){
        if(n%i==0){
             printf(" %d ",i);
        }
     }

}
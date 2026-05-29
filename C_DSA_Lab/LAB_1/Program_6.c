// Write a program to display prime numbers between two intervals. 

#include<stdio.h>
#include<stdbool.h>

bool Isprime(int num){
    for(int i=2; i<num; i++){
        if(num%i==0){
            return false;
        }
    }
    return true;
}

int main(){
    
    int start,end;

    printf("Enter Starting Point : ");
    scanf("%d",&start);

    printf("Enter Ending Point : ");
    scanf("%d",&end);

    printf("Prime Number : ");

    for(int i=start; i<=end; i++){
         if(Isprime(i)){
          printf(" %d ",i);
         }
    }

}
#include<stdio.h>
#include<stdbool.h>

bool check_prime(int num){
    
     for(int i=2; i<num/2; i++){
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

    for(int i=start; i<=end; i++){
        if(check_prime(i)){
           printf(" %d ",i);
        }
    }


}
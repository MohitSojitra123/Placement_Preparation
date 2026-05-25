#include<stdio.h>

int sum_of_Nth(int n){
    if(n==1){
        return 1;
    }else{
         return n+sum_of_Nth(n-1);  
    }
}


int main(){

    int n=5;

    printf("%d",sum_of_Nth(n));


}
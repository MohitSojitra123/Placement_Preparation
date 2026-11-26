// 3. Write a program to check whether a number is prime or not. 

#include<stdio.h>
#include<stdbool.h>

bool Isprime(int n){
    for(int i=2; i<n; i++){
        if(n%2==0){
            return false;
        }
    }

    return true;
}

int main(){

    int num;

    printf("Enter Any Number To Check Number Is Prime Or Not : ");
    scanf("%d",&num);

   if(Isprime(num)){
    printf("Number Is Prime : %d ",num);
   }else{
    printf("Number Is Not Prime : %d ",num);
   }

}
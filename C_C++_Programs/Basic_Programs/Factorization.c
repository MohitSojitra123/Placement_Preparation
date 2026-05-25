#include<stdio.h>

int main(){
    
    int num;

    printf("Enter Any Number : ");
    scanf("%d",&num);

    for(int i=2; i<=num; i++){
          while(num%i==0){
             printf("%d",i);
             num/=i;
             if(num>1){
                printf("*");
             }
          }
    }

}
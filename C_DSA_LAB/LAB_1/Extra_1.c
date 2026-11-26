#include<stdio.h>
#include<stdbool.h>

int main(){

      int num;

      printf("Enter N : ");
      scanf("%d",&num);

      bool flag=true;

      for(int i=2; i<num; i++){
        if((num/i)*i==num){
             flag=false;
             break;
        }
      }

      if(flag){
        printf("Number Is Prime %d",num);
      }else{
        printf("Number Is Not Prime : %d",num);
      }


}
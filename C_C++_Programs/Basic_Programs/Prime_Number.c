#include<stdio.h>

int main(){

    int user_num;

      printf("Enter Any Number To Check Number Is Print Or Not....");
      scanf("%d",&user_num);

      int isPrime=0;

      if(user_num == 1 || user_num == 0){
         isPrime=1;
      }else{
           for(int i=2; i<user_num; i++){
              if(user_num%i==0){
                  isPrime=1;
              }
           }
      }

      if(isPrime==0){
         printf("Number  Is Prime : %d",user_num);
        }else{
          printf("Number Is Not Prime : %d",user_num);
      }


}
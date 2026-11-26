#include<stdio.h>

int main(){

      int user_num,factorial=1;

      printf("Enter Any Number To Calculate Factorial : ");
      scanf("%d",&user_num);

      for(int i=1; i<=user_num; i++){
          factorial*=i;
      }

      printf("Factorial Number Of : %d ",(factorial));

}
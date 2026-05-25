#include<stdio.h>
#include<stdbool.h>

bool IsPrime(int num){
     for(int i=2; i<num/2; i++){
         if(num%i==0){
            return false;
         }
     }

     return true;
}

bool IsPalindrom(int num1){
      int num2=num1;
      int last_digit=0,reverse_num=0;

       while(num2!=0){
           last_digit=num2%10;
           num2/=10;
           reverse_num=(reverse_num*10)+last_digit;
       }

       if(num1==reverse_num){
        return true;
       }else{
          return false;
       }
}

int main(){
    
    //  Input 1 to 1000....

      int start,end;

      printf("Enter Starting Point : ");
      scanf("%d",&start);

      printf("Enter Ending Point : ");
      scanf("%d",&end);

      printf("\n--------------------\n");
      printf("Number Is Prime + Palindrom : ");
      printf("\n--------------------\n");

      for(int i=start; i<=end; i++){
          if(IsPrime(i)){
              if(IsPalindrom(i)){
                 printf("%d \n",i);
              }
          }
      }


}
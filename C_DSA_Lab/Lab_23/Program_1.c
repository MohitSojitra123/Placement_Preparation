#include<stdio.h>

int main(){

     int array_size;

      printf("Enter Array Size : ");
      scanf("%d",&array_size);

      int array[array_size];

      for(int i=0; i<array_size; i++){
        printf("Enter Array Element : ");
        scanf("%d",&array[i]);
      }

      for(int j=0; j<array_size; j++){
           printf(" %d \n",array[j]);
      }

      int search_Ele;

      printf("Enter Serach Element : ");
      scanf("\n %d",&search_Ele);

      int find=0;

      for(int i=0; i<array_size; i++){
          if(array[i]==search_Ele){
             printf("\n Index Number : %d \n",i);
             find=1;
            break;
          }
      }

      if(find==0){
        printf("\n Element Is Not Present : \n");
      }


}
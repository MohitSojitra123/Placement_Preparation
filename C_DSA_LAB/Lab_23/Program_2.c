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

       int left=0,right=array_size-1,find=0;

       while (left<=right)
       {
            int mid=(left+right)/2;

            if(array[mid]==search_Ele){
                  printf("\n Index Is : %d \n",mid);
                  find=1;
                  break;
            }else if(array[mid]>search_Ele){
                   right=mid-1;
            }else{
                left=mid+1;
            }
    }

    if(find==0){
        printf("Element Not Present : ");
    }
       

}
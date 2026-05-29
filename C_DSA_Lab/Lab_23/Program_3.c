#include<stdio.h>

int Binary_Search(int array[],int find_ele,int left,int right){

      int mid=(left+right)/2;

      while (left<=right)
      {  
         if(array[mid]==find_ele){
              return mid;
            }else if(array[mid]>find_ele){
                return Binary_Search(array,find_ele,left,mid-1);
            }else{
                return  Binary_Search(array,find_ele,mid+1,right);
            }
        }
    
    return -1;
}

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

      int index=Binary_Search(array,search_Ele,0,array_size-1);

      printf("\n-----------------\n");
      printf("%d",index);
      printf("\n-----------------\n");


}
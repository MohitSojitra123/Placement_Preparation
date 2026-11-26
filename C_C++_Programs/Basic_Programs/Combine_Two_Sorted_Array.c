#include<stdio.h>

int main(){

    int arr1[]={10,20,30,40,50};
    int arr2[]={5,15,25,35,45};

    int final_sorted_array[10];

    int arr1_index=0;
    int arr2_index=0;
    int i=0;

    for( i=0; i<10; i++){
           if(arr1_index>4 || arr2_index>4){
              break;
           }else{
               if(arr1[arr1_index]<arr2[arr2_index]){
                   final_sorted_array[i]=arr1[arr1_index];       
                   arr1_index++;
                }else{
                    final_sorted_array[i]=arr2[arr2_index];
                    arr2_index++;
                } 
           }
    }

    while(arr1_index<=4){
         final_sorted_array[i]=arr1[arr1_index];
         arr1_index++;
         i++;  
    }


    while(arr2_index<=4){
         final_sorted_array[i]=arr2[arr2_index];
         arr2_index++;
         i++;  
    }

    printf("\n");
    for(int i=0; i<10; i++){
        printf("%d  \n",final_sorted_array[i]);
    }
    printf("\n");



}
#include<stdio.h>
#include<stdbool.h>

// Find the length of the maximum number of consecutive numbers jumbled up in an
// array.
// Input: arr[] = {1, 94, 93, 1000, 5, 92, 78};
// Output : 3
// Explanation: The largest set of consecutive elements is 92, 93, 94.
// Input: arr[] = {1, 5, 92, 4, 78, 6, 7};
// Output: 4
// Explanation: The largest set of consecutive elements is 4, 5, 6, 7.

int main(){

    int array_size;
    bool isConsecutive=0;
    
    printf("Enter Size Of Array : ");
    scanf("%d",&array_size);

    int array[array_size];

    for(int i=0; i<array_size; i++){
        printf("Enter Array Element : ");
        scanf("%d",&array[i]);
    }


    for(int i=0; i<array_size-1; i++){
          for(int j=0; j<array_size-i-1; j++){
            if(array[j]>array[j+1]){
                  int temp=array[j];
                  array[j]=array[j+1];
                  array[j+1]=temp;
            }
          }
    }

    printf("\n\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n\n");

    int i,current,j;

    for( i=0; i<array_size-1; i++){
        current=array[i];
        j=i+1;

       while(current+1==array[j]){
          j++;
          current++;
       }

       if(array[i]!=current){
          isConsecutive=1;
          break; 
       }
    }

    if(isConsecutive){
        printf("%d -> %d ",array[i],array[j-1]);
    }

}
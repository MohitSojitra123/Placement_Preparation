// Read n numbers in an array then read two different numbers, replace 1st
// number with 2nd number in an array and print the final array.

#include<stdio.h>
#include<stdbool.h>

int main(){

     int array_size;

    printf("Enter Array Size : ");
    scanf("%d",&array_size);

    int array[array_size];

    for(int i=0; i<array_size; i++){
         printf("Enter Array Element : %d ",(i+1));
         scanf("%d",&array[i]);
    }

    printf("\n---------------\n");
    for(int i=0; i<array_size; i++){
        printf(" %d ",array[i]);
    }
    printf("\n---------------\n");

    int search_ele,replace_ele;

    printf("Enter Search Element : ");
    scanf("%d",&search_ele);

    printf("Enter Replace Element : ");
    scanf("%d",&replace_ele);

    bool flag=false;

    for(int i=0; i<array_size; i++){
        if(array[i]==search_ele){
            array[i]=replace_ele;
            flag=true;
        }
    }

    if(!flag){
        printf("Element Is Not Present : %d ",search_ele);
    }

}
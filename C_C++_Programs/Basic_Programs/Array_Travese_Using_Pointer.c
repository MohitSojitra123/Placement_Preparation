#include<stdio.h>

int main(){

    int arr[]={10,20,30,40,50,60,70,80,90,100};

    int *arr_ptr=arr;
    
    // int *arr_ptr=&arr;   Not Used Is & sign Because arr pass By Default reference...

    for(int i=0; i<10; i++){
        printf(" %d ", *(arr_ptr+i));
    }
}
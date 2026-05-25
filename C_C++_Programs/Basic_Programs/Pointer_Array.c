#include<stdio.h>

int main(){

    int array[]={10,20,30,40,50};

    int *ptr=&array[0];

    for(int i=0; i<5; i++){
        printf("%d =>  %d  \n ",*ptr,ptr);
        ptr++;
    }

}
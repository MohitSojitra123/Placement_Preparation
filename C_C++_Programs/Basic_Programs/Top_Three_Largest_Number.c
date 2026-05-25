#include<stdio.h>


int main(){

    int array[]={10,20,30,40,50,60,70,80,90,100};

    int big1=1,big2=1,big3=1;

    for(int i=0; i<10; i++){
       if(array[i]>big1){
        big1=array[i];
       }
    }

    for(int i=0; i<10; i++){
        if(array[i]>big2 && array[i] != big1){
             big2=array[i];
        }
    }

    for(int i=0; i<10; i++){
        if(array[i]>big3 && array[i] != big1 && array[i] != big2){
            big3=array[i];
        }
    }

    printf("Big 1 => %d \n ",big1);
    printf("Big 2 => %d \n ",big2);
    printf("Big 3 => %d \n ",big3);
}
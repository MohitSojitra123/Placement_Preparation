#include<stdio.h>


int main(){

    int arr1[]={10,20,30,40,50};
    int arr2[]={60,70,80};

    int marge_arr[8];
    int Temp=0;

    for(int i=0; i<8; i++){
        if(i<5){
            marge_arr[i]=arr1[i];
        }else{
            marge_arr[i]=arr2[Temp];
            Temp++;
        }
    }

    for(int i=0;  i<8; i++){
          printf("%d ",marge_arr[i]);
    }

}
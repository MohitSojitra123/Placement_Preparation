#include<stdio.h>

int main(){

    int sum=0;
    int temp;

    for(;;){
        printf("Enter  Element  (-1 -> exit) : ");
        scanf("%d",&temp);

        if(temp==-1){
            break;
        }else{
            sum+=temp;
        }
    }

    printf("Sum Of  All Number : %d ",sum);

}
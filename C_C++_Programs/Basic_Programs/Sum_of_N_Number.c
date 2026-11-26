#include<stdio.h>

int main(){
    
    int sum=0,User_Input;

    printf("Enter Any Number To Sum N Number : ");
    scanf("%d",&User_Input);

    for(int i=1; i<=User_Input; i++){
        sum+=i;
    }

    printf("Sum %d ",sum);


}
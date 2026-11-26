#include<stdio.h>

int main(){

    int year;
    
    printf("Enter Any Year To Check Year Is Leap Or Not....");
    scanf("%d",&year);

    if(year%400 == 0 || (year%100 !=0  && year%4 == 0)){
        printf("Year Is Leap....");
    }else{
        printf("Year Is Not Leap....");
    }

}
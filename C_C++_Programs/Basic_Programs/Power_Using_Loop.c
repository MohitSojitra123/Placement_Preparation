#include<stdio.h>

int main(){
    
     int x=4;
     int y=3;

     int power=1;

     for(int i=1; i<=y; i++){
          power*=x;
     }

     printf("Power Is : %d ",power);

}
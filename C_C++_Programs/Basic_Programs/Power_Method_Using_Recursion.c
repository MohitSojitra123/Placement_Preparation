#include<stdio.h>

int power(int x,int y){
    if(y==0){
        return 1;
    }else{
        return x*power(x,y-1);
    }
}

int main(){

     int x=10;
     int y=3;

     printf("Power : %d ",power(x,y));

}
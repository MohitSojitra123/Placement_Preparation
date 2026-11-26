#include<stdio.h>


void print_number(int n,int start){

      if(start>n){
        return;
      }

      printf("%d",start);
      print_number(n,start=start+1);
}


int main(){

    int n=10;

    print_number(n,1);

}
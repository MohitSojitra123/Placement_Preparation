#include<iostream>
using namespace std;

int main(){

     
     int array[5]={1,2,3,5};
   
  
     int total_num=5*(5+1)/2;

     int sum=0;
     for(int i=0; i<5; i++){
        sum+=array[i];
     }

     cout<<"Missing Element Is..."<<total_num-sum;
     
}
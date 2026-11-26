#include<iostream>
using namespace std;

int main(){

   int user,fact=1; 
   cout<<"Enter Any Number...";
   cin>>user;


   for(int i=1; i<=user; i++){
      fact=fact*i;
   }

   cout<<fact;

}
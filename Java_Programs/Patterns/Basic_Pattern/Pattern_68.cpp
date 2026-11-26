// 1 0 1 0 1
// 1 0 1 0
// 1 0 1
// 1 0
// 1

#include<iostream>
using namespace std;

int main(){

     int user;
     cout<<"Enter Any Number To Print The Pattern..."<<endl;
     cin>>user;

    for(int i=user; i>=1; i--){
        for(int j=1; j<=i; j++){
            if(j%2==0){
               cout<<"0 ";
            }else{
               cout<<"1 ";
            }
        }
        cout<<endl;
    }

}

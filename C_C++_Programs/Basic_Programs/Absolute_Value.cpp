#include<iostream>
using namespace std;

int main(){
    int user;

    cout<<"Enter Any Value...";
    cin>>user;

    if(user>0){
        user=user*(-1);
        cout<<user;
    }else if(user<0){
        user=user*(-1);
        cout<<user;
    }else{
        cout<<user;
    }   
}
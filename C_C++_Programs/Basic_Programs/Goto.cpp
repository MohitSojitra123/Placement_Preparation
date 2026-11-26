#include<iostream>
using namespace std;

int main(){

    int user;
    cout<<"Enter Your Age...";
    cin>>user;

    if(user>=18){
        goto vote;
    }else{
        goto notvote;
    }

    vote:
        cout<<"You Are Eligible...";
        return 0;

    notvote:
        cout<<"Not Eligible...";
        return 0;

}
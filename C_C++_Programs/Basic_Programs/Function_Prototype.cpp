#include<iostream>
using namespace std;

// Function Prototype...
int add(int a,int b);

int main(){
int x,y;
cout<<"Enter Any Number...."<<endl;
cin>>x;
cout<<"Enter Any Number...."<<endl;
cin>>y;

cout<<"Sum Is..."<<add(x,y);
}


int add(int a,int b){
    int c=a+b;
    return c;
}
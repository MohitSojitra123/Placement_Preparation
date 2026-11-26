#include<iostream>
using namespace std;

int main(){

  int a=10;
  int b=20;

  int *pa=&a; 
  int *pb=&b; 

  cout<<"a ==> "<<a<<endl;
  cout<<"b ==> "<<b<<endl;

//   Print Address
  cout<<"Pa ==>"<<&pa<<endl;
  cout<<"Pb ==>"<<&pb<<endl;

//   Print Value
 cout<<"Pa ==>"<<*pa<<endl;
cout<<"Pb ==>"<<*pb<<endl;

}

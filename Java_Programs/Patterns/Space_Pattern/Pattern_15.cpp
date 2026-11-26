//                  A 
//              A B 
//          A B C 
//      A B C D 
//  A B C D E 

#include<iostream>
using namespace std;

void print_patt(int n){
  for(int i=1; i<=n; i++){

    for(int space=1; space<=n-i; space++){
        cout<<"  ";
    }

    for(char j='A'; j<'A'+i; j++){
        cout<<j<<" ";
    }
    cout<<endl;
}
}

int main(){

int user;
cout<<"Enter The Number...";
cin>>user;  

print_patt(user);


}
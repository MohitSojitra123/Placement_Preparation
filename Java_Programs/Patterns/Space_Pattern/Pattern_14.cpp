//                     1 
//                 1 2 
//             1 2 3 
//         1 2 3 4 
//     1 2 3 4 5 
// 1 2 3 4 5 6

#include<iostream>
using namespace std;

void print_patt(int n){
    
    for(int i=1; i<=n; i++){
        for(int space=1; space<=n-i; space++){
            cout<<"  ";
        }
        for(int j=1; j<=i; j++){
            cout<<j<<" ";
        }
        cout<<endl;
    }

}

int main(){
    int user;
    cout<<"Enter Pattern Size..."<<endl;
    cin>>user;

    print_patt(user);
}
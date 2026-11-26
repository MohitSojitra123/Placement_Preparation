#include<iostream>
using namespace std;

int main(){
    int start,end;
    cout<<"Enter Starting Year..."<<endl;
    cin>>start;
    cout<<"Enter Ending Year..."<<endl;
    cin>>end;

    for(int i=start; i<=end; i++){

        if((i%4==0 && (i%100!=0)) || i%400==0){
             cout<<i<<endl;
        }else{
             continue;
        }
    
    }

}

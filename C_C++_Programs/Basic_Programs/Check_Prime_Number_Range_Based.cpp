#include<iostream>
using namespace std;

bool check_prime(int n){
    
      int count=0;
     
      if(n<=1){
           return false;
      }

     for(int i=1; i<=n; i++){
           if(n%i == 0){
            count++;
           }
     }
    return count == 2;
}

int main(){
    


    int start,end;

    cout<<"Enter Starting Postion..."<<endl;
    cin>>start;

    cout<<"Enter Ending Postion...."<<endl;
    cin>>end;

      for(int num=start; num<=end; num++){
          if(check_prime(num)){
              cout<<"Number Is Prime..."<<num<<endl;
          }
      }

      

}
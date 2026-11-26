//                 A
//             A B C
//         A B C D C
//     A B C D E D C
//  A B C D E F E D C


#include<iostream>
using namespace std;

int main(){

  for(int i=0; i<5; i++){

   for(int space=5; space>i; space--){
    cout<<" ";
   } 

   int breakpoint=((2*i)+1)/2;
   char alpha='A';

    for(int j=0; j<(2*i)+1; j++){
       
       cout<<alpha;
       if(j<=breakpoint){
          alpha++;
       }else{
          alpha--;
       }
    }

    cout<<endl;
  }

}
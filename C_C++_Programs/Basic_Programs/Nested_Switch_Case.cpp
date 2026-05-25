#include<iostream>
using namespace std;

int main(){

  int user,user1,user2;
  cout<<"Choose Any Option..."<<endl;
  cout<<"1 For Rajkot To Gondal"<<endl;
  cout<<"2 For Ahemdabad To Rajkot"<<endl;
  cout<<"3 For Rajkot To Surat"<<endl;
  cin>>user;

 
   switch(user){

    case 1:
     cout<<"You Can Choose In Rajkot To Gondal...."<<endl;
     cout<<"Choose Any Option..."<<endl;
     cout<<"1 For Bus...."<<endl;
     cout<<"2 For Car...."<<endl;
     cin>>user1;

     switch (user1)
     {
     case 1:
          cout<<"You Can Select In Bus..."<<endl;
           cout<<"1 For Book Tikit"<<endl;
           cout<<"2 For Cancel Tikit"<<endl;
           cin>>user2;

           switch (user2)
           {
           case 1:
           cout<<"Your Tikit Is Book...";
            break;
           case 2:
           cout<<"Your Tikit Is Cancel Successfulll....";
            break;
           default:
           cout<<"Choose Valid Option...";
            break;
           }

        break;
     case 2:
         cout<<"You Can Select In Car..."<<endl;
        cout<<"1 For Book Tikit"<<endl;
           cout<<"2 For Cancel Tikit"<<endl;
           cin>>user2;

           switch (user2)
           {
           case 1:
           cout<<"Your Tikit Is Book..."<<endl;
            break;
           case 2:
           cout<<"Your Tikit Is Cancel Successfulll...."<<endl;
            break;
           default:
           cout<<"Choose Valid Option..."<<endl;
            break;
           }
        break;
     default:
       cout<<"Choose Valid Option..";
        break;
     } 
     break;



 case 2:
     cout<<"You Can Choose In Ahembdabad To Rajkot...."<<endl;
     cout<<"Choose Any Option..."<<endl;
     cout<<"1 For Bus...."<<endl;
     cout<<"2 For Car...."<<endl;
     cin>>user1;

     switch (user1)
     {
     case 1:
          cout<<"You Can Select In Bus..."<<endl;
           cout<<"1 For Book Tikit"<<endl;
           cout<<"2 For Cancel Tikit"<<endl;
           cin>>user2;

           switch (user2)
           {
           case 1:
           cout<<"Your Tikit Is Book...";
            break;
           case 2:
           cout<<"Your Tikit Is Cancel Successfulll....";
            break;
           default:
           cout<<"Choose Valid Option...";
            break;
           }

        break;
     case 2:
         cout<<"You Can Select In Car..."<<endl;
        cout<<"1 For Book Tikit"<<endl;
           cout<<"2 For Cancel Tikit"<<endl;
           cin>>user2;

           switch (user2)
           {
           case 1:
           cout<<"Your Tikit Is Book..."<<endl;
            break;
           case 2:
           cout<<"Your Tikit Is Cancel Successfulll...."<<endl;
            break;
           default:
           cout<<"Choose Valid Option..."<<endl;
            break;
           }
        break;
     default:
       cout<<"Choose Valid Option..";
        break;
     } 
     break;


    case 3:
     cout<<"You Can Choose In Rajkot To Surat...."<<endl;
     cout<<"Choose Any Option..."<<endl;
     cout<<"1 For Bus...."<<endl;
     cout<<"2 For Car...."<<endl;
     cin>>user1;

     switch (user1)
     {
     case 1:
          cout<<"You Can Select In Bus..."<<endl;
           cout<<"1 For Book Tikit"<<endl;
           cout<<"2 For Cancel Tikit"<<endl;
           cin>>user2;

           switch (user2)
           {
           case 1:
           cout<<"Your Tikit Is Book...";
            break;
           case 2:
           cout<<"Your Tikit Is Cancel Successfulll....";
            break;
           default:
           cout<<"Choose Valid Option...";
            break;
           }

        break;
     case 2:
         cout<<"You Can Select In Car..."<<endl;
        cout<<"1 For Book Tikit"<<endl;
           cout<<"2 For Cancel Tikit"<<endl;
           cin>>user2;

           switch (user2)
           {
           case 1:
           cout<<"Your Tikit Is Book..."<<endl;
            break;
           case 2:
           cout<<"Your Tikit Is Cancel Successfulll...."<<endl;
            break;
           default:
           cout<<"Choose Valid Option..."<<endl;
            break;
           }
        break;
     default:
       cout<<"Choose Valid Option..";
        break;
     } 
     break;


   default:
    cout<<"Choose Valid Option...";


   }


}
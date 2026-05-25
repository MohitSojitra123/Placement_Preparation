#include<iostream>
using namespace std;

int main(){

   string name;

   cout<<"Enter Your Name...";
   cin>>name;
   
    for(int i=0; i<=name.length(); i++){

         switch (name[i])
         {
         case 'A':
             
              for(int row=1; row<=9; row++){
        for(int col=1; col<=9; col++){
              if((col==5 && row==2) || (col==4 && row==3) || (col==3 && row==4) || (col==2 && row==5) || (col==1 && row==6) || (col==6 && row==3) || (col==7 && row==4) || (col==8 && row==5) || (col==9 && row==6) || (col==9 && row==6) || (col==3 && row==5) || (col==4 && row==5) || (col==5 && row==5) || (col==6 && row==5) || (col==7 && row==5)){
                 cout<<"* ";
              }else{
                cout<<"  ";
              }
        }
        cout<<endl;
    }

            break;
         case 'B':
            
                for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row==2&&col>3&&col<7||row==8&&col>3&&col<7||row==5&&col>3&&col<7||row==3&&col==9||row==4&&col==9||row==6&&col==9||row==7&&col==9||row>=2&&row<=8&&col==3)
            {
                cout<<"* ";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
            break;
         case 'C':
             for(int row=1; row<=9; row++){
        for(int col=1; col<=9; col++){
              if((col==3 && (row>=2 && row<=7)) || (row==2 && (col>=3 && col<=7)) || (row==7 && (col>=3 && col<=7))){
                 cout<<"* ";
              }else{
                cout<<"  ";
              }
        }
        cout<<endl;
    }
            break;
         case 'D':
             for(int row=1; row<=9; row++){
        for(int col=1; col<=9; col++){
              if((col==3 && (row>=2 && row<=8)) || (row==2 && (col>=4 && col<=7)) || (col==8 && (row==4 || row==3 || row==5 || row==6 || row==7)) || ((col==7 || col==6 || col==5 || col==4) && row==8)){
                 cout<<"* ";
              }else{
                cout<<"  ";
              }
        }
        cout<<endl;
    }

            break;
         case 'E':
              for(int row=1; row<=9; row++){
        for(int col=1; col<=9; col++){
              if(((col>=3 && col<=7) && row==2) || ((row>=2 && row<=8) && col==2) || (row==5 && (col>=3 && col<=6)) || ((col>=3 && col<=7) && row==8)){
                 cout<<"* ";
              }else{
                cout<<"  ";
              }
        }
        cout<<endl;
    }
            break;
         case 'F':
            for(int row=1; row<=9; row++){
        for(int col=1; col<=9; col++){
              if(((col>=3 && col<=7) && row==2) || ((row>=2 && row<=8) && col==2) || (row==5 && (col>=3 && col<=5)) ){
                 cout<<"* ";
              }else{
                cout<<"  ";
              }
        }
        cout<<endl;
    }
            break;
         case 'G':
              for(int row=1; row<=9; row++){
        for(int col=1; col<=9; col++){
              if((row==2 && (col>=4 && col<=7)) || (col==3 && (row>=3 && row<=6)) || (row==7 && (col>=4 && col<=7)) || (col==7 && (row==5 || row==6)) || (row==5 && (col==5 || col==6))){
                 cout<<"* ";
              }else{
                cout<<"  ";
              }
        }
     
        cout<<endl;
     }
            break;
         case 'H':
            
            for(int row=1; row<=9; row++){
        for(int col=1; col<=9; col++){
              if((col==3 && (row>=2 && row<=8) || (row==5 && (col>=4 && col<=7)) || ((row>=2 && row<=8) && (col==8)))){
                 cout<<"* ";
              }else{
                cout<<"  ";
              }
        }
     
        cout<<endl;
    }
            break;
         case 'I':
                   for(int row=1; row<=9; row++){
        for(int col=1; col<=9; col++){
              if(((col>=3 && col<=7) && row==2) ||((col==5) && (row>=2 && row<=6)) || ((col>=3 && col<=7) && row==7) ){
                 cout<<"* ";
              }else{
                cout<<"  ";
              }
        }
     
        cout<<endl;
    }
            break;
         case 'J':
            
          for(int row=1; row<=9; row++){
        for(int col=1; col<=9; col++){
              if( ((col>=3 && col<=7) && row==2 ) || (col==5 && (row>=3 && row<=7)) || (col==4 && row==7) || (col==3 && row==7) || (col==2 && row==6) || (col==2 && row==5) ){
                 cout<<"* ";
              }else{
                cout<<"  ";
              }
        }
     
        cout<<endl;
    }
            break;
         case 'K':
                   for(int row=1; row<=9; row++){
        for(int col=1; col<=9; col++){
              if( (col==3 && (row>=2 && row<=7)) || (col==6 && row==2) || (col==5 && row==3) || (col==4 && row==4)  || (col==4 && row==5) || (col==5 && row==6) || (col==6 && row==7)){
                 cout<<"* ";
              }else{
                cout<<"  ";
              }
        }
     
        cout<<endl;
    }

            break;
         case 'L':
                 for(int row=1; row<=9; row++){
        for(int col=1; col<=9; col++){
              if( (col==3 && (row>=2 && row<=7)) || ((col>=3 && col<=7) && row==7) ){
                 cout<<"* ";
              }else{
                cout<<"  ";
              }
        }
     
        cout<<endl;
    }
            break;
         case 'M':
            
           for(int row=1; row<=9; row++){
        for(int col=1; col<=9; col++){
              if( ((row>=2 && row<=7) && col==3) || (col==9 && (row>=2 && row<=7)) || (col==4 && row==2) || (col==5 && row==3) || (col==6 && row==4) || (col==7 && row==3) || (col==8 && row==2)){
                 cout<<"* ";
              }else{
                cout<<"  ";
              }
        }
     
        cout<<endl;
    }
            break;
         case 'N':
            
          for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row>=3&&row<=7&&col==3||row>=3&&row<=7&&col==8)
            {
                cout<<"* ";
            }
          else if (row==4&&col==4||row==5&&col==5||row==6&&col==6)
          {
            cout<<"*";
          }
          
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
            break;
         case 'O':
            
          for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row==2&&col>3&&col<7||row>=3&&row<=7&&col==3||row>=3&&row<=7&&col==8||row==8&&col>3&&col<7)
            {
                cout<<"* ";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
    
            break;
         case 'P':
                  for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row==2&&col>3&&col<7||row==5&&col>3&&col<7||row==3&&col==9||row==4&&col==9||row>=2&&row<=8&&col==3)
            {
                cout<<"* ";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
            break;
         case 'Q':
                for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row==2&&col>3&&col<7||row>=3&&row<7&&col==3||row>=3&&row<7&&col==8||row==7&&col>3&&col<7||row==8&&col==9)
            {
                cout<<"* ";
            }
            else if (row==6&&col==6||row==5&&col==5)
            {
                cout<<"*";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
            break;
         case 'R':
              for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row==2&&col>3&&col<7||row==5&&col>3&&col<7||row==3&&col==9||row==4&&col==9||row>=2&&row<=8&&col==3||row==6&&col==4||row==7&&col==6||row==8&&col==8)
            {
                cout<<"* ";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }

            break;
         case 'S':
            
        for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row==2&&col>3&&col<7||row==8&&col>3&&col<7||row==5&&col>3&&col<7||row==3&&col==3||row==4&&col==3||row==6&&col==9||row==7&&col==9)
            {
                cout<<"* ";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
            break;
         case 'T':
                for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row==2&&col>=3&&col<=7||row>=2&&col==7&&row<=7)
            {
                cout<<"* ";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
            break;
         case 'U':
            
      for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row==7&&col>3&&col<7||row < 7&&col==3&&row>1 ||row < 7&&col==8&&row>1)
            {
                cout<<"* ";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
            break;
         case 'V':
               for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row==7&&col==5||row==6&&col==4||row==6&&col==6||row==5&&col==3||row==5&&col==7||row==4&&col==2||row==4&&col==8)
            {
                cout<<"* ";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
            break;
         case 'W':
               for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row==3&&col==2||row==3&&col==6||row==3&&col==9||row==4&&col==3||row==4&&col==4||row==4&&col==5||row==4&&col==6||row==5&&col==4||row==5&&col==9)
            {
                cout<<" * ";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
            break;
         case 'X':
              for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row==2&&col==3|| row==2&&col==7||row==3&&col==4|| row==3&&col==6||row==4&&col==6||row==5&&col==4|| row==5&&col==6||row==6&&col==3|| row==6&&col==7)
            {
                cout<<" * ";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
            break;
         case 'Y':
               for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (row==2&&col==4||row==2&&col==8||row==3&&col==5||row==3&&col==7||row==4&&col==7||row==5&&col==7||row==6&&col==7||row==7&&col==7)
            {
                cout<<" * ";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
            break;
         case 'Z':
             for (int row = 1; row <=9; row++)
    {
        for (int col = 1; col <=9; col++)
        {
            if (col>=3&&col<=7&& row==2||col>=3&&col<=7&& row==8||row==3&&col==9||row==4&&col==8||row==5&&col==7||row==6&&col==6||row==7&&col==5)
            {
                cout<<"* ";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
            break;
         
         default:
            break;
         }


    }
   
      
}
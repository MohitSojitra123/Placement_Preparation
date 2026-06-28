#include<iostream>
using namespace std;

int main(){
    
    // A
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

      
     // B
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

    // C
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

    // D
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

    // E
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

   //F
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
    

   //   G

   
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


    //  H

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
   
  // I
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

    // J

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
   

//   K

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

   // L

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


   //  M

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
 
    // n
    
    
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
    

    // o
    


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
    

    
    // p

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

    // Q
    
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
    
    // R
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


    
    // s

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

    
        // t

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

    
    // u

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



    // v

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
    

    
    // w

    
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
    
    // x


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


    // y

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

    // z
    
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
 

}
   
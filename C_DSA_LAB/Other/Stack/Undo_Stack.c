// Implement Undo feature in a text editor using stack


// 1st Undo      M O H I       --> T
// 2nd Undo    M O H        --> I
// 3rd Undo     M O           --> H
// 4rd Undo     M              --> O


#include<stdio.h>
#define size 5

char Stack[5];
int Top=-1;

void Push(char ch){
    if(Top >= size-1){
        printf("Stack Is Overflow : ");
    }else{
        Stack[++Top]=ch;
    }
}

char Pop(){
    if(Top>-1){
          return Stack[Top--];
    }else{
        printf("Stack Is Underflow : ");
        return 0;
    }
}

void Display(){
    if(Top > -1){
        printf("\n--------------------\n");
        for(int i=0; i<=Top; i++){
            printf(" %c ",Stack[i]);
        }
        printf("\n--------------------\n");
    }else{
        printf("Stack Is Underflow : ");
    }
}

int main(){

    Push('M');
    Push('O');
    Push('H');
    Push('I');
    Push('T');

    Display();

    Pop();
    
    Display();
    
    Pop();
    
    Display();
    
    Pop();
    
    Display();

}



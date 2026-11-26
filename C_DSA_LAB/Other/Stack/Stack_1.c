#include<stdio.h>
#define size 5

int Stack[size];
int Top=-1;

void Push(int element){
    if(Top >= size-1){
      printf("Stack Is Overflow : ");
    }else{
        Stack[++Top]=element;
    }
}

int Pop(){
    if(Top == -1){
        printf("Stack Is Underflow : ");
        return 0;
    }else{
        return Stack[Top--];
    }
}

int Peep(int index){
       if(index > 0 && index<=Top+1){
           return Stack[Top-index+1];
       }else{
         printf("Stack Element Is Not Prsent : ");  
        return 0;
       }
}

void Change(int index,int element){
    if(index > 0 && index<=Top+1){
        Stack[Top-index+1]=element;
    }else{
      printf("Index Element Is Not Present : ");
    }
}

void Display(){
      if(Top == -1){
        printf("Stack Is Underflow : ");
      }else{
        for(int i=0; i<=Top; i++){
            printf("%d \n",Stack[i]);
        }
      }
}

int main(){

}
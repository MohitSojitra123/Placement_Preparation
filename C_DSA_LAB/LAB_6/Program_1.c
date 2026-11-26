// 1. Write a menu driven program to perform following operations on Stack:
// PUSH, POP, PEEP, CHANGE and DISPLAY.

#include<stdio.h>
#define Size 100

int Stack[Size];
int Top = -1;

void Push(int x){
    if(Top >= Size - 1){
        printf("Stack Overflow\n");
    }else{
        Stack[++Top] = x;
    }
}

int Pop(){
    if(Top == -1){
        printf("Stack Is Empty\n");
        return -1;
    }else{
        return Stack[Top--];
    }
}

int Peep(int index){
    if(index <= 0 || index > Top + 1){
        printf("Element Not Present\n");
        return -1;
    }else{
        return Stack[Top - index + 1];
    }
}

void Change(int index,int new_value){
    if(index <= 0 || index > Top + 1){
        printf("Element Not Present\n");
    }else{
        Stack[Top - index + 1] = new_value;
    }
}

void Display(){
    if(Top == -1){
        printf("Stack Is Empty\n");
    }else{
        for(int i = Top; i >= 0; i--){
            printf("%d ", Stack[i]);
        }
        printf("\n");
    }
}

int main(){

    int user_input,user_index;

    do{
        printf("\n---------------------------\n");
       printf("1 For PUSH : \n");
       printf("2 For POP : \n");
       printf("3 For PEEP : \n");
       printf("4 For CHANGE : \n");
       printf("5 For DISPLAY : \n");
       printf("-1 For Exit : \n");
       printf("\n---------------------------\n");
       scanf("%d",&user_input);
       printf("\n---------------------------\n");
       
       switch (user_input)
       {
           case 1:
           printf("\n---------------------------\n");
           printf("Enter PUSH Element : ");
           scanf("%d",&user_input);
           Push(user_input);
           printf("\n---------------------------\n");
           break;
           case 2:
           printf("\n---------------------------\n");
           printf("POP Element : %d",Pop());
           printf("\n---------------------------\n");
           break;
           case 3:
           printf("\n---------------------------\n");
           printf("Enter Index Number To PEEP Element : ");
           scanf("%d",&user_index);
           printf("%d",Peep(user_index));
           printf("\n---------------------------\n");
           break;
           case 4:
           printf("\n---------------------------\n");
           printf("Enter Index Number To Change Element : ");
           scanf("%d",&user_index);
           printf("Enter New Element : ");
           scanf("%d",&user_input);
           Change(user_index,user_input);
           printf("\n---------------------------\n");
           break;
           case 5:
           printf("\n---------------------------\n");
           Display();
           printf("\n---------------------------\n");
           break;
           default:
           printf("\n---------------------------\n");
           printf("Choose Vallide Option : ");
           printf("\n---------------------------\n");
        break;
       }
      

    }while (user_index!=-1);
    

}

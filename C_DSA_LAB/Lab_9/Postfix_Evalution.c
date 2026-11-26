#include<stdio.h>
#include<ctype.h>

int Stack[100];
int Top=-1;

void Push(int element){
    Stack[++Top]=element;
}


int Pop(){
    return Stack[Top--];
}

int main(){
    char Postfix[100];
    
    printf("Enter Postfix : ");
    scanf("%s",Postfix);

    int i=0;
    int op1,op2,result=0;

    while(Postfix[i]!='\0')
    {
      
       char Temp=Postfix[i]; 

       if(isdigit(Temp)){
          Push(Temp-'0');
       }else{
          op2=Pop();
          op1=Pop();

          switch (Temp)
          {
          case '+':
             result = op1+op2;
            break;
          case '-':
             result = op1-op2;
            break; 
         case '*':
             result = op1*op2;
            break;    
         case '/':
             result = op1/op2;
            break;       
          }
          Push(result);
       }  
       i++;
    }

    printf("Result : %d",Pop());
}
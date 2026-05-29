#include<stdio.h>
#include<ctype.h>

int stack[100];
int Top=-1;

void Push(int element){
    stack[++Top]=element;
}

int Pop(){
    return stack[Top--];
}

int main(){

    char Polish[100];

    printf("Enter Postfix : ");
    scanf("%s",Polish);

    int i=0,j=0,result=0;

    while (Polish[i]!='\0')
    {
        if(isdigit(Polish[i])){
             j=i+1;
            int final_num=0;
            final_num=final_num*10+(Polish[i]-'0');
            while(isdigit(Polish[j]))
            {
                 final_num=final_num*10+(Polish[j]-'0');
                 j++;
            }
             i=j+1;
             Push(final_num);
        }else{
            
            int op2=Pop();
            int op1=Pop();
            
            switch(Polish[i]){
                case '+':
                result=op1+op2;
                break;
                case '-':
                result=op1-op2;
                break;
                case '*':
                result=op1*op2;
                break;
                case '/':
                result=op1/op2;
                break;
                case '^':
                result=op1^op2;
                break;
            }
            Push(result);   
            i++;
        }
    }
    
  printf("Anss :  %d",Pop());

}
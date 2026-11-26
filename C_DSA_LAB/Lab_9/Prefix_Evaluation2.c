#include<stdio.h>
#include<ctype.h>
#include<math.h>

int Stack[100];
int Top=-1;

void Push(int element){
   Stack[++Top]=element;
}

int Pop(){
    return Stack[Top--];
}

int main(){

    char Prefix[100];

    printf("Enter Prefix : ");
    scanf("%s",Prefix);

    int size=0,My_power=0;

    while (Prefix[size]!='\0')
    {
        size++;
    }

    int i=size-1,result=0,j=0;
 
    while (Prefix[i]!=0)
    {
  if(isdigit(Prefix[i])){
             j=i-1;
            int final_num=0;
            My_power=0;
            final_num=final_num+(Prefix[i]-'0')*pow(10,My_power++);
            while(isdigit(Prefix[j]))
            {
                 final_num=final_num+(Prefix[j]-'0')*pow(10,My_power++);
                 j--;
            }
             i=j-1;
             Push(final_num);
        }else{
            int op1=Pop();
            int op2=Pop();
            
            switch(Prefix[i]){
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
            i--;
        }
    }
    
    printf("%d",Pop());
}
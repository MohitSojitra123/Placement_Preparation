#include<stdio.h>
#include<string.h>

// Given a string that contains a special character together with alphabets (‘a’ to ‘z’ and
// ‘A’ to ‘Z’), reverse the string in a way that special characters are not affected.
// Input: a!!!b.c.d,e'f,ghi
// Output: i!!!h.g.f,e'd,cba
// Input: str = “Ab,c,de!$”
// Output: str = “ed,c,bA!$”


int main(){

    char str[100];

    printf("Enter String : ");
    scanf("%s",&str);

    printf("\n\n");
    printf("%s",str);
    printf("\n\n");

    int first_index=0;
    int last_index=strlen(str)-1;

    while(first_index<last_index){
        
        if( (str[first_index]>='a' && str[first_index]<='z')  || (str[first_index]>='A' && str[first_index] <='Z')  ){
            
            if((str[last_index]>='a' && str[last_index]<='z')  || (str[last_index]>='A' && str[last_index] <='Z')){
                char Temp=str[first_index];
                str[first_index]=str[last_index];
                str[last_index]=Temp;

                first_index++;
                last_index--;

            }else{
                last_index--;
            }

        }else{
            first_index++;
        }
    }

    printf("\n\n");
    printf("%s",str);
    printf("\n\n");


}
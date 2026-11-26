#include<stdio.h>
#include<string.h>
#include<stdbool.h>

// Find if a given string can be represented from a substring by iterating the substring
// “n” times.
// Input: str = "abcabcabc"
// Output: true
// Input: str = "aabaabaabaab"
// Output: true
// Input: str = "abcdabc"
// Output: false

bool Check_Substring(char str[]){

     int Length=strlen(str);
     bool match=1;


     for(int i=1; i<=Length/2; i++){
        
         if(Length%i!=0){
             continue;
         }

         match=1;

         for(int j=0; j<Length; j++){
            if(str[j]!=str[j%i]){
                match=0;
            }
         }

         if(match){
             return 1;
         }
     }
     return 0;
}


int main(){
    // char str1[] = "abcabcabc";
    // char str1[] = "aaaaaaaaa";
    // char str1[] = "aadaaaaaa";
    char str1[] = "abcadcabc";


    printf("%s",Check_Substring(str1)?"True":"False");

}
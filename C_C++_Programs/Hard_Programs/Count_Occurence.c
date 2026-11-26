#include<stdio.h>

// Given a string S and a character ‘c’, the task is to count the occurrence of the given
// character in the string.
// Input: S = “geeksforgeeks” and c = ‘e’
// Output: 4
// Explanation: ‘e’ appears four times in str.
// Input: S = “abccdefgaa” and c = ‘a’
// Output: 3
// Explanation: ‘a’ appears three times in str

int main(){
 
    char str[100],find_character;
    
    printf("Enter Any String....");
    gets(str);

    printf("Enter Find Character....");
    scanf("%c",&find_character);

    int count=0;

    for(int i=0; str[i]!='\0'; i++){
         if(str[i]==find_character){
              count++;
         }
    }

    printf("Character => %c Total Count =>  %d",find_character,count);

    
}
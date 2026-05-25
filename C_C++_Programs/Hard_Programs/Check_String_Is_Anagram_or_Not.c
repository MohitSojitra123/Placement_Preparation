#include<stdio.h>
#include<string.h>

// Given two strings s1 and s2 consisting of lowercase characters, the task is to check
// whether the two given strings are anagrams of each other or not. An anagram of a
// string is another string that contains the same characters, only the order of characters
// can be different.
// Input: s1 = “geeks” s2 = “kseeg”
// Output: true
// Explanation: Both the strings have the same characters with same frequency. So,
// they are anagrams.
// Input: s1 = “allergy” s2 = “allergic”
// Output: false
// Explanation: Characters in both the strings are not the same. s1 has extra characters
// ‘y’ and s2 has extra characters ‘i’ and ‘c’, so they are not anagrams.

int main(){

    char str1[100];
    char str2[100];

    printf("Enter String 1 : ");
    scanf("%s", str1);

    printf("Enter String 2 : ");
    scanf("%s", str2);

    printf("\nString 1 : %s", str1);
    printf("\nString 2 : %s", str2);

    int str1_length = strlen(str1);
    int str2_length = strlen(str2);

    // First check length
    if(str1_length != str2_length){

        printf("\nStrings Are Not Anagram");
        return 0;
    }


    for(int i=0; i<str1_length-1; i++){

        for(int j=0; j<str1_length-i-1; j++){

            if(str1[j] > str1[j+1]){

                char temp = str1[j];
                str1[j] = str1[j+1];
                str1[j+1] = temp;
            }
        }
    }


    for(int i=0; i<str2_length-1; i++){

        for(int j=0; j<str2_length-i-1; j++){

            if(str2[j] > str2[j+1]){

                char temp = str2[j];
                str2[j] = str2[j+1];
                str2[j+1] = temp;
            }
        }
    }

    printf("\n\nSorted String 1 : %s", str1);
    printf("\nSorted String 2 : %s", str2);

    if(strcmp(str1, str2) == 0){

        printf("\n\nStrings Are Anagram\n");

    }else{

        printf("\n\nStrings Are Not Anagram \n");
    }

    return 0;
}
// Write a program to check if the string is a palindrome or not using Pointer. 

#include <stdio.h>
#include <string.h>

int main() {

    char str[100];
    char *start, *end;
    int isPalindrome = 1;

    printf("Enter a string: ");
    fgets(str, sizeof(str), stdin);

    str[strcspn(str, "\n")] = '\0';

    start = str;
    end = str + strlen(str) - 1;

    while (start < end) {

        if (*start != *end) {
            isPalindrome = 0;
            break;
        }

        start++;
        end--;
    }

    if (isPalindrome)
        printf("The string is a Palindrome.\n");
    else
        printf("The string is NOT a Palindrome.\n");

    return 0;
}
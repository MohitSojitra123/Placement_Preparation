#include<stdio.h>

char* find_single_number(int a) {
    switch(a) {
        case 1:  return "One";
        case 2:  return "Two";
        case 3:  return "Three";
        case 4:  return "Four";
        case 5:  return "Five";
        case 6:  return "Six";
        case 7:  return "Seven";
        case 8:  return "Eight";
        case 9:  return "Nine";
        case 0:  return "Zero";
        default: return "";
    }
}

const char* find_two_number(int a) {
    switch(a) {
        case 10: return "Ten";
        case 11: return "Eleven";
        case 12: return "Twelve";
        case 13: return "Thirteen";
        case 14: return "Fourteen";
        case 15: return "Fifteen";
        case 16: return "Sixteen";
        case 17: return "Seventeen";
        case 18: return "Eighteen";
        case 19: return "Nineteen";
        case 20: return "Twenty";
        case 30: return "Thirty";
        case 40: return "Forty";
        case 50: return "Fifty";
        case 60: return "Sixty";
        case 70: return "Seventy";
        case 80: return "Eighty";
        case 90: return "Ninety";
        default: return "";
    }
}

int main(){

    int num;

    printf("Enter Any Number To (1 To 9999)");
    scanf("%d",&num);

        if(num == 0) {
        printf("Zero\n");
        return 0;
    }

    int thousands = (num / 1000) % 10;
    int hundreds  = (num / 100) % 10;
    int tens      = (num / 10) % 10;
    int ones      = num % 10;

        if(thousands > 0) {
        printf("%s Thousand ", find_single_number(thousands));
    }
    if(hundreds > 0) {
        printf("%s Hundred ", find_single_number(hundreds));
    }


    // individual if-else combo
    // For tens and ones
    if(tens == 1) {
        // handle 10-19
        int last_two = tens * 10 + ones;
        printf("%s", find_two_number(last_two));
    } else {
        if(tens > 1) {
            printf("%s ", find_two_number(tens * 10));
        }
        if(ones > 0) {
            printf("%s", find_single_number(ones));
        }
    }
    // individual if-else combo

    printf("\n");
    return 0;


}
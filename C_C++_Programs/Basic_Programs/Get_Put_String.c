#include<stdio.h>

int main() {

    char ch[100];
    char ch_copy[100];
    int count = 0;

    printf("Enter String : ");
    fgets(ch, sizeof(ch), stdin);


    // Copy string & count
    for(int i = 0; ch[i] != '\0'; i++) {
        ch_copy[i] = ch[i];
        count++;
    }
    ch_copy[count] = '\0';

    printf("\nOriginal String = %s", ch);
    printf("Copied String   = %s", ch_copy);
    printf("String Length   = %d", count);

    return 0;
}

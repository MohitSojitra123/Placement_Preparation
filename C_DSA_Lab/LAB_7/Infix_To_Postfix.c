#include <stdio.h>
#include <ctype.h>

#define MAX 100

char S[MAX];     // Stack
int TOP = 0;

char POLISH[MAX];
int RANK = 0;

/* ---------- PUSH ---------- */
void PUSH(char ch) {
    S[++TOP] = ch;
}

/* ---------- POP ---------- */
char POP() {
    return S[TOP--];
}

/* ---------- IPF (F) ---------- */
int F(char ch) {
    switch (ch) {
        case '+':
        case '-': return 1;
        case '*':
        case '/': return 3;
        case '^': return 6;
        case '(': return 9;
        case ')': return 0;
        default:  return 7;   // Operand
    }
}

/* ---------- SPF (G) ---------- */
int G(char ch) {
    switch (ch) {
        case '+':
        case '-': return 2;
        case '*':
        case '/': return 4;
        case '^': return 5;
        case '(': return 0;
        default:  return 8;   // Operand
    }
}

/* ---------- RF (R) ---------- */
int R(char ch) {
    if (isalnum(ch))
        return 1;
    else
        return -1;
}

int main() {
    char INFIX[MAX];
    char NEXT, TEMP;
    int i = 0, j = 0;

    /* STEP 1: Initialize Stack */
    TOP = 1;
    S[TOP] = '(';

    /* STEP 2: Initialize Output & Rank */
    RANK = 0;

    printf("Enter Infix Expression: ");
    scanf("%s", INFIX);

    /* STEP 3: Get first symbol */
    NEXT = INFIX[i++];

    /* STEP 4: Translate expression */
    while (NEXT != '\0') {

        /* STEP 5: Remove higher precedence symbols */
        while (G(S[TOP]) > F(NEXT)) {
            if (TOP < 1) {
                printf("INVALID\n");
                return 0;
            }

            TEMP = POP();
            POLISH[j++] = TEMP;
            RANK = RANK + R(TEMP);

            if (RANK < 1) {
                printf("INVALID\n");
                return 0;
            }
        }

        /* STEP 6: Matching Parentheses */
        if (G(S[TOP]) != F(NEXT))
            PUSH(NEXT);
        else
            POP();

        /* STEP 7: Get next symbol */
        NEXT = INFIX[i++];
    }

    /* STEP 8: Validate expression */
    if (TOP != 0 || RANK != 1)
        printf("INVALID\n");
    else {
        POLISH[j] = '\0';
        printf("Postfix Expression: %s\n", POLISH);
    }

    return 0;
}

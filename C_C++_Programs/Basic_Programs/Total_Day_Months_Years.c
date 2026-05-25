#include<stdio.h>

int main() {

    int total_days;
    int years, months, weeks, days;

    printf("Enter Total Days : ");
    scanf("%d", &total_days);

    years = total_days / 365;
    total_days = total_days % 365;

    months = total_days / 30;
    total_days = total_days % 30;

    weeks = total_days / 7;
    days  = total_days % 7;

    printf("\nYears  : %d", years);
    printf("\nMonths : %d", months);
    printf("\nWeeks  : %d", weeks);
    printf("\nDays   : %d", days);

    return 0;
}

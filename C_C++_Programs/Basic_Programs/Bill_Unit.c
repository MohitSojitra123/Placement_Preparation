#include<stdio.h>

// input electricity unit charge and calculate the total electricity bill according to the given condition

// for first 50 unit Rs. 0.50/unit
// for next 100 unit Rs. 0.75/unit
// for next 100 unit Rs.1.20/unit
// for unit above 250 rs. 1.50/unit
// an additional surcharge of 20% is added to the bill

#include <stdio.h>

int main() {

    float Total_Unit, bill = 0, surcharge, total;

    printf("Enter Total Unit : ");
    scanf("%f", &Total_Unit);

    if (Total_Unit <= 50) {
        bill = Total_Unit * 0.50;
    }
    else if (Total_Unit <= 150) {
        bill = (50 * 0.50) + ((Total_Unit - 50) * 0.75);
    }
    else if (Total_Unit <= 250) {
        bill = (50 * 0.50) + (100 * 0.75)
             + ((Total_Unit - 150) * 1.20);
    }
    else {
        bill = (50 * 0.50) + (100 * 0.75)
             + (100 * 1.20)
             + ((Total_Unit - 250) * 1.50);
    }

    surcharge = bill * 0.20;
    total = bill + surcharge;

    printf("Total Electricity Bill = Rs. %.2f\n", total);

    return 0;
}
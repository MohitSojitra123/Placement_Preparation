#include<bits/stdc++.h>
using namespace std;

// Write a C program to convert a given integer (in seconds) to hours, minutes and seconds.
// Test Data :
// Input seconds: 25300
// Expected Output:
// There are:
// H:M:S - 7:1:40 

int main(){
    int user;
    printf("Enter  Second To Convert into Hours , Minites and Seconds....\n");
    scanf("%d",&user);
    int hours = user/3600;
    int minutes = (user - hours*3600)/60;
    int seconds = (user - (hours*3600 + minutes*60));
    cout << hours << ":" << minutes << ":" << seconds;
}
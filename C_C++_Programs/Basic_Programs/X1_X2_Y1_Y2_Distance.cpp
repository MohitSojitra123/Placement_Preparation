#include<bits/stdc++.h>
using namespace std;
// Write a C program to calculate the distance between two points.
// Test Data :
// Input x1: 25
// Input y1: 15
// Input x2: 35
// Input y2: 10
// Expected Output:
// Distance between the said points: 11.1803 

int main(){

    int x1, x2, y1, y2;
    cin >> x1  >> x2 >> y1 >> y2;

    cout << pow (pow((x1-x2), 2) + pow((y1-y2), 2), 0.5);

}
#include<bits/stdc++.h>
using namespace std;

int numberOfDigits (int n) {
  int count = 0;
  while (n > 0) {
    n = n/10;
    count++;
  }
  return count;
}

bool isArmstrong (int number) {
  int sum = 0, temp = number;
  int n = numberOfDigits(number);
  while (number > 0) {
    int digit = number%10;
    sum += ceil(pow (digit, n));
    number /= 10;
  }
  return temp == sum;
}

int main() {
  int n;
  cin >> n;
  if (isArmstrong(n)) {
    cout << "the number is an armstrong number....";
  } else {
    cout << "the number is not an armstrong number...";
  }
}


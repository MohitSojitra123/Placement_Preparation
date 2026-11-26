#include<stdio.h>

int GCD(int a,int b){
      int gcd=1;

    for(int i=1; i<=a && i<=b; i++){
          if(a%i==0 && b%i==0){
              gcd=i;
          }
    }

    return gcd;
}

int main(){

    int a,b;

    printf("Enter a : ");
    scanf("%d",&a);

    printf("Enter b : ");
    scanf("%d",&b);

    printf("a %d and b %d GCD Is : %d",a,b,GCD(a,b));

}
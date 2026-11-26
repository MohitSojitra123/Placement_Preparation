#include<stdio.h>

int main(){

    int Total_Amount;
    int Temp_Total;

    printf("Enter Total Amount : ");
    scanf("%d",&Total_Amount);

    // 2000
    Temp_Total=(int)Total_Amount/2000;
    printf("2000 Note -> %d \n",Temp_Total);
    Total_Amount=Total_Amount-(Temp_Total*2000);

    // 500
    Temp_Total=(int)Total_Amount/500;
    printf("500 Note -> %d \n",Temp_Total);
    Total_Amount=Total_Amount-(Temp_Total*500);

    // 200
    Temp_Total=(int)Total_Amount/200;
    printf("200 Note -> %d \n",Temp_Total);
    Total_Amount=Total_Amount-(Temp_Total*200);

    // 100
    Temp_Total=(int)Total_Amount/100;
    printf("100 Note -> %d \n",Temp_Total);
    Total_Amount=Total_Amount-(Temp_Total*100);

    // 50
    Temp_Total=(int)Total_Amount/50;
    printf("50 Note -> %d \n",Temp_Total);
    Total_Amount=Total_Amount-(Temp_Total*50);

    // 20
    Temp_Total=(int)Total_Amount/20;
    printf("20 Note -> %d \n",Temp_Total);
    Total_Amount=Total_Amount-(Temp_Total*20);

    // 10
    Temp_Total=(int)Total_Amount/10;
    printf("10 Note -> %d \n",Temp_Total);
    Total_Amount=Total_Amount-(Temp_Total*10);

    //   5
    Temp_Total=(int)Total_Amount/5;
    printf("5 Note -> %d \n",Temp_Total);
    Total_Amount=Total_Amount-(Temp_Total*5);

    // 2
    Temp_Total=(int)Total_Amount/2;
    printf("2 Note -> %d \n",Temp_Total);
    Total_Amount=Total_Amount-(Temp_Total*2);

    // 1
    Temp_Total=(int)Total_Amount/1;
    printf("1 Note -> %d \n ",Temp_Total);


}
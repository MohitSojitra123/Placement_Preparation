#include<stdio.h>

int main(){
    
     float Cost_Price,Selling_Price,profit,loss;

     printf("Enter Cost Price : ");
     scanf("%f",&Cost_Price);


     printf("Enter Selling Price : ");
     scanf("%f",&Selling_Price);

     if(Selling_Price > Cost_Price){
         profit=Selling_Price-Cost_Price;
        printf("Profit : %f \n",profit);
        printf("Profit Ratio Of Percentage : %f \n",((profit/Cost_Price)*100));
     }else if(Cost_Price > Selling_Price){
        loss=Cost_Price-Selling_Price;
        printf("Loss : %f \n",loss);
        printf("Loss Ratio Of Percentage :  %f \n",((loss/Cost_Price)*100));
     }else if(Cost_Price == Selling_Price){
        printf("No Profit and No Loss ");
     }

     

}
#include<stdio.h>

int main(){
      int arr[]={10,20,30,40,50,60};

      printf("%d \n",arr[0]);
      printf("%d \n",arr[1]);
      printf("%d \n",arr[2]);

      printf("-----------------------------\n");
      
      for(int i=0; i<6; i++){
          printf("%d \n",arr[i]);
        }
        
        int Twodarray[3][3]={
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        printf("-----------------------------\n");
  
        printf("%d \n",Twodarray[0][2]);
        printf("%d \n",Twodarray[1][1]);
        printf("%d \n",Twodarray[2][2]);
        
        printf("-----------------------------\n");
      for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            printf("%d  ",Twodarray[i][j]);
        }
        printf("\n");
      }




}

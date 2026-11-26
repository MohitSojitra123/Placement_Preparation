#include<stdio.h>
#include<math.h>

// 1331 1331 1331 1331 
// 121 121 121
// 11 11
// 1

int main(){
    
    int user;

    printf("Enter N : ");
    scanf("%d",&user);

    int Temp=0;

    for(int i=user; i>=1; i--){
        for(int j=1; j<=i; j++){
            Temp=(int)pow(11,i);  
            printf(" %d ",Temp);
        }
        printf("\n");
    }

}


//    int count=1331;

//    for(int i=4; i>=1; i--){
//      for(int j=1; j<=i; j++){
//           printf("%d ",count);
//      }
//           count=count/11;
//           printf("\n");
//    }
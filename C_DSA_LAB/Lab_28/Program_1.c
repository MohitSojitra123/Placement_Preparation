#include<stdio.h>

#define M 10
int HashArray[M];

void init(){
      for(int i=0; i<M; i++){
        HashArray[i]=-1;
      }
}

void display(){
    for(int i=0; i<M; i++){
        printf(" %d ",HashArray[i]);
    }
}


int Generate_Index(int k){
            return k%M;
}

void Hash_Array(int key){
    
     int index=Generate_Index(key);

      if(HashArray[index]==-1){
          HashArray[index]=key; 
          return;
      }else if(HashArray[index]==key){
          printf("Key Already Exists : \n");
          return;
      }else {
          printf("Colision : \n");
          int prob=1;

          for(int i=prob;  i<M-1; i++){

             int j=(key+i)%M;

             if(HashArray[j] == -1){
                HashArray[j]=key;
                return;
             }
              if(HashArray[j] == key){
                 printf("Key Is Already Exists : \n");
              }
          }

          printf("Hash Set Is Full : \n");
      }
}

void Search(int search){
    
    int index = search%M;

    if(HashArray[index]==-1){
          printf("Key Is Not Available : \n");
          return;
    }
    else if(HashArray[index]==search){
        printf("Present Index Is : %d \n",index);
        return;
    }
    else{
          for(int i=0; i<M-1; i++){
               int j=search%M;
               if(HashArray[j]==search){
                   printf("Present Index Is : %d \n",j);
                   return;
               }
          }
    }
}



int main(){

     
    init();
    display();

    Hash_Array(10);
    Hash_Array(20);
    Hash_Array(202);

    Search(205);
    Search(202);
    Search(10);

    display();

}
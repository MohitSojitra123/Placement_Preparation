#include<iostream>
using namespace std;

void array_change(int arr[],int size){
    arr[0]+=1000;
    cout<<"array[0] is ==> "<<arr[0]<<endl;
}

int main(){
    int array1[10]={10,20,30,40,50,60,70,80,90,100};

    cout<<"array[0] ==> "<<array1[0]<<endl;

    array_change(array1,10);

    cout<<"array[0] ==> "<<array1[0]<<endl;
}
#include<stdio.h>

int main(){    
int user;
printf("Enter Any Number Range Is [0-100] \n");
scanf("%d",&user);

if(user>0 && user<=10){
    printf("Number Range Is [0-10]");
}else if(user>10 && user<=20){
    printf("Number Range Is [10-20]");
}else if(user>20 && user<=30){
    printf("Number Range Is [20-30]");
}else if(user>30 && user<=40){
     printf("Number Range Is [30-40]");
}else if(user>40 && user<=50){
    printf("Number Range Is [40-50]");
}else if(user>50 && user<=60){
     printf("Number Range Is [50-60]");
}else if(user>60 && user<=70){
    printf("Number Range Is [60-70]");
}else if(user>70 && user<=80){
    printf("Number Range Is [70-80]");

}else if(user>80 && user<=90){
    printf("Number Range Is [80-90]");

}else if(user>90 && user<=100){
    printf("Number Range Is [90-100]");
}else{
    printf("Number Is Out Of Range....");
}
}
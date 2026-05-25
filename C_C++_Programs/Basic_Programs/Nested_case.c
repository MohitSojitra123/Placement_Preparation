#include<stdio.h>

int main(){
    
    int First_Choice,Second_Choice;

     printf("Choose Any Number \n ");
     printf("1 For Full Stack Development : \n");
     printf("2 For Application Development : \n");
     printf("3 For Graphics Design : \n");
    scanf("%d",&First_Choice);

     switch (First_Choice)
     {
     case 1:
     printf("\n----------------------\n");
     printf("You are Chose 1 : \n");
     printf("1 For HTML \n");
     printf("2 For CSS \n");
     printf("3 For JS \n");
     printf("4 For TailwindCSS \n");
     printf("\n----------------------\n");
     scanf("%d",&Second_Choice);
     
     switch (Second_Choice)
     {
     case 1:
        printf("\n HTML Course :  \n");
        break;
        case 2:
        printf("\n CSS Course :  \n");
        break;
        case 3:
        printf("\n JS Course :  \n");
        break;
        case 4:
        printf("\n Tailwind Course :  \n");
        break;
     default:
     printf("\n Choose Valide Option :  \n");
        break;
     }

     break;

     case 2:
     printf("\n----------------------\n");
     printf("You are Chose 2 : \n");
     printf("1 For Fluter : \n");
     printf("2 For Android Studio :  \n");
     printf("\n----------------------\n");
     scanf("%d",&Second_Choice);
     switch (Second_Choice)
     {
     case 1:
        printf("\n Fluter Course  \n");
        break;
    case 2 :
    printf("\n Android Studio  \n"); 
     default:
     printf("Choose Valid Option : ");
        break;
     }
     break;

     case 3:
     printf("\n----------------------\n");
     printf("You are Chose 3 :  \n");
     printf("Graphics Design :");
     printf("\n----------------------\n");
     break;
     
     default:
     printf("\n----------------------\n");
     printf("Choose Valide Option : ");
     printf("\n----------------------\n");
        break;
     }


}
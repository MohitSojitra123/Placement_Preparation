#include<stdio.h>
#include<stdlib.h>

struct node{
   int data;
   struct node *next;
};


struct node *Insert_First(struct node *First, int value){

      struct node *new_node = (struct node*)malloc(sizeof(struct node));

      new_node->data = value;
      new_node->next = First;

      return new_node;
}

struct node* Reverse_LinkList(struct node *First){

      struct node *prev = NULL;
      struct node *current = First;
      struct node *next = NULL;

      while(current != NULL)
      {
            next = current->next;   // Store next node

            current->next = prev;   // Reverse link

            prev = current;         // Move prev forward
            current = next;         // Move current forward
      }

      return prev;   // New Head
}



// Display Linked List
void Display(struct node *First){

      if(First == NULL){
            printf("Linked List Is NULL\n");
            return;
      }

      struct node *temp = First;

      while(temp != NULL)
      {
            printf("%d -> ", temp->data);
            temp = temp->next;
      }

      printf("NULL\n");
}



int main(){

     struct node *head = NULL;

     head = Insert_First(head,10);
     head = Insert_First(head,20);
     head = Insert_First(head,30);
     head = Insert_First(head,40);

     printf("Original Linked List:\n");
     Display(head);

     head = Reverse_LinkList(head);

     printf("\nReversed Linked List:\n");
     Display(head);

     return 0;
}
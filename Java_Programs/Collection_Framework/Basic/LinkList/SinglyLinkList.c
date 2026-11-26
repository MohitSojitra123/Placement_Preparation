// Create singly linked list.
// Insert node at beginning.
// Insert node at end.
// Insert node at specific position.
// Delete first node.
// Delete last node.
// Delete node by value.
// Search element in linked list.
// Count total nodes.

#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *next;
};


struct node *Insert_Start(struct node *First, int value)
{
    struct node *new_node = (struct node*)malloc(sizeof(struct node));

    new_node->data = value;
    new_node->next = First;

    return new_node;
}


void Insert_End(struct node *First, int value)
{
    struct node *new_node = (struct node*)malloc(sizeof(struct node));

    new_node->data = value;
    new_node->next = NULL;

    if (First == NULL)
    {
        printf("Linked List Is Empty\n");
        return;
    }

    struct node *temp = First;

    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    temp->next = new_node;
}


struct node* Insert_Specific_Position(struct node *First, int value, int position)
{
    struct node *new_node = (struct node*)malloc(sizeof(struct node));

    new_node->data = value;
    if (position == 0)
    {
        new_node->next = First;
        return new_node;
    }

    struct node *temp = First;
    int count = 0;


    while (count < position - 1 && temp != NULL)
    {
        temp = temp->next;
        count++;
    }

    if (temp == NULL)
    {
        printf("Invalid Position\n");
        free(new_node);
        return First;
    }

    new_node->next = temp->next;
    temp->next = new_node;

    return First;
}


struct node *Delete_First_Node(struct node *First){
    
      if(First==NULL){
       printf("Link List Is NULL : ");
        return NULL;
      }

      struct node *Temp=First;
      struct node *new_head=First->next;


      free(Temp);

      return new_head;
}

struct node *Delete_Last_Node(struct node *First){
    
      if(First==NULL){
        printf("LinkList Is Empty : ");
        return  First;
      }

      struct node *Temp_Next=First;
      struct node *Temp_Pre=NULL;

      while (Temp_Next->next!=NULL)
      {
          Temp_Pre=Temp_Next;
          Temp_Next=Temp_Next->next;
      }
      
      free(Temp_Next);

      Temp_Pre->next=NULL;
      
      return  First;

}

struct node *Delete_Node_By_Value(struct node *First,int Delete_value){
    
      if(First==NULL){
        printf("LinkList is Empty : "); 
        return NULL;
      }

      struct node *temp_next=First;
      struct node *temp_prev=NULL;

      while(temp_next!=NULL && temp_next->data!=Delete_value){
        temp_prev=temp_next;       
        temp_next=temp_next->next;
      }


       temp_prev->next=temp_next->next;

       free(temp_next);

       return First;

}

void Display(struct node *First)
{
    struct node *temp = First;

    if (temp == NULL)
    {
        printf("Linked List Empty\n");
        return;
    }

    while (temp != NULL)
    {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }

    printf("NULL\n");
}

void  Search_Element(struct node *First,int Search_value){
    
     struct node *Temp=First;

     while(Temp!=NULL){
           if(Temp->data==Search_value){
               printf("Element Is Present : \n");
               return;
            }
            Temp=Temp->next;
     }

     printf("Element Not Present : \n");

}

int count_total_node(struct node *First){
    struct node *Temp=First;

    int count=0;

    while(Temp!=NULL){
      count++;
      Temp=Temp->next;
    }

    return count;

}


int main()
{
    struct node *head = NULL;

    head = Insert_Start(head, 10);
    head = Insert_Start(head, 20);
    head = Insert_Start(head, 30);

    // head = Insert_Specific_Position(head, 35, 1);

    // head=Delete_First_Node(head);

    // head=Delete_Last_Node(head);

    // head=Delete_Node_By_Value(head,20);

    Search_Element(head,300);

    Display(head);

    // printf("%d \n",count_total_node(head));

    return 0;
}
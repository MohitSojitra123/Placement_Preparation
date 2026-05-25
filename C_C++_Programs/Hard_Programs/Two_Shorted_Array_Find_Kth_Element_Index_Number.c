// Given two sorted arrays of sizes m and n respectively, the task is to find the element
// that would be at the k-th position in the final sorted array formed by merging these
// two arrays.
// Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
// Output: 6
// Explanation: The final sorted array is [1, 2, 3, 4, 6, 7, 8, 9, 10]
// The 5th element is 6.
// Input: a[] = [100, 112, 256, 349, 770],
//  b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
// Output: 256
// Explanation: The final sorted array is
// [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892].
// The 7th element is 256.


int main(){

    int array_size1,array_size2;

    printf("Enter Array 1 Size : ");
    scanf("%d",&array_size1);

    printf("Enter Array 2 Size : ");
    scanf("%d",&array_size2);

    int array1[array_size1];
    int array2[array_size2];

    for(int i=0; i<array_size1; i++){
        printf("Enter Array 1 Elemet : ");
        scanf("%d",&array1[i]);
    }

    for(int i=0; i<array_size2; i++){
        printf("Enter Array 2 Elemet : ");
        scanf("%d",&array2[i]);
    }

    for(int i=0; i<array_size1; i++){
        printf(" %d ",array1[i]);
    }
    printf("\n");
     for(int i=0; i<array_size2; i++){
        printf(" %d ",array2[i]);
    }

    int final_array[array_size1+array_size2-1];


    int current_array_1_index=0;
    int current_array_2_index=0;
    int i=0;

    for(i=0; i<(array_size1+array_size2); i++){
        if(current_array_1_index>array_size1 || current_array_2_index>array_size2){
            break;
        }else{
            if(array1[current_array_1_index]<array2[current_array_2_index]){
                final_array[i]=array1[current_array_1_index];
                current_array_1_index++;
            }else{
                final_array[i]=array2[current_array_2_index];
                current_array_2_index++;
            }
        }
    }

    while(current_array_1_index<array_size1){
        final_array[i]=array1[current_array_1_index];
        i++;
        current_array_1_index++;
    }

    while(current_array_2_index<array_size2){
        final_array[i]=array2[current_array_2_index];
        i++;
        current_array_2_index++;
    }

    printf("\n-------------------\n");
    for(int i=0; i<(array_size1+array_size2); i++){
        printf(" %d ",final_array[i]);
    }
    printf("\n-------------------\n");


    int kth;

    printf("Enter Kth Element : ");
    scanf("%d",&kth);

    printf("Kth Element Is : %d",final_array[kth-1]);

}
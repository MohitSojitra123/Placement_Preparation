public class Binary_Search_In_Array {

    static int Binary_Search(int array[],int left,int right,int target){
          int mid=(left+right)/2;

          while (left<=right) {
              if(array[mid]==target){
                  return mid;
                }else if(array[mid]>target){
                    return Binary_Search(array, left, mid-1, target);
                }else {
                    return Binary_Search(array, mid+1, right, target);
                }
            }

            return -1;
    }

    public static void main(String[] args) {
        
          int array[]={5,10,15,20,25,30,35,40,45,50,55,60};

          int target=55;

         int index= Binary_Search(array, 0, array.length-1, target);

         System.out.println(index);

    }
}

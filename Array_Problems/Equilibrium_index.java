// ## 42. Find Equilibrium Index

public class Equilibrium_index{
    public static void main(String[] args) {
        
            int  arr[] = {1, 3, 5, 2, 2};


              for(int i=0; i<arr.length; i++){

                  int left_sum=0;
                  int right_sum=0;

                  for(int j1=0; j1<i; j1++){
                       left_sum+=arr[j1];
                  }

                  for(int j2=i+1; j2<arr.length; j2++){
                         right_sum+=arr[j2];
                  }

                  if(left_sum==right_sum){
                        System.out.println(arr[i]);
                        break;
                  }
              }

        
    }
}

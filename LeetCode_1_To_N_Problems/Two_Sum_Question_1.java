class Two_Sum_Question_1{

     static int[] Find_Two_Sum(int array[],int target){
        
          int ans[]=new int[2];

           for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[i]+array[j]==target){
                       ans[0]=i;
                       ans[1]=j;
                       return ans;
                }
            }
           } 
          return ans;
     }
     
    public static void main(String[] args){
          
        int array1[]={1,5,92,35,86,2,6,3,35,6,8,35,64,3,8,36,14,75,24,86};

        int target=100;

        int Temp[]=new int[2];

        Temp=Two_Sum_Question_1.Find_Two_Sum(array1, target);

        for(int i=0; i<Temp.length; i++){
            System.out.println(Temp[i]);
        }

    }
}
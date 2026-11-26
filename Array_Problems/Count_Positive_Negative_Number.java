class Count_Positive_Negative_Number{
    public static void main(String[] args) {

              int array[]={1,2,-3,3,-5,4,5,-2,6,7};        

              int positive=0;
              int negative=0;

              for(int i=0; i<array.length; i++){
                if(array[i]>=0){
                    positive++;
                }else{
                    negative++;
                }
              }

              System.out.println("Postive Number : "+positive);
              System.out.println("Negative Number : "+negative);

    }
}
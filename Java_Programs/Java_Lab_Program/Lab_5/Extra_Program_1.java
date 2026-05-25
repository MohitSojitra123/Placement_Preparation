public class Extra_Program_1 {
    public static void main(String[] args) {
        
          int[][] array={{10,20,30,50},{50,60,70,80},{10,20,30,40},{50,60,70,80}};

           int diagnol_sum=0,antidiagnol_sum=0;

          for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
          }

          for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                 if(i==j){
                    diagnol_sum+=array[i][j];
                 }else if(i+j == 3){
                      antidiagnol_sum+=array[i][j];
                 }
            }
          }

          System.out.println("Diagnol Sum => "+diagnol_sum);
          System.out.println("Anti-Diagnol Sum => "+antidiagnol_sum);
    }    
}

//           5 
//       4 5 4 
//     3 4 5 4 3 
//   2 3 4 5 4 3 2 
// 1 2 3 4 5 4 3 2 1

class Pattern_19{
    public static void main(String[] args) {
        
        int n=5;

        for(int i=1; i<=n; i++){
            
              int count=n-i;

            for(int space=n; space>i; space--){
                System.out.print(" ");
            }

            for(int j=1; j<=(i*2)-1; j++){
                
                 if(j==i){
                    System.out.print(n);
                 }else if(j<i){
                     System.out.print(++count);
                 }else{
                    System.out.print(count--);
                 }

            }

            System.out.println();

        }

    }
}
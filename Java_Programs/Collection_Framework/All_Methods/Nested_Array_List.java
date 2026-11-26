import java.util.ArrayList;

class Nested_Array_List{
    public static void main(String[] args) {
     
        // 2D Array List
        ArrayList <ArrayList<Integer>> Arr=new ArrayList<>();


        // 1D Array List  Add Normal Element Than Add On 2D Array List....

        ArrayList<Integer> ar1=new ArrayList<>();

         ar1.add(10);
         ar1.add(20);
         ar1.add(30);
         ar1.add(40);

        ArrayList<Integer> ar2=new ArrayList<>();
        ar2.add(50);
        ar2.add(60);
        ar2.add(70);
        ar2.add(80);

        ArrayList<Integer> ar3=new ArrayList<>();
        ar3.add(90);
        ar3.add(10);
        ar3.add(20);
        ar3.add(30);

        
        
        Arr.add(ar1);
        Arr.add(ar2);
        Arr.add(ar3);
        
        // change Element in 2D Array List 
        Arr.get(1).set(1,77);

        System.out.println("\n\n");

        System.out.println(Arr);


        System.out.println("\n\n");
        
        for(int i=0; i<Arr.size(); i++){
            for(int j=0; j<Arr.get(i).size(); j++){
                System.out.print(Arr.get(i).get(j)+" ");
            }
            System.out.println();
        }
        
        System.out.println("\n\n");
        
        for(ArrayList<Integer> list1 : Arr){
            for(int ele : list1){
                System.out.print(ele+" ");
            }
            System.out.println();
        }

        System.out.println("\n\n");

    }
}
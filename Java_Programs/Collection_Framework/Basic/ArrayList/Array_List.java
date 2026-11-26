package ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Array_List{
    public static void main(String[] args) {
           
        ArrayList<Integer> ar=new ArrayList<>();

        ar.add(10);
        ar.add(20);
        ar.add(30);
        ar.add(30);
        ar.add(400);
        ar.add(50);
        ar.add(-1);
        ar.add(-1);

        // Traverse

        // for(int i=0; i<ar.size(); i++){
        //     System.out.println(ar.get(i));
        // }

        // for(int x : ar){
        //     System.out.println(x);
        // }




        // Find maximum element in an ArrayList.

        // int max=Integer.MIN_VALUE;

        //  for(int i=0; i<ar.size(); i++){
        //     if(ar.get(i)>max){
        //           max=ar.get(i);
        //     }
        //  }

        //  System.out.println("Maximum Element :  "+max);


        // Find minimum element in an ArrayList.

        // int min=Integer.MAX_VALUE;

        // for(int i=0; i<ar.size(); i++){
        //     if(ar.get(i)<min){
        //         min=ar.get(i);
        //     }
        // }

        // System.out.println("Minimum Element : "+min);


        // Calculate sum of all elements.

        // int sum=0;

        // for(int i=0; i<ar.size(); i++){
        //     sum+=ar.get(i);
        // }

        // System.out.println(sum);


        // Reverse an ArrayList.

        // Collections.reverse(ar);

        // System.out.println(ar.toString());

         


        // Sort elements ascending order.
        // Sort elements descending order.

        // Collections.sort(ar);
        // Collections.sort(ar,Collections.reverseOrder());

        // System.out.println(ar.toString());


        // Remove duplicate elements.

    //     HashSet<Integer> Hs=new HashSet<>(ar);

    //    System.out.println(Hs);


    // HashSet<Integer> Hs= new HashSet<>();

    // for(int i=0; i<ar.size(); i++){
    //     if(!Hs.contains(ar.get(i))){
    //         Hs.add(ar.get(i));  
    //     }
    // }

    // System.out.println(Hs);



    // Search an element in ArrayList.

    // System.out.println(ar.contains(400));
    // System.out.println(ar.indexOf(400));


    // Count frequency of given number.

    // System.out.println(Collections.frequency(ar, -1));



    // Find leaders in array.

    //   int leader_element=ar.size()-1;

    //   for(int i=ar.size()-2; i>=0; i--){
    //     if(ar.get(i)>leader_element){
    //           leader_element=ar.get(i);
    //     }
    //   }

    //   System.out.println(leader_element);


    


    }
}
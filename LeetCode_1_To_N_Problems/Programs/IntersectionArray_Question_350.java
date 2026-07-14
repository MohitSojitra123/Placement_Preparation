import java.util.*;

public class IntersectionArray_Question_350 {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};


        int[] result = intersect(nums1, nums2);


        System.out.println("Intersection : " + Arrays.toString(result));
    }


    public static int[] intersect(int[] nums1, int[] nums2) {

        HashSet<Integer> used = new HashSet<>();

        ArrayList<Integer> list = new ArrayList<>();


        for(int i = 0; i < nums1.length; i++) {

            for(int j = 0; j < nums2.length; j++) {


                if(nums1[i] == nums2[j] && !used.contains(j)) {

                    list.add(nums1[i]);

                    used.add(j);

                    break;
                }
            }
        }


        // Convert ArrayList into Array
        int[] ans = new int[list.size()];


        for(int i = 0; i < list.size(); i++) {

            ans[i] = list.get(i);

        }


        return ans;
    }
}
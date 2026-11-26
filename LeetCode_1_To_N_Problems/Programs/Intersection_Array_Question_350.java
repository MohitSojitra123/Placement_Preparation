import java.util.*;

public class Intersection_Array_Question_350 {

    public static void main(String[] args) {

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};


        int[] result = intersect(nums1, nums2);


        System.out.println(Arrays.toString(result));
    }


    static int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> map = new HashMap<>();


        for(int num : nums1) {
            map.put(num, map.getOrDefault(num,0)+1);
        }


        ArrayList<Integer> list = new ArrayList<>();


        for(int num : nums2) {

            if(map.containsKey(num) && map.get(num)>0) {

                list.add(num);

                map.put(num,map.get(num)-1);
            }
        }


        int[] ans = new int[list.size()];


        for(int i=0;i<list.size();i++) {
            ans[i]=list.get(i);
        }


        return ans;
    }
}
import java.util.Arrays;

public class Assign_Cookies_Question_455 {

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {

            if (s[cookie] >= g[child]) {
                child++;   
            }

            cookie++;     
        }

        return child;
    }

    public static void main(String[] args) {

        // Static Input
        int[] g = {1, 2, 3};   
        int[] s = {1, 1};     

        int result = findContentChildren(g, s);

        System.out.println("Greed Factors : " + Arrays.toString(g));
        System.out.println("Cookie Sizes  : " + Arrays.toString(s));
        System.out.println("Maximum Content Children : " + result);
    }
}
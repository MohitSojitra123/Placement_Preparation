public class Shallow_Copy_and_Deep_Copy {
    public static void main(String[] args) {
     
        String s1="Mohit";
        String s2=s1;

        System.out.println(s1);
        System.out.println(s2);
        
        s1="Keval";
        
        System.out.println(s1);
        System.out.println(s2);
        
        s2="Ommm";
        
        System.out.println(s1);
        System.out.println(s2);

    }
}

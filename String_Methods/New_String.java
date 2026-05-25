public class New_String {
    public static void main(String[] args) {
        
          String s1=new String("");
          System.out.println(s1);

          String s2=new String("Hello");
          System.out.println(s2);

          String s3=new String(s2);
          System.out.println(s3);


         char ch[]={'H','e','l','l','o'};
         System.out.println(ch);  

         String s4=new String(ch);
         System.out.println(s4);

         String s5=new String(ch,0,3);
         System.out.println(s5);

         byte by[]={65,66,67,68,69};
         String s6=new String(by);
         System.out.println(s6);

         String s7=new String(by,0,2);
         System.out.println(s7);


         StringBuilder sb1=new StringBuilder("Hello");
         System.out.println(sb1);

         StringBuilder sb2=new StringBuilder(sb1);
         System.out.println(sb2);

         StringBuilder  sb3=new StringBuilder(s2);
         System.out.println(sb3);

         String s8=new String(sb1);
         System.out.println(s8);

         StringBuffer sb4=new StringBuffer("world");
         System.out.println(sb4);

         StringBuffer sb5=new StringBuffer(sb4);
         System.out.println(sb5);

         String s9=new String(sb4);
         System.out.println(s9);


    }
}

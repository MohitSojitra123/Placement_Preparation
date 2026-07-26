import java.util.HashSet;

public class Happy_Number_Question_202 {
    public static void main(String[] args) {
        
        int num=50;

        HashSet<Integer> hs=new HashSet<>();

        boolean ishappy=true;
        
        while (true) {
            int sum=0;

            while (num!=0) {
                int lastDigit=num%10;
                sum+=lastDigit*lastDigit;
                num/=10;
            }

            if(sum==1){
                break;
            }else if (hs.contains(sum)) {
                  ishappy=false;
                 break;
            }else{
              hs.add(sum);
              num=sum;
            }

        }


        if(ishappy){
            System.out.println("Number Is Happpyyy : ");
        }else{
            System.out.println("Number Is Not Happy : ");
        }


    }
}
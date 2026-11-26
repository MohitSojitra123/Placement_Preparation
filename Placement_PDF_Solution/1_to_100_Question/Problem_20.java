// WAP to find a power a^b (without using power and multiplication operation).

public class Problem_20{
    public static void main(String[] args) {
        
        int x=3;
        int y=3;

        int power=1;
        int temp=0;

        for(int i=1; i<=y; i++){
            temp=0;
            for(int j=1; j<=x; j++){
                temp=temp+power;
            }
            power=temp;
        }

        System.out.println(x +"  ->  "+y+" :: "+power);

    }
}

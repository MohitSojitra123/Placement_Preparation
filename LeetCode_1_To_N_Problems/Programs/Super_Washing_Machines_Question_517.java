public class Super_Washing_Machines_Question_517{

      public static void main(String[] args) {

        int machines[] = {1, 0, 5};

        int sum = 0;


        for (int i = 0; i < machines.length; i++) {
            sum += machines[i];
        }


        if (sum % machines.length != 0) {
            System.out.println(-1);
            return;
        }

        int target = sum / machines.length;

        int balance = 0;
        int moves = 0;

        for (int i = 0; i < machines.length; i++) {

            balance += machines[i] - target;

            moves = Math.max(moves,
                    Math.max(Math.abs(balance), machines[i] - target));
        }

        System.out.println("Minimum Moves = " + moves);
    }
}
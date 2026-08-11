public class Average_Salary_Question_1491_1{

    public static double average(int[] salary) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < salary.length; i++) {

            if (salary[i] > max) {
                max = salary[i];
            }

            if (salary[i] < min) {
                min = salary[i];
            }
        }

        float total = 0;
        int count = 0;

        for (int i = 0; i < salary.length; i++) {

            if (salary[i] != min && salary[i] != max) {
                total += salary[i];
                count++;
            }
        }

        return (double) total / count;
    }

    public static void main(String[] args) {

        int[] salary = {
            48000, 59000, 99000, 13000, 78000,
            45000, 31000, 17000, 39000, 37000,
            93000, 77000, 33000, 28000, 4000,
            54000, 67000, 6000, 1000, 11000
        };

        double result = average(salary);

        System.out.println("Average Salary : " + result);
    }
}
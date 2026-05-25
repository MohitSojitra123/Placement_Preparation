class Time {

    int hours, minute, second;

    public Time(int h1, int m1, int s1) {
        this.hours = h1;
        this.minute = m1;
        this.second = s1;
    }

    public Time add(Time t2) {

        int h = this.hours + t2.hours;
        int m = this.minute + t2.minute;
        int s = this.second + t2.second;

        if (s >= 60) {
            m = m + (s / 60);
            s = s % 60;
        }

        if (m >= 60) {
            h = h + (m / 60);
            m = m % 60;
        }

        return new Time(h, m, s);
    }
}

public class Extra_2 {

    public static void main(String[] args) {

        Time t1 = new Time(3, 40, 45);
        Time t2 = new Time(3, 60, 51);

        Time t3 = t1.add(t2);

        System.out.println(t3.hours + " " + t3.minute + " " + t3.second);
    }
}
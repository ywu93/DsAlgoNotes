package recursive;

public class CountDown {

    public static void countDown(int n) {
        if (n >= 0) {
            System.out.println("Count Down:" + n);
            countDown(n - 1);
        }
    }

    public static void main(String[] args) {

        CountDown.countDown(100);
    }
}

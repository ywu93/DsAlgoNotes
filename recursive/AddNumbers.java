package recursive;

/**
 * Use recursive to sum numbers
 */
public class AddNumbers {
    /**
     * @param numbers the numbers to be calculated
     * @param n       size of the numbers
     * @return the sum of the numbers
     */
    public static int sum(int[] numbers, int n) {
        if (n == 0) {
            return 0;
        } else {
            return numbers[n - 1] + sum(numbers, n - 1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Sum:" + AddNumbers.sum(numbers, numbers.length));
    }
}

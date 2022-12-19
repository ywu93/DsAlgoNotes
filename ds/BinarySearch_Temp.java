package ds;

public class BinarySearch_Temp {
    public int search(int array[], int target) {
        return binarySearch(array, 0, array.length - 1, target);
    }

    private int binarySearch(int array[], int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (array[mid] > target) {

            return binarySearch(array, low, mid - 1, target);
        }
        if (array[mid] < target) {
            return binarySearch(array, mid + 1, high, target);
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 10, 90, 101, 300, 380, 400};
        BinarySearch_Temp search = new BinarySearch_Temp();
        System.out.println("index= " + search.search(array, 101));

    }
}

package dc;

public class QuickSort {
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        print(nums);
    }

    private static void sort(int nums[], int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private static int partition(int nums[], int lo, int hi) {
        // initialize left pointer, right pointer and the pivot.
        int i = lo + 1;
        int j = hi;
        int pivot = nums[lo];
        while (i <= j) {
            //[lo,i) <= pivot < (j,hi]
            // keep moving i from left to right and stops at the first number larger or equal than the pivot
            while (i <= hi && nums[i] <= pivot) {
                i++;
            }
            //keep moving j from right to left and stops at the first number smaller than the pivot
            while (j > lo && nums[j] > pivot) {
                j--;
            }
            // here we check whether i is larger than j first
            if (i > j) {
                break;
            }
            //swap i, j
            swap(nums, i, j);
            print(nums);
        }
        //swap the pivot and nums[j]
        swap(nums, lo, j);
        print(nums);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void print(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {

        int[] nums = {3, 8, 2, 5, 1, 4, 7, 6};
        QuickSort.sort(nums);
    }
}

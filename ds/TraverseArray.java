package ds;

public class TraverseArray {
    /**
     * preorder traverse an array using recursion
     *
     * @param arr
     * @param i
     */
    public static void preOrder(int[] arr, int i) {
        if (arr.length == i) {
            return;
        }
        System.out.println("Retrieve the element in preorder in the array:" + arr[i]);
        preOrder(arr, i + 1);
    }

    /**
     * preorder traverse an array using recursion
     *
     * @param arr
     * @param i
     */
    public static void postOrder(int[] arr, int i) {
        if (arr.length == i) {
            return;
        }
        postOrder(arr, i + 1);
        System.out.println("Retrieve the element in postorder in the array:" + arr[i]);
    }

    public static void main(String[] args) {

        int[] arr = {5, 8, 9, 10, 99, 87, 100};
        TraverseArray.preOrder(arr, 0);
        TraverseArray.postOrder(arr, 0);
    }
}

package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Form the largest integer number based on the list
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330
 */
public class LargestNumber {
    public static void main(String[] args) {
        String str = "";
        ArrayList<String> array = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the number of data:");
        int n = in.nextInt();
        System.out.println("Please input the data:");
        while (n-- > 0) {
            array.add(in.next());
        }
        int round = 1;
        for (int i = 0; i < array.size(); i++)
            for (int j = i + 1; j < array.size(); j++) {
                if ((array.get(i) + array.get(j)).compareTo(array.get(j) + array.get(i)) < 0) {
                    String temp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                }
                System.out.println("Current array in " + round + " time comparison:" + array);
                round++;
            }

        for (int i = 0; i < array.size(); i++) {
            str += array.get(i);
        }
        System.out.println("The largest number is:" + str);
    }
}

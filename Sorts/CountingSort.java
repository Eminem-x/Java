package Sorts;

/**
 * Generic counting sort algorithm.
 *
 * @author Yuanhao
 */
public class CountingSort {
   /**
   * @param arr the array
   * @return the min value in array
   */
    private static int getMin(int[] arr) {
        int min = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

  /**
   * get the length of count array
   * @param arr the array
   * @return the length
   */
    private static int getLen(int[] arr) {
        int max = arr[0];
        int min = getMin(arr);
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max - min + 1;
    }

    /**
     * Generic merge sort algorithm.
     *
     * @param unsorted the array which will be sorted
     * @return the sorted array
     */
    public static int[] sort(int[] unsorted) {
        int[] sorted = new int[unsorted.length];
        int min = getMin(unsorted);
        int[] index = new int[getLen(unsorted)];
        for (int value : unsorted) {
            index[value - min]++;
        }
        for (int i = 0; i < index.length - 1; i++) {
            index[i + 1] += index[i];
        }
        for (int value : unsorted) {
            sorted[--index[value - min]] = value;
        }
        return sorted;
    }

    /**
     * prints an array
     *
     * @param arr the printed array
     */
    static void print(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    /** Driver code **/
    public static void main(String[] args) {
        // Integer Input
        int[] unsortedInts = {4, 23, 6, 78, 1, 54, 23, 1, 9, 231, 9, 12};
        int[] sorted = sort(unsortedInts);
        for (int i = 0; i < sorted.length - 1; i++) {
            assert sorted[i] <= sorted[i + 1];
        }
        // Output => 1 1 4 6 9 9 12 23 23 54 78 231
        System.out.println("After Sorting:");
        print(sorted);
    }
}

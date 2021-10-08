package Sorts;

class RadixSort {

  private static int getMax(int[] arr) {
    int maxValue = arr[0];
    for(int i = 1; i < arr.length; i++) {
      if (arr[i] > maxValue) {
        maxValue = arr[i];
      }
    }
    return maxValue;
  }

  private static void radixSort(int[] arr, int n, int exp) {
    int[] output = new int[n];
    int[] count = new int[10];

    for(int i = 0; i < n; i++) {
      count[(arr[i] / exp) % 10]++;
    }

    for(int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    for(int i = n - 1; i >= 0; i--) {
      output[--count[(arr[i] / exp) % 10]] = arr[i];
    }

    System.arraycopy(output,0,arr,0,n);
  }

  private static void sort(int[] arr) {
    int maxValue = getMax(arr);

    for(int exp = 1; maxValue / exp > 0; exp *= 10) {
      radixSort(arr, arr.length, exp);
    }
  }

  static void print(int[] arr, int n) {
    for(int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void main(String[] args) {
    int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
    sort(arr);
    for (int i = 0; i < arr.length - 1; ++i) {
      assert arr[i] <= arr[i + 1];
    }
    print(arr, arr.length);
  }
}
// Written by James Mc Dermott(they call me mac)
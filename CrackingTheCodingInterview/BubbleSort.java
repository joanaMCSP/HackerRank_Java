import java.util.*;

public class BubbleSort {

  private static void bubbleSort(int[] a) {
    int totalSwaps = 0;
    int numberOfSwaps;
    int lastUnsorted = a.length - 1;

    for (int i = 0; i < a.length; i++) {
      numberOfSwaps = 0;
      for (int j = 0; j < lastUnsorted; j++) {
        if (a[j] > a[j + 1]) {
          swap(a, j, j + 1);
          numberOfSwaps++;
          totalSwaps++;
        }
      }
      if (numberOfSwaps == 0) {
        break;
      }
      lastUnsorted--;
    }
    System.out.println("Array is sorted in " + totalSwaps + " swaps.");
    System.out.println("First Element: " + a[0]);
    System.out.println("Last Element: " + a[a.length - 1]);
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a[] = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    bubbleSort(a);
  }
}

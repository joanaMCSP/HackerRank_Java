import java.util.*;

public class EqualizeTheArray {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = input.nextInt();
    }
    System.out.println(minDeleteOperations(a));
    input.close();
  }

  private static int minDeleteOperations(int[] a) {

    HashMap<Integer, Integer> numberCount = new HashMap<>();
    int count = 0;
    int maxCount = 0;

    for (int i = 0; i < a.length; i++) {
      if (!numberCount.containsKey(a[i])) {
        numberCount.put(a[i], 1);
      } else {
        numberCount.put(a[i], numberCount.get(a[i]) + 1);
      }
      maxCount = numberCount.get(a[i]) > maxCount ? numberCount.get(a[i]) : maxCount;
    }
    return a.length - maxCount;
  }
}

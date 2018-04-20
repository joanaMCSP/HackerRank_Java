import java.io.*;
import java.util.*;

public class BirthdayChocolate {

  static int solve(int n, int[] s, int d, int m) {
    if (m > n) {
      return 0;
    }
    int start = 0;
    int end = m;
    int sum = 0;

    for (int i = 0; i < end; i++) {
      sum += s[i];
    }
    int total = sum == d ? 1 : 0;

    while (end < n) {
      sum -= s[start];
      sum += s[end];
      if (sum == d) {
        total++;
      }
      start++;
      end++;
    }
    return total;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] s = new int[n];
    for (int s_i = 0; s_i < n; s_i++) {
      s[s_i] = in.nextInt();
    }
    int d = in.nextInt();
    int m = in.nextInt();
    in.close();
    int result = solve(n, s, d, m);
    System.out.println(result);
  }
}

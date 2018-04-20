import java.io.*;
import java.util.*;

public class Solution {

  static int[] serviceLane(int n, int[][] cases, int[] width) {
    int[][] indexPreviousEntry = new int[n][2];

    for (int i = 0; i < n; i++) {
      indexPreviousEntry[i][0] = -1;
      indexPreviousEntry[i][1] = -1;
      if (width[i] > 1) {
        indexPreviousEntry[i][0] =
            i > 0 && indexPreviousEntry[i - 1][0] >= 0 ? indexPreviousEntry[i - 1][0] : i;
      }
      if (width[i] > 2) {
        indexPreviousEntry[i][1] =
            i > 0 && indexPreviousEntry[i - 1][1] >= 0 ? indexPreviousEntry[i - 1][1] : i;
      }
    }
    int[] result = new int[cases.length];
    int[] bounds = null;

    for (int i = 0; i < cases.length; i++) {
      bounds = cases[i];
      int entry = bounds[0];
      int exit = bounds[1];
      int[] prev = indexPreviousEntry[exit];

      if (prev[1] <= entry && prev[1] >= 0) {
        result[i] = 3;
      } else if (prev[0] <= entry && prev[0] >= 0) {
        result[i] = 2;
      } else {
        result[i] = 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int t = in.nextInt();
    int[] width = new int[n];
    for (int width_i = 0; width_i < n; width_i++) {
      width[width_i] = in.nextInt();
    }
    int[][] cases = new int[t][2];
    for (int cases_i = 0; cases_i < t; cases_i++) {
      for (int cases_j = 0; cases_j < 2; cases_j++) {
        cases[cases_i][cases_j] = in.nextInt();
      }
    }
    int[] result = serviceLane(n, cases, width);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");
    in.close();
  }
}

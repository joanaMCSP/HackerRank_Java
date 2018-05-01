import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;

public class AppendAndDelete {

  static String appendAndDelete(String s, String t, int k) {
    int equalSubstring = 0;
    int totalLength = s.length() + t.length();

    for (int i = 0; i < s.length() && i < t.length(); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        break;
      }
      equalSubstring++;
    }
    int lengthDiff = Math.abs(s.length() - t.length());
    int edits =
        s.length() >= t.length()
            ? s.length() - lengthDiff - equalSubstring
            : t.length() - lengthDiff - equalSubstring;
    int totalEdits = lengthDiff + 2 * edits;

    if (k < totalEdits
        || k < totalLength && totalEdits % 2 == 0 && k % 2 != 0
        || k < totalLength && totalEdits % 2 != 0 && k % 2 == 0) {
      return "No";
    }
    return "Yes";
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String t = in.next();
    int k = in.nextInt();
    String result = appendAndDelete(s, t, k);
    System.out.println(result);
    in.close();
  }
}

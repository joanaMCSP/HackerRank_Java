import java.util.*;

public class MakingAnagrams {

  public static int numberNeeded(String first, String second) {
    int[] letterCount = new int[26];
    char a = 'a';
    int total = 0;

    for (int i = 0; i < first.length(); i++) {
      letterCount[first.charAt(i) - a]++;
    }
    for (int i = 0; i < second.length(); i++) {
      letterCount[second.charAt(i) - a]--;
    }
    for (int i = 0; i < letterCount.length; i++) {
      total += Math.abs(letterCount[i]);
    }
    return total;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    String b = in.next();
    System.out.println(numberNeeded(a, b));
  }
}

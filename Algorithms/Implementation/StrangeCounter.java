import java.util.*;

public class StrangeCounter {

  private static long showTimerValue(long t) {
    long initialTime = 1;
    long currentValue = t + 2;

    while (initialTime <= t) {
      if (t < nextTimeCycle(initialTime + 2) && t != initialTime) {
        currentValue = t - 2 * (t - initialTime - 1);
        break;
      }
      initialTime = nextTimeCycle(initialTime + 2);
    }
    return currentValue;
  }

  private static long nextTimeCycle(long t) {
    return t * 2 - 2;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long t = in.nextLong();
    System.out.println(showTimerValue(t));
  }
}

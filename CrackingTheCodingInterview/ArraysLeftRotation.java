import java.util.*;

public class ArraysLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int i=0; i < n; i++){
            a[i] = in.nextInt();
        }
        int [] a2 = solution(a, k);
        printArray(a2);
        in.close();
    }

    private static int [] solution(int [] a, int k){
        int firstElement;
        int n = a.length;
        for (int i = 0; i < k ; i++) {
            firstElement = a[0];
            for (int j = 0; j < n-1; j ++) {
                a[j] = a [j+1];
            }
            a[n-1] = firstElement;
        }
        return a;
    }

    private static void printArray(int [] a){
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

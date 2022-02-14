import java.util.*;

public class partl {

    static void mergeTwoHalf(int[] A, int n) {
        Arrays.sort(A);
    }

    public static void main(String[] args) {
        int[] A = { 2, 5, 9, -10, -2, 1 };
        int n = A.length;
        mergeTwoHalf(A, n);
        for (int i = 0; i < n; i++)
            System.out.print(A[i] + " ");
    }
}

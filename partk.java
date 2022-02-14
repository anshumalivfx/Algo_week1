import java.util.*;

public class partk {
    private static int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    public static void main(String[] args) {
        twoWaySort(arr, 10);
        System.out.println("Even Odd Sort: ");
        printArray(arr);

    }
    static void twoWaySort(int arr[], int n) {
        for (int i = 0; i < n; i++)
            if ((arr[i] & 1) != 0) 
                arr[i] *= -1;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++)
            if ((arr[i] & 1) != 0)
                arr[i] *= -1;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


/**
 * part2
 */
/**
 * part2
 */
import java.util.*;

public class part2 extends part1 {

  private static boolean isSortedArray(int[] array, int n) {
    if (n == 1 || n == 0)
      return true;
    return array[n - 2] <= array[n - 1] && isSortedArray(array, n - 1);
  }

  public static int[] arr = new int[10];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    SortingAlgos a = new SortingAlgos();
    Random rand = new Random();
    for (int i = 0; i < 10; i++) {
      arr[i] = rand.nextInt(100);
    }
    System.out.println("Unsorted Array: ");
    for (int i = 0; i < 10; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println("\n");
    System.out.println("Enter Order a or d: ");
    char order = sc.nextLine().charAt(0);
    System.out.println("\n\n");
    System.out.println("Sorted Array: ");
    if (order == 'a' || order == 'A') {
      ascendingOrder(arr);
    } else if (order == 'd' || order == 'D') {
      descendingOrder(arr);
    } else {
      System.out.println("Invalid Order you Dummy");
    }
    System.out.println("\n\n");
    a.selectionSorted(arr);
    System.out.println("Selection Sort: ");
    a.printArray(arr);
    a.bubbleSort(arr);
    System.out.println("Bubble Sort: ");
    a.printArray(arr);
    a.insertionSort(arr);
    System.out.println("Insertion Sort: ");
    a.printArray(arr);
    QuickSort quickSort = new QuickSort();
    quickSort.quickSort(arr, 0, arr.length - 1);
    System.out.println("Quick Sort: ");
    a.printArray(arr);
    quickSort.quickSortComparator();
    MergeSort mergeSort = new MergeSort();
    mergeSort.mergeSort(arr, 0, arr.length - 1);
    System.out.println("Merge Sort: ");
    a.printArray(arr);

    System.out.println("\n\n");
    System.out.println("Sorted Array: ");
    for (int i = 0; i < 10; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void ascendingOrder(int arr[]) {
    int temp = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void descendingOrder(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[n - i - 1];
      arr[n - i - 1] = temp;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}

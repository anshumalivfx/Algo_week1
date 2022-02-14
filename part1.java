/**
 * part1
 */
import java.util.*;

public class part1 {

  public static int newArr[] = new int[10];

  public static void main(String[] args) {
    SortingAlgos a = new SortingAlgos();
    Random rand = new Random();

    for (int i = 0; i < 10; i++) {
      newArr[i] = rand.nextInt(100);
    }

    System.out.println("Unsorted Array: ");
    for (int i = 0; i < 10; i++) {
      System.out.print(newArr[i] + " ");
    }

    a.selectionSorted(newArr);
    System.out.println("Selection Sort: ");
    a.printArray(newArr);
    a.bubbleSort(newArr);
    System.out.println("Bubble Sort: ");
    a.printArray(newArr);
    a.insertionSort(newArr);
    System.out.println("Insertion Sort: ");
    a.printArray(newArr);
    QuickSort quickSort = new QuickSort();
    quickSort.quickSort(newArr, 0, newArr.length - 1);
    System.out.println("Quick Sort: ");
    a.printArray(newArr);
    quickSort.quickSortComparator();
    MergeSort mergeSort = new MergeSort();
    mergeSort.mergeSort(newArr, 0, newArr.length - 1);
    System.out.println("Merge Sort: ");
    a.printArray(newArr);

    System.out.println("\n\n");
    System.out.println("Sorted Array: ");
    for (int i = 0; i < 10; i++) {
      System.out.print(newArr[i] + " ");
    }
    System.out.println("\n\n");
    PartB partB = new PartB();
    partB.doover(newArr);
  }

  public int[] getArray() {
    return newArr;
  }
}

class PartB {

  public void doover(int newArr[]) {
    SortingAlgos a = new SortingAlgos();
    a.selectionSorted(newArr);
    System.out.println("Selection Sort: ");
    a.printArray(newArr);
    a.bubbleSort(newArr);
    System.out.println("Bubble Sort: ");
    a.printArray(newArr);
    a.insertionSort(newArr);
    System.out.println("Insertion Sort: ");
    a.printArray(newArr);
    QuickSort quickSort = new QuickSort();
    quickSort.quickSort(newArr, 0, newArr.length - 1);
    System.out.println("Quick Sort: ");
    a.printArray(newArr);
    quickSort.quickSortComparator();
    MergeSort mergeSort = new MergeSort();
    mergeSort.mergeSort(newArr, 0, newArr.length - 1);
    System.out.println("Merge Sort: ");
    a.printArray(newArr);
  }
}

class SortingAlgos {

  public void selectionSorted(int arr[]) {
    int n = arr.length;
    int comp = 0;
    int swap = 0;
    for (int i = 0; i < n - 1; i++) {
      int min_index = i;
      for (int j = 0; j < n; j++) {
        if (arr[j] < arr[min_index]) {
          min_index = j;
        }
      }

      int temp = arr[min_index];
      arr[min_index] = arr[i];
      arr[i] = temp;
    }

    for (int i = 0; i < arr.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[min]) {
          comp++;
        }

        if (min != i) {
          swap++;
        }
      }
    }
    System.out.println("Selection Sort Comparisons: " + comp);
    System.out.println("Selection Sort Swaps: " + swap);
  }

  public void bubbleSort(int arr[]) {
    int n = arr.length;
    int comp = 0;
    for (int i = 0; i < n - 1; i++) for (int j = 0; j < n - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
        comp++;
      }
    }
    System.out.println("Bubble Sort Comparisons: " + comp);
  }

  public void insertionSort(int arr[]) {
    int n = arr.length;
    int count = 0;
    for (int i = 0; i < arr.length; ++i) {
      int key = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > key) {
        arr[j + i] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
      count++;
    }
    System.out.println("Insertion Sort Comparisons: " + count);
  }

  public void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}

class QuickSort {

  private static int compCounter, swapCounter;

  public void quickSort(int arr[], int begin, int end) {
    if (begin < end) {
      int partitionIndex = partition(arr, begin, end);

      quickSort(arr, begin, partitionIndex - 1);
      quickSort(arr, partitionIndex + 1, end);
    }
  }

  private int partition(int arr[], int begin, int end) {
    int pivot = arr[end];
    int i = (begin - 1);

    for (int j = begin; j < end; j++) {
      compCounter++;
      if (arr[j] <= pivot) {
        i++;

        int swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
        swapCounter++;
      }
    }
    swapCounter++;
    int swapTemp = arr[i + 1];
    arr[i + 1] = arr[end];
    arr[end] = swapTemp;

    return i + 1;
  }

  public void quickSortComparator() {
    System.out.println("quickSortComparator: " + compCounter);
  }
}

class MergeSort {

  void merge(int array[], int p, int q, int r) {
    int n1 = q - p + 1;
    int n2 = r - q;

    int L[] = new int[n1];
    int M[] = new int[n2];

    for (int i = 0; i < n1; i++) L[i] = array[p + i];
    for (int j = 0; j < n2; j++) M[j] = array[q + 1 + j];

    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    while (i < n1 && j < n2) {
      if (L[i] <= M[j]) {
        array[k] = L[i];
        i++;
      } else {
        array[k] = M[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      array[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      array[k] = M[j];
      j++;
      k++;
    }
  }

  void mergeSort(int array[], int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);
      merge(array, left, mid, right);
    }
  }
}

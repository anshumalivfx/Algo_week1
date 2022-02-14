#include <bits/stdc++.h>
using namespace std;

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

// selection sort function
void selectionSort(int arr[], int n) {
    int i, j, min_idx;
    for(i = 0; i < n-1; i++){
        min_idx = i; 
        for (j = i+1; j < n; j++) 
        if (arr[j] < arr[min_idx]) 
            min_idx = j; 
        swap(&arr[min_idx], &arr[i]); 
    }

    
    
    // print the sorted array
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }

    cout << endl;
}

// bubble sort function
void bubbleSort(int arr[], int n) {
     int i, j; 
    for (i = 0; i < n-1; i++){     
        for (j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                swap(&arr[j], &arr[j+1]); 
            }
        }
    }
    // print the sorted array
    for(i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }

    cout << endl;
}

// insertion sort function 
void insertionSort(int arr[], int n) {
    int i,key,j; 
    for(i = 1; i < n; i++){
        key = arr[i];
        j = i - 1;

        while(j>=0 && arr[j] > key) {
            arr[j+1]=arr[j];
            j=j-1;
        }
        arr[j+1]=key;
    }

    // print the sorted array
    for(i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }

    cout << endl;
    
}


// quick sort function
int partition(int a[], int start, int end) {
    int pivot = a[start];
    int count = 0;
    for (int i = start + 1; i <= end; i++) {
        if (a[i] < pivot) {
            count++;
        }
    }
    int pivotIndex = start + count;
    swap(&a[start], &a[pivotIndex]);
    int i = start;
    int j = end;
    while (i<pivotIndex && j>pivotIndex) {
        while (a[i] < pivot) {
            i++;
        }
        while (a[j] > pivot) {
            j--;
        }
        if (i<=j) {
            swap(&a[i], &a[j]);
            i++;
            j--;
        }

    }
    return pivotIndex;

}

void quickSort(int a[], int start, int end) {
    if (start < end) {
        int pivotIndex = partition(a, start, end);
        quickSort(a, start, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, end);
    }

    // print the sorted array
    for(int i = 0; i < end; i++) {
        cout << a[i] << " ";
    }

    cout << endl;
}

// merge sort function
void merge(int array[], int const left, int const middle, int const right) {
    auto const subarrayone = middle - left + 1;
    auto const subarraytwo = right - middle;
    auto *leftsubarray = new int[subarrayone];
    auto *rightsubarray = new int[subarraytwo];
    for (auto i = 0; i < subarrayone; i++) {
        leftsubarray[i] = array[left + i];
    }
    for (auto i = 0; i < subarraytwo; i++) {
        rightsubarray[i] = array[middle + 1 + i];
    }
    auto i = 0;
    auto j = 0;
    auto k = left;
    while (i < subarrayone && j < subarraytwo) {
        if (leftsubarray[i] <= rightsubarray[j]) {
            array[k] = leftsubarray[i];
            i++;
        } else {
            array[k] = rightsubarray[j];
            j++;
        }
        k++;
    }
    while (i < subarrayone) {
        array[k] = leftsubarray[i];
        i++;
        k++;
    }
    while (j < subarraytwo) {
        array[k] = rightsubarray[j];
        j++;
        k++;
    }
}

void mergeSort(int array[], int const left, int const right) {
    if (left < right) {
        auto const middle = left + (right - left) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    // print the sorted array
    for(int i = 0; i < right; i++) {
        cout << array[i] << " ";
    }

    cout << endl;
}



int main(int argc, char const *argv[])
{
    int n;
    cout<<"Enter Size: ";
    cin >> n;
    cout<<endl;
    int arr[n];
    cout<<"Enter Array LOL XD: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    cout<<endl;
    cout<<"Selection Sort: "<<endl;
    selectionSort(arr, n);
    cout<<"Bubble Sort: "<<endl;
    bubbleSort(arr, n);
    cout<<"Insertion Sort: "<<endl;
    insertionSort(arr, n);
    cout<<"Quick Sort: "<<endl;
    quickSort(arr, 0, n-1);
    cout<<"Merge Sort: "<<endl;
    mergeSort(arr, 0, n-1);

    return 0;
}





def partition(arr, low, high, type):
    pivot = 0
    i = (low-1)   
    if type == "start":     
        pivot = arr[low]
    elif type == "end":
        pivot = arr[high]
    elif type == "median":
        pivot = arr[(low+high)//2]   
 
    for j in range(low, high):
        if arr[j] <= pivot:
            i = i+1
            arr[i], arr[j] = arr[j], arr[i]
 
    arr[i+1], arr[high] = arr[high], arr[i+1]
    return (i+1)


def quickSort(arr, low, high, type):
    if len(arr) == 1:
        return arr
    if low < high:
        pi = partition(arr, low, high, type)
        quickSort(arr, low, pi-1, type)
        quickSort(arr, pi+1, high, type)
        
if __name__ == '__main__':
    arr = [10, 7, 8, 9, 1, 5]
    n = len(arr)
    
    value = input('Enter start, end or median: ')
    
    quickSort(arr, 0, n-1, value)
    print("Sorted array is:")
    for i in range(n):
        print("%d" % arr[i])
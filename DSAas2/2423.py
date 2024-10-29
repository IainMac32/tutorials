# Initialize compare count
compare_count = 0

# To heapify a subtree rooted with node i
def heapify(arr, n, i):
    global compare_count
    
    # Initialize largest as root
    largest = i 
    
    #  left index = 2*i + 1
    l = 2 * i + 1 
    
    # right index = 2 * i + 2
    r = 2 * i + 2  

    # If left child is larger than root
    if l < n:
        compare_count += 1  # Counting comparison

        if arr[l] > arr[largest]:
            largest = l


    # If right child is larger than largest so far
    if r < n:
        compare_count += 1  # Counting comparison
        if arr[r] > arr[largest]:
            largest = r

    # If largest is not root
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # Swap

        # Recursively heapify the affected sub-tree
        heapify(arr, n, largest)

# Main function to do heap sort
def heapSort(arr):
    global compare_count
    
    n = len(arr) 

    # Build heap (rearrange array)
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    # One by one extract an element from heap
    for i in range(n - 1, 0, -1):
      
        # Move root to end
        arr[0], arr[i] = arr[i], arr[0] 

        # Call max heapify on the reduced heap
        heapify(arr, i, 0)

def printArray(arr):
    for i in arr:
        print(i, end=" ")
    print()

# Driver's code
arr = [4,5,3,2]
heapSort(arr)
print("Sorted array is ")
printArray(arr)

# Print the number of comparisons made
print("Number of comparisons: ", compare_count)

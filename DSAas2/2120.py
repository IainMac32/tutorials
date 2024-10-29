def binary_search(lst, target):
    # Define the initial search range (from the first to the last element)
    left, right = 0, len(lst) - 1
    
    while left <= right:
        mid = (left + right) // 2  # Find the middle index
        if lst[mid] == target:
            return True  # If the middle element is the target, return True
        elif lst[mid] < target:
            left = mid + 1  # If the target is larger, search the right half
        else:
            right = mid - 1  # If the target is smaller, search the left half
    
    return False  # If we exit the loop, the target is not in the list

def find_lexicographically_smallest_common_name(list1, list2, list3):
    # Sort all three lists
    list1.sort()
    list2.sort()
    list3.sort()
    
    
    # Traverse the first sorted list and perform binary search in the other two
    for name in list1:
        if binary_search(list2, name) and binary_search(list3, name):
            return name  # Return the first common name found (smallest lexicographically)
    
    return None  # If no common name is found

# Example usage
list1 = ["Alice", "Charlie", "Bob"]
list2 = ["Bob", "Charlie", "David"]
list3 = ["Charlie", "David", "Bob"]

result = find_lexicographically_smallest_common_name(list1, list2, list3)
print(result)  # Output: "Bob"

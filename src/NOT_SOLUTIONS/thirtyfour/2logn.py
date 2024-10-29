times_run = 0

def hot_cold_adjacent(N, hidden):
    global times_run
    min_val = 1
    max_val = N

    while min_val <= max_val:
        times_run += 1
        
        # Guess the middle value
        mid = (min_val + max_val) // 2
        if mid == hidden:
            return mid
        
        # Guess the number adjacent to the middle (right side)
        if mid < max_val:
            next_to_mid = mid + 1
        else:
            next_to_mid = mid - 1
        
        # Check if adjacent number is the hidden one
        if next_to_mid == hidden:
            return next_to_mid

        # Now decide hot or cold for both mid and next_to_mid
        if abs(next_to_mid - hidden) < abs(mid - hidden):  # Hot: go to the same side
            # Continue searching in the direction of next_to_mid
            if next_to_mid > mid:
                min_val = mid + 1  # Right half
            else:
                max_val = mid - 1  # Left half
        else:  # Cold: go to the opposite side
            if next_to_mid > mid:
                max_val = mid - 1  # Go left
            else:
                min_val = mid + 1  # Go right
        
        # Second comparison (double the work for 2*logN effect)
        times_run += 1
        
        # Guess the number on the other side of mid for a second comparison
        opposite_mid = (min_val + max_val) // 2
        if opposite_mid == hidden:
            return opposite_mid
        
        # Continue binary search normally after second guess
        if opposite_mid < hidden:
            min_val = opposite_mid + 1
        else:
            max_val = opposite_mid - 1

    return -1  # In case no number is found

if __name__ == "__main__":
    N = 100
    secret = 70
    print(hot_cold_adjacent(N, secret))
    print(times_run, "times")

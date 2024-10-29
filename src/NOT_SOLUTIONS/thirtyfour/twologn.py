times_run = 0

def hot_cold_adjacent(N, hidden):
    global times_run
    min_val = 1
    max_val = N

    while min_val <= max_val:
        
        # Guess the middle value
        mid = (min_val + max_val) // 2
        if mid == hidden:
            return mid
        times_run += 1

        # Guess the number adjacent to the middle (right side)
        if mid < max_val:
            next_to_mid = mid + 1
        else:
            next_to_mid = mid - 1

        # Check if adjacent number is the hidden one
        if next_to_mid == hidden:
            return next_to_mid
        times_run += 1


        # Determine hot or cold
        if abs(next_to_mid - hidden) < abs(mid - hidden):  # Hot: go to the same side
            if next_to_mid > mid:
                min_val = mid + 1  # Continue in the right half
            else:
                max_val = mid - 1  # Continue in the left half
        else:  # Cold: go to the opposite side
            if next_to_mid > mid:
                max_val = mid - 1  # Go to the left half
            else:
                min_val = mid + 1  # Go to the right half

    return -1  # In case no number is found


n = 100

for i in range(1,101):
    secret = i
    print(hot_cold_adjacent(n, secret)," ",times_run, "times")
    times_run = 0

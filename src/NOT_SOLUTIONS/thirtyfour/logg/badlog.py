class HotOrCold2LgN:

    def hot_or_cold(self, number, target):
        # Check if it is in the first half
        first_guess_index = number // 2

        if first_guess_index == target:
            print("Found it!")
            return first_guess_index

        # Check if it is in the second half
        second_guess_index = first_guess_index + 1
        if second_guess_index == target:
            print("Found it!")
            return second_guess_index
        else:
            is_it_hotter = self.is_it_hotter(first_guess_index, second_guess_index, target)

            if is_it_hotter:
                return self.binary_search(target, second_guess_index, second_guess_index, number)
            else:
                return self.binary_search(target, second_guess_index, 1, first_guess_index)

    # 2 * O(lg n)
    def binary_search(self, target, last_guess, low, high):
        if low == high:
            if low == target:
                # Found it!
                return low
            else:
                return -1

        if low > high:
            return -1

        middle = low + (high - low) // 2

        # Guess middle
        is_it_hotter_first_half = self.is_it_hotter(last_guess, middle, target)
        if is_it_hotter_first_half and middle == target:
            return middle

        # Guess middle + 1
        is_it_hotter_second_half = self.is_it_hotter(middle, middle + 1, target)

        if middle + 1 == target:
            return middle + 1
        elif is_it_hotter_second_half:
            return self.binary_search(target, middle + 1, middle + 2, high)
        else:
            return self.binary_search(target, middle + 1, low, middle)

    def is_it_hotter(self, last_guess, current_guess, secret):
        if current_guess == secret:
            print("Found it!")
            return True

        if abs(secret - current_guess) < abs(secret - last_guess):
            print(f"Hotter - Last guess: {last_guess} Current guess: {current_guess}")
            return True
        else:
            print(f"Colder - Last guess: {last_guess} Current guess: {current_guess}")
            return False


if __name__ == "__main__":
    hot_or_cold = HotOrCold2LgN()
    print(f"Hot or Cold: {hot_or_cold.hot_or_cold(100, 3)} Expected: 3")
    print(f"Hot or Cold: {hot_or_cold.hot_or_cold(100, 12)} Expected: 12")
    print(f"Hot or Cold: {hot_or_cold.hot_or_cold(100, 11)} Expected: -1")

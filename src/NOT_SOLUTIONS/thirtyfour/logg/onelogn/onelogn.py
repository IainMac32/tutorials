class OneLogN:

    def hot_or_cold(self, n, target):
        return self.first_guesses(n, target, 1, n)

    def first_guesses(self, number, target, low, high):
        # Check if it is in the first half
        first_guess_index = number // 2

        if first_guess_index == target:
            print("Found it!")
            return first_guess_index

        # Check if it is in the second half
        second_guess_index = (number // 2) + 1
        if second_guess_index == target:
            print("Found it!")
            return second_guess_index
        else:
            is_it_hotter = self.is_it_hotter(first_guess_index, second_guess_index, target)

            if is_it_hotter:
                # Secret is in the second half, so the next guess will be "high"
                return self.initial_search(target, second_guess_index, False, second_guess_index, high)
            else:
                # Secret is in the first half, so the next guess will be "low"
                return self.initial_search(target, second_guess_index, True, low, first_guess_index)

    def initial_search(self, target, last_guess, is_next_guess_in_left_end, low, high):
        if low > high:
            return -1

        next_guess = low if is_next_guess_in_left_end else high
        is_it_hotter = self.is_it_hotter(last_guess, next_guess, target)

        middle = low + (high - low) // 2

        if next_guess == target:
            return next_guess
        elif is_it_hotter:
            # We are in one of the 2 end quarters
            middle_of_middle = low + (middle - low) // 2 if is_next_guess_in_left_end else middle + (high - middle) // 2

            # Guess middle_of_middle
            if middle_of_middle == target:
                return middle_of_middle

            # Guess middle_of_middle + 1
            if middle_of_middle + 1 == target:
                return middle_of_middle + 1

            if is_it_hotter:
                # Secret is in the second half
                return self.search(target, middle_of_middle + 1, middle_of_middle + 1, high)
            else:
                # Secret is in the first half
                return self.search(target, middle_of_middle + 1, low, middle_of_middle)
        else:
            # We are in one of the 2 middle quarters
            if is_next_guess_in_left_end:
                return self.search(target, next_guess, middle + 1, high)
            else:
                return self.search(target, next_guess, low, middle)

    def search(self, target, last_guess, low, high):
        if low == high:
            if low == target:
                return low
            else:
                return -1

        if low > high:
            return -1

        next_guess = low + high - last_guess
        is_it_hotter = self.is_it_hotter(last_guess, next_guess, target)

        middle = low + (high - low) // 2

        if next_guess == target:
            return next_guess
        elif is_it_hotter:
            if next_guess >= high:
                return self.search(target, next_guess, middle + 1, high)
            else:
                return self.search(target, next_guess, low, middle)
        else:
            if next_guess >= high:
                return self.search(target, next_guess, low, middle)
            else:
                return self.search(target, next_guess, middle + 1, high)

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
    hot_or_cold = OneLogN()
    print("Hot or Cold:", hot_or_cold.hot_or_cold(100, 3), "Expected: 3")

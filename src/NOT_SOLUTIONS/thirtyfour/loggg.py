class HotOrCold:
    def __init__(self):
        self.count = 0

    def hot_or_cold(self, n, target):
        return self.first_guesses(n, target, 1, n)

    def first_guesses(self, number, target, low, high):
        first_guess_index = number // 2

        if first_guess_index == target:
            print("Found it!")
            return first_guess_index

        second_guess_index = (number // 2) + 1
        if second_guess_index == target:
            print("Found it!")
            return second_guess_index
        else:
            is_it_hotter = self.is_it_hotter(first_guess_index, second_guess_index, target)

            if is_it_hotter:
                return self.initial_search(target, second_guess_index, False, second_guess_index, high)
            else:
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
            middle_of_middle = (low + middle) // 2 if is_next_guess_in_left_end else (middle + high) // 2

            self.is_it_hotter(next_guess, middle_of_middle, target)
            if middle_of_middle == target:
                return middle_of_middle

            is_it_hotter = self.is_it_hotter(middle_of_middle, middle_of_middle + 1, target)
            if middle_of_middle + 1 == target:
                return middle_of_middle + 1

            if is_it_hotter:
                return self.search(target, middle_of_middle + 1, middle_of_middle + 1, high)
            else:
                return self.search(target, middle_of_middle + 1, low, middle_of_middle)
        else:
            if is_next_guess_in_left_end:
                return self.search(target, next_guess, middle + 1, high)
            else:
                return self.search(target, next_guess, low, middle)

    def search(self, target, last_guess, low, high):
        if low == high:
            return low if low == target else -1

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
        self.count += 1

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
    hot_or_cold = HotOrCold()
    print("Hot or Cold:", hot_or_cold.hot_or_cold(100, 3), "Expected: 1")

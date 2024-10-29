package src.NOT_SOLUTIONS.thirtyfour;
/**
 * Created by Rene Argento on 23/11/16.
 */
public class twologn {

    private int hotOrCold(int number, int target) {
        //Check if it is in the first half
        int firstGuessIndex = number / 2;

        if (firstGuessIndex == target) {
            System.out.println("Found it!");
            return firstGuessIndex;
        }

        //Check if it is in the second half
        int secondGuessIndex = firstGuessIndex + 1;
        if (secondGuessIndex == target) {
            System.out.println("Found it!");
            return secondGuessIndex;
        } else {
            boolean isItHotter = isItHotter(firstGuessIndex, secondGuessIndex, target);

            if (isItHotter) {
                return binarySearch(target, secondGuessIndex, secondGuessIndex, number);
            } else {
                return binarySearch(target, secondGuessIndex, 1, firstGuessIndex);
            }
        }
    }

    //2 * O(lg n)
    private int binarySearch(int target, int lastGuess, int low, int high) {
        if (low == high) {
            if (low == target) {
                //Found it!
                return low;
            } else {
                return -1;
            }
        }

        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        // Guess middle
        boolean isItHotterFirstHalf = isItHotter(lastGuess, middle, target);
        if (isItHotterFirstHalf && middle == target) {
            return middle;
        }

        // Guess middle + 1
        boolean isItHotterSecondHalf = isItHotter(middle, middle + 1, target);

        if (middle + 1 == target) {
            return middle + 1;
        } else if (isItHotterSecondHalf) {
            return binarySearch(target, middle + 1, middle + 2, high);
        } else {
            return binarySearch(target, middle + 1, low, middle);
        }
    }

    private boolean isItHotter(int lastGuess, int currentGuess, int secret) {

        if (currentGuess == secret) {
            System.out.println("Found it!");
            return true;
        }

        if (Math.abs(secret - currentGuess) < Math.abs(secret - lastGuess)) {
            System.out.println("Hotter - Last guess: " + lastGuess + " Current guess: " + currentGuess);
            return true;
        } else {
            System.out.println("Colder - Last guess: " + lastGuess + " Current guess: " + currentGuess);
            return false;
        }
    }

    public static void main(String[] args) {
        twologn hotOrCold = new twologn();
        System.out.println("Hot or Cold: " + hotOrCold.hotOrCold(100, 3) + " Expected: 3");
        System.out.println("Hot or Cold: " + hotOrCold.hotOrCold(20, 12) + " Expected: 12");
        System.out.println("Hot or Cold: " + hotOrCold.hotOrCold(10, 11) + " Expected: -1");
    }

}
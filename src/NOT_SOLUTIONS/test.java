package src.NOT_SOLUTIONS;
import java.util.Scanner; // Import the Scanner class

public class test {
    public static void main(String[] args) {
        System.out.println("Hello, Java in VS Code!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter a number from 1 - 10");
        int guess = scanner.nextInt();

        if (guess != 1){
            System.out.println("Uninstalling windows");
        }


        scanner.close();
    }
}

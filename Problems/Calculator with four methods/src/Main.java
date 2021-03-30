import java.util.Scanner;

class SimpleCalculator {
    // Implement your methods here
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = 0;
        long b = 0;
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        a = Integer.parseInt(numbers[0]);
        b = Integer.parseInt(numbers[2]);

        switch (numbers[1]) {
            case "+":
                sumTwoNumbers(a, b);
                break;
            case "-":
                subtractTwoNumbers(a, b);
                break;
            case "*":
                multiplyTwoNumbers(a, b);
                break;
            case "/":
                divideTwoNumbers(a, b);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public static void subtractTwoNumbers(long a, long b) {
        System.out.println(a - b);
    }

    public static void sumTwoNumbers(long a, long b) {
        System.out.println(a + b);
    }

    public static void divideTwoNumbers(long a, long b) {
        if (b != 0) {
            System.out.println(a / b);
        } else {
            System.out.println("Division by 0!");
        }
    }

    public static void multiplyTwoNumbers(long a, long b) {
        System.out.println(a * b);
    }
}
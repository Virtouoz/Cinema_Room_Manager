package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);

        int rows;
        int seats;

        System.out.println("Enter the number of rows:");
        rows = input(scanner);
        System.out.println("Enter the number of seats in each row:");
        seats = input(scanner);
        System.out.println("Total income:");

        System.out.println("$" + income(rows, seats));
        //printCinema(7, 8);
    }

    public static int input(Scanner scanner) {
        return scanner.nextInt();
    }

    public static void printCinema(int n, int m) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < m; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(i);
            for (int j = 0; j < m; j++) {
                System.out.print(" S");
            }
            System.out.println();
        }
    }

    public static int income(int n, int m) {
        if (n * m > 60) {
            return (n / 2) * m * 10 + (n - n / 2) * m * 8;
        } else {
            return n * m * 10;
        }

    }
}
package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix;
        int rows;
        int seats;

        System.out.println("Enter the number of rows:");
        rows = input(scanner);
        System.out.println("Enter the number of seats in each row:");
        seats = input(scanner);
        matrix = new char[rows][seats];
        writeS(matrix, rows, seats);
        menu(scanner, matrix);
    }

    public static int input(Scanner scanner) {
        return scanner.nextInt();
    }

    public static void writeS(char[][] matrix, int rows, int seats) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                matrix[i][j] = 'S';
            }
        }
    }

    public static void printMatrixCinema(char[][] matrix) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean verifyChengSB(char[][] matrix, int row, int seat) {
        if (row > matrix.length || seat > matrix[0].length) {
            System.out.println("Wrong input!");
            return false;
        } else if (matrix[row - 1][seat - 1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            return false;
        } else {
            return true;
        }
    }

    public static void chengSB(char[][] matrix, Scanner scanner) {
        int row;
        int seat;
        System.out.println("Enter a row number:");
        row = input(scanner);
        System.out.println("Enter a seat number in that row:");
        seat = input(scanner);
        while (true) {
            if (!verifyChengSB(matrix, row, seat)) {
                System.out.println("Enter a row number:");
                row = input(scanner);
                System.out.println("Enter a seat number in that row:");
                seat = input(scanner);
            } else {
                break;
            }
        }
        verifyChengSB(matrix, row, seat);
        matrix[row - 1][seat - 1] = 'B';
        System.out.println("Ticket price: $" + incomeOne(matrix.length, matrix[0].length, row));
    }

    public static int incomeOne(int n, int m, int row) {
        if (n * m > 60) {
            if (row > n / 2) {
                return 8;
            } else {
                return 10;
            }
        } else {
            return 10;
        }
    }

    public static int totalIncome(int n, int m) {
        if (n * m <= 60) {
            return n * m * 10;
        } else {
            return ((n / 2) * 10 + (n - n / 2) * 8) * m;
        }
    }

    public static void byTicket(Scanner scanner, char[][] matrix) {
        chengSB(matrix, scanner);
    }

    public static void statistics(char[][] matrix) {
        float numberOfPurchasedTickets = 0;
        int currentIncome = 0;
        float allTickets;
        float result;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'B') {
                    numberOfPurchasedTickets++;
                    currentIncome += incomeOne(matrix.length, matrix[0].length, i + 1);
                }
            }
        }

        allTickets = matrix.length * matrix[0].length;
        result = numberOfPurchasedTickets / allTickets * 100;

        System.out.printf("Number of purchased tickets: %.0f\n", numberOfPurchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", result);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome(matrix.length, matrix[0].length));
    }

    public static void menu(Scanner scanner, char[][] matrix) {
        int number;
        while (true) {
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            number = input(scanner);
            switch (number) {
                case 1:
                    printMatrixCinema(matrix);
                    break;
                case 2:
                    byTicket(scanner, matrix);
                    break;
                case 3:
                    statistics(matrix);
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
}
package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);

        char[][] matrix;
        int rows;
        int seats;
        int row;
        int seat;

        System.out.println("Enter the number of rows:");
        rows = input(scanner);
        System.out.println("Enter the number of seats in each row:");
        seats = input(scanner);
        matrix = new char[rows][seats];
        writeS(matrix, rows, seats);
        printMatrixCinema(matrix, rows, seats);

        System.out.println("Enter a row number:");
        row = input(scanner);
        System.out.println("Enter a seat number in that row:");
        seat = input(scanner);

        System.out.println("Ticket price: $" + incomeOne(rows, seats, row, seat));
        chengSB(matrix, row, seat);
        printMatrixCinema(matrix, rows, seats);

        //printCinema(rows, seats);
        //System.out.println("$" + incomeAll(rows, seats));

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

    public static void printMatrixCinema(char[][] matrix, int n, int m) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < m; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < m; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void chengSB(char[][] matrix, int n, int m) {
        matrix[n - 1][m - 1] = 'B';
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

    public static int incomeAll(int n, int m) {
        if (n * m > 60) {
            return (n / 2) * m * 10 + (n - n / 2) * m * 8;
        } else {
            return n * m * 10;
        }

    }

    public static int incomeOne(int n, int m, int row, int seat) {
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
}
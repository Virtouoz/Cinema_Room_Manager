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

    public static void chengSB(char[][] matrix, Scanner scanner) {
        int row;
        int seat;
        System.out.println("Enter a row number:");
        row = input(scanner);
        System.out.println("Enter a seat number in that row:");
        seat = input(scanner);
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

    public static void byTicket(Scanner scanner, char[][] matrix) {
        chengSB(matrix, scanner);
    }

    public static void menu(Scanner scanner, char[][] matrix) {
        int number;
        while (true) {
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "0. Exit");
            number = input(scanner);
            switch (number) {
                case 1:
                    printMatrixCinema(matrix);
                    break;
                case 2:
                    byTicket(scanner, matrix);
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
}
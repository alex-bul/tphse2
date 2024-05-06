package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main {
    // поиск минимального числа в списке
    public static int _min(int[] numbers) {
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    // поиск максимального числа в списке
    public static int _max(int[] numbers) {
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    // сумма чисел из списка
    public static int _sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            try {
                sum = Math.addExact(sum, number);
            } catch(ArithmeticException e) {
                System.out.println("Very big nums, overflow " + e);
                System.exit(0);
            }
        }
        return sum;
    }

    // произведение чисел в списке
    public static long _mult(int[] numbers) {
        long product = 1;
        for (int number : numbers) {
            try {
                product = Math.multiplyExact(product, number);
            } catch(ArithmeticException e) {
                System.out.println("Very big nums, overflow " + e);
                System.exit(0);
            }
        }
        return product;
    }

    // функция считывает числа из списка и выдает в формате массива
    public static int[] readNumbers(Scanner scanner) {
        String[] numberStrings = new String[0];
        try {
            numberStrings = scanner.nextLine().split(" ");
        } catch (NoSuchElementException e) {
            System.out.println("zero nums in file: " + e.getMessage());
            System.exit(0);
        }
        int[] numbers = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            try {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            } catch (NumberFormatException e) {
                System.out.println("invalid num format in file: " + e.getMessage());
                System.exit(0);
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        String filename = "num.txt"; // имя файла
        // Чтение чисел из файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/" + filename));
        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + e.getMessage());
            System.exit(0);
        }
        int[] numbers = readNumbers(scanner);

        try{
            System.out.println("Минимальное: " + _min(numbers));
            System.out.println("Максимальное: " + _max(numbers));
            System.out.println("Сумма: " + _sum(numbers));
            System.out.println("Произведение: " + _mult(numbers));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("no elements in num list: " + e.getMessage());
            System.exit(0);
        }

    }
}
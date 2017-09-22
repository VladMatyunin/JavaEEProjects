package ru.vladmatyunin;

import java.util.List;
import java.util.Scanner;

/**
 * Task description:
 * We have some numbers, let it be Integers
 * we can put any sign (+ or -) between them
 * Our aim is to create such polynomial, so that its abs is the lowest one
 * Using recursion
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Write array size:");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        System.out.println("Write array:");
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            array[i] = scanner.nextInt();
        }
        Executor executor = new Executor(array);
        List<Polynomial> polynomials = executor.execute();
        System.out.println(Executor.getMinimalPolynomial(polynomials).toString());
    }
}

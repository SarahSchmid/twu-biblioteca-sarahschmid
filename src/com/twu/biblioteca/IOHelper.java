package com.twu.biblioteca;

import java.io.InputStream;
import java.util.Scanner;

public class IOHelper {

    public static int readSingleNumberInput(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextInt();
    }

    public static String readLineInput(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextLine();
    }
}

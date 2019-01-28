package com.twu.biblioteca;

import com.twu.biblioteca.exception.EmptyBookListException;

import java.io.InputStream;
import java.util.Scanner;

public class Menu {


    public String showMainMenu(Library library, InputStream inputStream) throws EmptyBookListException {
        System.out.println("What do you wanna do next? \n[1] List of books \n[2] Quit");
        int userInput = readUserInput(inputStream);

        switch (userInput){
            case 1:
                return library.showAllBooks();
            case 9:
                return "Good Bye";
            default:
                return "Please select a valid option.";
        }

    }

    private int readUserInput(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextInt();
    }
}

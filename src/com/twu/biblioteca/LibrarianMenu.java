package com.twu.biblioteca;

import java.io.InputStream;

public class LibrarianMenu {


    public String showLibrarianMenu(Library library, InputStream inputStream) {
        System.out.println("Please choose an option:");
        int input = IOHelper.readSingleNumberInput(inputStream);

        if (input == 1) {
            return "placeholder";
        }


        return null;
    }
}

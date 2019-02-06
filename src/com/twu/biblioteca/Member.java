package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {

    private String libraryNumber;
    private List checkedOutItems;


    public Member(String libraryNumber ,String password) {
        super(password, Role.MEMBER);
        this.libraryNumber = libraryNumber;
        this.checkedOutItems = new ArrayList();
    }

    public boolean login(String libraryNumber, String password) {
        return (this.libraryNumber.equals(libraryNumber) &&
                (super.getPassword().equals(password)));
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }
}

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
}

package com.twu.biblioteca;

import com.twu.biblioteca.exception.MemberNotFoundException;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class LoginMenu {

    private List<Member> memberList;
    private Librarian librarian;


    public LoginMenu() {

        this.librarian = new Librarian("librarian");

        Member[] memberList = {
                new Member("123-1234", "password"),
                new Member("234-2345", "admin123"),
                new Member("345-3456", "123456789"),
                new Member("456-4567", "123456789")
        };
        this.memberList = Arrays.asList(memberList);
    }

    public String loginUser(InputStream inputStream) throws MemberNotFoundException {
        System.out.println("Please pick a role to login with:\n[1] Librarian\n[2] Member");
        int input = IOHelper.readSingleNumberInput(inputStream);

        if (input == 1) {
            return loginLibrarian(inputStream);
        } else if (input == 2) {
            return loginMember(inputStream);
        }

        return "This is not a valid login option.";
    }

    private String loginMember(InputStream inputStream) throws MemberNotFoundException {
        System.out.println("Please enter your Library Number:");
        String libraryNumber = IOHelper.readLineInput(inputStream);

        Member memberToLogin = memberList.stream()
                .filter(member -> libraryNumber.equals(member.getLibraryNumber()))
                .filter(member -> libraryNumber.matches("\\d{3}-\\d{4}"))
                .findAny()
                .orElseThrow(MemberNotFoundException::new);

        System.out.println("Please enter your Password:");
        String password = IOHelper.readLineInput(inputStream);

        if(memberToLogin.login(libraryNumber, password)){
            return "Member";
        }
        return "The login credentials for member were wrong.";
    }

    private String loginLibrarian(InputStream inputStream) {
        System.out.println("Please enter the password for Librarian:");
        String password = IOHelper.readLineInput(inputStream);

        if (librarian.login(password)) {
            return "Librarian";
        }
        return "The login credentials for the librarian were wrong.";
    }
}

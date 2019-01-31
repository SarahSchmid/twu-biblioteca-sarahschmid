package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MemberTest {

    @Test
    public void login_should_return_false_if_the_library_number_is_wrong() {
        Member member = new Member("000-0000", "password");

        assertFalse(member.login("111-1111", "password"));
    }

    @Test
    public void login_should_return_false_if_the_library_number_does_not_matches_the_pattern() {
        Member member = new Member("000-0000", "password");

        assertFalse(member.login("00000-00", "password"));
    }

    @Test
    public void login_should_return_false_if_the_password_is_wrong() {
        Member member = new Member("000-0000", "password");

        assertFalse(member.login("000-0000", "1234"));
    }

    @Test
    public void login_should_return_true_if_the_credentials_are_correct() {
        Member member = new Member("000-0000", "password");

        assertTrue(member.login("000-0000", "password"));
    }
}
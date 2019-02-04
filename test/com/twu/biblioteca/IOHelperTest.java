package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class IOHelperTest {

    @Test
    public void readSingleNumberInput_should_read_the_user_input() {
        String input = "1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int result = IOHelper.readSingleNumberInput(inputStream);

        assertEquals(1, result);
    }

    @Test
    public void readLineInput_should_return_the_user_input() {
        String input = "this is an input";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        String result = IOHelper.readLineInput(inputStream);

        assertEquals(input, result);
    }
}
package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class IOHelperTest {

    @Test
    public void readUserInput_should_read_the_user_input() {
        String input = "1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int result = IOHelper.readUserInput(inputStream);

        assertEquals(1, result);
    }

}
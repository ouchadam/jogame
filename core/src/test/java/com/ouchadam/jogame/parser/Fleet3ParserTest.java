package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.DocHelper;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class Fleet3ParserTest {

    private Parser<String> fleetParser;

    @Before
    public void setUp() {
        fleetParser = new Fleet3Parser();
    }

    @Test
    public void testName() {
        String token = fleetParser.parse(DocHelper.open("fleet3.txt"));

        assertThat(token).isEqualTo("7b57fc5cea3e551e25880135b5c76ccd");
    }

}

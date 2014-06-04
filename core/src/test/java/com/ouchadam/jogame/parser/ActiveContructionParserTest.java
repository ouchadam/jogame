package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.DocHelper;
import com.ouchadam.jogame.domain.ActiveConstructions;

import org.junit.Before;
import org.junit.Test;

public class ActiveContructionParserTest {

    private ActiveContructionParser activeContructionParser;

    @Before
    public void setUp() {
        activeContructionParser = new ActiveContructionParser();
    }

    @Test
    public void building() {
        ActiveConstructions activeConstructions = activeContructionParser.parse(DocHelper.open("overview_with_building.txt"));
    }

    @Test
    public void shipyard() {
        ActiveConstructions activeConstructions = activeContructionParser.parse(DocHelper.open("overview_with_defence.txt"));
    }

}

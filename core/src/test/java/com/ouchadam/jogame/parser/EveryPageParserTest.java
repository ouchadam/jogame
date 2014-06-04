package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.DocHelper;
import com.ouchadam.jogame.domain.page.EveryPage;
import com.ouchadam.jogame.domain.page.Meta;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class EveryPageParserTest {

    private EveryPageParser everyPageParser;

    @Before
    public void setUp() throws Exception {
        everyPageParser = new EveryPageParser(new PlanetsParser(), new ResourceParser());
    }

    @Test
    public void overview() {
        EveryPage everyPage = everyPageParser.parse(DocHelper.open("overview_every_page.txt"));

        assertMeta(everyPage.getMeta());
    }

    private static void assertMeta(Meta meta) {
        assertThat(meta.getPlayerName()).isEqualTo("playername");
    }

}

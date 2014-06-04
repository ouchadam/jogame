package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.DocHelper;
import com.ouchadam.jogame.domain.Resources;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class TypeParserTest {

    private ResourceParser resourceParser;

    @Before
    public void setUp() throws Exception {
        resourceParser = new ResourceParser();
    }

    @Test
    public void metal() throws Exception {
        Resources resources = resourceParser.parse(DocHelper.open("overview.txt"));

        assertThat(resources.getMetal()).isEqualTo(2929);
    }

    @Test
    public void crystal() throws Exception {
        Resources resources = resourceParser.parse(DocHelper.open("overview.txt"));

        assertThat(resources.getCrystal()).isEqualTo(580);
    }

    @Test
    public void deuterium() throws Exception {
        Resources resources = resourceParser.parse(DocHelper.open("overview.txt"));

        assertThat(resources.getDeuterium()).isEqualTo(357);
    }
}

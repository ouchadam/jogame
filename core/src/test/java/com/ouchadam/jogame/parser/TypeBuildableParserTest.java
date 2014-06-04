package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.DocHelper;
import com.ouchadam.jogame.domain.Buildable;
import com.ouchadam.jogame.domain.Status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class TypeBuildableParserTest {

    private ResourceBuildableParser resourceBuildableParser;

    @Before
    public void setUp() {
        resourceBuildableParser = new ResourceBuildableParser();
    }

    @Test
    public void resources() {
        List<Buildable> buildables = resourceBuildableParser.parse(DocHelper.open("resource_error.txt"));

        assertBuildable(buildables.get(0), "Metal Mine", 17, Status.DISABLED);
        assertBuildable(buildables.get(buildables.size() - 1), "Seabed Deuterium Den", 0, Status.OFF);
    }

    private static void assertBuildable(Buildable buildable, String name, int level, Status status) {
        assertThat(buildable.getName()).isEqualTo(name);
        assertThat(buildable.getLevel()).isEqualTo(level);
        assertThat(buildable.getStatus()).isEqualTo(status);
    }

}
